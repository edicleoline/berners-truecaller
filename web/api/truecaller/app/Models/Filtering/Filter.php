<?php

namespace App\Models\Filtering;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Facades\Authentication;
use App\Models\Account\Auth\Session;
use App\Models\Filtering\Attribute;
use Illuminate\Pagination\Cursor;

class Filter extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'filters';

    protected $fillable = [
        'filter_type',
        'rule',
        'value',
        'attributes_checksum',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id'
    ];

    protected $appends = [
        'attributes'
    ];

    protected $hidden = [
        'created_at',
        'updated_at',
        'deleted_at',
        'deleted_by_auth_session_id',
        'created_by_auth_session_id',
        'attributes_checksum'
    ];

    protected $casts = [        
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
    ];

    public static function findById($id) {
        return Filter::find($id);
    }

    protected function getAttributesAttribute() {
        if($this->hasOnce('attributes')) return $this->getOnceValue('attributes');

        $attributes = Attribute::where('filter_id', $this->id)
            ->get();

        $this->setOnce('attributes', $attributes);
        return $attributes;
    }

    protected static function getQueryBuilder(string $type, string $rule, ?Session $session = null) {
        if(is_null($session)) {
            $session = Authentication::session();
        }

        if(is_null($session)) {
            return null;
        }

        return Filter::selectRaw('filters.*')
            ->join('auth_sessions', 'filters.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('filters.filter_type', $type)
            ->where('filters.rule', $rule)
            ->where('auth_sessions.user_id', $session->user_id);
    }

    public static function findOrCreate(string $type, string $rule, mixed $value, ?array $attributes, ?Session $session = null) {
        if(is_null($session)) {
            $session = Authentication::session();
        }

        if(is_null($session)) {
            return null;
        }

        $attributesChecksum = null;
        if(!is_null($attributes)) {
            $attributesChecksum = md5(serialize($attributes));
        }

        $filter = static::getQueryBuilder($type, $rule, $session)
            ->where('filters.attributes_checksum', $attributesChecksum)
            ->latest('filters.created_at')
            ->first();

        if(!is_null($filter)) {
            $filter->value = $value;
            $filter->save();
            return $filter;
        }
       
        $filter = new Filter();
        $filter->filter_type = $type;
        $filter->rule = $rule;
        $filter->value = $value;
        $filter->attributes_checksum = $attributesChecksum;
        $filter->created_by_auth_session_id = $session->id;
        $filter->save();

        if(!is_null($attributes)) {
            foreach($attributes as $key => $value) {
                $attribute = new Attribute();
                $attribute->filter_id = $filter->id;
                $attribute->name = $value['name'];
                $attribute->value = $value['value'];
                $attribute->created_by_auth_session_id = $session->id;
                $attribute->save();
            }
        }

        return $filter;
    }

    public static function list($maxResults = 1, $paginationToken = null) {
        $paginator = Filter::select(['filters.*'])
            ->join('auth_sessions', 'filters.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('auth_sessions.user_id', auth()->user()->id)
            ->orderBy('filters.created_at', 'desc')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($filter) {  
            $filter->deleted_by_auth_session_id = Authentication::session()->id;
            $filter->save();
            
            return true;
        });
    }
}
