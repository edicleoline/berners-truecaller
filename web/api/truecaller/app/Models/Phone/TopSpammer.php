<?php

namespace App\Models\Phone;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Incoming\IncomingType;
use Illuminate\Pagination\Cursor;
use App\Models\Place\Country;

class TopSpammer extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'top_phone_spammers';

    protected $fillable = [        
        'phone_id',
        'label',
        'reports_count',
        'crawler_job_id',
        'categories',
        'original_crawled',
        'incoming_type',
        'phone_e164_format',
        'country_iso2'
    ];

    protected $appends = [
        'phone'
    ];

    protected $hidden = [
        'created_at',
        'updated_at',
        'deleted_at',
        'crawler_job_id',
        'original_crawled',
        'incoming_type',
        'phone_id',
        'id',
        'phone_e164_format',
        'country_iso2'
    ];

    protected $casts = [        
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
        'categories' => 'array',
        'original_crawled' => 'array',
        'incoming_type' => IncomingType::class
    ];

    public static function listByIncomingType(Country $country, IncomingType $incomingType, $maxResults = 1, $paginationToken = null) {
        $paginator = TopSpammer::select(['top_phone_spammers.*'])
            ->where('top_phone_spammers.country_iso2', $country->iso2)
            ->where('top_phone_spammers.incoming_type', $incomingType->value)
            ->orderByDesc('top_phone_spammers.reports_count')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    protected function getPhoneAttribute() {
        return [
            'e164_format' => $this->phone_e164_format
        ];
    }
}
