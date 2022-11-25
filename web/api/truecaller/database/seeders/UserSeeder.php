<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use App\Models\Place\Location;
use App\Models\Company\Company;
use App\Models\Social\SocialMedia;

use App\Core\Person\Gender;
use Carbon\Carbon;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $location = Location::firstOrCreate([
            'country_id' => 31,
            'state_id' => 2021,
            'city_id' => 10569
        ]);

        $company = Company::firstOrCreate([
            'name' => 'Berners Software',
            'legal_name' => 'Berners Software LTDA'
        ]);

        $id = DB::table('users')->insertGetId([
            'name' => 'João Silva',
            'gender' => Gender::Male(),
            'birthday' => '1985-10-28',
            'location_id' => $location->id,
            'lang' => 'en',
            'bio' => 'Something writing here',
            'job_title' => 'CEO',
            'job_company_id' => $company->id,
            'social_id_facebook' => 'berners_software',
            'social_id_instagram' => '@berners',
            'social_id_twitter' => '@berners_brasil',
            'url' => 'https://berners.com.br',
            'user_group_id' => 1722002547,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);

        $location = Location::firstOrCreate([
            'country_id' => 31,
            'state_id' => null,
            'city_id' => null
        ]);

        DB::table('users')->insert([
            'name' => 'Maria Santos',
            'gender' => Gender::Female(),
            'birthday' => '1984-09-27',
            'location_id' => $location->id,
            'lang' => 'en',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);

        DB::table('users')->insert([
            'name' => 'José Farias',
            'gender' => Gender::Male(),
            'birthday' => '1964-01-26',
            'location_id' => $location->id,
            'lang' => 'en',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);

        DB::table('users')->insert([
            'name' => 'Francisco Tavares',
            'gender' => Gender::Male(),
            'birthday' => '1954-09-27',
            'location_id' => $location->id,
            'lang' => 'en',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);

        DB::table('users')->insert([
            'name' => 'Alexandre de Moraes',
            'gender' => Gender::Male(),
            'birthday' => '1974-04-25',
            'location_id' => $location->id,
            'lang' => 'en',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);
    }
}
