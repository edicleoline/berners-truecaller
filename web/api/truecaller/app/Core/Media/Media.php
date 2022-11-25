<?php

namespace App\Core\Media;
use App\Core\Media\Category;
use Illuminate\Support\Str;
use App\Core\Media\Resize;
use App\Models\Storage\Path as PathModel;

class Media
{
    public static function settings() {
        return config('app.medias');
    }

    public static function supportedImages() {
        return self::settings()['supported_images'];
    }

    public static function supportedVideos() {
        return self::settings()['supported_videos'];
    }

    public static function storagePath(Category $category) {
        $p = self::settings()['categories'][Str::snake($category->key)];
  
        $path = PathModel::getOrCreate(self::settings()['path']['disk'], $p['storage_path']);
        return $path;
    }

    public static function isSupportedImage(string $mimeType) {
        $supportedImages = self::supportedImages();
  
        if(in_array($mimeType, $supportedImages)){
          return true;
        }
  
        return false;
    }
  
    public static function isSupportedVideo(string $mimeType) {
        $supportedVideos = self::supportedVideos();
  
        if(in_array($mimeType, $supportedVideos)){
          return true;
        }
  
        return false;
      }
  
    public static function isSupportedMimeType(string $mimeType) {
        if(self::isSupportedImage($mimeType)){
          return true;
        }
  
        if(self::isSupportedVideo($mimeType)){
          return true;
        }
  
        return false;
    }   


    

    public static function sizes(Category $category) {
      $settings = self::settings();
      $categorySnaked = Str::snake($category->key);

      $sizes = $settings['categories'][$categorySnaked]['sizes'];
      foreach ($sizes as $key => &$value) {
        $value['resize'] = Resize::fromKey($value['resize']);
      }

      return $sizes;
    }

    public static function size(Category $category, string $alias) {
      $sizes = self::sizes($category);
      return $sizes[$alias];
    }     

    public static function ffmpegSettings() {
      return config('app.ffmpeg');
    }
}
