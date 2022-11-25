<?php

namespace App\Models\Company;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Phone\Phone;
use App\Models\Uploading\Media;
use Illuminate\Database\Eloquent\SoftDeletes;
use Laravel\Scout\Attributes\SearchUsingFullText;
use Laravel\Scout\Searchable;
use App\Models\Phone\PhoneCompany;

class Company extends Model
{
    use HasFactory, SoftDeletes, Searchable;
    protected $table = 'companies';

    protected $appends = [
        'verified',
        'default_profile_image',
        'profile_image_url',
        'social_id'
    ];

    protected $fillable = [
        'name',
        'legal_name',
        'url',
        'profile_image_id',
        'social_id_facebook',
        'social_id_twitter',
        'social_id_instagram',
        'url'
    ];

    protected $hidden = [
        'deleted_at',
        'verified_at',
        'social_id_facebook',
        'social_id_twitter',
        'social_id_instagram',
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime',
        'deleted_at' => 'datetime',
    ];    

    protected function getVerifiedAttribute() {
        return !is_null($this->verified_at) ? true : false;
    }

    public function getProfileImage() {
        if($this->hasOnce('profile_image')) return $this->getOnceValue('profile_image');

        $media = !is_null($this->profile_image_id) ? Media::find($this->profile_image_id) : null;
        $this->setOnce('profile_image', $media);
        return $media;
    }

    protected function getProfileImageUrlAttribute() {
        $profileImage = $this->getProfileImage();

        if(is_null($profileImage)) return null;

        return $profileImage->factory()->original()->url;
    }

    protected function getDefaultProfileImageAttribute() {
        return !is_null($this->getProfileImage()) ? false : true;
    }

    protected function getSocialIdAttribute() {
        return [
            'facebook' => $this->social_id_facebook,
            'instagram' => $this->social_id_instagram,
            'twitter' => $this->social_id_twitter,
        ];
    }

    #[SearchUsingFullText(['name', 'legal_name'])]
    public function toSearchableArray()
    {
        return [
            'name' => $this->name,
            'legal_name' => $this->legal_name
        ];
    }

    // public function verifiedPhone() {
    //     $phoneCompany = PhoneCompany::selectRaw('phone_companies.*')            
    //         ->where('phone_companies.company_id', $this->id)
    //         ->whereNotNull('phone_companies.verified_at')
    //         ->latest('phone_companies.verified_at')
    //         ->first();

    //     if(!is_null($phoneCompany)) {
    //         return Phone::find($phoneCompany->phone_id);
    //     }

    //     return null;
    // }

    public function makeVisibleBasic(array $include = []) {
        $this->setHidden(array_merge(array_merge($this->hidden, [
            'created_at',
            'updated_at',
            'legal_name'
        ]), $include));
    }
}
