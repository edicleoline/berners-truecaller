<?php

namespace App\Core\Enum\Rules;

use Illuminate\Contracts\Validation\Rule;
use App\Core\Helper\StringUtil;

class EnumKey implements Rule
{
    /**
     * The name of the rule.
     */
    protected $rule = 'enum_key';

    /**
     * @var string|\BenSampo\Enum\Enum
     */
    protected $enumClass;

    /**
     * Create a new rule instance.
     *
     * @param  string  $enum
     * @return void
     *
     * @throws \InvalidArgumentException
     */
    public function __construct(string $enum)
    {
        $this->enumClass = $enum;

        if (! class_exists($this->enumClass)) {
            throw new \InvalidArgumentException("Cannot validate against the enum, the class {$this->enumClass} doesn't exist.");
        }
    }

    /**
     * Determine if the validation rule passes.
     *
     * @param  string  $attribute
     * @param  mixed  $value
     * @return bool
     */
    public function passes($attribute, $value)
    {
        $pass = $this->enumClass::hasKey($value);

        if($pass === false) {
          $pass = $this->enumClass::hasKey(StringUtil::camelize($value));
        }

        return $pass;
    }

    /**
     * Get the validation error message.
     *
     * @return string|array
     */
    public function message()
    {
        return trans()->has('validation.enum_key')
            ? __('validation.enum_key')
            : __('laravelEnum::messages.enum_key');
    }

    /**
     * Convert the rule to a validation string.
     *
     * @return string
     *
     * @see \Illuminate\Validation\ValidationRuleParser::parseParameters
     */
    public function __toString()
    {
        return "{$this->rule}:{$this->enumClass}";
    }
}
