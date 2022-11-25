<?php

namespace App\Core\Helper;

use Illuminate\Filesystem\FilesystemAdapter;

class Storage
{
    public static function isLocal(FilesystemAdapter $disk) {
      return $disk->getConfig()['driver'] == 'local';
    }

    public static function isS3(FilesystemAdapter $disk) {
      return $disk->getConfig()['driver'] == 's3';      
    }
}
