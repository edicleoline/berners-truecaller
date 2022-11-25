<?php

namespace App\Exceptions;

use Illuminate\Foundation\Exceptions\Handler as ExceptionHandler;
use Throwable;
use Illuminate\Validation\ValidationException;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;
use App\Exceptions\Api\ErrorCodes;
use App\Exceptions\InvalidArgumentException;
use App\Exceptions\DataIntegrityViolationException;
use App\Exceptions\ForbiddenException;
use App\Exceptions\InvalidOperationException;
use App\Exceptions\UnsupportedFileException;
use \App\Exceptions\ObjectNotFoundException;

class Handler extends ExceptionHandler
{
    protected $error = [
        'error' => [
          'message' => '',
          'type' => 'Exception',
          'code' => 500,
        ]
    ];
    /**
     * A list of the exception types that are not reported.
     *
     * @var array
     */
    protected $dontReport = [
        //
    ];

    /**
     * A list of the inputs that are never flashed for validation exceptions.
     *
     * @var array
     */
    protected $dontFlash = [
        'current_password',
        'password',
        'password_confirmation',
    ];

    public function render($request, $exception)
    {
        if ($exception instanceof ModelNotFoundException) {
            if ($request->is('api/*')) {
                $this->error['error']['message'] = __('api_error.object_not_found');
                $this->error['error']['code'] = ErrorCodes::OBJECT_NOT_FOUND;

                return response()->json($this->error, 404);
            }
        }
        else if ($exception instanceof NotFoundHttpException) {
            if ($request->is('api/*')) {
                $this->error['error']['message'] = __('api_error.resource_not_found');
                $this->error['error']['code'] = ErrorCodes::RESOURCE_NOT_FOUND;

                return response()->json($this->error, 404);
            }
        }
        else if ($exception instanceof ObjectNotFoundException) {
            if ($request->is('api/*')) {
                $this->error['error']['message'] = $exception->getMessage() ? __($exception->getMessage()) : __('api_error.object_not_found');
                $this->error['error']['code'] = ErrorCodes::OBJECT_NOT_FOUND;
                // $this->error['error']['subcode'] = $exception->subcode;
                $this->error['error']['parameters'] = $exception->params;

                return response()->json($this->error, 404);
            }
        }
        else if ($exception instanceof InvalidArgumentException) {
            if ($request->is('api/*')) {
                $this->error['error']['message'] = __($exception->getMessage());
                $this->error['error']['code'] = ErrorCodes::BAD_REQUEST;
                $this->error['error']['subcode'] = $exception->subcode;

                return response()->json($this->error, $exception->status);
            }
        }
        else if ($exception instanceof DataIntegrityViolationException) {
            if ($request->is('api/*')) {
                $this->error['error']['message'] = __($exception->getMessage());
                $this->error['error']['code'] = ErrorCodes::DATA_INTEGRITY_VIOLATION;
                $this->error['error']['subcode'] = $exception->subcode;

                return response()->json($this->error, $exception->status);
            }
        }
        else if ($exception instanceof ForbiddenException) {
            if ($request->is('api/*')) {
                $this->error['error']['message'] = __($exception->getMessage());
                $this->error['error']['code'] = ErrorCodes::FORBIDDEN;
                $this->error['error']['subcode'] = $exception->subcode;

                return response()->json($this->error, $exception->status);
            }
        }
        else if ($exception instanceof InvalidOperationException) {
            if ($request->is('api/*')) {
                $this->error['error']['message'] = __($exception->getMessage());
                $this->error['error']['code'] = ErrorCodes::INVALID_OPERATION;
                $this->error['error']['subcode'] = $exception->subcode;

                return response()->json($this->error, $exception->status);
            }
        }
        else if ($exception instanceof UnsupportedFileException) {
            if ($request->is('api/*')) {
                $this->error['error']['message'] = __($exception->getMessage());
                $this->error['error']['code'] = ErrorCodes::UNSUPPORTED_FILE_EXCEPTION;
                $this->error['error']['subcode'] = $exception->subcode;

                return response()->json($this->error, $exception->status);
            }
        }
        else if ($exception instanceof AuthException) {
            if ($request->is('api/*')) {
                $this->error['error']['type'] = 'AuthException';
                $this->error['error']['message'] = __($exception->getMessage());
                $this->error['error']['code'] = ErrorCodes::BAD_AUTHENTICATION;
                $this->error['error']['subcode'] = $exception->subcode;

                return response()->json($this->error, $exception->status);
            }
        }

        return parent::render($request, $exception);
    }

    /**
     * Register the exception handling callbacks for the application.
     *
     * @return void
     */
    public function register()
    {
        $this->renderable(function (\Exception $exception, $request) {

            if($exception instanceof ValidationException) {
                if ($request->is('api/*')) {
                    $this->error['error']['message'] = __('api_error.invalid_param');
                    $this->error['error']['code'] = ErrorCodes::VALIDATION_FIELD;
                    $this->error['error']['error_data'] = [
                        'blame_field_specs' => $exception->validator->errors()
                    ];

                    return response()->json($this->error, 422);
                }
            }
        });
    }
}
