<?php

namespace App\Exceptions\Api;

class ErrorSubcodes
{
    public const PHONE_VERIFIER_NOT_INITIALIZED = 1001095;
    public const EMAIL_VERIFIER_NOT_INITIALIZED = 1001195;

    public const COUNTRY_OBJECT_NOT_FOUND = 2002105;

    public const AUTH_TOKEN_NOT_FOUND = 1901002;
    public const AUTH_INVALID_TOKEN = 1901005;
    public const AUTH_TOKEN_EXPIRED = 1901008;    

}
