<?php

namespace App\Core\Url\Factory;

use App\Models\Uploading\Media as MediaModel;
use App\Models\Posting\Post as PostModel;

class Post
{
    public static function url(PostModel $post): string {
      return 'https://t.co/' . $post->id;
    }
}
