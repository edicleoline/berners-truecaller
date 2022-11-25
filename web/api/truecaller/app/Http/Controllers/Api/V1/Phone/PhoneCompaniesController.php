<?php

namespace App\Http\Controllers\Api\V1\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Company\Company;
use App\Models\Phone\Phone;
use App\Core\Api\Response;
use App\Models\Phone\PhoneCompany;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use App\Exceptions\ObjectNotFoundException;

class PhoneCompaniesController extends Controller
{      
    public function store(Request $request, $phoneId)
    {   
        $validated = $request->validate([
            'company_id' => 'required',
        ]);

        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $company = $this->findOrFail(Company::class, $request->company_id, ['company_id' => $request->company_id]);

        $phoneCompany = $phone->addCompany($company);

        return response(Response::content($request, $phoneCompany), 201);            
    }

    public function destroy(Request $request, $phoneId, $companyId)
    {           
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $company = $this->findOrFail(Company::class, $companyId, ['company_id' => $companyId]);

        $phone->removeCompany($company);        

        return response()->noContent();
    }
}
