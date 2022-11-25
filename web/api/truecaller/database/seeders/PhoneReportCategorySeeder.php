<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class PhoneReportCategorySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('phone_report_categories')->insert([
            'label' => 'sales',
            'icon_id' => 17220149,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);

        DB::table('phone_report_categories')->insert([
            'label' => 'scam',
            'icon_id' => 17220150,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);

        DB::table('phone_report_categories')->insert([
            'label' => 'robo_call',
            'icon_id' => 17220151,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);
        

        DB::table('phone_report_categories')->insert([
            'label' => 'market_research',
            'icon_id' => 17220152,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('phone_report_categories')->insert([
            'label' => 'survey_research',
            'icon_id' => 17220153,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('phone_report_categories')->insert([
            'label' => 'insurance',
            'icon_id' => 17220154,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('phone_report_categories')->insert([
            'label' => 'political',
            'icon_id' => 17220155,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  

        DB::table('phone_report_categories')->insert([
            'label' => 'public_service',
            'icon_id' => 17220156,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  
        
        DB::table('phone_report_categories')->insert([
            'label' => 'other',
            'icon_id' => 17220157,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  
    }
}
