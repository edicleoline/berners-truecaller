<?php

namespace App\Models\Media;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Models\Uploading\Upload;
use App\Models\Uploading\Media;

class Video extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'videos';

    protected $fillable = [
      'media_id',
      'alias',
      'content_type',
      'filename',
      'kilo_bitrate',
      'width',
      'height'
    ];

    protected $hidden = [
      'deleted_at',
      'updated_at'
    ];

    protected $appends = [
      'media'
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

    public static function videoByMedia(int $mediaId, string $alias) {
      $image = Video::where('media_id', $mediaId)
        ->where('alias', $alias);

      return $image->first();
    }

    public static function videoByMediaAndType(int $mediaId, string $alias, string $type) {
      $image = Video::where('media_id', $mediaId)
        ->where('alias', $alias)
        ->where('content_type', $type);

      return $image->first();
    }

    public static function originalVideoByMedia(int $mediaId) {
      return self::videoByMedia($mediaId, "original");
    }
}
