<?php

namespace App\Core\Facades;

use Illuminate\Support\Facades\Facade;
use App\Models\Account\Auth\Session;
use JWTAuth;

class Authentication extends Facade
{
    protected static function getFacadeAccessor()
    {
        return 'auth.session';
    }

    public static function session() {
        $token = JWTAuth::getToken();

        if(empty($token)) return null;

        // $session = Session::where('token', $token)
        //     ->firstOrFail();
        $session = Session::findByToken($token);

        return $session;
    }

}