<?php

namespace App\Core\Url\Factory;

use App\Models\Uploading\Media as MediaModel;
use App\Models\Posting\Post as PostModel;

class Media
{
    public static function display(MediaModel $media): string {
      return 'pic.ensei.com/' . $media->id;
    }

    public static function expanded(PostModel $post, MediaModel $media): string {
      $url = 'https://ensei.com/' . $post->author()->username . '/status/' . $post->id;

      if($media->isImage()) {
        return $url . '/photo/' . $post->imageIndex($media);
      }
      else if($media->isVideo()) {
        return $url . '/video/' . $post->videoIndex($media);
      }

      return $url;
    }

    public static function mediaHttps(MediaModel $media): string {      
      $url = 'https://pbs.twimg.com/media/';

      if($media->isImage()) {
        // $url = $url . $media->upload->path . '/' . $media->upload->filename;
        return $media->upload->url();
      }

      return $url;
    }
}
