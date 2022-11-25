<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class IconSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('icons')->insert([
            'storage_path_id' => 17220022,
            'path' => 'sales.svg',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  
        
        DB::table('icons')->insert([
            'storage_path_id' => 17220022,
            'path' => 'scam.svg',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('icons')->insert([
            'storage_path_id' => 17220022,
            'path' => 'robo_call.svg',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('icons')->insert([
            'storage_path_id' => 17220022,
            'path' => 'market_research.svg',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  
        
        DB::table('icons')->insert([
            'storage_path_id' => 17220022,
            'path' => 'survey_research.svg',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('icons')->insert([
            'storage_path_id' => 17220022,
            'path' => 'insurance.svg',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('icons')->insert([
            'storage_path_id' => 17220022,
            'path' => 'political.svg',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('icons')->insert([
            'storage_path_id' => 17220022,
            'path' => 'public_service.svg',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('icons')->insert([
            'storage_path_id' => 17220022,
            'path' => 'spam_other.svg',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  
    }
}
