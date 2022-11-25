<?php

namespace App\Models\Uploading;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use Illuminate\Http\Request;
use App\Models\Account\User;
use App\Core\Uploading\UploadType;
use App\Core\Uploading\UploadState;
use Illuminate\Support\Facades\Storage;
use App\Core\Helper\Path;
use Symfony\Component\Filesystem\Path as SymfonyPath;
use Symfony\Component\HttpFoundation\File\File as SymfonyFile;
use App\Exceptions\InvalidOperationException;
use App\Exceptions\UnsupportedFileException;
use App\Core\Uploading\UploadError;
use App\Core\Media\Media;
use Illuminate\Support\Str;
use App\Core\Helper\Storage as StorageHelper;
use Illuminate\Filesystem\FilesystemAdapter;
use App\Models\Storage\Path as PathModel;

use Pion\Laravel\ChunkUpload\Exceptions\UploadFailedException;
use Illuminate\Http\UploadedFile;
use Pion\Laravel\ChunkUpload\Exceptions\UploadMissingFileException;
use Pion\Laravel\ChunkUpload\Handler\AbstractHandler;
use Pion\Laravel\ChunkUpload\Handler\HandlerFactory;
use Pion\Laravel\ChunkUpload\Receiver\FileReceiver;

class Upload extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'uploads';

    protected $fillable = [
        'author_id',
        'base_path_id',
        'path',
        'filename',
        'total_bytes',
        'mime_type',
        'expires_after_secs',
        'upload_type',
        'upload_state',
        'progress_percent',
        'upload_error'
    ];

    protected $appends = [
        'base_path'
    ];

    protected $hidden = [
        'client_original_name',
        'deleted_at',
        'updated_at'
    ];

    protected $casts = [
        'deleted_at'     => 'datetime',
        'upload_type'    => UploadType::class,
        'upload_state'   => UploadState::class,
        'upload_error'   => UploadError::class
    ];

    protected PathModel $_basePath;

    protected function getBasePathAttribute() {
      if(isset($this->_basePath)) return $this->_basePath;

      $this->_basePath = PathModel::find($this->base_path_id);
      return $this->_basePath;
    }

    public static function createFromRequest(Request $request, User $author, UploadType $uploadType, PathModel $basePath) {
      $validated = $request->validate([
        'total_bytes' => 'required',
        'mime_type' => 'required',
      ]);

      $totalBytes = $request['total_bytes'];
      $mimeType = $request['mime_type'];

      $upload = new Upload();
      $upload->author_id = $author->id;
      $upload->total_bytes = $totalBytes;
      $upload->mime_type = $mimeType;
      $upload->expires_after_secs = 86399;
      $upload->upload_state = UploadState::fromValue(UploadState::InProgress);
      $upload->upload_type = $uploadType;
      $upload->base_path_id = $basePath->id;
      // $upload->path = self::createDirectory($basePath);
      $upload->save();

      $upload->path = self::createDirectory($basePath, $upload);
      $upload->save();

      return $upload;
    }

    protected static function createDirectory(PathModel $basePath, Upload $upload) {
      // $directory = null;
      // do {
      //   $directory = Str::random(20);
      // }
      // while($basePath->disk->directoryExists(SymfonyPath::join($basePath->path, $directory)));
      //
      // $basePath->disk->makeDirectory(SymfonyPath::join($basePath->path, $directory));
      //
      // return $directory;

      $directory = $upload->id;
      $basePath->disk->makeDirectory(SymfonyPath::join($basePath->path, $directory));

      return $directory;
    }

    protected function isValidMedia(UploadedFile $file) {
      if(!$file->isValid()) return null;

      $mimeType = $file->getMimeType();

      $isSupported = Media::isSupportedMimeType($mimeType);

      $result = new \stdClass();

      if(!$isSupported) {
        $result->isValid = false;
        $result->error = new \stdClass();
        $result->error->code = UploadError::fromValue(UploadError::InvalidMedia);
        $result->error->message = 'Unsupported media format.';
        return $result;
      }

      $result->isValid = true;
      return $result;
    }

    public function appendFile(Request $request, string $requestFilename) {
      $response = new \stdClass();

      $receiver = new FileReceiver($requestFilename, $request, HandlerFactory::classFromRequest($request));

      if ($receiver->isUploaded() === false) {
        throw new UploadMissingFileException();
      }

      $save = $receiver->receive();
      $file = $save->getFile();

      if($file->isValid()) {
        $this->mime_type = $file->getMimeType();
        $this->save();
      }

      if(isset($this->upload_type) && $this->upload_type->is(UploadType::Media)) {
        $isValidMedia = $this->isValidMedia($file);

        if(isset($isValidMedia) && $isValidMedia->isValid === false) {
          $this->upload_state = UploadState::fromValue(UploadState::Failed);
          $this->upload_error = $isValidMedia->error->code;
          $this->save();

          throw UnsupportedFileException::withMessage($isValidMedia->error->message);
        }
      }

      if(isset($this->upload_state) && $this->upload_state->is(UploadState::Failed)) {
        $response->status = false;
        return $response;
      }

      if($save->isFinished()) {
        $response->progress_percent = 100;
        $response->status = $this->saveFile($file);
        return $response;
      }

      $handler = $save->handler();

      $response->progress_percent = $handler->getPercentageDone();
      $response->status = true;

      $this->progress_percent = $response->progress_percent;
      $this->save();

      return $response;
    }

    protected function saveFile(UploadedFile $file)
    {
      $this->total_bytes = $file->getSize();
      $this->client_original_name = $file->getClientOriginalName();
      $this->filename = join([Str::random(20), '.', $file->extension()]);
      $this->progress_percent = 100;

      if(StorageHelper::isLocal($this->base_path->disk)) {
        $this->saveFileToLocal($file);
      }
      else if(StorageHelper::isS3($this->base_path->disk)) {
        $this->saveFileToS3($file);
      }

      $this->upload_state = UploadState::fromValue(UploadState::Succeeded);
      $this->save();

      return true;
    }

    protected function saveFileToLocal(UploadedFile $file) {
      $file->move($this->base_path->disk->path(SymfonyPath::join($this->base_path->path, $this->path)), $this->filename);
    }

    protected function saveFileToS3(UploadedFile $file)
    {
      $this->base_path->disk->putFileAs(SymfonyPath::join($this->base_path->path, $this->path), $file, $this->filename);
    }

    public function finalize() {
      if($this->progress_percent < 100) {
        throw InvalidOperationException::withMessage('Wait for uploading complete.');
      }

      if(isset($this->upload_state) && $this->upload_state->is(UploadState::Failed)) {
        throw InvalidOperationException::withMessage('Your upload was failed.');
      }
    }

    public function status() {
      $status = new \stdClass();
      $status->state = $this->upload_state;
      $status->progress_percent = $this->progress_percent;

      if(isset($status->state) && $status->state->is(UploadState::InProgress)) {
        $status->check_after_secs = 10;
      }

      if(isset($status->state) && $status->state->is(UploadState::Failed)) {
        $status->error = new \stdClass();

        if(isset($this->upload_error)) {
          $status->error->type = $this->upload_error->key;
          $status->error->code = $this->upload_error->value;
        }
      }

      return $status;
    }

    public function url() {
      return $this->base_path->disk->url(SymfonyPath::join($this->base_path->path, $this->path, $this->filename));
    }



    public function file() {
      $pathname = $this->base_path->disk->path(SymfonyPath::join($this->base_path->path, $this->path, $this->filename));
      return new SymfonyFile($pathname);
    }

    public function filenameWithoutExtension() {
      return pathinfo($this->filename, PATHINFO_FILENAME);
    }
}
