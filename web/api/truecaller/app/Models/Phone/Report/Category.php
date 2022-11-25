<?php

namespace App\Models\Phone\Report;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Eloquent\Model;
use Illuminate\Pagination\Cursor;
use App\Models\Resources\Icon;

class Category extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'phone_report_categories';

    protected $appends = [
        'label_translated',
        'icon'
    ];

    protected $fillable = [
        'label',        
        'icon_id'
    ];

    protected $hidden = [
        'updated_at',
        'deleted_at',
        'icon_id'
    ];

    protected $casts = [
        'deleted_at' => 'datetime',
    ];

    public static function list($maxResults = 1, $paginationToken = null) {
        $paginator = Category::select(['phone_report_categories.*'])
          ->orderByDesc('phone_report_categories.id')
          ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    protected function getLabelTranslatedAttribute() {
        return __('phone_report_category.' . $this->label);
    }

    public function icon() {
        if($this->hasOnce('icon')) return $this->getOnceValue('icon');

        $icon = !is_null($this->icon_id) ? Icon::find($this->icon_id) : null;
        $this->setOnce('icon', $icon);
        return $icon;
    }

    protected function getIconAttribute() {
        $icon = $this->icon();
        $icon->makeVisibleBasic();
        return $icon;
    }

    public function makeVisibleBasic() {
        $this->setHidden(array_merge($this->hidden, [
            
        ]));
    }
}
