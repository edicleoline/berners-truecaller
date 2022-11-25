<?php

namespace App\Models\Resources;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Storage\Path;

class Icon extends Model
{
    use HasFactory;
    protected $table = 'icons';

    protected $appends = [
        'src'
    ];

    protected $fillable = [
        'storage_path_id',    
        'path'
    ];

    protected $hidden = [
        'updated_at',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];   

    public function storage() {
        if($this->hasOnce('storage')) return $this->getOnceValue('storage');

        $storage = Path::find($this->storage_path_id);
        $this->setOnce('storage', $storage);
        return $storage;
    }

    protected function getSrcAttribute() {        
        return $this->storage()->disk->url($this->path);
    }

    public function makeVisibleBasic() {
        $this->setHidden(array_merge($this->hidden, [
            'created_at',
            'updated_at',
            'storage_path_id',
            'path',
            'id'
        ]));
    }
}
