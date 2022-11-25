<?php

namespace App\Http\Controllers\Api\V1\Email;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Email\Email;
use App\Core\Api\Response;
use App\Core\Facades\Authentication;

class EmailVerifierController extends Controller
{  
    public function store(Request $request, $emailId)
    {      
        $email = $this->findOrFail(Email::class, $emailId, ['email_id' => $emailId]);
        $session = Authentication::session();
        $verifier = $email->verifier($session->installation)->start();  
        $verifier->makeHidden(['created_at', 'verified_at']);

        return response(Response::content($request, $verifier), 201);            
    }

    public function verify(Request $request, $emailId)
    {
        $request->validate([
            'uuid' => 'required',
            'token' => 'required',
        ]);

        $email = $this->findOrFail(Email::class, $emailId, ['email_id' => $emailId]);
        $session = Authentication::session();
        $verifier = $email->verifier($session->installation)->verify($request->uuid, $request->token);          
        $verifier->makeHidden(['created_at', 'ttl', 'verified_at']);

        return response(Response::content($request, $verifier));
    }
}
