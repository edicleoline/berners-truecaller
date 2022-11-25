<?php

namespace App\Http\Controllers\Api\Unversioned;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Core\Api\Response;
use App\Models\Posting\Post;
use App\Core\Facades\Authentication;

class ResourcesController extends Controller
{
    public function list(Request $request)
    {
        

        // return response(Response::content($request, $post), 201);
    }
}
