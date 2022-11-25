<?php

namespace App\Models\Posting;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Facades\Authentication;

class Post extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'posts';

    protected $appends = [
        'created_by',
    ];

    protected $fillable = [
        'text',
        'anonymous_mode',
        'created_by_auth_session_id',
    ];

    protected $hidden = [
        'deleted_at',
        'updated_at',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id'
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
        'anonymous_mode' => 'boolean'
    ];

    protected function getCreatedByAttribute() {
        return $this->createdBy();
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($post) {  
            $post->deleted_by_auth_session_id = Authentication::session()->id;
            $post->save();
            
            return true;
        });
    }
}
