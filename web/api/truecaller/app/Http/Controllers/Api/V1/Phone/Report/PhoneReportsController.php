<?php

namespace App\Http\Controllers\Api\V1\Phone\Report;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Phone\Phone;
use App\Models\Phone\Report\Report;
use App\Core\Api\Response;
use App\Core\Enum\Rules\EnumKey;
use App\Models\Phone\Report\Category;
use App\Core\Enum\EntityType;

class PhoneReportsController extends Controller
{  
    public function list(Request $request, $phoneId)
    {      
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);

        $pagination = $this->paginationParams($request);
        $reports = Report::listByPhone($phone, $pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $reports));          
    }

    public function store(Request $request, $phoneId)
    {      
        $request->validate([
            'entity_type' => ['required', new EnumKey(EntityType::class)],
        ]);

        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);

        $category = $this->findOrFail(Category::class, $request->report_category_id, ['report_category_id' => $request->report_category_id]);                

        $report = $phone->addReport(
            $category,
            EntityType::fromKey($request->entity_type),
            $request->has('anonymous_mode') ? $request->anonymous_mode : false
        );

        return response(Response::content($request, $report), 201);            
    }

    public function destroy(Request $request, $reportId)
    { 
        $report = $this->findOrFail(Report::class, $reportId, ['report_id' => $reportId]);

        $this->validateBasicAuthorization($report->createdBy()->user_id);
        
        $report->delete();

        return response()->noContent();
    }
}
