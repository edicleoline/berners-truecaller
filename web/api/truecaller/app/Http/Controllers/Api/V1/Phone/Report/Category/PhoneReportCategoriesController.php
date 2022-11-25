<?php

namespace App\Http\Controllers\Api\V1\Phone\Report\Category;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Core\Api\Response;
use App\Models\Phone\Report\Category;

class PhoneReportCategoriesController extends Controller
{  
    public function list(Request $request)
    {      
        $pagination = $this->paginationParams($request);
        $categories = Category::list($pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $categories));          
    }

    public function show(Request $request, $id)
    {              
        $category = $this->findOrFail(Category::class, $id, ['category_id' => $id]);
        
        return response(Response::content($request, $category));          
    }
}
