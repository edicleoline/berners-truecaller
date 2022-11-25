<?php

namespace App\Http\Controllers\Api\V1\Onboarding;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Core\Api\Response;
use App\Models\Device\Installation;
use App\Models\App\App;
use App\Models\Device\Device;
use App\Models\Device\Sim;
use App\Models\Place\Country;
use App\Models\Phone\Phone;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use App\Exceptions\ObjectNotFoundException;
use App\Exceptions\InvalidArgumentException;
use App\Models\Account\User;
use PHPOpenSourceSaver\JWTAuth\Facades\JWTFactory;
use PHPOpenSourceSaver\JWTAuth\Facades\JWTAuth;
use App\Models\Account\Auth\Session;
use App\Models\Place\Location;
use App\Models\Account\Group;

class OnboardingController extends Controller
{
    protected const HEADER_INSTALLATION_UUID = "Installation-Token";

    protected function getInstallation(Request $request) {
        $installation = null;

        if($request->hasHeader(self::HEADER_INSTALLATION_UUID)) {
            $installation = Installation::where('uuid', $request->header(self::HEADER_INSTALLATION_UUID))->first();
        }

        if(is_null($installation)) {
            $installation = new Installation();
        }

        return $installation;
    }

    protected function getCountry(Request $request) {
        try {
            return Country::findOrFailByIsoCode2($request->country_code);
        }
        catch (ModelNotFoundException $exception) {
            throw ObjectNotFoundException::withQueryParam(['country_code' => $request->country_code]);
        }
    }

    public function otp(Request $request)
    {
        $request->validate([
            'lang' => 'required',
            'country_code' => 'required|alpha|min:2|max:2',
            'phone_number' => 'required',
            'region' => 'required',

            'installation' => 'required|required_array_keys:app,device',
            'installation.app' => 'required_array_keys:build_version,major_version,minor_version,store',

            'installation.device' => 'required_array_keys:lang,os_name,os_version'
        ]);

        $reqInstallation = json_decode(json_encode($request->installation), false);

        $country = $this->getCountry($request);

        $app = App::firstOrCreate([
            'build_version' => $reqInstallation->app->build_version,
            'major_version' => $reqInstallation->app->major_version,
            'minor_version' => $reqInstallation->app->minor_version,
            'store' => $reqInstallation->app->store,
        ]);

        $installation = $this->getInstallation($request);

        $device = null;

        if(!is_null($installation->device_id)) {
            $device = Device::find($installation->device_id);
        }

        if(is_null($device)) {
            $device = new Device();
        }
        else {
            Sim::where('device_id', $device->id)->delete();
        }
        
        $device->device_id = isset($reqInstallation->device->device_id) ? $reqInstallation->device->device_id : null;
        $device->lang = isset($reqInstallation->device->lang) ? $reqInstallation->device->lang : null;
        $device->manufacturer = isset($reqInstallation->device->manufacturer) ? $reqInstallation->device->manufacturer : null;
        $device->model = isset($reqInstallation->device->model) ? $reqInstallation->device->model : null;
        $device->os_name = isset($reqInstallation->device->os_name) ? $reqInstallation->device->os_name : null;
        $device->os_version = isset($reqInstallation->device->os_version) ? $reqInstallation->device->os_version : null;
        $device->save();

        if(isset($reqInstallation->device->sims)) {
            foreach($reqInstallation->device->sims as $deviceSim) {
                $sim = new Sim();
                $sim->device_id = $device->id;
                $sim->serial = isset($deviceSim->serial) ? $deviceSim->serial : null;
                $sim->imsi = isset($deviceSim->imsi) ? $deviceSim->imsi : null;
                $sim->mcc = isset($deviceSim->mcc) ? $deviceSim->mcc : null;
                $sim->mnc = isset($deviceSim->mnc) ? $deviceSim->mnc : null;
                $sim->operator = isset($deviceSim->operator) ? $deviceSim->operator : null;
                $sim->save();
            }
        }
    
        $installation->app_id = $app->id;
        $installation->device_id = $device->id;
        $installation->lang = $request->lang;
        $installation->country_id = $country->id;
        $installation->region = $request->has('region') ? $request->region : null;
        $installation->save();
        
        $phone = Phone::findOrCreate($request->phone_number, $country->iso2, true);
        $verifier = $phone->verifier($installation)->start();
        $verifier->makeHidden(['created_at', 'verified_at']);        

        $otp = [
            'phone' => [
                'e164_format' => $phone->e164_format
            ]
        ];

        $response = [
            'installation' => [
                'uuid' => $installation->uuid
            ],
            'otp' => array_merge($otp, $verifier->toArray())
        ];

        return response(Response::content($request, $response), 201);
    }  
    
    public function otpVerify(Request $request) {
        $request->validate([
            'uuid' => 'required',
            'token' => 'required',
        ]);

        $installation = $this->getInstallation($request);

        if(is_null($installation) || is_null($installation->id)) {
            throw InvalidArgumentException::withMessage('No valid installation present.');
        }

        $country = $this->getCountry($request);

        $phone = Phone::findOrCreate($request->phone_number, $country->iso2, true);
        $verifier = $phone->verifier($installation)->verify($request->uuid, $request->token);
        $verifier->makeHidden(['created_at', 'ttl', 'verified_at']);

        $location = Location::findOrCreate($country);
        $group = Group::firstOrCreate([
            'name' => 'default'
        ]);
        
        $user = new User();
        $user->location_id = $location->id;
        $user->user_group_id = $group->id;
        $user->lang = $installation->lang;
        $user->save();        

        $jwt = (object)[
            'token' => JWTAuth::fromUser($user),
            'token_type' => 'bearer',
            'ttl' => auth('api')->factory()->getTTL() * 60
        ];

        $session = Session::create($user, $installation, $jwt->token, $jwt->token_type, $jwt->ttl);

        $user->storePhone($phone, $session);
        
        $response = [
            'otp' => $verifier,
            'auth' => $jwt
        ];

        return response(Response::content($request, $response), 200);
    }
}