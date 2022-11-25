<?php

namespace App\Models\Tag;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Core\Eloquent\Model;
use Illuminate\Pagination\Cursor;
use App\Models\Resources\Icon;

class Tag extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'tags';

    protected $appends = [
        'label_translated',
        'icon',
        'childs'
    ];

    protected $fillable = [
        'label',        
        'icon_id',
        'parent_tag_id',
        'ordering'
    ];

    protected $hidden = [
        'updated_at',
        'deleted_at',
        'icon_id',
        'ordering',
        'childs'
    ];

    protected $casts = [
        'deleted_at' => 'datetime',
    ];

    public static function list($maxResults = 1, $paginationToken = null) {
        $paginator = Tag::select(['tags.*'])
          ->orderBy('tags.ordering', 'asc')
          ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));
  
        return $paginator;
    }

    protected function getLabelTranslatedAttribute() {
        return __('tag.' . $this->label);
    }

    public function icon() {
        if($this->hasOnce('icon')) return $this->getOnceValue('icon');

        $icon = !is_null($this->icon_id) ? Icon::find($this->icon_id) : null;
        $this->setOnce('icon', $icon);

        if(is_null($icon)) {
            $parent = $this->parent();
            $icon = !is_null($parent) ? $parent->icon : null;
            $this->setOnce('icon', $icon);
        }

        return $icon;
    }

    protected function getIconAttribute() {
        $icon = $this->icon();        

        if(is_null($icon)) {
            return null;
        }

        $icon->makeVisibleBasic();
        return $icon;
    }

    protected function getChildsAttribute() {
        if($this->hasOnce('childs')) return $this->getOnceValue('childs');

        $childs = Tag::where('parent_tag_id', $this->id)
            ->orderBy('ordering', 'asc')
            ->get();

        $this->setOnce('childs', $childs);
        return $childs;
    }

    public function parent() {
        if($this->hasOnce('parent')) return $this->getOnceValue('parent');

        $parent = !is_null($this->parent_tag_id) ? Tag::find($this->parent_tag_id) : null;
        $this->setOnce('parent', $parent);
        return $parent;
    }

    public function makeVisibleBasic() {
        $this->setHidden(array_merge($this->hidden, [
            'childs',
        ]));
    }
}
