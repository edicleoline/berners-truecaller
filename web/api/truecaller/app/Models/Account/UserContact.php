<?php

namespace App\Models\Account;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Phone\Phone;
use Illuminate\Database\Eloquent\SoftDeletes;
use Illuminate\Pagination\Cursor;
use App\Core\Facades\Authentication;

class UserContact extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'user_contacts';

    protected $appends = [
        'phone',
    ];

    protected $fillable = [
        'phone_id',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
    ];

    protected $hidden = [
        'phone_id',
        'updated_at',
        'deleted_at',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
    ];       

    public static function list($maxResults = 1, $paginationToken = null) {
        $me = auth()->user();

        $paginator = UserContact::select(['user_contacts.*'])
            ->join('auth_sessions', 'user_contacts.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('auth_sessions.user_id', auth()->user()->id)
            ->orderBy('user_contacts.created_at', 'desc')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    protected function getPhoneAttribute() {
        if($this->hasOnce('phone')) return $this->getOnceValue('phone');

        $phone = !is_null($this->phone_id) ? Phone::find($this->phone_id) : null;
        if(!is_null($phone)) {
            $phone->makeVisibleBasic();
        }
        $this->setOnce('phone', $phone);
        return $phone;
    }

    /**
     * Counts how many users added a number as a contact.
     *
     * @return int
     */
    public static function countPhone(Phone $phone) {
        return UserContact::selectRaw('user_contacts.*')            
            ->where('user_contacts.phone_id', $phone->id)
            ->count();
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($contact) {  
            $contact->deleted_by_auth_session_id = Authentication::session()->id;
            $contact->save();
            
            return true;
        });

        static::restoring(function($contact) {  
            $contact->deleted_by_auth_session_id = null;
            $contact->save();
            
            return true;
        });
    }
}
