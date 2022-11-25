<?php

namespace App\Http\Controllers;

use Illuminate\Foundation\Auth\Access\AuthorizesRequests;
use Illuminate\Foundation\Bus\DispatchesJobs;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Routing\Controller as BaseController;
use Illuminate\Http\Request;
use App\Exceptions\ForbiddenException;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use App\Exceptions\ObjectNotFoundException;
use App\Core\Facades\Authentication;

class Controller extends BaseController
{
    use AuthorizesRequests, DispatchesJobs, ValidatesRequests;

    public function paginationParams(Request $request, $validation = [
      'max_results' => 'required|integer|min:1|max:20',
    ]) {
        $validated = $request->validate($validation);

        $pagination = new \StdClass;
        $pagination->max_results = $request->max_results;
        $pagination->pagination_token = $request->has('pagination_token') ? $request->pagination_token : null;

        return $pagination;
    }

    public function validateBasicAuthorization($userId) {
        $user = auth()->user();

        if($user->id != $userId) {
            throw ForbiddenException::withMessage('Client Forbidden.');
        }
    }

    public function validateAdminAuthorization($userId = null) {
        $user = auth()->user();

        if(is_null($userId)) {
            $user_id = $user->id;
        }

        if(is_null($user->group) || $user->group->name !== 'admin') {
            throw ForbiddenException::withMessage('Client Forbidden.');
        }
    }

    public function me() {
          return auth()->user();
    }

    public function findOrFail(string $namespace, mixed $id, array $params) {
        $model = null;
        try {
            $model = $namespace::findOrFail($id);
        }
        catch (ModelNotFoundException $exception) {
            throw ObjectNotFoundException::withQueryParam($params);
        }

        return $model;
    }

    public function session() {
        return Authentication::session();
    }
}
