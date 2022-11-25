<?php

namespace App\Core\Incoming\Sentinel;
use App\Core\Incoming\Sentinel\EventType;

class Event
{
    public function __construct(
        public EventType $type,
        public array $extra = []
    ) { }
}