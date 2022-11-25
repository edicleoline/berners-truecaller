<?php

namespace App\Models\Storage;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Support\Facades\Storage;

class Path extends Model
{
    use HasFactory;
    protected $table = 'storage_paths';

    protected $fillable = [
        'disk_name',
        'path',
    ];

    protected $hidden = [
        'updated_at'
    ];

    protected $appends = [
        'disk'
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime'
    ];

    protected function getDiskAttribute() {
        if($this->hasOnce('disk')) return $this->getOnceValue('disk');

        $disk = Storage::disk($this->disk_name);
        $this->setOnce('disk', $disk);
        return $disk;
    }

    public static function getOrCreate(string $disk_name, string $storage_path) {
        return Path::firstOrCreate([
            'disk_name' => $disk_name,
            'path' => $storage_path
        ]);
    }
}
