<?php

namespace App\Core\Media\Video;

use App\Models\Uploading\Media as MediaModel;
use App\Models\Media\Video as VideoModel;
use App\Models\Uploading\Upload;
use App\Core\Uploading\UploadType;
use App\Core\Helper\Path;
use Symfony\Component\Filesystem\Path as SymfonyPath;
use App\Core\Media\Media as MediaHelper;
use Symfony\Component\HttpFoundation\File\File as SymfonyFile;
use App\Core\Media\Resize;
use App\Core\Helper\Video as VideoHelper;

use Illuminate\Support\Str;
use App\Core\Media\Media as MediaCore;
use Streaming\FFMpeg;
use App\Core\Media\Video\Representation;
use Streaming\Media as StreamingMedia;

class Optimizer
{
    protected MediaModel $media;
    protected Upload $upload;
    protected SymfonyFile $uploadedFile;

    public static function fromMedia(MediaModel $media) {
      $optimizer = new Optimizer();
      $optimizer->media = $media;
      $optimizer->upload = $media->upload;
      // $optimizer->uploadedFile = $optimizer->upload->file();

      return $optimizer;
    }

    protected function ffmpegSettings() {
      $ffmpegSettings = MediaCore::ffmpegSettings();

      return [
          'ffmpeg.binaries'  => $ffmpegSettings['ffmpeg.binaries'],
          'ffprobe.binaries' => $ffmpegSettings['ffprobe.binaries'],
          'timeout'          => $ffmpegSettings['timeout'],
          'ffmpeg.threads'   => $ffmpegSettings['ffmpeg.threads'],
      ];
    }

    public function getOriginalMedia() {
      $ffmpeg = FFMpeg::create($this->ffmpegSettings(), null);
      $media = $ffmpeg->open($this->upload->base_path->disk->path(SymfonyPath::join($this->upload->base_path->path, $this->upload->path, $this->upload->filename)));

      return $media;
    }

    public function execute() {


      dd($this->upload->base_path->disk->url(SymfonyPath::join($this->upload->base_path->path, $this->upload->path, $this->upload->filename)));

      $media = $this->getOriginalMedia();

      $dimensions = VideoHelper::dimensions($media);
      $this->createAlias([
        'alias' => 'original',
        'filename' => $this->upload->filename,
        'content_type' => $this->upload->mime_type,
        'width' => $dimensions->width,
        'height' => $dimensions->height
      ]);

      $this->hls($media);
    }

    protected function hls(StreamingMedia $media) {
      $sizes = MediaHelper::sizes($this->media->category);

      $v = $media->baseMedia();
      $frame = $v->frame(\FFMpeg\Coordinate\TimeCode::fromSeconds(10));
      $frame->save('/home/berners/Documents/dev/web/ensei/ensei/storage/app/public/media/image.jpg');
      dd($frame);

      $representations = [];
      foreach ($sizes as $key => $value) {
        $representations[] = (new Representation)->setKiloBitrate(intval($value['kilo_bitrate']))->setResize(intval($value['width']), intval($value['height']))->setAlias($key);
      }

      // $representations = [
      //   (new Representation)->setKiloBitrate(276)->setResize(640, 360),
      //   (new Representation)->setKiloBitrate(750)->setResize(854, 480),
      //   (new Representation)->setKiloBitrate(2048)->setResize(1280, 720)
      // ];

      $hls = $media
        ->hls()
        ->x264()
        ->fragmentedMP4()
        ->addRepresentations($representations)
        ->setHlsTime(5)
        ->setHlsAllowCache(false)
        ->setSegSubDirectory(Str::random(20))
        ->save();

      $metadata = $hls->metadata()->export();

      foreach ($representations as $key => $value) {
        $this->createAlias([
          'alias' => $value->getAlias(),
          'filename' => join([$this->upload->filenameWithoutExtension(), '_', $value->getHeight(), 'p.m3u8']),
          'content_type' => 'application/x-mpegURL',
          'width' => $value->getWidth(),
          'height' => $value->getHeight(),
          'kilo_bitrate' => $value->getKiloBitrate()
        ]);
      }

      $this->createAlias([
        'alias' => 'playlist',
        'filename' => join([$this->upload->filenameWithoutExtension(), '.m3u8']),
        'content_type' => 'application/x-mpegURL'
      ]);
    }

    public function createAlias($data) {
      $model = VideoModel::videoByMediaAndType($this->media->id, $data['alias'], $data['content_type']);
      $model = !isset($model) ? new VideoModel() : $model;
      $model->media_id = $this->media->id;
      $model->alias = $data['alias'];
      $model->content_type = $data['content_type'];
      $model->filename = $data['filename'];
      $model->width = isset($data['width']) ? $data['width'] : null;
      $model->height = isset($data['height']) ? $data['height'] : null;
      $model->kilo_bitrate = isset($data['kilo_bitrate']) ? $data['kilo_bitrate'] : null;
      $model->save();
    }
}
