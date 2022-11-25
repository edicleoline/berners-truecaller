<?php

namespace App\Core\Scrapping;

use App\Core\Scrapping\Hashtag;
use App\Core\Scrapping\Url;

class Scrapper implements \JsonSerializable
{
  public function __construct(
    public $hashtags,
    public $urls
  ) { }

  public static function scrapString(string $text) {
    return new Scrapper(
      Hashtag::scrapAll($text),
      Url::scrapAll($text)
    );
  }

  public function jsonSerialize()
  {
    return array_filter([
      'hashtags' => $this->hashtags,
      'urls' => $this->urls
    ]);
  }
}
