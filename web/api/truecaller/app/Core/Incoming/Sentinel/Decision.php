<?php

namespace App\Core\Incoming\Sentinel;

use App\Core\Incoming\Sentinel\DecisionType;
use JsonSerializable;
use Illuminate\Contracts\Support\Jsonable;
use Illuminate\Contracts\Support\Arrayable;

class Decision implements Arrayable, JsonSerializable, Jsonable
{
    protected $type;
    protected $message;

    public function __construct(DecisionType $type, ?string $message = null) { 
        $this->type = $type;
        $this->message = $message;
    }

    public function toArray() : mixed {
        return [
            'type' => $this->type,
            'message' => $this->message
        ];
    }

    public function jsonSerialize() {
        return $this->toArray();
    }

    public function toJson($options = 0)
    {
        return json_encode($this->jsonSerialize(), $options);
    }   
}