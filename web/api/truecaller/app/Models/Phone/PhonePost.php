<?php

namespace App\Models\Phone;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Posting\Post;
use App\Models\Phone\Report\Report;

class PhonePost extends Model
{
    use HasFactory;
    protected $table = 'phone_posts';

    protected $fillable = [
        'phone_id',
        'post_id',
        'phone_report_id',        
    ];

    protected $appends = [
        'post',
        'report'
    ];

    protected $hidden = [
        'updated_at',
    ];

    protected $casts = [        
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
    ];   
    
    protected function getPostAttribute() {
        if($this->hasOnce('post')) return $this->getOnceValue('post');

        $post = Post::find($this->post_id);
        $this->setOnce('post', $post);
        return $post;
    }

    protected function getReportAttribute() {
        if($this->hasOnce('report')) return $this->getOnceValue('report');

        $report = Report::find($this->phone_report_id);
        $this->setOnce('report', $report);
        return $report;
    }

    public function makeVisibleBasic() {
        $this->setHidden(array_merge($this->hidden, [
            'post',
        ]));
    }
}
