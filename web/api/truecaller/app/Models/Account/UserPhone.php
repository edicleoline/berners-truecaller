<?php

namespace App\Models\Account;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Phone\Phone;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Facades\Authentication;

class UserPhone extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'user_phones';

    protected $appends = [
        'phone'
    ];

    protected $fillable = [
        'phone_id',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
    ];

    protected $hidden = [
        'phone_id',
        'deleted_at',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
    ];           

    protected function getPhoneAttribute() {
        if($this->hasOnce('phone')) return $this->getOnceValue('phone');

        $phone = !is_null($this->phone_id) ? Phone::find($this->phone_id) : null;

        if(!is_null($phone)) {
            $phone->setUserRef($this->createdBy()->user());
            $phone->makeVisibleBasic();
        }

        $this->setOnce('phone', $phone);
        return $phone;
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($userPhone) {  
            $userPhone->deleted_by_auth_session_id = Authentication::session()->id;
            $userPhone->save();
            
            return true;
        });
    }
}
