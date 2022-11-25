<?php

namespace App\Models\Account;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;

class Group extends Model
{
    use HasFactory;
    protected $table = 'user_groups';

    protected $appends = [
        
    ];

    protected $fillable = [
        'name',
    ];

    protected $hidden = [        
        'updated_at',        
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];

    public static function findByName($name) {
        return Group::where('name', $name)
            ->first();
    }
}
