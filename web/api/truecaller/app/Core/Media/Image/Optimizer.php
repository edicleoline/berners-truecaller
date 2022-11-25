<?php

namespace App\Core\Media\Image;

use App\Models\Uploading\Media as MediaModel;
use App\Models\Media\Image as ImageModel;
use App\Models\Uploading\Upload;
use Intervention\Image\ImageManagerStatic;
use Intervention\Image\ImageManager;
use Intervention\Image\Image;
use App\Core\Uploading\UploadType;
use App\Core\Helper\Path;
use Symfony\Component\Filesystem\Path as SymfonyPath;
use App\Core\Media\Media as MediaHelper;
use Symfony\Component\HttpFoundation\File\File as SymfonyFile;
use App\Core\Media\Resize;

class Optimizer
{
    protected MediaModel $media;
    protected Upload $upload;
    protected SymfonyFile $uploadedFile;
    protected ImageManager $imageManager;

    public static function fromMedia(MediaModel $media) {
      $optimizer = new Optimizer();
      $optimizer->media = $media;
      $optimizer->upload = $media->upload;
      // $optimizer->uploadedFile = $optimizer->upload->file();
      $optimizer->imageManager = new ImageManager(['driver' => 'imagick']);

      return $optimizer;
    }

    public function getOriginalImage() {
      return $this->imageManager->make($this->upload->url());
    }

    public function execute() {
      
      // $image->save('/home/berners/Documents/dev/web/ensei/ensei/storage/app/public/media/test.jpg', 90);
      // dd($image);


      $this->createOriginal();

      // $sizes = MediaHelper::sizes($this->media->category);
      // foreach ($sizes as $key => $value) {
      //   $this->resize($key);
      // }
    }

    public function createOriginal() {
        $image = $this->getOriginalImage();

        $model = ImageModel::firstOrCreate([
            'media_id' => $this->media->id,
            'alias' => null,
            'width' => $image->width(),
            'height' => $image->height()
        ]);

        return $model;
    }

    // public function resize(string $alias) {
    //   $originalImage = $this->getOriginalImage();
    //   $size = MediaHelper::size($this->media->category, $alias);

    //   $image = null;

    //   if($size['resize']->is(Resize::Fit)) {
    //     $image = $this->fit($originalImage, $alias, $size['width'], $size['height']);
    //   }
    //   else if($size['resize']->is(Resize::Crop)) {
    //     $image = $this->fit($originalImage, $alias, $size['width'], $size['height']);
    //   }

    //   $model = ImageModel::imageByMedia($this->media->id, $alias);
    //   $model = !isset($model) ? new ImageModel() : $model;
    //   $model->media_id = $this->media->id;
    //   $model->alias = $alias;
    //   $model->width = $image->width();
    //   $model->height = $image->height();
    //   $model->save();
    // }

    // public function fit(Image $image, string $alias, ?int $width, ?int $height) {
    //   $img = null;

    //   if(!is_null($width) && $image->width() >= $width) {
    //     $img = $image->resize($width, null, function ($constraint) {
    //       $constraint->aspectRatio();
    //       $constraint->upsize();
    //     });
    //   }
    //   else if(!is_null($height) && $image->height() >= $height) {
    //     $img = $image->resize(null, $height, function ($constraint) {
    //       $constraint->aspectRatio();
    //       $constraint->upsize();
    //     });
    //   }

    //   if(isset($img)) {
    //     $img->save(SymfonyPath::join($image->dirname, join([$image->filename, '_', $alias, '.', $image->extension])), 90);
    //   }
    //   else {
    //     $pathname = SymfonyPath::join($image->dirname, join([$image->filename, '_', $alias, '.', $image->extension]));
    //     \File::copy(SymfonyPath::join($image->dirname, $image->basename), $pathname);
    //     $img = $this->imageManager->make($pathname);
    //   }

    //   // OPTIMIZE: https://github.com/spatie/laravel-image-optimizer

    //   return $img;
    // }

}
