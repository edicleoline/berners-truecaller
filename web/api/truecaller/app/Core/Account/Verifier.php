<?php

namespace App\Core\Account;

use App\Models\Account\User;

class Verifier
{
    protected $user;

    public function __construct(User $user)
    {
        $this->user = $user;
    }

    public static function instance(User $user) {
        $verifier = new Verifier($user);
        return $verifier;
    }

    public function verified() {
        return false;
    }

    public function verifiedObjects() {
        $verifiers = [];

        $email = $this->user->email();
        if($email && $email->verifier()->verified()) {
            $verifiers[] = 'email';
        }

        $phone = $this->user->phone();
        if($phone && $phone->verifier()->verified()) {
            $verifiers[] = 'phone';
        }

        return $verifiers;
    }
}
