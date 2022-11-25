<?php

namespace App\Models\Place;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Pagination\Cursor;
use App\Models\Place\State;
use Illuminate\Support\Facades\Cache;
use App\Core\Helper\StringUtil;

class City extends Model
{
    use HasFactory;
    protected $table = 'cities';

    protected $fillable = [
        'name',
        'state_id'
    ];

    protected $appends = [
        'state',
    ];

    protected $hidden = [
        
    ];

    protected $casts = [
       
    ];
    
    public static function listByState(State $state, $maxResults = 1, $paginationToken = null) {
        $paginator = City::select(['cities.*'])
            ->where('state_id', $state->id)
            ->orderBy('cities.name', 'asc')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    public static function findByName(string $stateId, string $cityName) {
        $encodedCityName = StringUtil::encode($cityName);

        return Cache::rememberForever("cities_state_id_{$stateId}_name_{$encodedCityName}", function() use ($stateId, $cityName) {
            return City::where('state_id', $stateId)
                ->where('name', $cityName)
                ->first();
        });
    }

    public static function findById($id) {
        return self::find($id);
    }

    protected function getStateAttribute() {
        if($this->hasOnce('state')) return $this->getOnceValue('state');

        $state = !is_null($this->state_id) ? State::findById($this->state_id) : null;
        $this->setOnce('state', $state);
        return $state;
    }
}
