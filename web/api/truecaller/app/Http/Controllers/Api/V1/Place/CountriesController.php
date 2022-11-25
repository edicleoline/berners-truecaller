<?php

namespace App\Http\Controllers\Api\V1\Place;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Place\Country;
use App\Core\Api\Response;

class CountriesController extends Controller
{  
    public function list(Request $request)
    {      
        $pagination = $this->paginationParams($request, [
            'max_results' => 'required|integer|min:1|max:100',
        ]);

        $countries = Country::list($pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $countries));          
    }    

    public function show(Request $request, $id)
    {
        $country = $this->findOrFail(Country::class, $id, ['country_id' => $id]);

        return response(Response::content($request, $country));
    }
}
