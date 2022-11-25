<?php

namespace App\Models\Place;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Pagination\Cursor;
use Illuminate\Support\Facades\Cache;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use Illuminate\Support\Str;

class Country extends Model
{
    use HasFactory;
    protected $table = 'countries';

    protected $fillable = [
        'name',
        'iso2',
        'iso3',
        'phonecode',
        'timezones',
        'translations'
    ];

    protected $hidden = [
        
    ];

    protected $casts = [
        'timezones' => 'array',
        'translations' => 'array'
    ];

    public static function findOrFailByIsoCode2(string $code) {
        $country = static::findByIsoCode2($code);

        if(is_null($country)) {
            $exception = new ModelNotFoundException();
            $exception->setModel(Country::class, [$code]);
            throw $exception;  
        }

        return $country;
    }

    public static function findById($id) {
        return Cache::rememberForever("countries_id_{$id}", function() use ($id) {
            return Country::find($id);
        });
    }

    public static function findByIsoCode2(string $code) {
        return Cache::rememberForever("countries_iso2_{$code}", function() use ($code) {
            return Country::where('iso2', $code)
                ->first();
        });
    }

    public static function list($maxResults = 1, $paginationToken = null) {
        $paginator = Country::select(['countries.*'])
            ->orderBy('countries.id', 'asc')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    public function getName(?string $lang = null) {
        if(is_null($lang)) {
            return $this->native;
        }

        if(Str::lower($lang) === 'en') {
            return $this->name;
        }

        if(is_null($this->translations) || !is_array($this->translations)) {
            return $this->name;
        }

        foreach($this->translations as $key => $value) {
            if(Str::lower($key) === trim(Str::lower($lang))) {
                return $value;
            }
        }

        return $this->native;
    }
}
