<?php

namespace App\Core\Enum;

use App\Core\Helper\StringUtil;
use Illuminate\Support\Str;
use BenSampo\Enum\Exceptions\InvalidEnumKeyException;

class Enum extends \BenSampo\Enum\Enum
{
    public static function fromKey(string $key): self {
        if (static::hasKey($key)) {
            $enumValue = static::getValue($key);

            return new static($enumValue);
        }
        else if (static::hasKey(StringUtil::camelize($key))) {
            $enumValue = static::getValue(StringUtil::camelize($key));

            return new static($enumValue);
        }

        throw new InvalidEnumKeyException($key, static::class);
    }

    public function jsonSerialize(): mixed
    {
        return Str::snake($this->key);
    }

    public function toArray(): mixed
    {
        return Str::snake($this->key);
    }
}
