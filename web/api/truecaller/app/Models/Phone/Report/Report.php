<?php

namespace App\Models\Phone\Report;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Eloquent\Model;
use App\Models\Phone\Report\Category;
use App\Models\Phone\Phone;
use Illuminate\Pagination\Cursor;
use App\Core\Facades\Authentication;
use App\Core\Enum\EntityType;
use App\Models\Phone\PhonePost;

class Report extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'phone_reports';

    protected $appends = [
        'category',
        'verified',
        'created_by',
        'post'
    ];

    protected $fillable = [
        'phone_id',
        'created_by_auth_session_id',
        'phone_report_category_id',
        'anonymous_mode',
        'verified_at',
        'deleted_by_auth_session_id',
        'crawler_job_id',
        'entity_type'
    ];

    protected $hidden = [
        'updated_at',
        'deleted_at',
        'phone_report_category_id',
        'created_by_auth_session_id',
        'verified_at',
        'deleted_by_auth_session_id',
        'crawler_job_id'
    ];

    protected $casts = [
        'deleted_at' => 'datetime',
        'verified_at' => 'datetime',
        'anonymous_mode' => 'boolean',
        'entity_type' => EntityType::class
    ];

    protected function getCategoryAttribute() {
        if($this->hasOnce('category')) return $this->getOnceValue('category');

        $category = !is_null($this->phone_report_category_id) ? Category::find($this->phone_report_category_id) : null;
        if(!is_null($category)) $category->makeVisibleBasic();
        $this->setOnce('category', $category);

        return $category;
    }

    public static function list($maxResults = 1, $paginationToken = null) {
        $paginator = Report::select(['phone_reports.*'])
          ->orderByDesc('phone_reports.id')
          ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    public static function listByPhone(Phone $phone, $maxResults = 1, $paginationToken = null) {
        $paginator = Report::select(['phone_reports.*'])
            ->where('phone_id', $phone->id)
            ->orderByDesc('phone_reports.id')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    protected function getVerifiedAttribute() {
        return !is_null($this->verified_at) ? true : false;        
    }

    protected function getCreatedByAttribute() {
        return $this->createdBy();
    }

    public function getPhonePost() {
        if($this->hasOnce('phone_post')) return $this->getOnceValue('phone_post');

        $phonePost = PhonePost::where('phone_report_id', $this->id)
            ->first();

        $this->setOnce('phone_post', $phonePost);

        return $phonePost;
    }

    public function getPost() {
        if($this->hasOnce('post')) return $this->getOnceValue('post');

        $phonePost = $this->getPhonePost();

        $post = !is_null($phonePost) ? $phonePost->post : null;
        $this->setOnce('post', $post);

        return $post;
    }

    protected function getPostAttribute() {
        return $this->getPost();
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
