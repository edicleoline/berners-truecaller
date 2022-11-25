<?php

namespace App\Http\Controllers\Api\V1\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Phone\Phone;
use App\Models\Place\Country;
use App\Core\Api\Response;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use App\Exceptions\ObjectNotFoundException;

class PhoneLookupController extends Controller
{  
    public function show(Request $request, $countryIso2, $phoneNumber)
    {      
        try {
            $country = Country::findOrFailByIsoCode2($countryIso2);
        }
        catch (ModelNotFoundException $exception) {
            throw ObjectNotFoundException::withQueryParam(['country_iso2' => $countryIso2]);
        }    


        // $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);

        // $verifier = $phone->verifier()->start();  

        // return response(Response::content($request, $verifier), 201);

        dd('lookup');
    }
}
