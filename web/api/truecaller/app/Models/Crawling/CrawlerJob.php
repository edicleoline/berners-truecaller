<?php

namespace App\Models\Crawling;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class CrawlerJob extends Model
{
    use HasFactory;
    protected $table = 'crawler_jobs';

    protected $appends = [
        
    ];

    protected $fillable = [
        'crawler_id',
        'filename'
    ];

    protected $hidden = [
        
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];
}
