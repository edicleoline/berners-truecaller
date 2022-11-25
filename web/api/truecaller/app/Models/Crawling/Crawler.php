<?php

namespace App\Models\Crawling;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Core\Casts\ArrayClosure;

class Crawler extends Model
{
    use HasFactory;
    protected $table = 'crawlers';

    protected $appends = [
        
    ];

    protected $fillable = [
        'name',
        'url',
        'transformers',
        'dictionary'
    ];

    protected $hidden = [
        
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'dictionary' => 'array',
        'transformers' => ArrayClosure::class
    ];    
}
