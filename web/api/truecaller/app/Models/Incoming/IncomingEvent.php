<?php

namespace App\Models\Incoming;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Core\Incoming\Event\EventType;
use App\Core\Incoming\IncomingType;
use App\Models\Incoming\Incoming;
use Illuminate\Support\Str;

class IncomingEvent extends Model
{
    use HasFactory;
    protected $table = 'incoming_events';

    protected $fillable = [
        'incoming_id',
        'event_type',
        'fired_at',
    ];

    protected $appends = [
        
    ];

    protected $hidden = [
       'updated_at'
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'fired_at' => 'datetime',
        'event_type' => EventType::class
    ];

    public static function isValidEventType(Incoming $incoming, EventType $eventType) {
        $isValidType = Str::startsWith(Str::snake($eventType->key), Str::snake($incoming->incoming_type->key));

        return $isValidType;
    }
}
