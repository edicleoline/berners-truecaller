<?php

namespace App\Core\Casts;

use Illuminate\Contracts\Database\Eloquent\CastsAttributes;
use Laravel\SerializableClosure\SerializableClosure;
use Closure;

class ArrayClosure implements CastsAttributes
{
    public function set($model, string $key, $value, array $attributes)
    {
        foreach($value as $key => $item) {
            if($item instanceof Closure) {
                $value[$key] = serialize(new SerializableClosure($item));
                continue;
            }            
        }

        return json_encode($value);
    }


    public function get($model, string $key, $value, array $attributes)
    {
        $value = json_decode($value, true);

        foreach($value as $key => $item) {
            if (!str_contains($item, 'SerializableClosure\SerializableClosure')) { 
                continue;
            }

            $value[$key] = unserialize($item)->getClosure();
        }

        return $value;        
    }
}
