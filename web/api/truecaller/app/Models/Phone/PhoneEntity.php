<?php

namespace App\Models\Phone;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Exceptions\InvalidOperationException;
use App\Core\Facades\Authentication;
use App\Models\Account\Auth\Session;
use App\Models\Phone\Phone;
use Illuminate\Pagination\Cursor;
use App\Core\Enum\EntityType;

class PhoneEntity extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'phone_entities';

    protected $fillable = [
        'phone_id',
        'name',
        'verified_at',
        'is_public',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
        'entity_type'
    ];

    protected $appends = [
        'verified',        
    ];

    protected $hidden = [
        'verified_at',
        'updated_at',
        'deleted_at',
        'deleted_by_auth_session_id',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
        'phone_id',
        'is_public'
    ];

    protected $casts = [
        'verified_at' => 'datetime',
        'created_at' => 'datetime',
        'deleted_at' => 'datetime',
        'is_public' => 'boolean',
        'entity_type' => EntityType::class
    ];  
       
    protected function getVerifiedAttribute() {
        return !is_null($this->verified_at) ? true : false;
    }

    public function createdBy() {
        return Session::find($this->created_by_auth_session_id);
    }

    public static function listByPhone(Phone $phone, $maxResults = 1, $paginationToken = null) {
        $paginator = PhoneEntity::select(['phone_entities.*'])
            ->where('phone_entities.phone_id', $phone->id)
            ->orderByDesc('phone_entities.id')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($phoneName) {
            if($phoneName->verified === true) {
                throw InvalidOperationException::withMessage('You cannot delete this record because it has been verified.');
            }
            else if($phoneName->is_public === true) {
                throw InvalidOperationException::withMessage('You cannot delete this record because it is public.');
            }

            $phoneName->deleted_by_auth_session_id = Authentication::session()->id;
            $phoneName->save();

            return true;
        });
    }
}
