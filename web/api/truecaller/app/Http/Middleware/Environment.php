<?php

namespace App\Http\Middleware;

use Illuminate\Auth\Middleware\Authenticate as Middleware;
use Closure;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\App;

class Environment extends Middleware
{
    public function handle($request, Closure $next, ...$guards)
    {
        if(!auth()->check()) {
          return $next($request);
        }

        $user = auth()->user();

        $locale = config('app.locale');

        if($user && isset($user->lang)) {
          $locale = $user->lang;
        }

        \Carbon\Carbon::setLocale($locale);

        App::setLocale($locale);

        return $next($request);
    }
}
