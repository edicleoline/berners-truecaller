<?php

namespace App\Models\Device;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Sim extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'device_sims';

    protected $appends = [
        
    ];

    protected $fillable = [
        'device_id',
        'serial',
        'imsi',
        'mcc',
        'mnc',
        'operator',
    ];

    protected $hidden = [
        'updated_at',
        'deleted_at'
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
    ];    
}
