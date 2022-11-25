<?php

namespace App\Core\Filter;

use Illuminate\Http\Request;

class Filter
{
    protected const FILTERS = [
        'types' => [
            'phone' => [
                'block' => [
                    'value' => [
                        'validation' => [
                            'boolean_or_in:auto'
                        ]
                    ],
                    'attributes' => [
                        'fields' => [
                            [
                                'name' => 'phone',
                                'cast' => 'string',
                            ]
                        ],
                        'validation' => [
                            'attributes' => [
                                'required'
                            ],
                            'attributes.phone' => [
                                'required',
                                'regex:/^[0-9+]\d{1,14}$/'
                            ]
                        ]
                    ],
                ],
            ],
            // 'phone2' => [
            //     'block2' => [
            //         'value' => [
            //             'validation' => ['boolean_or_in:auto3']
            //         ]
            //     ]
            // ]
        ]
    ];

    public function __construct()
    {   
        
    }

    public static function getFilters() {
        return json_decode(json_encode(static::FILTERS), false);
    }

    public static function getTypes() {
        return static::getFilters()->types;
    }

    public static function getTypeNames() {
        $names = [];
        foreach(static::getTypes() as $key => $value) {
            $names[] = $key;
        }
        
        return $names;
    }

    public static function getRules(string $typeName) {
        $types = static::getTypes();

        if(!isset($types->{$typeName})) return null;

        return $types->{$typeName};
    }

    public static function getRuleNames(string $typeName) {
        $rules = static::getRules($typeName);

        if(is_null($rules)) return null;

        $names = [];
        foreach($rules as $key => $value) {
            $names[] = $key;
        }
        
        return $names;
    }

    public static function getRule(string $typeName, string $ruleName) {
        $rules = static::getRules($typeName);

        if(is_null($rules)) return null;

        if(!isset($rules->{$ruleName})) return null;

        return $rules->{$ruleName};
    }    

    public static function getAttributes(Request $request) {
        $rule = static::getRule($request->type, $request->rule);

        if(is_null($rule) || !isset($rule->attributes) || !isset($rule->attributes->fields)) {
            return null;
        }

        $attributes = [];

        foreach($rule->attributes->fields as $key => $value) {
            if(!isset($request['attributes'][$value->name])) continue;
            
            $attributes[] = [
                'name' => $value->name,
                'value' => $request['attributes'][$value->name]
            ];
        }

        return $attributes;
    }

    public static function getAttributeFields(string $typeName, string $ruleName) {
        $rule = static::getRule($typeName, $ruleName);

        if(is_null($rule) || !isset($rule->attributes) || !isset($rule->attributes->fields)) {
            return null;
        }

        return $rule->attributes->fields;
    }

    public static function getAttributeField(string $typeName, string $ruleName, string $fieldName) {
        $fields = static::getAttributeFields($typeName, $ruleName);

        if(is_null($fields)) {
            return null;
        }

        foreach($fields as $key => $value) {
            if($value->name === $fieldName) {
                return $value;
            }
        }

        return null;
    }
}