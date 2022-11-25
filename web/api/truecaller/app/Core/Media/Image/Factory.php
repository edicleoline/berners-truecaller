<?php

namespace App\Core\Media\Image;

use App\Models\Uploading\Media as MediaModel;
use App\Core\Media\Image\Optimizer;
use App\Models\Media\Image as ImageModel;
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
      return ImageModel::originalImageByMedia($this->media->id);
    }

    public function originalInfo(): ?array {
      $original = $this->original();

      return [
        'width' => $original->width,
        'height' => $original->height
      ];
    }
}
