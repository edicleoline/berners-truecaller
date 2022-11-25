<?php

namespace App\Http\Controllers\Api\V1\User;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Account\User;
use App\Models\Account\UserPhone;
use App\Models\Phone\Phone;
use App\Core\Api\Response;

class UserPhonesController extends Controller
{
    public function list(Request $request, $userId)
    {
        $this->validateBasicAuthorization($userId);

        $user = $this->findOrFail(User::class, $userId, ['user_id' => $userId]);

        $pagination = $this->paginationParams($request);
        $phones = $user->paginatedPhones($pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $phones));
    }

    public function store(Request $request, $userId, $phoneId)
    {        
        $this->validateBasicAuthorization($userId);

        $user = $this->findOrFail(User::class, $userId, ['user_id' => $userId]);      
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);      

        $userPhone = $user->storePhone($phone);

        return response(Response::content($request, $userPhone), 201);
    }

    public function destroy(Request $request, $userId, $phoneId)
    {
        $this->validateBasicAuthorization($userId);

        $user = $this->findOrFail(User::class, $userId, ['user_id' => $userId]);      
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);       

        $user->removePhone($phone);

        return response()->noContent();
    }

}
