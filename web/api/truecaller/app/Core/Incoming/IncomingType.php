<?php

namespace App\Core\Incoming;

use App\Core\Enum\Enum;

final class IncomingType extends Enum
{
    const Call      = 1;
    const Sms       = 2;
}