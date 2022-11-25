<?php

namespace App\Http\Controllers\Api\V1\Posting;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Core\Api\Response;
use App\Models\Posting\Post;
use App\Core\Facades\Authentication;

class PostsController extends Controller
{
    public function store(Request $request)
    {
        $request->validate([
            'text' => 'required|max:240',
            'anonymous_mode' => 'required|boolean',
        ]);

        $post = new Post();
        $post->text = $request->text;
        $post->anonymous_mode = $request->anonymous_mode;
        $post->created_by_auth_session_id = Authentication::session()->id;
        $post->save();

        return response(Response::content($request, $post), 201);
    }   

    public function destroy(Request $request, $postId)
    { 
        $post = $this->findOrFail(Post::class, $postId, ['post_id' => $postId]);

        $this->validateBasicAuthorization($post->createdBy()->user_id);
        
        $post->delete();

        return response()->noContent();
    }
}
