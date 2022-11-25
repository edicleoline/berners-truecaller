<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;
use App\Models\Device\Installation;
use App\Models\App\App;
use App\Models\Device\Device;

class AuthSessionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $app = App::firstOrCreate([
            'build_version' => 7,
            'major_version' => 11,
            'minor_version' => 22,
            'store' => 'APPLE_STORE',
        ]);

        $device = new Device();
        $device->device_id = null;
        $device->lang = 'en';
        $device->manufacturer = 'apple';
        $device->model = 'iPhone 6 Plus';
        $device->os_name = 'ios';
        $device->os_version = '13.3.5';
        $device->save();

        $installation = new Installation();
        $installation->app_id = $app->id;
        $installation->device_id = $device->id;
        $installation->lang = 'en';
        $installation->country_id = 31;
        $installation->region = 'region-br';
        $installation->save();

        DB::table('auth_sessions')->insert([
            'user_id' => 1722001690041,
            'token' => 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vMTI3LjAuMC4xOjgwMDAvYXBpL2FjY291bnQvbG9naW4iLCJpYXQiOjE2NTEwODU5ODksImV4cCI6MTY4MjYyMTk4OSwibmJmIjoxNjUxMDg1OTg5LCJqdGkiOiJaUVFYbU52Vk1wYXFRaUFFIiwic3ViIjoiMTcyMjAwMTY5MDA0MSIsInBydiI6ImY2NzYzOGEzMjZlMGE1OGU5MzY3NDZhZWZkM2RlNWM1MjAzYWMyOTEifQ.ti5tzyQnJO0CtDYVylRsqXtaQT_tA5MgOaKJPlLMB2k',
            'token_type' => 'bearer',
            'ttl' => 31536000,            
            'device_installation_id' => $installation->id,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);    
        
        DB::table('auth_sessions')->insert([
            'user_id' => 1722001690041,
            'token' => '??',
            'token_type' => 'bearer',
            'ttl' => 31536000,            
            'device_installation_id' => $installation->id,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);
        
        DB::table('auth_sessions')->insert([
            'user_id' => 1722001690042,
            'token' => '?',
            'token_type' => 'bearer',
            'ttl' => 31536000,     
            'device_installation_id' => $installation->id,       
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);   
    }
}
