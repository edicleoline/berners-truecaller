<?php

namespace App\Core\Media\Video;

use App\Models\Uploading\Media as MediaModel;
use App\Core\Media\Video\Optimizer;
use App\Models\Media\Video as VideoModel;
use App\Core\Media\FactoryInterface;

class Factory implements FactoryInterface
{
    protected MediaModel $media;

    public static function fromMedia(MediaModel $media): FactoryInterface {
      $factory = new Factory();
      $factory->media = $media;

      return $factory;
    }

    public function optimizer() {
      return Optimizer::fromMedia($this->media);
    }

    public function original() {
      return VideoModel::originalVideoByMedia($this->media->id);
    }

    public function originalInfo(): ?array {
      $original = $this->original();

      return [
        'width' => $original->width,
        'height' => $original->height
      ];
    }
}
