<?php

namespace App\Core\Util;

class ArrayUtil
{  
    public static function arrayFilterRecursive($input) 
    { 
        foreach ($input as &$value) 
        { 
            if (is_array($value)) 
            { 
                $value = static::arrayFilterRecursive($value); 
            } 
        } 

        return array_filter($input, function($x) { return !(is_null($x)); }); 
    } 


    public static function merge($arrays, $filterFn = null) {
        return static::mergeDeep($arrays, "", 1, $filterFn);
    }

    public static function mergeDeep($arrays, $path, $depth, $filterFn) {
        // detect if associative or sequential array
        if(array_values($arrays) !== $arrays) {
            return static::mergeDeep(array($arrays), $path, $depth, $filterFn);
        }
      
        $result = array();
        foreach($arrays as $array) {
            foreach($array as $key => $value) {
                // Renumber integer keys as array_merge_recursive() does. Note that PHP
                // automatically converts array keys that are integer strings (e.g., '1')
                // to integers.
        
                $subpath = (strlen($path) > 0 ? $path . "." . $key : $key);
        
                if(!is_null($filterFn) && !$filterFn($subpath, $value, $depth)) {
                    continue;
                }
        
                // TODO: this doesn't work always, imagine 4 => value, 6 => value. It will just count 1 => value, 2 => value.
                if(is_integer($key)) {
                    $result[] = $value;
                }
                // Recurse when both values are arrays.
                elseif(isset($result[$key]) && is_array($result[$key]) && is_array($value)) {
                    $result[$key] = static::mergeDeep(array($result[$key], $value), $subpath, $depth + 1, $filterFn);
                } 
                elseif(is_array($value)) {
                    $result[$key] = static::mergeDeep(array($value), $subpath, $depth + 1, $filterFn);
                }
                // Otherwise, use the latter value, overriding any previous value.
                else {
                    $result[$key] = $value;
                }
            }
        }
      
        return $result;
    }
}