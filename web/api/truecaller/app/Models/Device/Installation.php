<?php

namespace App\Models\Device;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Account\Auth\Session;

class Installation extends Model
{
    use HasFactory;
    protected $table = 'device_installations';

    protected bool $useUuid = true;

    protected $appends = [
        
    ];

    protected $fillable = [
        'app_id',
        'device_id',
        'lang',
        'country_id',
        'region'
    ];

    protected $hidden = [
        'updated_at',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];

    public function getSession() {
        return Session::findByInstallation($this);
    }
}
