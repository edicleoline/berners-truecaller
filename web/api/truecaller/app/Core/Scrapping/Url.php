<?php

namespace App\Core\Scrapping;

class Url
{
    public function __construct(
        public int $start,
        public int $end,
        public string $url,
        public string $display_url,
    ) { }

    public static function scrapAll(string $text) {
        preg_match_all('_(?:(?:https?|ftp)://)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\x{00a1}-\x{ffff}0-9]-*)*[a-z\x{00a1}-\x{ffff}0-9]+)(?:\.(?:[a-z\x{00a1}-\x{ffff}0-9]-*)*[a-z\x{00a1}-\x{ffff}0-9]+)*(?:\.(?:[a-z\x{00a1}-\x{ffff}]{2,}))\.?)(?::\d{2,5})?(?:[/?#][^\s"]*)?_iuS', $text, $matches);

        if(count($matches[0]) < 1) return  null;

        $urls = [];

        foreach($matches[0] as $match) {
            $pos = strpos($text, $match);
            $url = $match;

            $urls[] = new Url($pos, $pos + strlen($url), $url, $url);
        }

        return $urls;
    }
}
