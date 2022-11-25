<?php

namespace App\Core\Incoming\Sentinel;

use App\Models\Incoming\Incoming;
use JsonSerializable;
use Illuminate\Contracts\Support\Jsonable;
use Illuminate\Contracts\Support\Arrayable;
use App\Core\Incoming\Sentinel\DecisionType;
use App\Core\Incoming\Sentinel\Decision;

class Response implements Arrayable, JsonSerializable, Jsonable
{
    protected $incoming;
    protected $decision;

    public function __construct(Incoming $incoming) { 
        $this->incoming = $incoming;
    }

    public function setDecision(Decision $decision) {
        $this->decision = $decision;
    }

    public function getDecision() {
        return $this->decision;
    }

    public function toArray() : mixed {
        $source = $this->incoming->source;
        $source->makeHidden([
            'blocked',
            'never_block',
            'score',
            'company',
            'user'
        ]);

        return [
            'source' => $source,
            'id' => $this->incoming->id,
            'sentinel' => [
                'decision' => $this->getDecision(),
                'phone' => $this->incoming->phone
            ]
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