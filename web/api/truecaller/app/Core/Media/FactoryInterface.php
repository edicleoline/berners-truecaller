<?php

namespace App\Core\Media;

use App\Models\Uploading\Media as MediaModel;

interface FactoryInterface
{
    public static function fromMedia(MediaModel $media): FactoryInterface;

    public function optimizer();

    public function original();

    public function originalInfo(): ?array;
}
