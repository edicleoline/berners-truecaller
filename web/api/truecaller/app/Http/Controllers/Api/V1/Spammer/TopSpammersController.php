<?php

namespace App\Http\Controllers\Api\V1\Spammer;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Core\Api\Response;
use Illuminate\Support\Facades\Validator;
use App\Core\Enum\Rules\EnumKey;
use App\Core\Incoming\IncomingType;
use App\Models\Phone\TopSpammer;
use Illuminate\Support\Str;

class TopSpammersController extends Controller
{  
    public function list(Request $request, $incomingType)
    {
        $incomingType = Str::lower($incomingType);
        
        Validator::make(['incoming_type' => $incomingType], [
            'incoming_type' => new EnumKey(IncomingType::class),
        ])->validate();

        $incomingType = IncomingType::fromKey($incomingType);

        $pagination = $this->paginationParams($request, [
            'max_results' => 'required|integer|min:1|max:2000',
        ]);

        $topSpammers = TopSpammer::listByIncomingType($this->me()->location->country, 
            $incomingType, $pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $topSpammers));            
    }
}