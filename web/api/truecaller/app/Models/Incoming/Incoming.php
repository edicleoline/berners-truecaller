<?php

namespace App\Models\Incoming;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Core\Incoming\Direction;
use App\Models\Phone\Phone;
use App\Core\Incoming\IncomingType;

class Incoming extends Model
{
    use HasFactory;
    protected $table = 'incomings';

    protected $fillable = [
        'created_by_auth_session_id',
        'source_phone_id',
        'target_phone_id',
        'direction',
        'sms_text',
    ];

    protected $appends = [
        'source',
        'target',
        'incoming_type'
    ];

    protected $hidden = [
        'source',
        'target',
        'created_by_auth_session_id',
        'direction',
        'updated_at',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'direction' => Direction::class
    ];

    protected function getSourceAttribute() {
        if($this->hasOnce('source')) return $this->getOnceValue('source');

        $phone = Phone::find($this->source_phone_id);
        $this->setOnce('source', $phone);

        return $phone;
    }

    protected function getTargetAttribute() {
        if($this->hasOnce('target')) return $this->getOnceValue('target');

        $phone = Phone::find($this->target_phone_id);
        $this->setOnce('target', $phone);

        return $phone;
    }

    protected function getIncomingTypeAttribute() {
        if(!empty($this->sms_text)) {
            return IncomingType::fromValue(IncomingType::Sms);
        }

        return IncomingType::fromValue(IncomingType::Call);
    }
}
