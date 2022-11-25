<?php

namespace App\Models\Phone;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Place\Location;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Facades\Authentication;

class PhoneLocation extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'phone_locations';

    protected $fillable = [
        'phone_id',
        'location_id',
        'created_by_auth_session_id',
        'verified_at',
        'deleted_by_auth_session_id'
    ];

    protected $appends = [
        'verified',        
    ];

    protected $hidden = [
        'verified_at',
        'updated_at',
        'deleted_at',
        'deleted_by_auth_session_id'
    ];

    protected $casts = [
        'verified_at' => 'datetime',
        'created_at' => 'datetime',
        'deleted_at' => 'datetime',
    ];    

    public function location() {
        if($this->hasOnce('location')) return $this->getOnceValue('location');

        $location = !is_null($this->location_id) ? Location::find($this->location_id) : null;
        $this->setOnce('location', $location);
        return $location;
    }

    protected function getVerifiedAttribute() {
        return !is_null($this->verified_at) ? true : false;
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($phoneLocation) {            
            $phoneLocation->deleted_by_auth_session_id = Authentication::session()->id;
            $phoneLocation->save();

            return true;
        });
    }
}
