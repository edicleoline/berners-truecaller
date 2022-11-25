<?php

namespace App\Http\Controllers\Api\V1\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Tag\Tag;
use App\Models\Phone\Phone;
use App\Core\Api\Response;
use App\Models\Phone\PhoneTag;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use App\Exceptions\ObjectNotFoundException;

class PhoneTagsController extends Controller
{  
    public function list(Request $request)
    {      
        $pagination = $this->paginationParams($request);
        $tags = Tag::list($pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $tags));          
    }

    public function store(Request $request, $phoneId)
    {   
        $request->validate([
            'tag_id' => 'required',
        ]);

        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $tag = $this->findOrFail(Tag::class, $request->tag_id, ['tag_id' => $request->tag_id]);

        $phoneTag = $phone->addTag($tag);

        return response(Response::content($request, $phoneTag), 201);                  
    }

    public function destroy(Request $request, $phoneId, $tagId)
    {           
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $tag = $this->findOrFail(Tag::class, $tagId, ['tag_id' => $tagId]);

        $phone->removeTag($tag);

        return response()->noContent();
    }
}
