<?php

namespace App\Models\Account;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Facades\Authentication;
use App\Models\Email\Email;

class UserEmail extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'user_emails';

    protected $appends = [
        'email'
    ];

    protected $fillable = [
        'email_id',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
    ];

    protected $hidden = [
        'email_id',
        'deleted_at',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
    ];           

    protected function getEmailAttribute() {
        if($this->hasOnce('email')) return $this->getOnceValue('email');

        $email = !is_null($this->email_id) ? Email::find($this->email_id) : null;

        if(!is_null($email)) {
            $email->setUserRef($this->createdBy()->user());
            // $email->makeVisibleBasic();
        }

        $this->setOnce('email', $email);
        return $email;
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($userEmail) {  
            $userEmail->deleted_by_auth_session_id = Authentication::session()->id;
            $userEmail->save();
            
            return true;
        });
    }
}
