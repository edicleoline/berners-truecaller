<?php

namespace App\Models\Email;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Email\Email;
use Carbon\Carbon;
use Illuminate\Validation\ValidationException;
use App\Exceptions\InvalidArgumentException;
use App\Exceptions\Api\ErrorSubcodes;
use App\Core\Enum\OtpRequestStatus;
use App\Models\Device\Installation;

class Verifier extends Model
{
    use HasFactory;
    protected $table = 'email_verifiers';

    protected bool $useUuid = true;

    protected $fillable = [
        'email_id',
        'ttl',
        'token',
        'device_installation_id'
    ];

    protected $appends = [
        'verified'
    ];

    protected $hidden = [
        'id',
        'email_id',
        'token',
        'updated_at',
        'expires_at',
        'device_installation_id'
    ];

    protected $casts = [
        'verified_at' => 'datetime',
        'expires_at' => 'datetime',
    ];

    public static function instance(Email $email, Installation $installation) {
        $verifier = new Verifier();
        $verifier->email_id = $email->id;
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
            throw InvalidArgumentException::withMessage('This email has already been verified.');
        }

        //// TODO: request timer

        $this->token = str_pad(rand(010201, 999896), 6, "0", STR_PAD_LEFT);
        $this->ttl = 86400;
        $this->expires_at = Carbon::now()->addSecond($this->ttl);
        $this->save();

        $this->start_status = OtpRequestStatus::fromValue(OtpRequestStatus::Success);
        $this->message = null;

        //// TODO: send mail

        return $this;
    }

    public function verified() {
        if($this->hasOnce('verified')) return $this->getOnceValue('verified');

        $verifier = Verifier::selectRaw('email_verifiers.*')
            ->where('email_verifiers.email_id', $this->email_id)
            ->whereNotNull('email_verifiers.verified_at')
            ->latest('email_verifiers.verified_at')
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

        $verifier = Verifier::selectRaw('email_verifiers.*')
            ->where('email_verifiers.email_id', $this->email_id)
            ->where('email_verifiers.device_installation_id', $this->device_installation_id)
            ->where('email_verifiers.uuid', $uuid)
            ->first();

        if(!$verifier) {
            throw InvalidArgumentException::withMessage('Verifier not initialized.', ErrorSubcodes::EMAIL_VERIFIER_NOT_INITIALIZED);
        }

        if($verifier->token !== $token) {
            throw ValidationException::withMessages(['token' => 'This value is incorrect.']);
        }

        $verifier->verified_at = Carbon::now();
        $verifier->save();

        return $verifier;
    }  
}
