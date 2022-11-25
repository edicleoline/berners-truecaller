<?php

namespace App\Models\Phone;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Phone\Phone;
use Carbon\Carbon;
use Illuminate\Validation\ValidationException;
use App\Exceptions\InvalidArgumentException;
use App\Exceptions\Api\ErrorSubcodes;
use App\Core\Enum\PhoneVerifierMethod;
use App\Core\Enum\OtpRequestStatus;
use App\Models\Device\Installation;

class Verifier extends Model
{
    use HasFactory;
    protected $table = 'phone_verifiers';

    protected bool $useUuid = true;

    protected $fillable = [
        'phone_id',
        'method',
        'token',
        'ttl',
        'device_installation_id'
    ];

    protected $appends = [
        'verified'
    ];

    protected $hidden = [
        'id',
        'phone_id',
        'token',
        'updated_at',
        'expires_at',
        'device_installation_id'
    ];

    protected $casts = [
        'verified_at' => 'datetime',
        'expires_at' => 'datetime',
        'method' => PhoneVerifierMethod::class
    ];

    public static function instance(Phone $phone, Installation $installation) {
        $verifier = new Verifier();
        $verifier->phone_id = $phone->id;
        $verifier->setOnce('installation', $installation);
        $verifier->device_installation_id = $installation->id;
        return $verifier;
    }

    public function getInstallation() {
        if($this->hasOnce('installation')) return $this->getOnceValue('installation');

        $installation = Installation::find($this->device_installation_id);
        $this->setOnce('installation', $installation);

        return $installation;
    }

    protected function getVerifiedAttribute() {
        return $this->verified();
    }

    public function start() {
        if($this->verified()) {
            throw InvalidArgumentException::withMessage('This phone has already been verified.');
        }

        //// TODO: request timer

        $this->token = str_pad(rand(010201, 999896), 6, "0", STR_PAD_LEFT);
        $this->ttl = 300;
        $this->expires_at = Carbon::now()->addSecond($this->ttl);
        $this->method = PhoneVerifierMethod::fromValue(PhoneVerifierMethod::Sms);
        $this->save();

        $this->start_status = OtpRequestStatus::fromValue(OtpRequestStatus::Success);
        $this->message = null;

        //// TODO: send sms

        return $this;
    }    

    public function verified() {
        if($this->hasOnce('verified')) return $this->getOnceValue('verified');

        $verifier = Verifier::selectRaw('phone_verifiers.*')
            ->where('phone_verifiers.phone_id', $this->phone_id)
            ->whereNotNull('phone_verifiers.verified_at')
            ->latest('phone_verifiers.verified_at')
            ->first();

        if(is_null($verifier)) {
            $this->setOnce('verified', false);
            return false;
        }

        if($verifier->device_installation_id === $this->getInstallation()->id) {
            $this->setOnce('verified', true);
            return true;
        }
        
        $session = $this->getInstallation()->getSession();

        if(is_null($session)) {
            $this->setOnce('verified', false);
            return false;
        }

        foreach($session->user->installations() as $installation) {
            if($verifier->device_installation_id === $installation->id) {
                $this->setOnce('verified', true);
                return true;
            }
        }
    
        $this->setOnce('verified', false);
        return false;
    }

    public function verify(string $uuid, string $token) {
        if($this->verified()) {
            throw InvalidArgumentException::withMessage('This phone has already been verified.');
        }

        $verifier = Verifier::selectRaw('phone_verifiers.*')
            ->where('phone_verifiers.phone_id', $this->phone_id)
            ->where('phone_verifiers.device_installation_id', $this->device_installation_id)
            ->where('phone_verifiers.uuid', $uuid)
            ->first();  

        if(!$verifier) {
            throw InvalidArgumentException::withMessage('Verifier not initialized.', ErrorSubcodes::PHONE_VERIFIER_NOT_INITIALIZED);
        }

        if($verifier->token !== $token) {
            throw ValidationException::withMessages(['token' => 'This value is incorrect.']);
        }

        $verifier->verified_at = Carbon::now();
        $verifier->save();

        return $verifier;
    }
}
