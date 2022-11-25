<?php

namespace App\Models\Phone;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Tag\Tag;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Exceptions\InvalidOperationException;
use App\Core\Facades\Authentication;

class PhoneTag extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'phone_tags';

    protected $fillable = [
        'phone_id',
        'tag_id',
        'verified_at',
        'is_public',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id'
    ];

    protected $appends = [
        'verified',        
    ];

    protected $hidden = [
        'verified_at',
        'updated_at',
        'deleted_at',
        'deleted_by_auth_session_id'
    ];

    protected $casts = [
        'verified_at' => 'datetime',
        'created_at' => 'datetime',
        'deleted_at' => 'datetime',
        'is_public' => 'boolean'
    ];  
    
    public function tag() {
        if($this->hasOnce('tag')) return $this->getOnceValue('tag');

        $tag = Tag::find($this->tag_id);
        $this->setOnce('tag', $tag);
        return $tag;
    }

    protected function getVerifiedAttribute() {
        return !is_null($this->verified_at) ? true : false;
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($tag) {
            if($tag->verified === true) {
                throw InvalidOperationException::withMessage('You cannot delete this record because it has been verified.');
            }
            else if($tag->is_public === true) {
                throw InvalidOperationException::withMessage('You cannot delete this record because it is public.');
            }

            $tag->deleted_by_auth_session_id = Authentication::session()->id;
            $tag->save();

            return true;
        });
    }
}
