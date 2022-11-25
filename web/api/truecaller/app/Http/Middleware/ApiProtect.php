<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Exception;
use PHPOpenSourceSaver\JWTAuth\Facades\JWTAuth;
use PHPOpenSourceSaver\JWTAuth\Http\Middleware\BaseMiddleware;
use PHPOpenSourceSaver\JWTAuth\Exceptions\{TokenExpiredException, TokenInvalidException};
use App\Exceptions\AuthException;
use App\Exceptions\Api\ErrorSubcodes;

class ApiProtect extends BaseMiddleware
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle($request, Closure $next)
    {
        try {
            $user = JWTAuth::parseToken()->authenticate();
        }
        catch (Exception $exception) {
          // dd($exception);
            if ($exception instanceof TokenInvalidException) {
                throw AuthException::withMessage('Invalid token.', ErrorSubcodes::AUTH_INVALID_TOKEN);
            }
            else if ($exception instanceof TokenExpiredException) {
                throw AuthException::withMessage('Authorization token expired.', ErrorSubcodes::AUTH_TOKEN_EXPIRED);
            }
            else {
                throw AuthException::withMessage('Authorization token not found.', ErrorSubcodes::AUTH_TOKEN_NOT_FOUND);
            }
        }

        return $next($request);
    }
}
// PHPOpenSourceSaver\JWTAuth\Exceptions\JWTException
