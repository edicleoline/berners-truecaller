<?php

namespace App\Models\Phone;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use App\Core\Eloquent\Model;
use App\Models\Place\Country;
use Propaganistas\LaravelPhone\PhoneNumber;
use App\Models\Company\Company;
use App\Models\Phone\Report\Report;
use App\Models\Phone\PositiveReport\PositiveReport;
use App\Models\Tag\Tag;
use App\Models\Phone\PhoneTag;
use App\Models\Phone\PhoneLocation;
use App\Models\Place\Location;
use App\Core\Phone\Phone as PhoneCore;
use App\Models\Phone\PhoneCompany;
use App\Models\Account\User;
use Exception;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use App\Exceptions\ObjectNotFoundException;
use App\Exceptions\InvalidArgumentException;
use App\Core\Facades\Authentication;
use App\Models\Phone\Report\Category;
use App\Models\Account\Auth\Session;
use App\Models\Phone\Verifier;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use App\Models\Account\UserContact;
use App\Core\Enum\EntityType;
use App\Models\Phone\PhoneEntity;
use Illuminate\Pagination\Cursor;
use App\Models\Phone\PhonePost;
use App\Models\Device\Installation;
use App\Models\Phone\SpamInfo;
use App\Models\Filtering\Filter;
use App\Core\Helper\Cast;

class Phone extends Model
{
    use HasFactory;
    protected $table = 'phones';

    protected $appends = [
        // 'e164_format',
        'national_format',
        'dialing_code',
        'country_code',
        'carrier',
        'number_type',        
        'tag',
        'location',
        'company',
        'user',
        'reports_count',
        'score',
        'entity',
        'verified_by',
        'spam',    
        'blacklisted_by',
        'whitelisted_by'
    ];

    protected $fillable = [
        'phone',
        'raw',
        'country_id',
        'carrier_company_id',
        'created_by_auth_session_id',
        'crawler_job_id',
        'has_parse_error'
    ];

    protected $hidden = [
        'raw',
        'updated_at',
        'carrier_company_id',
        'created_by_auth_session_id',
        'crawler_job_id',
        'has_parse_error',
        'country_id',
        'reports_count',
        'score'
    ];

    protected $casts = [
        'created_at' => 'datetime',
        'updated_at' => 'datetime'
    ];    

    public function verifier(Installation $installation) {
        return Verifier::instance($this, $installation);
    }

    public function country() {            
        if($this->hasOnce('country')) return $this->getOnceValue('country');

        $country = !is_null($this->country_id) ? Country::findById($this->country_id) : null;
        $this->setOnce('country', $country);
        return $country;
    }

    public function getPhone() {
        if($this->hasOnce('propa_phone')) return $this->getOnceValue('propa_phone');

        $propaPhone = PhoneNumber::make($this->phone, $this->country()->iso2);
        $this->setOnce('propa_phone', $propaPhone);
        return $propaPhone;
    }

    // public function getLibPhone () {
    //     $phoneNumber = new \libphonenumber\PhoneNumber();
    //     $phoneNumber->setCountryCode($this->country()->iso2);
    //     $phoneNumber->setNationalNumber($this->phone);

    //     return $phoneNumber;
    // }

    // protected function getShortNumberUtil() {
    //     return ShortNumberInfo::getInstance();
    // }

    // protected function getE164FormatAttribute() {
    //     $phone = $this->getPhone();
    //     try {
    //         return !is_null($phone) ? $phone->formatE164() : null;
    //     }
    //     catch(Exception) {

    //     }
        
    //     return $this->phone;        
    // }

    protected function getNationalFormatAttribute() {
        $phone = $this->getPhone();
        try {
            return !is_null($phone) ? $phone->formatNational() : null;
        }
        catch(Exception) {

        }

        return $this->phone;
    }

    protected function getDialingCodeAttribute() {
        $country = $this->country();
        return !is_null($country) ? $country->phonecode : null;
    }    

    protected function getCountryCodeAttribute() {
        $country = $this->country();
        return !is_null($country) ? $country->iso2 : null;
    }    

    protected function getCarrierAttribute() {
        if($this->hasOnce('carrier')) return $this->getOnceValue('carrier');

        $carrier = !is_null($this->carrier_company_id) ? Company::find($this->carrier_company_id) : null;
        $this->setOnce('carrier', $carrier);
        return $carrier;
    }

