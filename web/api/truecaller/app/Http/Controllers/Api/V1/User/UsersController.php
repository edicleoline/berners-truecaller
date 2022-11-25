<?php

namespace App\Http\Controllers\Api\V1\User;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Account\User;
use App\Core\Api\Response;
use App\Core\Enum\Rules\EnumKey;
use App\Core\Person\Gender;
use App\Models\Uploading\Media;
use App\Core\Enum\Visibility;
use App\Models\Company\Company;

class UsersController extends Controller
{
    public function show(Request $request, $id)
    {
        $user = $this->findOrFail(User::class, $id, ['user_id' => $id]);

        return response(Response::content($request, $user));
    }

    public function loggedUser(Request $request)
    {
        $me = $this->me();

        return Response::content($request, parent::me());
    }

    public function update(Request $request, $id) {
        $request->validate([
            'birthday' => 'date|nullable',
            'gender' => ['nullable', new EnumKey(Gender::class)],
            'visibility' => ['nullable', new EnumKey(Visibility::class)],
        ]);

        $user = $this->findOrFail(User::class, $id, ['user_id' => $id]);

        $this->validateBasicAuthorization($user->id);

        if($request->has('name')) {
            $user->name = $request->name;
        }

        if($request->has('birthday')) {
            $user->birthday = $request->birthday;
        }

        if($request->has('gender')) {
            $user->gender = Gender::fromKey($request->gender);
        }

        if($request->has('lang')) {
            $user->lang = $request->lang;
        }

        if($request->has('bio')) {
            $user->bio = $request->bio;
        }

        if($request->has('job_title')) {
            $user->job_title = $request->job_title;
        }

        if($request->has('job_company_id')) {
            $company = $this->findOrFail(Company::class, $request->job_company_id, ['job_company_id' => $request->job_company_id]);
            $user->job_company_id = $company->id;
        }

        if($request->has('social_id')) {
            $reqSocialId = json_decode(json_encode($request->social_id), false);
            $user->social_id_facebook = isset($reqSocialId->facebook) ? $reqSocialId->facebook : null;
            $user->social_id_instagram = isset($reqSocialId->instagram) ? $reqSocialId->instagram : null;
            $user->social_id_twitter = isset($reqSocialId->twitter) ? $reqSocialId->twitter : null;
        }

        if($request->has('url')) {
            $user->url = $request->url;
        }
        
        if($request->has('gender')) {
            $user->gender = Gender::fromKey($request->gender);
        }

        if($request->has('visibility')) {
            $user->visibility = Visibility::fromKey($request->visibility);
        }

        if($request->has('profile_image_id') && empty($request->profile_image_id)) {
            $user->profile_image_id = null;
        }
        else if($request->has('profile_image_id')) {
            $media = $this->findOrFail(Media::class, $request->profile_image_id, ['profile_image_id' => $request->profile_image_id]);
            $this->validateBasicAuthorization($media->upload->author_id);
            $user->profile_image_id = $request->profile_image_id;
        }
        
        $user->save();

        return response(Response::content($request, $user));
    }
}
