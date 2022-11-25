<?php

namespace App\Core\Location\Transformers;

// use App\Models\Place\Country;
use Illuminate\Support\Str;

use CommerceGuys\Addressing\AddressFormat\AddressFormatRepository;
use CommerceGuys\Addressing\Country\CountryRepository;
use CommerceGuys\Addressing\Subdivision\SubdivisionRepository;

class Generic
{
    protected $location;
    protected $states;
    protected $subdivisionRepository;

    protected $countryIso2;

    protected $state;
    protected $city;

    public function __construct(string $countryIso2, string $location) {
        $this->countryIso2 = $countryIso2;
        $this->location = $location;

        $this->subdivisionRepository = new SubdivisionRepository();
        $this->states = $this->subdivisionRepository->getAll([$this->countryIso2]);
    }

    public function getState() {
        return $this->state;
    }

    public function getCity() {
        return $this->city;
    }

    protected function getStateByIso2(string $iso2) {        
        foreach ($this->states as $state) {
            if(trim(Str::upper($iso2)) == trim(Str::upper($state->getCode()))) {
                return $state;
            }
        }

        return null;
    }

    protected function getStateByName(string $name) {        
        foreach ($this->states as $state) {
            if(trim(Str::upper($name)) == trim(Str::upper($state->getName()))) {
                return $state;
            }
        }

        return null;
    }

    protected function getCityByName(string $name) {
        $cities = $this->subdivisionRepository->getAll([$this->countryIso2, $this->state->getCode()]);
        foreach($cities as $city) {
            if(trim(Str::upper($name)) == trim(Str::upper($city->getName()))) {
                return $city;
            }
        }

        return null;
    }

    public function parse() {
        $items = [];
        foreach(preg_split('/[;,-]/', $this->location) as $part) {
            $items[] = (object)[
                'value' => trim($part),
                'parsed' => false
            ];
        }       

        if(count($items) < 2) {
            foreach($items as $item) {
                if($item->parsed === true) continue;
    
                $state = $this->getStateByName($item->value);
                if(!is_null($state)) {
                    $this->state = $state;
                    $item->parsed = true;
                }
            }
        }
        
        foreach($items as $item) {
            if($item->parsed === true) continue;

            $state = $this->getStateByIso2($item->value);
            if(!is_null($state)) {
                $this->state = $state;
                $item->parsed = true;
            }
        }

        if(!is_null($this->state)) {
            foreach($items as $item) {
                if($item->parsed === true) continue;

                $city = $this->getCityByName($item->value);
                if(!is_null($city)) {
                    $this->city = $city;
                    $item->parsed = true;
                }
            }            
        }

        return $this;
    }
}