<?php

namespace App\Core\Incoming\Sentinel;

use App\Core\Enum\Enum;

final class EventType extends Enum
{
    const UnverifiedUrl     = 1;
    const VerfiedBadUrl     = 2;
}