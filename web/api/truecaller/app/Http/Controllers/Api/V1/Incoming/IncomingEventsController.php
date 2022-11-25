<?php

namespace App\Http\Controllers\Api\V1\Incoming;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Core\Api\Response;
use App\Models\Incoming\Incoming;
use App\Core\Enum\Rules\EnumKey;
use App\Models\Incoming\IncomingEvent;
use App\Core\Incoming\Event\EventType;
use Carbon\Carbon;
use BenSampo\Enum\Exceptions\InvalidEnumKeyException;
use App\Core\Incoming\Direction;
use App\Exceptions\ObjectNotFoundException;

class IncomingEventsController extends Controller
{
    protected function getIncoming(mixed $id, Direction $direction) {
        $incoming = Incoming::where('id', $id)
            ->where('direction', $direction)
            ->first();

        if(is_null($incoming)) {
            throw ObjectNotFoundException::withQueryParam(['incoming_id' => $id]);
        }

        return $incoming;
    }

    protected function createEvent(Request $request, Incoming $incoming) {
        $request->validate([
            'event_type' => [
                'required', 
                new EnumKey(EventType::class),
                function($attribute, $value, $fail) use ($incoming) {
                    try {
                        $eventType = EventType::fromKey($value);
                        if(!IncomingEvent::isValidEventType($incoming, $eventType)) {
                            $fail(__('validation.incoming_event_type', ['attribute' => $attribute]));
                        }
                    }
                    catch(InvalidEnumKeyException) { }
                },
            ],
            'fired_at' => 'required|date_format:Y-m-d\TH:i:s.u\Z',            
        ]);
        
        $firedAt = Carbon::parse($request->fired_at);
        $eventType = EventType::fromKey($request->event_type);

        $incomingEvent = new IncomingEvent();
        $incomingEvent->incoming_id = $incoming->id;
        $incomingEvent->fired_at = $firedAt;
        $incomingEvent->event_type = $eventType;

        $incomingEvent->save();

        return $incomingEvent;
    }

    public function store(Request $request, $incomingId) {

        $incoming = $this->getIncoming($incomingId, Direction::fromValue(Direction::Incoming));
        $this->validateBasicAuthorization($incoming->createdBy()->user_id);        
        $incomingEvent = $this->createEvent($request, $incoming);
                
        return response(Response::content($request, $incomingEvent));
    }   

    public function storeOutgoing(Request $request, $outgoingId) {

        $outgoing = $this->getIncoming($outgoingId, Direction::fromValue(Direction::Outgoing));
        $this->validateBasicAuthorization($outgoing->createdBy()->user_id);        
        $outgoingEvent = $this->createEvent($request, $outgoing);
                
        return response(Response::content($request, $outgoingEvent));
    }   
}
