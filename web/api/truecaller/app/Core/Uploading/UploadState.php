<?php

namespace App\Core\Uploading;
use App\Core\Enum\Enum;
use Illuminate\Support\Str;

final class UploadState extends Enum
{
    const InProgress     = 1;
    const Succeeded      = 2;
    const Failed         = 3;

    public function jsonSerialize(): mixed
    {
        return Str::snake($this->key);
    }
}
