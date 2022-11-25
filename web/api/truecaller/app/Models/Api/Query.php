<?php

namespace App\Models\Api;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use Illuminate\Support\Facades\Cache;

class Query extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'api_queries';

    protected $appends = [
        
    ];

    protected $fillable = [
        'api_resource_id',
        'fields',
    ];

    protected $hidden = [
        'deleted_at',
        'updated_at',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
    ];

    public static function findById($id) {
        // return Cache::rememberForever("api_queries_id_{$id}", function() use ($id) {
        //     return Query::find($id);
        // });

        return Query::find($id);
    }
}
