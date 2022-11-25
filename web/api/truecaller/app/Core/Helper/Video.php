<?php

namespace App\Core\Helper;

use Streaming\Media;

class Video
{
    public static function getStream(Media $media) {
      return $media->getStreams()->first();
    }

    public static function dimensions(Media $media) {
      $d = self::getStream($media)->getDimensions();

      $dimensions = new \stdClass();
      $dimensions->width = $d->getWidth();
      $dimensions->height = $d->getHeight();

      return $dimensions;
    }
}
