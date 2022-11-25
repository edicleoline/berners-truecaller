<?php

namespace App\Http\Controllers\Api\V1\User;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Account\User;
use App\Models\Email\Email;
use App\Core\Api\Response;

class EmailsController extends Controller
{
    public function show(Request $request, $id)
    {
        $this->validateBasicAuthorization($id);

        $user = $this->findOrFail(User::class, $id, ['user_id' => $id]); 
        $email = $user->emails();
        
        return response(Response::content($request, $email));
    }

    public function store(Request $request, $id)
    {
        $request->validate([
            'email' => 'required|email:rfc,dns',
        ]);

        $this->validateBasicAuthorization($id);

        $user = $this->findOrFail(User::class, $id, ['user_id' => $id]);
        $email = Email::firstOrCreate([
            'email' => $request->email
        ]);

        $user->storeEmail($email);

        return response(Response::content($request, $email), 201);
    }

    public function destroy(Request $request, $userId, $emailId)
    {
        $this->validateBasicAuthorization($userId);

        $user = $this->findOrFail(User::class, $userId, ['user_id' => $userId]);
        $email = $this->findOrFail(Email::class, $emailId, ['email_id' => $emailId]);
        $user->removeEmail($email);

        return response()->noContent();
    }

}
