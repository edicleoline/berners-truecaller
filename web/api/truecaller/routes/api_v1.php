<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\Api\V1\Account\AuthController;
use App\Http\Controllers\Api\V1\User\UsersController;
use App\Http\Controllers\Api\V1\Phone\PhonesController;
use App\Http\Controllers\Api\V1\Phone\PhoneVerifierController;
use App\Http\Controllers\Api\V1\Phone\Report\PhoneReportsController;
use App\Http\Controllers\Api\V1\Phone\Report\Category\PhoneReportCategoriesController;
use App\Http\Controllers\Api\V1\Phone\PhoneTagsController;
use App\Http\Controllers\Api\V1\Phone\PhoneCompaniesController;
use App\Http\Controllers\Api\V1\Phone\PhoneLocationsController;

use App\Http\Controllers\Api\V1\Filter\FiltersController;
use App\Http\Controllers\Api\V1\Spammer\TopSpammersController;

use App\Http\Controllers\Api\V1\Phone\PhoneEntitiesController;
use App\Http\Controllers\Api\V1\Phone\PhoneLookupController;
use App\Http\Controllers\Api\V1\Tag\TagsController;
use App\Http\Controllers\Api\V1\Place\CountriesController;
use App\Http\Controllers\Api\V1\Place\StatesController;
use App\Http\Controllers\Api\V1\Place\CitiesController;
use App\Http\Controllers\Api\V1\Place\LocationsController;
use App\Http\Controllers\Api\V1\User\EmailsController as UserEmailsController;
use App\Http\Controllers\Api\V1\Email\EmailVerifierController;
use App\Http\Controllers\Api\V1\Phone\PositiveReport\PhonePositiveReportsController;
use App\Http\Controllers\Api\V1\Company\CompaniesController;
use App\Http\Controllers\Api\V1\Search\SearchController;
use App\Http\Controllers\Api\V1\User\UserContactsController;
use App\Http\Controllers\Api\V1\User\UserPhonesController;
use App\Http\Controllers\Api\V1\Upload\UploadMediaController;
use App\Http\Controllers\Api\V1\Incoming\IncomingsController;
use App\Http\Controllers\Api\V1\Incoming\IncomingEventsController;
use App\Http\Controllers\Api\V1\Posting\PostsController;
use App\Http\Controllers\Api\V1\Phone\PhonePostsController;
use App\Http\Controllers\Api\V1\Onboarding\OnboardingController;

use App\Http\Controllers\Api\V1\Crawl\Phone\ReportsController;
use App\Http\Controllers\Api\V1\Crawl\Phone\TopSpammersController as CrawlTopSpammersController;

Route::post('onboarding/otp', [OnboardingController::class, 'otp']);
Route::post('onboarding/otp/verify', [OnboardingController::class, 'otpVerify']);

// Route::post('account/login', [AuthController::class, 'login']);
// Route::post('account/register', [AuthController::class, 'register']);

