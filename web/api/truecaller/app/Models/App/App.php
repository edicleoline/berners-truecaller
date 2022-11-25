<?php

namespace App\Models\App;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;

class App extends Model
{
    use HasFactory;
    protected $table = 'apps';

    protected $appends = [
        
    ];

    protected $fillable = [
        'build_version',
        'major_version',
        'minor_version',
        'store'
    ];

    protected $hidden = [
        'updated_at',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];    
}
