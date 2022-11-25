<?php

namespace App\Models\Search;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;

class Search extends Model
{
    use HasFactory;
    protected $table = 'searches';

    protected $appends = [
        
    ];

    protected $fillable = [
        'query',
        'created_by_auth_session_id',
    ];

    protected $hidden = [
        'updated_at',
        'created_by_auth_session_id'
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];

}