Route::group(['middleware' => ['apiJwt', 'env']], function() {

    Route::get('me', [UsersController::class, 'loggedUser']);
    Route::get('users/{id}', [UsersController::class, 'show']);
    Route::put('users/{id}', [UsersController::class, 'update']);

    Route::get('users/{id}/emails', [UserEmailsController::class, 'show']);
    Route::post('users/{id}/emails', [UserEmailsController::class, 'store']);
    Route::delete('users/{userId}/emails/{emailId}', [UserEmailsController::class, 'destroy']);

    Route::get('users/{userId}/contacts', [UserContactsController::class, 'list']);
    Route::post('users/{userId}/contacts', [UserContactsController::class, 'store']);    

    Route::get('users/{userId}/phones', [UserPhonesController::class, 'list']);
    Route::post('users/{userId}/phones/{phoneId}', [UserPhonesController::class, 'store']);
    Route::delete('users/{userId}/phones/{phoneId}', [UserPhonesController::class, 'destroy']);

    Route::get('countries', [CountriesController::class, 'list']);
    Route::get('countries/{id}', [CountriesController::class, 'show']);

    Route::get('countries/{countryId}/states', [StatesController::class, 'list']);
    Route::get('states/{id}', [StatesController::class, 'show']);

    Route::get('states/{stateId}/cities', [CitiesController::class, 'list']);
    Route::get('cities/{id}', [CitiesController::class, 'show']);

    Route::post('locations', [LocationsController::class, 'store']);
    Route::get('locations/{id}', [LocationsController::class, 'show']);

    Route::get('companies/{id}', [CompaniesController::class, 'show']);      

    Route::get('phones/tags', [PhoneTagsController::class, 'list']);  
    
    Route::post('posts', [PostsController::class, 'store']);
    Route::delete('posts/{postId}', [PostsController::class, 'destroy']);

    Route::post('phones', [PhonesController::class, 'store']);
    Route::get('phones/{id}', [PhonesController::class, 'show']);

    Route::post('phones/{phoneId}/verifier', [PhoneVerifierController::class, 'store']);
    Route::post('phones/{phoneId}/verify', [PhoneVerifierController::class, 'verify']);

    Route::post('emails/{emailId}/verifier', [EmailVerifierController::class, 'store']);
    Route::post('emails/{emailId}/verify', [EmailVerifierController::class, 'verify']);

    Route::get('phones/{phoneId}/reports', [PhoneReportsController::class, 'list']);
    Route::post('phones/{phoneId}/reports', [PhoneReportsController::class, 'store']);
    Route::delete('phones/reports/{reportId}', [PhoneReportsController::class, 'destroy']);    

    Route::post('phones/{phoneId}/positive-reports', [PhonePositiveReportsController::class, 'store']);
    Route::delete('phones/positive-reports/{reportId}', [PhonePositiveReportsController::class, 'destroy']);

    Route::post('phones/{phoneId}/companies', [PhoneCompaniesController::class, 'store']);
    Route::delete('phones/{phoneId}/companies/{companyId}', [PhoneCompaniesController::class, 'destroy']);

    Route::post('phones/{phoneId}/tags', [PhoneTagsController::class, 'store']);
    Route::delete('phones/{phoneId}/tags/{tagId}', [PhoneTagsController::class, 'destroy']);

    Route::post('phones/{phoneId}/locations', [PhoneLocationsController::class, 'store']);
    Route::delete('phones/{phoneId}/locations/{locationId}', [PhoneLocationsController::class, 'destroy']);    

    Route::get('phones/{phoneId}/entities', [PhoneEntitiesController::class, 'list']);
    Route::post('phones/{phoneId}/entities', [PhoneEntitiesController::class, 'store']);
    Route::delete('phones/{phoneId}/entities/{entityId}', [PhoneEntitiesController::class, 'destroy']);

    Route::get('phones/{phoneId}/posts', [PhonePostsController::class, 'list']);
    Route::post('phones/{phoneId}/posts', [PhonePostsController::class, 'store']);    

    Route::get('phones/reports/categories', [PhoneReportCategoriesController::class, 'list']);
    Route::get('phones/reports/categories/{id}', [PhoneReportCategoriesController::class, 'show']);   

    Route::get('tags/{id}', [TagsController::class, 'show']);
    
    Route::get('search', [SearchController::class, 'search']);

    Route::post('incomings', [IncomingsController::class, 'store']);
    Route::post('incomings/{incomingId}/events', [IncomingEventsController::class, 'store']);

    Route::post('outgoings', [IncomingsController::class, 'storeOutgoing']);
    Route::post('outgoings/{outgoingId}/events', [IncomingEventsController::class, 'storeOutgoing']);

    Route::put('filters', [FiltersController::class, 'store']);
    Route::get('filters', [FiltersController::class, 'list']);
    Route::delete('filters/{id}', [FiltersController::class, 'destroy']);

    Route::get('top-spammers/{incomingType}', [TopSpammersController::class, 'list']);
    
    Route::post('upload/media/init', [UploadMediaController::class, 'init']);
    Route::post('upload/media/{id}/append', [UploadMediaController::class, 'append']);
    Route::post('upload/media/{id}/finalize', [UploadMediaController::class, 'finalize']);

    Route::post('crawl/phones/reports/telguarder', [ReportsController::class, 'telguarder']);
    Route::post('crawl/phones/top-spammers/truecaller', [CrawlTopSpammersController::class, 'truecaller']);

    Route::get('phones/{countryIso2}/{phoneNumber}', [PhoneLookupController::class, 'show']);

    Route::post('account/refresh', [AuthController::class, 'refresh']);
});
