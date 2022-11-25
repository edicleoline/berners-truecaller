<?php

namespace App\Http\Controllers\Api\V1\Incoming;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Phone\Phone;
use App\Core\Api\Response;
use App\Models\Incoming\Incoming;
use App\Core\Incoming\Direction;
use App\Core\Incoming\Sentinel\Engine;
use App\Core\Facades\Authentication;

class IncomingsController extends Controller
{
    protected function createIncoming(Request $request, Direction $direction) {
        $request->validate([
            'source' => 'required',
        ]);

        $source = Phone::findOrCreate($request->source, $request->source_country_code, true);
        $target = $request->has('target') ? Phone::findOrCreate($request->target, $request->target_country_code, true) : null;        

        $incoming = new Incoming();
        $incoming->created_by_auth_session_id = Authentication::session()->id;
        $incoming->source_phone_id = $source->id;
        $incoming->target_phone_id = !is_null($target) ? $target->id : null;
        $incoming->sms_text = $request->has('sms_text') ? $request->sms_text : null;
        $incoming->direction = $direction;
        $incoming->save();

        return $incoming;
    }

    public function store(Request $request) {
        $incoming = $this->createIncoming($request, Direction::fromValue(Direction::Incoming));
        
        $engine = new Engine($incoming);
        $response = $engine->execute();
        
        return response(Response::content($request, $response));
    }

    public function storeOutgoing(Request $request) {
        $outgoing = $this->createIncoming($request, Direction::fromValue(Direction::Outgoing));              
        
        return response(Response::content($request, $outgoing));
    }
}
