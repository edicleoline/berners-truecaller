<?php

namespace App\Core\Person;
use App\Core\Enum\Enum;

final class Gender extends Enum
{
    const Custom = 1;
    const Female = 2;
    const Male   = 3;
}
