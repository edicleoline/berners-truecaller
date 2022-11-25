<?php

namespace App\Models\Place;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use Illuminate\Support\Facades\App;
use Illuminate\Support\Str;
use App\Models\Place\Country;
use App\Models\Place\State;
use App\Models\Place\City;

class Location extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'locations';

    protected $fillable = [
        'country_id',
        'state_id',
        'city_id',
        'address_1',
        'address_2',
        'address_3',        
    ];

    protected $appends = [
        'formatted',
        'country',
        'state',
        'city'
    ];

    protected $hidden = [
        'deleted_at',
        'updated_at',
        'country',
        'state',
        'city'
    ];

    protected $casts = [
        'created_at' => 'datetime'
    ];

    public static function findOrCreate(Country $country, ?State $state = null, ?City $city = null, 
        ?string $addr1 = null, ?string $addr2 = null, ?string $addr3 = null) {
        return Location::firstOrCreate([
            'country_id' => $country->id,
            'state_id' => !is_null($state) ? $state->id : null,
            'city_id' => !is_null($city) ? $city->id : null,
            'address_1' => !is_null($addr1) ? $addr1 : null,
            'address_2' => !is_null($addr2) ? $addr2 : null,
            'address_3' => !is_null($addr3) ? $addr3 : null,
        ]);
    }

    protected function getFormattedAttribute() {                        
        $city = $this->city;
        $state = $this->state;
        // $country = $this->country;

        // $locale = App::getLocale();

        if(!is_null($city) && is_null($state)) {
            $state = $city->state;
        }

        $f = "";

        if(!is_null($city) && !is_null($state)) {
            $f .= "{$city->name}";
            if($city->name !== $state->name) {
                $f .= Str::length($city->name) < 20 ? ", {$state->name}" : ", {$state->iso2}";
            }

            return $f;
        }

        if(is_null($city) && !is_null($state)) {
            $f .= "{$state->name}";

            return $f;
        }

        return $f;
    }

    protected function getCountryAttribute() {
        if($this->hasOnce('country')) return $this->getOnceValue('country');

        $country = !is_null($this->country_id) ? Country::findById($this->country_id) : null;
        $this->setOnce('country', $country);
        return $country;
    }

    protected function getStateAttribute() {
        if($this->hasOnce('state')) return $this->getOnceValue('state');

        $state = !is_null($this->state_id) ? State::findById($this->state_id) : null;
        $this->setOnce('state', $state);
        return $state;
    }

    protected function getCityAttribute() {
        if($this->hasOnce('city')) return $this->getOnceValue('city');

        $city = !is_null($this->city_id) ? City::findById($this->city_id) : null;
        $this->setOnce('city', $city);
        return $city;
    }


    public function makeVisibleBasic() {
        $this->setHidden(array_merge($this->hidden, [
            'created_at',
        ]));
    }
}
