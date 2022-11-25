<?php

namespace App\Exceptions;

use Exception;
use Illuminate\Support\Arr;

class InvalidOperationException extends Exception
{
    /**
     * The status code to use for the response.
     *
     * @var int
     */
    public $status = 406;

    public $subcode;

    /**
     * Create a new exception instance.
     *
     * @param  string  $message
     * @return void
     */
    public function __construct($message = 'Object has invalid state.', $subcode = null)
    {
        parent::__construct($message);
        $this->subcode = $subcode;
    }

    /**
     *
     *
     * @param  string  $message
     * @return static
     */
    public static function withMessage(string $message, $subcode = null)
    {
        return new static($message, $subcode);
    }

    /**
     * Set the HTTP status code to be used for the response.
     *
     * @param  int  $status
     * @return $this
     */
    public function status($status)
    {
        $this->status = $status;

        return $this;
    }
}
