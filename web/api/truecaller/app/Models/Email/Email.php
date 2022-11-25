<?php

namespace App\Models\Email;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Account\User;
use App\Models\Email\Verifier;
use App\Models\Device\Installation;

class Email extends Model
{
    use HasFactory;
    protected $table = 'emails';

    protected $appends = [
        'verified_by'
    ];

    protected $fillable = [
        'email',
    ];

    protected $hidden = [
        'updated_at'
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];

    public function setUserRef(User $user) {
        $this->setOnce('user_ref', $user);
    }

    protected function getVerifiedByAttribute() {
        if(!$this->hasOnce('user_ref') || $this->isOnceValueNull('user_ref')) return null;

        $installation = $this->getOnceValue('user_ref')->getLastInstallation();        
        return $this->verifier($installation)->verified();
    }

    public function verifier(Installation $installation) {
        return Verifier::instance($this, $installation);
    }
}
