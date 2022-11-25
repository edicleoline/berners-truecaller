<?php

namespace App\Models\Place;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Pagination\Cursor;
use App\Models\Place\Country;
use Illuminate\Support\Facades\Cache;

class State extends Model
{
    use HasFactory;
    protected $table = 'states';

    protected $fillable = [
        'name',        
        'country_id',
        'country_code',
        'iso2'
    ];

    protected $hidden = [
        
    ];

    protected $casts = [
       
    ];
    
    public static function listByCountry(Country $country, $maxResults = 1, $paginationToken = null) {
        $paginator = State::select(['states.*'])
            ->where('country_id', $country->id)
            ->orderBy('states.name', 'asc')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    public static function findByIsoCode2(string $countryCode, string $stateCode) {
        return Cache::rememberForever("states_country_code_{$countryCode}_iso2_{$stateCode}", function() use ($countryCode, $stateCode) {
            return State::where('country_code', $countryCode)
                ->where('iso2', $stateCode)
                ->first();
        });
    }

    public static function findById($id) {
        return self::find($id);
    }
}
