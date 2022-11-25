<?php

namespace App\Http\Controllers\Api\V1\Tag;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Tag\Tag;
use App\Core\Api\Response;

class TagsController extends Controller
{
    public function show(Request $request, $id)
    {
        $tag = $this->findOrFail(Tag::class, $id, ['tag_id' => $id]);

        return response(Response::content($request, $tag));
    }   
}
