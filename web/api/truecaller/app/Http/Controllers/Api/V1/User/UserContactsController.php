<?php

namespace App\Http\Controllers\Api\V1\User;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Account\User;
use App\Models\Account\UserContact;
use App\Models\Phone\Phone;
use App\Core\Api\Response;

class UserContactsController extends Controller
{
    public function list(Request $request, $userId)
    {
        $this->validateBasicAuthorization($userId);

        $user = $this->findOrFail(User::class, $userId, ['user_id' => $userId]);

        $pagination = $this->paginationParams($request, [
            'max_results' => 'required|integer|min:1|max:20',
        ]);

        $contacts = UserContact::list($pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $contacts)); 
    }

    public function store(Request $request, $userId)
    {        
        $validated = $request->validate([
            'phones' => 'required|array',
        ]);

        $this->validateBasicAuthorization($userId);

        $user = $this->findOrFail(User::class, $userId, ['user_id' => $userId]);     
        $user->updateContacts($request->phones);

        return response()->noContent();
    }
}
