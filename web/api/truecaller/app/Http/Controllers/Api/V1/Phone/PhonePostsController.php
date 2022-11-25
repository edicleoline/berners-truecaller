<?php

namespace App\Http\Controllers\Api\V1\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Posting\Post;
use App\Models\Phone\Phone;
use App\Core\Api\Response;
use App\Models\Phone\PhonePost;
use App\Models\Phone\Report\Report;

class PhonePostsController extends Controller
{      
    public function list(Request $request, $phoneId)
    {      
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);

        $pagination = $this->paginationParams($request);
        $posts = $phone->posts($pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $posts));
    }

    public function store(Request $request, $phoneId)
    {   
        $request->validate([
            'post_id' => 'required',
        ]);

        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $post = $this->findOrFail(Post::class, $request->post_id, ['post_id' => $request->post_id]);
        $report = $request->has('phone_report_id') 
            ? $this->findOrFail(Report::class, $request->phone_report_id, ['phone_report_id' => $request->phone_report_id]) 
            : null;

        $this->validateBasicAuthorization($post->createdBy()->user_id);

        $phonePost = PhonePost::firstOrCreate([
            'phone_id' => $phone->id,
            'post_id' => $post->id,
            'phone_report_id' => $report ? $report->id : null
        ]);
        $phonePost->makeVisibleBasic();

        return response(Response::content($request, $phonePost), 201);                  
    }    
}
