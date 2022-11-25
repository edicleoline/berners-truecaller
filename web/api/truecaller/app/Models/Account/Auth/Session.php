<?php

namespace App\Models\Account\Auth;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Account\User;
use Illuminate\Support\Facades\Cache;
use App\Models\Device\Installation;

class Session extends Model
{
    use HasFactory;
    protected $table = 'auth_sessions';

    protected $appends = [
        'user',
        'installation'
    ];

    protected $fillable = [
        'user_id',
        'token',
        'token_type',
        'ttl',
        'device_installation_id'
    ];

    protected $hidden = [
        'token',
        'token_type',
        'ttl',
        'created_at',
        'updated_at',
        'user_id',
        'device_installation_id'
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];

    public function user() {
        if($this->hasOnce('user')) return $this->getOnceValue('user');

        $user = User::find($this->user_id);
        $user->makeVisibleBasic();
        $this->setOnce('user', $user);
        return $user;
    }    

    protected function getUserAttribute() {
        return $this->user();
    }

    public static function findById($id, bool $anonymous = false) {
        $session = Cache::rememberForever("sessions_id_{$id}", function() use ($id) {
            return Session::find($id);
        });

        if($anonymous) $session->makeHidden(['user']);
        return $session;
    }

    public static function findByToken($token) {
        // $session = Cache::rememberForever("sessions_token_{$token}", function() use ($token) {
        //     return Session::where('token', $token)
        //         ->first();
        // });
        // return $session;
        return Session::where('token', $token)
            ->first();        
    }

    public static function findByInstallation(Installation $installation) {
        return Session::where('device_installation_id', $installation->id)
            ->first();
    }

    public static function create(User $user, Installation $installation, string $token, string $tokenType, int $ttl) {
        $session = new Session();
        $session->user_id = $user->id;
        $session->device_installation_id = $installation->id;
        $session->token = $token;
        $session->token_type = $tokenType;
        $session->ttl = $ttl;
        $session->save();

        return $session;
    }

    protected function getInstallationAttribute() {
        if($this->hasOnce('installation')) return $this->getOnceValue('installation');

        $installation = Installation::find($this->device_installation_id);        
        $this->setOnce('installation', $installation);

        return $installation;
    }
}
