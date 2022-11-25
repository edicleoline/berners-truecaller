<?php

namespace App\Core\Helper;

class Oncer
{
    protected $onces = [];

    public function setOnce(string $name, $value) {
        $once = $this->getOnce($name);

        if(!is_null($once)) {
            $once->value = $value;
            return true;
        }

        $once = new \stdClass();
        $once->name = $name;
        $once->value = $value;
        $this->onces[] = $once;

        return true;
    }

    public function getOnce(string $name) {
        foreach($this->onces as $once) {
            if($once->name === $name) {
                return $once;
            }
        }

        return null;
    }

    public function getOnceValue(string $name) {
        $once = $this->getOnce($name);
        return !is_null($once) ? $once->value : null;
    }

    public function isOnceValueNull(string $name) {
        return is_null($this->getOnceValue($name));
    }

    public function hasOnce(string $name) {
        return !is_null($this->getOnce($name));
    }
}