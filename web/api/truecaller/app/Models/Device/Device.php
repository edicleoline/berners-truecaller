<?php

namespace App\Models\Device;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;

class Device extends Model
{
    use HasFactory;
    protected $table = 'devices';

    protected $appends = [
        
    ];

    protected $fillable = [
        'device_id',
        'lang',
        'manufacturer',
        'model',
        'os_name',
        'os_version',
    ];

    protected $hidden = [
        'updated_at',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];    
}
