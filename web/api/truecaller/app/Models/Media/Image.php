<?php

namespace App\Models\Media;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Models\Uploading\Upload;
use App\Models\Uploading\Media;

class Image extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'images';

    protected $fillable = [
        'media_id',
        'alias',
        'width',
        'height'
    ];

    protected $hidden = [
        'deleted_at',
        'updated_at',
    ];

    protected $appends = [
        'media',
        'url'
    ];

    protected $casts = [
        'deleted_at' => 'datetime'
    ];

    protected Media $_media;

    protected function getMediaAttribute() {
        if(isset($this->_media)) return $this->_media;

        $this->_media = Media::find($this->media_id);
        return $this->_media;
    }

    public static function imageByMedia(int $mediaId, ?string $alias) {
        $image = Image::where('media_id', $mediaId)
            ->where('alias', $alias);

        return $image->first();
    }

    public static function originalImageByMedia(int $mediaId) {
        return self::imageByMedia($mediaId, null);
    }

    protected function getUrlAttribute() {
        if(is_null($this->alias)) {
            return $this->media->upload->base_path->disk->url(
                $this->media->upload->base_path->path . '/' . $this->media->upload->path . '/' . $this->media->upload->filename
            );
        }

        return null;
    }
}
