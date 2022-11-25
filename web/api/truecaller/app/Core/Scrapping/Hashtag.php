<?php

namespace App\Core\Scrapping;

class Hashtag
{
  public function __construct(
    public int $start,
    public int $end,
    public string $tag,
  ) { }

  public static function scrapAll(string $text) {
    preg_match_all("/\B(#[a-zA-Z0-9_-]+)/", $text, $matches);

    if(count($matches[0]) < 1) return  null;

    $hashtags = [];

    foreach($matches[0] as $match) {
      $pos = strpos($text, $match);
      $tag = substr($match, 1);

      $hashtags[] = new Hashtag($pos, $pos + strlen($tag) + 1, $tag);
    }

    return $hashtags;
  }
}
