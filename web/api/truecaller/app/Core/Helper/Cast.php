<?php

namespace App\Core\Helper;

class Cast
{
    public static function getBooleanIfPossible($input) {
        if($input === 1 || $input === "1" || $input === true) return true;
        if($input === 0 || $input === "0" || $input === false) return false;

        return null;
    }
}
