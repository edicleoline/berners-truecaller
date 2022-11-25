<?php

namespace App\Core\Incoming\Sentinel;

use App\Core\Enum\Enum;

final class DecisionType extends Enum
{
    const Allow     = 1;
    const Block     = 2;
    const Ask       = 3;
}