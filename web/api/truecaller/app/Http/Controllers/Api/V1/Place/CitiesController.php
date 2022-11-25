<?php

namespace App\Http\Controllers\Api\V1\Place;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Place\City;
use App\Models\Place\State;
use App\Core\Api\Response;

class CitiesController extends Controller
{  
    public function list(Request $request, $stateId)
    {      
        $state = $this->findOrFail(State::class, $stateId, ['state_id' => $stateId]);

        $pagination = $this->paginationParams($request, [
            'max_results' => 'required|integer|min:1|max:100',
        ]);

        $states = City::listByState($state, $pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $states));          
    }    

    public function show(Request $request, $id)
    {
        $city = $this->findOrFail(City::class, $id, ['city_id' => $id]);

        return response(Response::content($request, $city));
    }
}
