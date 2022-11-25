<?php

namespace App\Providers;

use Illuminate\Support\ServiceProvider;
use Illuminate\Support\Facades\Validator;

class AppServiceProvider extends ServiceProvider
{
    /**
     * Register any application services.
     *
     * @return void
     */
    public function register()
    {
        //
    }

    /**
     * Bootstrap any application services.
     *
     * @return void
     */
    public function boot()
    {
        Validator::extend('boolean_or_in', function ($attribute, $value, $parameters, $validator) {
            if(in_array($value, $parameters)) {
                return true;
            }
            
            return is_bool($value);
        });

        Validator::replacer('boolean_or_in', function($message, $attribute, $rule, $parameters){
            return str_replace(':other', preg_replace('/\"/',"'", json_encode($parameters)), $message);
        });
    }
}
