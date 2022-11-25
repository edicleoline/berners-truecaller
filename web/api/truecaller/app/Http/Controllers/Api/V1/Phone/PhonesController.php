<?php

namespace App\Http\Controllers\Api\V1\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Phone\Phone;
use App\Core\Api\Response;

class PhonesController extends Controller
{
    public function show(Request $request, $id)
    {
        $phone = $this->findOrFail(Phone::class, $id, ['phone_id' => $id]);
        sleep(2);
        return response(Response::content($request, $phone));
    }

    public function store(Request $request)
    {
        $phone = Phone::findOrCreate($request->phone, $request->country_code, true);
        return response(Response::content($request, $phone), 201);
    }
}
