<?php

namespace App\Exceptions;

class ObjectNotFoundException extends \Exception
{
    public $subcode = 2;
    public $params;

    public function __construct($message = null, $subcode = null, $params = null)
    {
        parent::__construct($message);
        $this->subcode = $subcode;
        $this->params = $params;
    }

    public static function withSubcode($subcode = null, $message = 'Object not found.')
    {
        return new static($message, $subcode);
    }

    public static function withQueryParam($params, $subcode = null, $message = 'Object not found.')
    {
        return new static($message, $subcode, $params);
    }
}
