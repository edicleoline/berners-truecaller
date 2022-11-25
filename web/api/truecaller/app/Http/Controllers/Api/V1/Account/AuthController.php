<?php

namespace App\Http\Controllers\Api\V1\Account;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Models\Account\User;
use JWTFactory;
use JWTAuth;
use Validator;
use App\Core\Api\Response;

class AuthController extends Controller
{
    // public function register(Request $request)
    // {
    //     if($this->me()) {
    //         //throw
    //     }

    //     $user = new User();
    //     $user->save();

    //     $token = JWTAuth::fromUser($user);
    //     $response = $this->respondWithToken($token);
    
    //     return response(Response::content($request, $response), 201);  
    // }

    public function refresh()
    {
        return $this->respondWithToken(auth()->refresh());
    }

    protected function respondWithToken($token)
    {
        return [
            'token' => $token,
            'token_type' => 'bearer',
            'ttl' => auth('api')->factory()->getTTL() * 60
        ];
    }
}
