<?php

namespace App\Models\Filtering;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Facades\Authentication;
use App\Core\Filter\Filter as CoreFilter;
use App\Models\Filtering\Filter;

class Attribute extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'filter_attributes';

    protected $fillable = [
        'filter_id',
        'name',
        'value',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id'
    ];

    protected $appends = [
        'filter'
    ];

    protected $hidden = [
        'created_at',
        'updated_at',
        'deleted_at',
        'deleted_by_auth_session_id',
        'created_by_auth_session_id',
        'filter_id',
        'name',
        'value',
        'filter'
    ];

    protected $casts = [        
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
        'value'      => "string"
    ];

    public static function findById($id) {
        return Attribute::find($id);
    }

    protected function getFilterAttribute() {
        if($this->hasOnce('filter')) return $this->getOnceValue('filter');

        $filter = Filter::find($this->filter_id);
        $this->setOnce('filter', $filter);

        return $filter;
    }

    protected function getCastType($key) {
        if($key === 'value') {
            $field = CoreFilter::getAttributeField($this->filter->filter_type, $this->filter->rule, $this->name);

            if(is_null($field) || !isset($field->cast)) {
                return parent::getCastType($key);
            }

            return $field->cast;
        }
    }

    public function toArray()
    {
        $array = parent::toArray();
        $array[$this->name] = $this->value;    

        return $array;
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($attribute) {  
            $attribute->deleted_by_auth_session_id = Authentication::session()->id;
            $attribute->save();
            
            return true;
        });
    }
}
