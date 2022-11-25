<?php

namespace App\Core\Location;

use App\Core\Location\Transformers\Generic;
use App\Models\Place\Country;
use App\Models\Place\State;
use App\Models\Place\City;
use App\Models\Place\Location;
use Illuminate\Support\Str;
use App\Core\Helper\Oncer;

class Adapter
{
    protected $countryIso2;
    protected $location;

    protected $transformer;

    protected $oncer;

    public function __construct(string $countryIso2, string $location) {
        $this->countryIso2 = $countryIso2;
        $this->location = $location;

        $this->oncer = new Oncer();
    }

    public static function transform(string $countryIso2, string $location) {
        $adapter = new Adapter($countryIso2, $location);
        $adapter->parse();
        return $adapter;
    }

    public function parse() {
        $br = new Generic($this->countryIso2, $this->location);
        $this->transformer = $br->parse();
    }

    public function getState() {        
        if($this->oncer->hasOnce('state')) return $this->oncer->getOnceValue('state');

        $state = $this->transformer->getState();

        if(is_null($state)) {
            $this->oncer->setOnce('state', null);
            return $this->oncer->getOnceValue('state');
        }

        $model = State::findByIsoCode2(Str::upper($this->countryIso2), Str::upper($state->getCode()));

        $this->oncer->setOnce('state', $model);
        return $model;
    }

    public function getCity() {        
        if($this->oncer->hasOnce('city')) return $this->oncer->getOnceValue('city');

        $city = $this->transformer->getCity();

        if(is_null($city)) {
            $this->oncer->setOnce('city', null);
            return $this->oncer->getOnceValue('city');
        }        

        // $model = City::where('name', $city->getName())
        //     ->where('state_id', $this->getState()->id)
        //     ->first();

        $model = City::findByName($this->getState()->id, $city->getName());

        $this->oncer->setOnce('city', $model);
        return $model;
    }

    public function getCountry() {
        if($this->oncer->hasOnce('country')) return $this->oncer->getOnceValue('country');
       
        $model = Country::findByIsoCode2($this->countryIso2);

        $this->oncer->setOnce('country', $model);
        return $model;
    }

    public function getLocation() {
        $location = null;

        $location = Location::firstOrCreate([
            'country_id' => $this->getCountry()->id,
            'state_id' => !is_null($this->getState()) ? $this->getState()->id : null,
            'city_id' => !is_null($this->getCity()) ? $this->getCity()->id : null,
        ]);        

        return $location;
    }
}