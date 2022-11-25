<?php

namespace App\Core\Helper;
use Illuminate\Support\Str;
use Symfony\Component\Filesystem\Path as SymfonyPath;

class Path
{
    public static function randomFolder(string $rootPath) {
      $folder = Str::random(20);

      $fullPath = SymfonyPath::join($rootPath, $folder);
      //// TODO: create directory

      return $folder;
    }

}
