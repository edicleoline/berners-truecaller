<?php

namespace App\Core\Language;

use LanguageDetection\Language;
use LanguageDetection\Trainer;

class Detector
{
  public function __construct() {
    
  }

  public static function detect(string $text) {
    // $t = new Trainer();
    // $t->setMaxNgrams(9000);
    // $t->learn();

    $ld = new Language;
    $ld->setMaxNgrams(9000);
    $results = $ld->detect($text)->bestResults()->close();

    return $results && count($results) > 0 ? array_key_first($results) : null;
  }
}
