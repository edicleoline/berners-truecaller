<?php

namespace App\Core\Incoming\Event;

use App\Core\Enum\Enum;

final class EventType extends Enum
{
    const CallInitiated         = 1;
    const CallEnded             = 2;
    const CallRecordInitiated   = 3;
    const CallRecordEnded       = 4;

    const SmsReceived           = 50;
    const SmsSent               = 51;
    const SmsDeleted            = 52;
    const SmsMarkedAsSpam       = 53;
    const SmsRead               = 54;
}