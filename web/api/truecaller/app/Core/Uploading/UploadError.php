<?php

namespace App\Core\Uploading;
use App\Core\Enum\Enum;
use Illuminate\Support\Str;

final class UploadError extends Enum
{
    const InvalidMedia     = 3;


    public function jsonSerialize(): mixed
    {
        return $this->key;
    }
}
