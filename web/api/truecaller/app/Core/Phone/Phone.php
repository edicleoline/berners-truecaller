<?php

namespace App\Core\Phone;
use Illuminate\Support\Str;
use App\Models\Phone\Phone as PhoneModel;
use App\Models\Company\Company;
use Illuminate\Support\Facades\App;
use App\Models\Place\Country;
use App\Models\Place\Location;
use App\Core\Helper\StringUtil;
use Propaganistas\LaravelPhone\PhoneNumber;
use libphonenumber\PhoneNumberUtil;
use libphonenumber\geocoding\PhoneNumberOfflineGeocoder;
use libphonenumber\PhoneNumberToCarrierMapper;
use Exception;
use App\Core\Location\Adapter;
use Illuminate\Support\Facades\Log;

class Phone
{
    protected $number;
    protected $country;

    protected $util;
    protected $carrierMapper;
    protected $lib;
    protected $errors;

    protected $nationalFormat;
    protected $e164Format;
    protected $numberType;

    public function __construct(string $number, ?Country $country) {
        $this->number = $number;
        $this->country = $country;
        $this->errors = [];
        $this->util = PhoneNumberUtil::getInstance();
        $this->carrierMapper = PhoneNumberToCarrierMapper::getInstance();
    }

    protected function parseNumber() {
        $this->lib = PhoneNumber::make($this->number, (null !== $this->country ? $this->country->iso2 : null));

        $countryCode = null;
        try { 
            $countryCode = $this->lib->getCountry(); 
            $this->nationalFormat = $this->lib->formatNational();
            $this->e164Format = $this->lib->formatE164();
            $this->numberType = $this->lib->getType();
        }
        catch(Exception $e) {
            $this->errors[] = $e;
        }

        if(is_null($this->country) && !is_null($countryCode)) {
            try { $this->country = Country::findOrFailByIsoCode2($countryCode); }
            catch (Exception $e) {
                $this->errors[] = $e;
            }
        }

        if(is_null($this->numberType)) {
            $this->numberType = "unknown";
        }

        if(is_null($this->nationalFormat)) {
            $this->nationalFormat = $this->number;
        }

        if(is_null($this->e164Format)) {
            $this->e164Format = $this->number;
        }
    }

    public function hasError() {
        return !is_null($this->errors) && count($this->errors) > 0 ? true : false;
    }

    public function formatNational() {
        return $this->nationalFormat;
    }

    public function formatNationalNormalized() {
        return preg_replace("/[^0-9]/", '', $this->formatNational());
    }

    public function formatE164() {
        return $this->e164Format;
    }

    public function getType() {
        return $this->numberType;
    }

    public function getCountry() {
        return $this->country;
    }

    public function getLocation() {
        $geocoder = PhoneNumberOfflineGeocoder::getInstance();
        $location = $geocoder->getDescriptionForNumber($this->lib->getPhoneNumberInstance(), App::getLocale());

        try {
            $adapter = Adapter::transform($this->getCountry()->iso2, $location);     
            return $adapter->getLocation();
        }
        catch(Exception $exception) { 
            Log::error($exception);
        }

        if(empty($location) && !is_null($this->getCountry())) {
            return Location::firstOrCreate([
                'country_id' => $this->getCountry()->id,
                'state_id' => null,
                'city_id' => null,
                'address_1' => null,
                'address_2' => null,
                'address_3' => null,
            ]);
        }

        if(!empty($location)) {
            $location = Location::firstOrCreate([
                'country_id' => !is_null($this->getCountry()) ? $this->getCountry()->id : null,
                'state_id' => null,
                'city_id' => null,
                'address_1' => $location,
                'address_2' => null,
                'address_3' => null,
            ]);
    
            return $location;
        }
        
        return null;
    }

    public function getCarrier() {
        $utilParsed = $this->util->parse($this->number, (null !== $this->country ? $this->country->iso2 : null));
        $carrierName = $this->carrierMapper->getNameForNumber($utilParsed, App::getLocale());

        if(empty($carrierName)) return null;

        $company = Company::firstOrCreate([
            'name' => $carrierName
        ]);

        return $company;
    }

    public static function parse(string $number, ?Country $country = null) {
        $phone = new static(static::unformatted($number), $country);
        $phone->parseNumber();

        return $phone;
    }

    public static function isPossiblePhone($value) {
        $isNumeric = ctype_digit(preg_replace('/\s+/S', "", StringUtil::alpha($value)));

        return $isNumeric === true;
    }    

    public static function unformatted(string $number) {
        return preg_replace("/[^0-9+]/", '', $number);
    }
}