<?php

namespace App\Http\Controllers\Api\V1\Place;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Place\Country;
use App\Models\Place\State;
use App\Core\Api\Response;

class StatesController extends Controller
{  
    public function list(Request $request, $countryId)
    {      
        $country = $this->findOrFail(Country::class, $countryId, ['country_id' => $countryId]);

        $pagination = $this->paginationParams($request, [
            'max_results' => 'required|integer|min:1|max:100',
        ]);

        $states = State::listByCountry($country, $pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $states));          
    }    

    public function show(Request $request, $id)
    {
        $state = $this->findOrFail(State::class, $id, ['state_id' => $id]);

        return response(Response::content($request, $state));
    }
}
