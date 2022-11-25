<?php

namespace App\Core\Eloquent;

use Illuminate\Database\Eloquent\Model as BaseModel;
use App\Models\Account\Auth\Session;
use Exception;
use Ramsey\Uuid\Uuid;
use App\Core\Facades\Authentication;

abstract class Model extends BaseModel
{
    protected $onces = [];

    protected bool $useUuid = false;

    protected int $uuidVersion = 4;

    public function setOnce(string $name, $value) {
        $once = $this->getOnce($name);

        if(!is_null($once)) {
            $once->value = $value;
            return true;
        }

        $once = new \stdClass();
        $once->name = $name;
        $once->value = $value;
        $this->onces[] = $once;

        return true;
    }

    public function getOnce(string $name) {
        foreach($this->onces as $once) {
            if($once->name === $name) {
                return $once;
            }
        }

        return null;
    }

    public function getOnceValue(string $name) {
        $once = $this->getOnce($name);
        return !is_null($once) ? $once->value : null;
    }

    public function isOnceValueNull(string $name) {
        return is_null($this->getOnceValue($name));
    }

    public function hasOnce(string $name) {
        return !is_null($this->getOnce($name));
    }

    public function createdBy() {
        if($this->hasOnce('created_by')) return $this->getOnceValue('created_by');

        $anonymousMode = is_null($this->anonymous_mode) ? true : $this->anonymous_mode;

        $session = Session::findById($this->created_by_auth_session_id, $anonymousMode);
        $this->setOnce('created_by', $session);
        return $session;
    }

    protected static function boot(): void
    {
        parent::boot();

        static::creating(function (self $model): void {
            if ($model->useUuid && empty($model->uuid)) {
                $model->uuid = $model->generateUuid();
            }
        });
    }

    protected function generateUuid(): string
    {
        switch ($this->uuidVersion) {
            case 1:
                return Uuid::uuid1()->toString();
            case 4:
                return Uuid::uuid4()->toString();
        }

        throw new Exception("UUID version [{$this->uuidVersion}] not supported.");
    }

    protected function getSession() {
        if($this->hasOnce('session')) return $this->getOnceValue('session');

        $session = Authentication::session();
        $this->setOnce('session', $session);

        return $session;
    }

    protected function setSession(Session $session) {        
        $this->setOnce('session', $session);
    }

    protected function resolveSessionIfNecessary(?Session $session = null) {
        if(is_null($session)) {
            $session = $this->getSession();
        }

        return $session;
    }
}