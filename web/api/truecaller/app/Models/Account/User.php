<?php

namespace App\Models\Account;

use Illuminate\Database\Eloquent\Factories\HasFactory;
// use Illuminate\Foundation\Auth\User as Authenticatable;
use App\Core\Account\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Laravel\Sanctum\HasApiTokens;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Models\Email\Email;
use App\Core\Person\Gender;
use App\Models\Phone\Phone;
use PHPOpenSourceSaver\JWTAuth\Contracts\JWTSubject;
use Illuminate\Pagination\Cursor;
use App\Models\Uploading\Media;
use App\Core\Enum\Visibility;
use App\Models\Account\UserPhone;
use App\Models\Account\UserEmail;
use Laravel\Scout\Searchable;
use Laravel\Scout\Attributes\SearchUsingFullText;
use Laravel\Scout\Attributes\SearchUsingPrefix;
use App\Core\Facades\Authentication;
use App\Models\Account\UserContact;
use Exception;
use App\Models\Account\Auth\Session;
use App\Models\Device\Installation;
use App\Models\Place\Location;
use App\Models\Company\Company;
use App\Models\Account\Group;

class User extends Authenticatable implements JWTSubject
{
    use HasApiTokens, HasFactory, Notifiable, SoftDeletes, Searchable;
    protected $table = 'users';

    protected $appends = [
        'blocked_by',
        'blocking',
        'verified',
        'default_profile_image',
        'profile_image_url',
        'phones',
        'emails',
        'location',
        'job_company',
        'social_id',
        'group'
    ];

    protected $fillable = [
        'name',
        'birthday',
        'gender',
        'location_id',
        'lang',
        'profile_image_id',
        'visibility',
        'user_group_id',
        'verified_at',
        'job_title',
        'job_company_id',
        'social_id_facebook',
        'social_id_twitter',
        'social_id_instagram',
        'url'
    ];

    protected $hidden = [
        'deleted_at',
        'updated_at',
        'verified_at',
        'birthday',
        'location_id',
        'blocking',
        'blocked_by',
        'user_group_id',
        'password',
        'remember_token',
        'phones',
        'emails',
        'social_id_facebook',
        'social_id_instagram',
        'social_id_twitter',      
        'job_company_id',
        'group'
    ];

    protected $casts = [
        'birthday' => 'datetime:Y-m-d',
        'verified_at' => 'datetime',
        'gender'   => Gender::class,
        'visibility' => Visibility::class
    ];

    // #[SearchUsingFullText(['users_search'])]    
    public function toSearchableArray()
    {
        return [
            'name' => $this->name
        ];
    }

    protected function getSocialIdAttribute() {
        return [
            'facebook' => $this->social_id_facebook,
            'instagram' => $this->social_id_instagram,
            'twitter' => $this->social_id_twitter,
        ];
    }

    protected function getJobCompanyAttribute() {
        if($this->hasOnce('job_company')) return $this->getOnceValue('job_company');

        $company = !is_null($this->job_company_id) ? Company::find($this->job_company_id) : null;
        if(!is_null($company)) {
            $company->makeVisibleBasic(['verified']);
        }
        $this->setOnce('job_company', $company);
        return $company;
    }

    protected function getLocationAttribute() {
        if($this->hasOnce('location')) return $this->getOnceValue('location');

        $location = !is_null($this->location_id) ? Location::find($this->location_id) : null;
        $this->setOnce('location', $location);
        return $location;
    }

