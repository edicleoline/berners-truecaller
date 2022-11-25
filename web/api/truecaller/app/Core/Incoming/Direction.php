<?php

namespace App\Core\Incoming;

use App\Core\Enum\Enum;

final class Direction extends Enum
{
    const Incoming      = 1;
    const Outgoing      = 2;
}