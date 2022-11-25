<?php

namespace App\Http\Controllers\Api\V1\Company;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Company\Company;
use App\Core\Api\Response;

class CompaniesController extends Controller
{
    public function show(Request $request, $id)
    {
        $company = $this->findOrFail(Company::class, $id, ['company_id' => $id]);

        return response(Response::content($request, $company));
    }   
}