    public function removeEmail(Email $email) {
        $userEmailBuilder = UserEmail::selectRaw('user_emails.*')
            ->join('auth_sessions', 'user_emails.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('user_emails.email_id', $email->id)
            ->where('auth_sessions.user_id', auth()->user()->id);

        $userEmails = $userEmailBuilder
            ->latest('user_emails.created_at')
            ->get();

        foreach($userEmails as $userEmail) {
            $userEmail->delete();
        }
    }

    protected function getEmailsAttribute()
    {
        return $this->emails();
    }

    public function emails() {
        $userEmailsBuilder = UserEmail::selectRaw('user_emails.*')
            ->join('auth_sessions', 'user_emails.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('auth_sessions.user_id', $this->id);

        $userEmails = $userEmailsBuilder
            ->latest('user_emails.created_at')
            ->get();

        $emails = [];
        
        foreach($userEmails as $userEmail) {
            $email = $userEmail->email;
            $email->setUserRef($this);
            $emails[] = $email;
        }

        return $emails;
    }

    public function storeEmail(Email $email, ?Session $session = null) {
        if(is_null($session)) {
            $session = Authentication::session();
        }

        if(is_null($session)) {
            return null; ////TODO throw
        }

        $userEmailBuilder = UserEmail::selectRaw('user_emails.*')
            ->join('auth_sessions', 'user_emails.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('user_emails.email_id', $email->id)
            ->where('auth_sessions.user_id', $session->user_id);

        $userEmail = $userEmailBuilder
            ->latest('user_emails.created_at')
            ->first();

        if(!is_null($userEmail)) {
            return $userEmail;
        }

        $userEmail = UserEmail::firstOrCreate([
            'created_by_auth_session_id' => $session->id,
            'email_id' => $email->id
        ]);

        return $userEmail;
    }

    protected function getVerifiedAttribute() {
        return !is_null($this->verified_at) ? true : false;
    }

    public function getAuthPassword() {
        return $this->password;
    }

    public function getJWTIdentifier() {
        return $this->getKey();
    }

    public function getJWTCustomClaims() {
        return [];
    }

    protected function getDefaultProfileImageAttribute() {
        return !is_null($this->profile_image_id) ? false : true;
    }

    protected function getProfileImageUrlAttribute() {
        if(is_null($this->profile_image_id)) return null;

        $media = Media::find($this->profile_image_id);
        return $media->factory()->original()->url;
    }  

    public function paginatedPhones($maxResults = 1, $paginationToken = null) {
        $paginator = UserPhone::select(['user_phones.*'])
            ->join('auth_sessions', 'user_phones.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('auth_sessions.user_id', auth()->user()->id)
            ->orderByDesc('user_phones.id')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));        
  
        return $paginator;
    }

    public function storePhone(Phone $phone, ?Session $session = null) {
        if(is_null($session)) {
            $session = Authentication::session();
        }

        if(is_null($session)) {
            return null; ////TODO throw
        }

        $userPhoneBuilder = UserPhone::selectRaw('user_phones.*')
            ->join('auth_sessions', 'user_phones.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('user_phones.phone_id', $phone->id)
            ->where('auth_sessions.user_id', $session->user_id);

        $userPhone = $userPhoneBuilder
            ->latest('user_phones.created_at')
            ->first();

        if(!is_null($userPhone)) {
            return $userPhone;
        }

        $userPhone = UserPhone::firstOrCreate([
            'created_by_auth_session_id' => $session->id,
            'phone_id' => $phone->id
        ]);

        return $userPhone;
    }

    public function removePhone(Phone $phone) {
        $userPhoneBuilder = UserPhone::selectRaw('user_phones.*')
            ->join('auth_sessions', 'user_phones.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('user_phones.phone_id', $phone->id)
            ->where('auth_sessions.user_id', auth()->user()->id);

        $userPhones = $userPhoneBuilder
            ->latest('user_phones.created_at')
            ->get();

        foreach($userPhones as $userPhone) {
            $userPhone->delete();
        }
    }

    protected function getUserContactsBuilder() {
        return UserContact::selectRaw('user_contacts.*')
            ->join('auth_sessions', 'user_contacts.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('auth_sessions.user_id', auth()->user()->id);
    }

    public function getUserContact(Phone $phone, bool $withTrashed = false) {
        $userContactBuilder = $this->getUserContactsBuilder()
            ->where('user_contacts.phone_id', $phone->id);

        if($withTrashed) $userContactBuilder = $userContactBuilder->withTrashed();
            
        return $userContactBuilder
            ->first();
    }

    protected function getRemovedContacts(array $phones) {
        $userContacts = $this->getUserContactsBuilder()
            ->get();
        
        $phonesIds = [];
        foreach($phones as $phone) $phonesIds[] = $phone->id;

        $removed = [];
        foreach($userContacts as $userContact) {
            if(!in_array($userContact->phone_id, $phonesIds)) {
                $removed[] = $userContact;
            }
        }

        return $removed;
    }

    public function updateContacts(array $phoneNumbers) {
        $session = Authentication::session();

        $phones = Phone::getPhonesByE164Format($phoneNumbers, true);

        $removedContacts = $this->getRemovedContacts($phones);
        foreach($removedContacts as $removedContact) {
            $removedContact->delete();
        }

        foreach($phones as $phone) {
            $userContact = $this->getUserContact($phone, true);

            if(is_null($userContact)) {
                $userContact = new UserContact();
                $userContact->phone_id = $phone->id;
                $userContact->created_by_auth_session_id = $session->id;
                $userContact->save();

                continue;
            }

            if($userContact->trashed()) {
                $userContact->restore();
            }                    
        }
    }

    public function getLastInstallation() {
        $installation = Installation::selectRaw('device_installations.*')
            ->join('auth_sessions', 'device_installations.id', '=', 'auth_sessions.device_installation_id')
            ->where('auth_sessions.user_id', $this->id)
            ->latest('device_installations.id')
            ->first();

        return $installation;
    }

    protected function getPhonesAttribute() {
        return $this->phones();
    }

    protected function phones() {
        $userPhonesBuilder = UserPhone::selectRaw('user_phones.*')
            ->join('auth_sessions', 'user_phones.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('auth_sessions.user_id', $this->id);

        $userPhones = $userPhonesBuilder
            ->latest('user_phones.created_at')
            ->get();

        $phones = [];
        
        foreach($userPhones as $userPhone) {
            $phone = $userPhone->phone;
            $phone->setUserRef($this);
            $phones[] = $phone;
        }

        return $phones;
    }

    public function installations() {
        if($this->hasOnce('installations')) return $this->getOnceValue('installations');

        $installations = Installation::selectRaw('device_installations.*')
            ->join('auth_sessions', 'device_installations.id', '=', 'auth_sessions.device_installation_id')
            ->where('auth_sessions.user_id', $this->id)
            ->orderBy('auth_sessions.created_at', 'desc')
            ->get(); 
            
        $this->setOnce('installations', $installations);
        return $installations;
    }

    protected function getGroupAttribute() {
        if($this->hasOnce('group')) return $this->getOnceValue('group');

        $group = !is_null($this->user_group_id) ? Group::find($this->user_group_id) : null;
        $this->setOnce('group', $group);
        return $group;
    }

    public function makeVisibleBasic() {
        $this->setHidden(array_merge($this->hidden, [
            'phone', 
            'email',
            'birthday',
            'gender',
            'updated_at',
            'blocked_by',
            'blocking',
            'user_group_id',
            'lang',
            'visibility',
            'location_id'                      
        ]));
    }
}
