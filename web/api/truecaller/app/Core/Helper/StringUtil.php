<?php

namespace App\Core\Helper;

class StringUtil
{
    public static function camelize($input, $separator = '_') {
        return str_replace($separator, '', ucwords($input, $separator));
    }

    public static function alpha($str) {
        return preg_replace("/[^A-Za-z0-9 ]/", '', $str);
    }

    public static function encode($str)
    {
        return str_replace(['+', '/', '='], ['-', '_', ''], base64_encode($str));
    }
}
