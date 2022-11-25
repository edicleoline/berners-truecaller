<?php

namespace App\Models\Phone;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Models\Company\Company;
use App\Exceptions\InvalidOperationException;
use App\Core\Facades\Authentication;

class PhoneCompany extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'phone_companies';

    protected $fillable = [
        'phone_id',
        'company_id',
        'created_by_auth_session_id',
        'verified_at',
        'is_public',
        'deleted_by_auth_session_id'
    ];

    protected $appends = [
        'verified',        
    ];

    protected $hidden = [
        'created_at',
        'updated_at',
        'deleted_at',
        'created_by_auth_session_id',
        'verified_at',
        'deleted_by_auth_session_id'
    ];

    protected $casts = [        
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
        'is_public' => 'boolean'
    ];   
    
    public function company() {
        if($this->hasOnce('company')) return $this->getOnceValue('company');        
        
        $this->setOnce('company', Company::find($this->company_id));
        return $this->getOnceValue('company');
    }

    protected function getVerifiedAttribute() {
        return !is_null($this->verified_at) ? true : false;
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($phoneCompany) {
            if($phoneCompany->verified === true) {
                throw InvalidOperationException::withMessage('You cannot delete this record because it has been verified. ' . $phoneCompany->id);
            }
            else if($phoneCompany->is_public === true) {
                throw InvalidOperationException::withMessage('You cannot delete this record because it is public.');
            }

            $phoneCompany->deleted_by_auth_session_id = Authentication::session()->id;
            $phoneCompany->save();

            return true;
        });
    }
}