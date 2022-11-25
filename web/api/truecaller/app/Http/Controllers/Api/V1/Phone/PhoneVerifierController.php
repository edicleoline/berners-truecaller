<?php

namespace App\Http\Controllers\Api\V1\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Phone\Phone;
use App\Core\Api\Response;
use App\Core\Facades\Authentication;

class PhoneVerifierController extends Controller
{  
    public function store(Request $request, $phoneId)
    {      
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $session = Authentication::session();
        $verifier = $phone->verifier($session->installation)->start();
        $verifier->makeHidden(['created_at', 'verified_at']);

        return response(Response::content($request, $verifier), 201);            
    }

    public function verify(Request $request, $phoneId)
    {
        $request->validate([
            'uuid' => 'required',
            'token' => 'required',
        ]);

        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $session = Authentication::session();
        $verifier = $phone->verifier($session->installation)->verify($request->uuid, $request->token);          
        $verifier->makeHidden(['created_at', 'ttl', 'verified_at']);

        return response(Response::content($request, $verifier));
    }
}
