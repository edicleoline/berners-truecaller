<?php

namespace App\Models\Phone\PositiveReport;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\SoftDeletes;
use Illuminate\Database\Eloquent\Model;
use App\Models\Account\User;
use Illuminate\Pagination\Cursor;
use App\Models\Account\Auth\Session;
use App\Core\Facades\Authentication;

class PositiveReport extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'phone_positive_reports';

    protected $appends = [
        'reported_by',
        'verified'
    ];

    protected $fillable = [
        'phone_id',
        'text',
        'anonymous_mode',
        'verified_at',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
    ];

    protected $hidden = [
        'updated_at',
        'deleted_at',
        'created_by_auth_session_id',
        'deleted_by_auth_session_id',
    ];

    protected $casts = [
        'deleted_at' => 'datetime',
        'updated_at' => 'datetime',
        'verified_at' => 'datetime',
        'anonymous_mode' => 'boolean'
    ];

    protected function getVerifiedAttribute() {
        return !is_null($this->verified_at) ? true : false;
    }

    protected function getReportedByAttribute() {
        if($this->anonymous_mode === true) {
            return null;
        }

        return Session::find($this->created_by_auth_session_id)->user();
    }

    public function createdBy() {
        return Session::find($this->created_by_auth_session_id);
    }

    protected static function boot(): void {
        parent::boot();

        static::deleting(function($report) {  
            $report->deleted_by_auth_session_id = Authentication::session()->id;
            $report->save();
            
            return true;
        });
    }
}
