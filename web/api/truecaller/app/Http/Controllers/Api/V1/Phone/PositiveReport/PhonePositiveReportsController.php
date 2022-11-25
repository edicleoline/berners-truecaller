<?php

namespace App\Http\Controllers\Api\V1\Phone\PositiveReport;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Phone\Phone;
use App\Models\Phone\PositiveReport\PositiveReport;
use App\Core\Api\Response;

class PhonePositiveReportsController extends Controller
{  
    public function store(Request $request, $phoneId)
    {      
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);

        $report = $phone->addPositiveReport(
            $request->has('text') ? $request->text : null,
            $request->has('anonymous_mode') ? $request->anonymous_mode : false
        );      

        return response(Response::content($request, $report), 201);                     
    }

    public function destroy(Request $request, $reportId)
    { 
        $report = $this->findOrFail(PositiveReport::class, $reportId, ['report_id' => $reportId]);

        $this->validateBasicAuthorization($report->createdBy()->user_id);
        
        $report->delete();

        return response()->noContent();
    }
}
