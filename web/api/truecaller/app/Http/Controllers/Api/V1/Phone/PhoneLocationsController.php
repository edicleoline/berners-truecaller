<?php

namespace App\Http\Controllers\Api\V1\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Place\Location;
use App\Models\Phone\Phone;
use App\Core\Api\Response;
use App\Models\Phone\PhoneLocation;

class PhoneLocationsController extends Controller
{      
    public function store(Request $request, $phoneId)
    {   
        $validated = $request->validate([
            'location_id' => 'required',
        ]);

        $me = $this->me();

        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $location = $this->findOrFail(Location::class, $request->location_id, ['location_id' => $request->location_id]);

        $phoneLocation = $phone->addLocation($location);

        return response(Response::content($request, $phoneLocation), 201);               
    }

    public function destroy(Request $request, $phoneId, $locationId)
    {           
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $location = $this->findOrFail(Location::class, $locationId, ['location_id' => $locationId]);

        $phone->removeLocation($location);

        return response()->noContent();
    }
}
