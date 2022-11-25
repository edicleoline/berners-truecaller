<?php

namespace App\Http\Controllers\Api\V1\Place;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Place\Country;
use App\Models\Place\State;
use App\Models\Place\City;
use App\Core\Api\Response;
use App\Models\Place\Location;

class LocationsController extends Controller
{  
    public function store(Request $request)
    {      
        $validated = $request->validate([
            'country_id' => 'required',
            'state_id' => 'required',
        ]);

        $country = $this->findOrFail(Country::class, $request->country_id, ['country_id' => $request->country_id]);

        $state = $this->findOrFail(State::class, $request->state_id, ['state_id' => $request->state_id]);

        if($request->has('city_id')) {
            $city = $this->findOrFail(City::class, $request->city_id, ['city_id' => $request->city_id]);
        }

        $location = Location::firstOrCreate([
            'country_id' => $request->has('country_id') ? $request->country_id : null,
            'state_id' => $request->has('state_id') ? $request->state_id : null,
            'city_id' => $request->has('city_id') ? $request->city_id : null,
            'address_1' => $request->has('address_1') ? $request->address_1 : null,
            'address_2' => $request->has('address_2') ? $request->address_2 : null,
            'address_3' => $request->has('address_3') ? $request->address_3 : null
        ]);

        return response(Response::content($request, $location), 201);
    }    

    public function show(Request $request, $id)
    {
        $location = $this->findOrFail(Location::class, $id, ['location_id' => $id]);

        return response(Response::content($request, $location));
    }
}