    protected function getNumberTypeAttribute() {
        $phone = $this->getPhone();        
        try {
            return !is_null($phone) ? $phone->getType() : null;
        }
        catch(Exception) {

        }

        return "unknown";
    }

    protected function getScoreAttribute() {
        if($this->hasOnce('score')) return $this->getOnceValue('score');

        $userContactCount = UserContact::countPhone($this);

        $score = ($userContactCount / 84) * 100;
        $score = (float)number_format($score, 2);

        $this->setOnce('score', $score);
        
        return $score;
    }    

    protected function transformEntityFromPhoneEntity(PhoneEntity $phoneEntity) {
        $entity = new \stdClass();
        $entity->type = "suggested" . ($phoneEntity->entity_type ? "_" . $phoneEntity->entity_type->jsonSerialize() : "");
        $entity->id = $phoneEntity->id;
        $entity->name = $phoneEntity->name;
        $entity->default_profile_image = true;            
        $entity->verified = $phoneEntity->verified;
        return $entity;
    }

    protected function transformEntityFromUser($user) {
        $entity = new \stdClass();
        $entity->type = "people";
        $entity->id = $user->entity->id;
        $entity->name = $user->entity->name;
        $entity->default_profile_image = $user->entity->default_profile_image;
        $entity->profile_image_url = $user->entity->profile_image_url;
        $entity->verified = $user->verified === true && $user->entity->verified === true;
        return $entity;
    }

    protected function transformEntityFromCompany($company) {
        $entity = new \stdClass();
        $entity->type = "company";
        $entity->id = $company->entity->id;
        $entity->name = $company->entity->name;
        $entity->default_profile_image = $company->entity->default_profile_image;
        $entity->profile_image_url = $company->entity->profile_image_url;
        $entity->verified = $company->verified;
        return $entity;
    }

    protected function getEntityAttribute() {
        if($this->hasOnce('entity')) return $this->getOnceValue('entity');

        $phoneCompany = PhoneCompany::where('phone_id', $this->id)
            ->whereNotNull('verified_at')
            ->where('is_public', true)
            ->latest()
            ->first();

        if(!is_null($phoneCompany)) {
            $entity = $this->transformEntityFromCompany((object)[
                'verified' => true,
                'entity' => $phoneCompany->company()
            ]);
            $this->setOnce('entity', $entity);
            return $entity;
        }

        $user = $this->user();

        if(!is_null($user) && !is_null($user->entity) && $user->verified === true && $user->entity->verified === true) {
            $entity = $this->transformEntityFromUser($user);
            $this->setOnce('entity', $entity);
            return $entity;
        }        

        $suggestedEntity = PhoneEntity::where('phone_id', $this->id)
            ->whereNotNull('verified_at')
            ->where('is_public', true)
            ->latest()
            ->first();        
            
        if(is_null($suggestedEntity)) {
            $suggestedEntity = PhoneEntity::selectRaw('phone_entities.*')
                ->join('auth_sessions', 'phone_entities.created_by_auth_session_id', '=', 'auth_sessions.id')
                ->where('auth_sessions.user_id', auth()->user()->id)     
                ->where('phone_entities.phone_id', $this->id)
                ->latest('phone_entities.created_at')   
                ->first();
        }
            
        if($suggestedEntity) {
            $entity = $this->transformEntityFromPhoneEntity($suggestedEntity);
            $this->setOnce('entity', $entity);
            return $entity;
        }
        
        if(!is_null($user) && !is_null($user->entity)) {
            $entity = $this->transformEntityFromUser($user);           
            $this->setOnce('entity', $entity);
            return $entity;
        }

        $company = $this->company();
        if(!is_null($company) && !is_null($company->entity)) {
            $entity = $this->transformEntityFromCompany($company);
            $this->setOnce('entity', $entity);
            return $entity;
        }

        $suggestedEntity = PhoneEntity::where('phone_id', $this->id)
            ->where('is_public', true)
            ->latest()
            ->first();

        if($suggestedEntity) {
            $entity = $this->transformEntityFromPhoneEntity($suggestedEntity);
            $this->setOnce('entity', $entity);
            return $entity;
        }

        return null;
    }

    protected function getReportsCountAttribute() {
        if($this->hasOnce('reports_count')) return $this->getOnceValue('reports_count');

        $reportsCount = DB::table('phone_reports')
            ->where('phone_reports.phone_id', $this->id)
            ->count();

        $this->setOnce('reports_count', $reportsCount);

        return $reportsCount;
    }
    
