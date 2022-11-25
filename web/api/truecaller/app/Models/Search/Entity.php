<?php

namespace App\Models\Search;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Account\User;
use App\Models\Company\Company;
use App\Models\Phone\Phone;
use App\Models\Place\Country;
use Illuminate\Database\Eloquent\SoftDeletes;
use Illuminate\Support\Facades\DB;
use Illuminate\Pagination\Cursor;
use App\Core\Enum\Visibility;
use App\Core\Helper\StringUtil;
use Illuminate\Support\Str;
use Propaganistas\LaravelPhone\PhoneNumber;
use Propaganistas\LaravelPhone\Exceptions\NumberParseException;
use Exception;
use App\Core\Phone\Phone as PhoneCore;
use App\Core\Api\CursorPagination;

class Entity
{
    public static function search($query, ?Country $country, $maxResults = 1, $paginationToken = null) {
        $users = DB::table('users')
            ->select(DB::raw("'user' as type"), 'users.id', 'users.name', 'users.profile_image_id')
            ->where('users.name', 'like', "%{$query}%")
            ->where('users.visibility', Visibility::_Public);        
 
        $companies = DB::table('companies')
            ->select(DB::raw("'company' as type"), 'companies.id','companies.name', 'companies.profile_image_id')
            ->where('companies.name', 'like', "%{$query}%");

        $phones = DB::table('phones')
            ->select(DB::raw("'phone' as type"), 'phones.id', 'phones.phone as name', 'phones.country_id');

        $queryBuilder = null;

        if(PhoneCore::isPossiblePhone($query)) {
            try {
                $queryBuilder = Phone::searchBuilder($query, $country)
                    ->select(DB::raw("'phone' as type"), 'phones.id');
            }
            catch(Exception) {
                return [];
            }
        }
        else {
            $queryBuilder = $users
                ->union($companies)
                ->orderBy('name', 'asc');
        }
        
        $pagination = CursorPagination::paginate($queryBuilder, $maxResults, $paginationToken);

        $items = $pagination->items();

        foreach ($items as $key => &$value) {            
            if($value->type === 'user') {
                static::transformUser($value);
            }
            else if($value->type === 'company') {
                static::transformCompany($value);
            }
            else if($value->type === 'phone') {
                static::transformPhone($value);
            }
        }

        return $pagination;
    }    

    protected static function transformPhone(&$data) {
        $phone = Phone::find($data->id);
        $phone->makeVisibleBasic(['carrier', 'blocked', 'never_block', 'location']);
        $phone->makeVisible(['entity']);

        unset($data->id);

        $data->entity = $phone;
    }

    protected static function transformUser(&$data) {
        $user = User::find($data->id);

        if(is_null($user)) {
            return false;
        }

        $data->default_profile_image = $user->default_profile_image;
        $data->profile_image_url = $user->profile_image_url;
        $data->verified = $user->verified;

        // if(!is_null($phone)) {
        //     $data->phone = (object)[
        //         'verified' => $phone->verified,
        //         'entity' => $phone
        //     ];
        // }        

        return true;
    }

    protected static function transformCompany(&$data) {
        $company = Company::find($data->id);
        $company->makeVisibleBasic();

        if(is_null($company)) {
            return false;
        }        

        $data->default_profile_image = $company->default_profile_image;
        $data->profile_image_url = $company->profile_image_url;
        $data->verified = $company->verified;

        // $phone = $company->verifiedPhone();
        // $phone->makeVisibleBasic();

        // if(!is_null($phone)) {
        //     $data->phone = (object)[
        //         'verified' => true,
        //         'entity' => $phone
        //     ];
        // }

        return true;
    }
}
