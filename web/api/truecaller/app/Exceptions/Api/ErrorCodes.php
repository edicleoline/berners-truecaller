<?php

namespace App\Exceptions\Api;

class ErrorCodes
{
    public const VALIDATION_FIELD = 1501001;
    public const OBJECT_NOT_FOUND = 4004001;
    public const RESOURCE_NOT_FOUND = 4004040;
    public const BAD_REQUEST = 4001020;
    public const BAD_AUTHENTICATION = 1901020;
    public const DATA_INTEGRITY_VIOLATION = 2301010;
    public const INVALID_OPERATION = 3901010;
    public const UNSUPPORTED_FILE_EXCEPTION = 6501010;

    public const FORBIDDEN = 3201010;
}
