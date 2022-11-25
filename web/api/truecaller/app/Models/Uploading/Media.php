<?php

namespace App\Models\Uploading;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Models\Uploading\Upload;
use App\Core\Media\Category;
use App\Core\Media\Image\Factory as ImageFactory;
use App\Core\Media\Video\Factory as VideoFactory;
use App\Core\Url\Factory\Media as UrlMediaFactory;
use App\Core\Url\Factory\Post as UrlPostFactory;
use App\Models\Posting\Post;

class Media extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'medias';

    protected $fillable = [

    ];

    protected $hidden = [
      'upload',
      'upload_id',
      'category',
      'deleted_at',
      'updated_at'
    ];

    protected $appends = [
      'expires_after_secs',
      'upload'
    ];

    protected $casts = [
      'deleted_at' => 'datetime',
      'category'   => Category::class
    ];

    protected Upload $_upload;

    protected function getExpiresAfterSecsAttribute() {
      return $this->upload->expires_after_secs;
    }

    protected function getUploadAttribute() {
      if(isset($this->_upload)) return $this->_upload;

      $this->_upload = Upload::find($this->upload_id);
      return $this->_upload;
    }

    public function isImage() {
      return strstr($this->upload->mime_type, "image/");
    }

    public function isVideo() {
      return strstr($this->upload->mime_type, "video/");
    }

    public function factory() {
      if($this->isImage()) {
        return ImageFactory::fromMedia($this);
      }
      else if($this->isVideo()) {
        return VideoFactory::fromMedia($this);
      }

      return null;
    }

    public function getType() {
      if($this->isImage()) return 'photo';
      if($this->isVideo()) return 'video';

      return '';
    }

    public function postEntity(Post $post) {
      $factory = $this->factory();

      $entity = [
        'id' => $this->id,
        'type' => $this->getType(),
        'display_url' => UrlMediaFactory::display($this),
        'expanded_url' => UrlMediaFactory::expanded($post, $this),
        'media_url_https' => UrlMediaFactory::mediaHttps($this),
        'url' => UrlPostFactory::url($post),
        'original_info' => !is_null($factory) ? $factory->originalInfo() : null
      ];

      return $entity;
    }
}
