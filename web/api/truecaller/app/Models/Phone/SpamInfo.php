<?php

namespace App\Models\Phone;

use App\Models\Phone\TopSpammer;
use App\Models\Phone\Phone;
use JsonSerializable;
use Illuminate\Contracts\Support\Jsonable;
use Illuminate\Contracts\Support\Arrayable;

class SpamInfo implements Arrayable, JsonSerializable, Jsonable {
    protected $phone;

    protected $score;
    protected $blacklisted;
    protected $blacklist;
    protected $label;

    public function __construct(Phone $phone) {
        $this->phone = $phone;
    }

    public function getReport() {
        $topSpammer = TopSpammer::selectRaw('top_phone_spammers.*')
            ->where('top_phone_spammers.phone_id', $this->phone->id)
            ->first();

        if(is_null($topSpammer)) {
            $this->blacklisted = false;
            return $this;
        }

        $this->blacklisted = true;
        $this->blacklist = "top_spammer";
        $this->score = $topSpammer->reports_count;
        $this->label = $topSpammer->label;

        return $this;
    }

    public function toArray() : mixed {
        if($this->blacklisted === false) {
            return [
                'blacklisted' => $this->blacklisted
            ];
        }

        $response = [
            'score' => $this->score,
            'blacklisted' => $this->blacklisted,
            'blacklist' => $this->blacklist,
            // 'label' => $this->label
        ];

        return $response;
    }

    public function jsonSerialize() {
        return $this->toArray();
    }

    public function toJson($options = 0)
    {
        return json_encode($this->jsonSerialize(), $options);
    }    
}