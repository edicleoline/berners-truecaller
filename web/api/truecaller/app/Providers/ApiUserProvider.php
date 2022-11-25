<?php

namespace App\Providers;

use Illuminate\Auth\GenericUser;
use Illuminate\Contracts\Auth\Authenticatable;
use Illuminate\Contracts\Auth\UserProvider;
use Illuminate\Support\Facades\Http;
use App\Models\Account\User;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\DB;

class ApiUserProvider implements UserProvider
{
    public function retrieveById($identifier)
    {
        return User::find($identifier);
    }

    public function retrieveByToken($identifier, $token)
    {
        return null;
    }

    public function updateRememberToken(Authenticatable $user, $token)
    {

    }

    public function retrieveByCredentials(array $credentials)
    {
        if (!array_key_exists('email', $credentials)) {
            return null;
        }

        $user = DB::table('emails')
            ->join('users', 'emails.user_id', '=', 'users.id')
            ->where('emails.email', $credentials['email'])
            ->select('users.id', 'users.password')
            ->first();

        if(!$user) return null;

        return User::find($user->id);
    }

    public function validateCredentials(Authenticatable $user, array $credentials)
    {
        $plain = $credentials['password'];

        return Hash::check($plain, $user->getAuthPassword());
    }
}
