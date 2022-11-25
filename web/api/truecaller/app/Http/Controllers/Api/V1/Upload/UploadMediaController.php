<?php

namespace App\Http\Controllers\Api\V1\Upload;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Account\User;
use App\Models\Uploading\Upload;
use App\Models\Uploading\Media;
use Illuminate\Support\Facades\Validator;
use App\Core\Api\Response;
use App\Core\Media\Category as MediaCategory;
use App\Core\Uploading\UploadType;
use App\Core\Enum\Rules\EnumKey;
use App\Exceptions\InvalidOperationException;
use App\Core\Media\Media as MediaCore;

class UploadMediaController extends Controller
{
    public function init(Request $request)
    {
        $validated = $request->validate([
            'media_category' => ['required', new EnumKey(MediaCategory::class)],
        ]);

        $mediaCategory = MediaCategory::fromKey($request['media_category']);

        $me = parent::me();

        $upload = Upload::createFromRequest($request, $me, UploadType::fromValue(UploadType::Media), MediaCore::storagePath($mediaCategory));

        $media = new Media();
        $media->upload_id = $upload->id;
        $media->category = $mediaCategory;

        $media->save();

        return response(Response::content($request, $media), 202);
    }

    public function append(Request $request, $id) {
        $media = Media::findOrFail($id);
        $upload = $media->upload;

        $this->validateBasicAuthorization($upload->author_id);

        $appended = $upload->appendFile($request, "media");

        return response()->noContent(204);
    }

    public function finalize(Request $request, $id) {
        $media = Media::findOrFail($id);
        $upload = $media->upload;

        $this->validateBasicAuthorization($upload->author_id);

        try {
            $response = $upload->finalize();
            $media->size = $upload->total_bytes;

            $factory = $media->factory();
            $factory->optimizer()->execute();
            $originalMedia = $factory->original();
            $info = null;

            if($media->isImage() || $media->isVideo()) {
                $info = [
                'width' => $originalMedia->width,
                'height' => $originalMedia->height,
                'image_type' => $originalMedia->media->upload->mime_type
                ];
            }

            if($media->isImage()) {
                $media->image = $info;
            }
            else if($media->isVideo()) {
                $media->video = $info;
            }

            return response(Response::content($request, $media), 201);
        }
        catch(InvalidOperationException) {
            $status = $upload->status();
            $media->processing_info = $status;
            return response(Response::content($request, $media));
        }
    }
}
