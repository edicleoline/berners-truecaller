<?php

namespace App\Http\Controllers\Api\V1\Filter;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Core\Api\Response;
use Illuminate\Validation\Rule;
use App\Models\Filtering\Filter as FilterModel;
use App\Core\Filter\Filter as CoreFilter;

class FiltersController extends Controller
{  
    public function store(Request $request)
    {
        $request->validate(array_merge([
            'type' => [
                'required',
                Rule::in(CoreFilter::getTypeNames()),
            ],
            'rule' => [
                'required',
                Rule::in(CoreFilter::getRuleNames($request->type)),
            ],
            'value' => array_merge([
                'required',
            ], CoreFilter::getRule($request->type, $request->rule) 
                && CoreFilter::getRule($request->type, $request->rule)->value 
                ? CoreFilter::getRule($request->type, $request->rule)->value->validation : []),
            
        ], CoreFilter::getRule($request->type, $request->rule) 
            && isset(CoreFilter::getRule($request->type, $request->rule)->attributes)
            && isset(CoreFilter::getRule($request->type, $request->rule)->attributes->validation)
            ? (array)CoreFilter::getRule($request->type, $request->rule)->attributes->validation : []));


        $attributes = CoreFilter::getAttributes($request);
        $filter = FilterModel::findOrCreate($request->type, $request->rule, $request->value, $attributes);

        return response(Response::content($request, $filter), 201);            
    }

    public function list(Request $request)
    {
        $pagination = $this->paginationParams($request);
        $filters = FilterModel::list($pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $filters));   
    }

    public function destroy(Request $request, $id)
    {
        $filter = $this->findOrFail(FilterModel::class, $id, ['filter_id' => $id]);

        $this->validateBasicAuthorization($filter->createdBy()->user_id);
        
        $filter->delete();
        return response()->noContent();
    }
}