    public function reports() {
        return Report::where('phone_id', $this->id)
            ->get();
    }

    protected function getTagAttribute() {
        if($this->hasOnce('tag')) return $this->getOnceValue('tag');

        $phoneTag = PhoneTag::selectRaw('phone_tags.*')
            ->join('auth_sessions', 'phone_tags.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('auth_sessions.user_id', auth()->user()->id)     
            ->latest('phone_tags.created_at')   
            ->first();

        if(is_null($phoneTag)) {
            $phoneTag = PhoneTag::where('phone_id', $this->id)
                ->whereNotNull('verified_at')
                ->where('is_public', true)
                ->latest()
                ->first();
        }
        
        if(is_null($phoneTag)) {
            $phoneTag = PhoneTag::where('phone_id', $this->id)
                ->where('is_public', true)
                ->latest()
                ->first();
        }

        if(is_null($phoneTag)) {
            $this->setOnce('tag', null);
            return null;
        }

        $obj = new \stdClass();
        $obj->verified = $phoneTag->verified;
        $obj->entity = $phoneTag->tag();
        if(!is_null($obj->entity)) {
            $obj->entity->makeVisibleBasic();
        }

        $this->setOnce('tag', $obj);

        return $obj;
    }

    protected function getLocationAttribute() {   
        if($this->hasOnce('location')) return $this->getOnceValue('location');

        $phoneLocation = PhoneLocation::selectRaw('phone_locations.*')
            ->join('auth_sessions', 'phone_locations.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('auth_sessions.user_id', auth()->user()->id)   
            ->where('phone_locations.phone_id', $this->id)  
            ->latest('phone_locations.created_at')       
            ->first();

        if(is_null($phoneLocation)) {
            $phoneLocation = PhoneLocation::where('phone_id', $this->id)
            ->whereNotNull('verified_at')
            ->where('is_public', true)
            ->latest()
            ->first();
        }
    
        if(is_null($phoneLocation)) {
            $phoneLocation = PhoneLocation::where('phone_id', $this->id)
                ->where('is_public', true)
                ->latest()
                ->first();
        }

        if(is_null($phoneLocation)) {
            $this->setOnce('location', null);
            return null;
        }

        $obj = new \stdClass();
        $obj->verified = $phoneLocation->verified;
        $obj->entity = $phoneLocation->location();
        if(!is_null($obj->entity)) {
            $obj->entity->makeVisibleBasic();
        }

        $this->setOnce('location', $obj);

        return $obj;
    }

    public function getPhoneCompany() {        
        if($this->hasOnce('phone_company')) return $this->getOnceValue('phone_company');

        $this->setOnce('phone_company', PhoneCompany::selectRaw('phone_companies.*')
            ->join('auth_sessions', 'phone_companies.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('phone_companies.phone_id', $this->id)
            ->where('auth_sessions.user_id', auth()->user()->id)
            ->latest('phone_companies.created_at')       
            ->first());
        
        if(!$this->isOnceValueNull('phone_company')) {
            return $this->getOnceValue('phone_company');
        }

        $this->setOnce('phone_company', PhoneCompany::where('phone_id', $this->id)
            ->whereNotNull('verified_at')
            ->where('is_public', true)
            ->latest()
            ->first());        
            
        if(!$this->isOnceValueNull('phone_company')) {
            return $this->getOnceValue('phone_company');
        }

        $this->setOnce('phone_company', PhoneCompany::where('phone_id', $this->id)
            ->where('is_public', true)
            ->latest()
            ->first());

        return $this->getOnceValue('phone_company');
    }

    protected function getCompanyAttribute() {
        return $this->company();
    }

    public function company() {
        if($this->hasOnce('company')) return $this->getOnceValue('company');

        $phoneCompany = $this->getPhoneCompany();
        
        if(is_null($phoneCompany)) {
            return null;
        }

        $obj = new \stdClass();
        $obj->verified = $phoneCompany->verified;
        $obj->entity = $phoneCompany->company();

        $this->setOnce('company', $obj);

        return $this->getOnceValue('company');
    }

    public function addPositiveReport(?string $text, bool $anonymous) {
        $report = PositiveReport::firstOrCreate([
            'created_by_auth_session_id' => Authentication::session()->id,
            'phone_id' => $this->id,
            'text' => $text,
            'anonymous_mode' => $anonymous
        ]);

        return $report;
    }

    public function addReport(Category $category, ?EntityType $entityType, bool $anonymous = true, ?Session $session = null) {
        if(is_null($session)) {
            $session = Authentication::session();
        }        

        $report = new Report();
        $report->created_by_auth_session_id = !is_null($session) ? $session->id : null;
        $report->phone_id = $this->id;
        $report->entity_type = $entityType;
        $report->anonymous_mode = $anonymous;
        $report->phone_report_category_id = $category->id;
        $report->save();

        return $report;
    }

    public function addEntity(string $name, EntityType $entityType) {
        $session = Authentication::session();

        $phoneEntity = PhoneEntity::firstOrNew([
            'created_by_auth_session_id' => !is_null($session) ? $session->id : null,
            'phone_id' => $this->id,
            'name' => $name
        ]);

        $phoneEntity->entity_type = $entityType;        
        $phoneEntity->save();

        return $phoneEntity;
    }

    public function addLocation(Location $location) {
        $phoneLocations = $this->getPhoneLocationBuilder()
            ->whereNull('phone_locations.verified_at')
            ->where('phone_locations.is_public', false)
            ->latest('phone_locations.created_at')
            ->get();

        foreach ($phoneLocations as $phoneLocation) {
            $phoneLocation->delete();
        }

        $phoneLocation = PhoneLocation::firstOrCreate([
            'phone_id' => $this->id,
            'location_id' => $location->id,
            'is_public' => false,
            'created_by_auth_session_id' => Authentication::session()->id
        ]);

        return $phoneLocation;
    }

    public function removeLocation(Location $location) {
        $phoneLocations = $this->getPhoneLocationBuilder()            
            ->where('phone_locations.location_id', $location->id)
            ->whereNull('phone_locations.verified_at')
            ->where('phone_locations.is_public', false)
            ->latest('phone_locations.created_at')
            ->get();

        foreach ($phoneLocations as $phoneLocation) {
            $phoneLocation->delete();
        }
    }

    protected function getPhoneLocationBuilder() {
        return PhoneLocation::selectRaw('phone_locations.*')
            ->join('auth_sessions', 'phone_locations.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('phone_locations.phone_id', $this->id)
            ->where('auth_sessions.user_id', auth()->user()->id);
    }

    public function addTag(Tag $tag) {
        $phoneTags = $this->getPhoneTagBuilder()
            ->whereNull('phone_tags.verified_at')
            ->where('phone_tags.is_public', false)
            ->latest('phone_tags.created_at')
            ->get();

        foreach ($phoneTags as $phoneTag) {
            $phoneTag->delete();
        }

        $phoneTag = PhoneTag::firstOrCreate([
            'phone_id' => $this->id,
            'tag_id' => $tag->id,
            'is_public' => false,
            'created_by_auth_session_id' => Authentication::session()->id
        ]);

        return $phoneTag;
    }

    public function removeTag(Tag $tag) {
        $phoneTags = $this->getPhoneTagBuilder()            
            ->where('phone_tags.tag_id', $tag->id)
            ->whereNull('phone_tags.verified_at')
            ->where('phone_tags.is_public', false)
            ->latest('phone_tags.created_at')
            ->get();

        foreach ($phoneTags as $phoneTag) {
            $phoneTag->delete();
        }
    }

    protected function getPhoneTagBuilder() {
        return PhoneTag::selectRaw('phone_tags.*')
            ->join('auth_sessions', 'phone_tags.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('phone_tags.phone_id', $this->id)
            ->where('auth_sessions.user_id', auth()->user()->id);
    }

    public function addCompany(Company $company) {
        $phoneCompanies = $this->getPhoneCompanyBuilder()
            ->whereNull('phone_companies.verified_at')
            ->where('phone_companies.is_public', false)
            ->latest('phone_companies.created_at')
            ->get();

        foreach ($phoneCompanies as $phoneCompany) {
            $phoneCompany->delete();
        }

        $phoneCompany = PhoneCompany::firstOrCreate([
            'phone_id' => $this->id,
            'company_id' => $company->id,
            'is_public' => false,
            'created_by_auth_session_id' => Authentication::session()->id
        ]);

        return $phoneCompany;
    }

    public function removeCompany(Company $company) {
        $phoneCompanies = $this->getPhoneCompanyBuilder()            
            ->where('phone_companies.company_id', $company->id)
            ->whereNull('phone_companies.verified_at')
            ->where('phone_companies.is_public', false)
            ->latest('phone_companies.created_at')
            ->get();

        foreach ($phoneCompanies as $phoneCompany) {
            $phoneCompany->delete();
        }
    }

    protected function getPhoneCompanyBuilder() {
        return PhoneCompany::selectRaw('phone_companies.*')
            ->join('auth_sessions', 'phone_companies.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->where('phone_companies.phone_id', $this->id)
            ->where('auth_sessions.user_id', auth()->user()->id);
    }

    public static function findById($id) {
        return Phone::find($id);
    }

    public static function findOrCreate(string $number, ?string $countryIso2 = null, bool $ignoreParseErrors = false) {
        $country = null;
        try {
            $country = !is_null($countryIso2) ? Country::findOrFailByIsoCode2($countryIso2) : null;
        }
        catch (ModelNotFoundException $exception) {
            throw ObjectNotFoundException::withQueryParam(['country_code' => $countryIso2]);
        }
        
        $phone = PhoneCore::parse($number, $country);  

        if(is_null($phone->getCountry())) {
            throw InvalidArgumentException::withMessage('Invalid country.');
        }

        if(!$ignoreParseErrors && $phone->hasError()) {
            throw InvalidArgumentException::withMessage('Invalid phone number.');
        }        

        $model = Phone::firstOrNew([
            'phone' => $phone->formatNationalNormalized(),
            'country_id' => $phone->getCountry()->id,
        ]);

        $isNew = !is_null($model->id) ? false : true;

        if($isNew) {
            $model->has_parse_error = $phone->hasError();
            $model->raw = $number;
            $model->e164_format = $phone->formatE164();
        
            $carrier = $phone->getCarrier();
            if(!is_null($carrier)) {
                $model->carrier_company_id = $carrier->id;
            }
            $model->save();

            try {
                $location = $phone->getLocation();
                if(!is_null($location)) {
                    $phoneLocation = PhoneLocation::firstOrCreate([
                        'phone_id' => $model->id,
                        'location_id' => $location->id,
                        'created_by_auth_session_id' => null
                    ]);
                    $phoneLocation->is_public = true;
                    $phoneLocation->save();
                }
            }
            catch(Exception) { }
        }

        return $model;
    }

    protected function getUserAttribute() {
        return $this->user();
    }

    public function user() {
        if($this->hasOnce('user')) return $this->getOnceValue('user');
        
        $verifier = Verifier::selectRaw('phone_verifiers.*, auth_sessions.user_id')
            ->join('auth_sessions', 'phone_verifiers.device_installation_id', '=', 'auth_sessions.device_installation_id')
            ->where('phone_verifiers.phone_id', $this->id)
            ->whereNotNull('phone_verifiers.verified_at')
            ->latest('phone_verifiers.verified_at')
            ->first();
        
        if(!is_null($verifier)) {
            $user = User::find($verifier->user_id);
            if(!is_null($user)) {
                $this->setOnce('user', (object)[
                    'verified' => true,
                    'entity' => (object)[
                        'id' => $user->id,
                        'name' => $user->name,
                        'default_profile_image' => $user->default_profile_image,
                        'profile_image_url' => $user->profile_image_url,
                        'verified' => $user->verified
                    ]
                ]);
                return $this->getOnceValue('user');
            }
        }

        return null;
    }

    public function posts($maxResults = 1, $paginationToken = null) {
        $paginator = PhonePost::select(['phone_posts.*'])
            ->where('phone_posts.phone_id', $this->id)
            ->orderByDesc('phone_posts.id')
            ->cursorPaginate($maxResults, ['*'], 'cursor', Cursor::fromEncoded($paginationToken));

        foreach($paginator->items() as $item) {
            $hidden = ['updated_at'];

            if($item->report) {
                $item->report->setHidden(['post']);
                $hidden[] = 'phone_report_id';
            }
            if($item->post) {
                $hidden[] = 'post_id';                
            }

            $item->setHidden($hidden);
        }
  
        return $paginator;
    }

    public static function searchBuilder(string $number, ?Country $country = null) {
        $number = PhoneCore::unformatted($number);

        $queryBuilder = DB::table('phones');
        
        if(Str::startsWith($number, '+')) {
            $propaPhone = PhoneNumber::make($number, (!is_null($country) ? $country->iso2 : null));
            $number = PhoneCore::unformatted($propaPhone->formatNational());

            if(is_null($country)) {
                $country = Country::findOrFailByIsoCode2($propaPhone->getCountry());
            }
                        
            $queryBuilder = $queryBuilder
                ->where('phones.phone', 'like', "%{$number}%")
                ->where('phones.country_id', '=', $country->id)
                ->orderBy('phones.phone', 'asc');
        }
        else {
            $queryBuilder = $queryBuilder
                ->where('phones.phone', 'like', "%{$number}%")
                ->orderBy('phones.phone', 'asc');

            if(!is_null($country)) {
                $queryBuilder = $queryBuilder
                    ->where('phones.country_id', '=', $country->id);
            }
        }

        return $queryBuilder;
    }

    public static function getPhonesByE164Format(array $numbers, bool $ignoreParseErrors = false) {
        $phones = [];

        foreach($numbers as $number) {
            try {
                $phones[] = static::findOrCreate($number, null, $ignoreParseErrors);
            }
            catch(Exception $e) {
                if(!$ignoreParseErrors) throw $e;
            }
        }

        return $phones;
    }

    public function makeVisibleBasic(array $include = []) {
        $this->setHidden(array_merge(array_merge($this->hidden, [
            'company',   
            'user',
            'verified',
            'entity',
            'reports_count',
            'tag',
            'score',
            'created_at'
        ]), $include));

        if(!is_null($this->carrier)) {
            $this->carrier->makeVisibleBasic();
        }
    }

    public function setUserRef(User $user) {
        $this->setOnce('user_ref', $user);
    }

    protected function getVerifiedByAttribute() {
        if(!$this->hasOnce('user_ref') || $this->isOnceValueNull('user_ref')) return null;

        $installation = $this->getOnceValue('user_ref')->getLastInstallation();        
        return $this->verifier($installation)->verified();
    }

    protected function getSpamAttribute() {
        $spamInfo = new SpamInfo($this);
        $report = $spamInfo->getReport();

        return $report;
    }

    protected function getFilterQueryBuilder(?Session $session = null) {
        $session = $this->resolveSessionIfNecessary($session);

        if(is_null($session)) {
            return null;
        }

        return Filter::selectRaw('filters.*')
            ->join('auth_sessions', 'filters.created_by_auth_session_id', '=', 'auth_sessions.id')
            ->join('filter_attributes', 'filters.id', '=', 'filter_attributes.filter_id')
            ->where('filters.filter_type', 'phone')
            ->where('auth_sessions.user_id', $session->user_id)
            ->where('filter_attributes.name', 'phone')
            ->where('filter_attributes.value', $this->e164_format);
    }

    protected function getFilterBlock(?Session $session = null) {        
        $session = $this->resolveSessionIfNecessary($session);

        if(is_null($session)) {
            return null;
        }

        if($this->hasOnce("filter_block_{$session->user_id}")) return $this->getOnceValue("filter_block_{$session->user_id}");

        $queryBuilder = $this->getFilterQueryBuilder($session);

        if(is_null($queryBuilder)) {
            $this->setOnce("filter_block_{$session->user_id}", null);
            return null;
        }

        $filter = $queryBuilder->where('filters.rule', 'block')
            ->latest('filters.created_at')
            ->first();

        $this->setOnce("filter_block_{$session->user_id}", $filter);
        return $filter;
    }

    public function isBlacklistedBy(?Session $session = null) {
        $session = $this->resolveSessionIfNecessary($session);

        if(is_null($session)) {
            return false;
        }

        $filter = $this->getFilterBlock($session);

        if(is_null($filter)) {
            return false;
        }

        $value = Cast::getBooleanIfPossible($filter->value);
        return is_bool($value) && $value === true;
    }

    protected function getBlacklistedByAttribute() {
        if($this->hasOnce('blacklisted')) return $this->getOnceValue('blacklisted');

        $blacklisted = $this->isBlacklistedBy();
        $this->setOnce('blacklisted', $blacklisted);

        return $blacklisted;
    }

    public function isWhitelistedBy(?Session $session = null) {
        $session = $this->resolveSessionIfNecessary($session);

        if(is_null($session)) {
            return false;
        }

        $filter = $this->getFilterBlock($session);

        if(is_null($filter)) {
            return false;
        }

        $value = Cast::getBooleanIfPossible($filter->value);
        return is_bool($value) && $value === false;
    }

    protected function getWhitelistedByAttribute() {
        if($this->hasOnce('whitelisted')) return $this->getOnceValue('whitelisted');

        $whitelisted = $this->isWhitelistedBy();
        $this->setOnce('whitelisted', $whitelisted);

        return $whitelisted;
    }
}
