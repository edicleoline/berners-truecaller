<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class PhoneSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('phones')->insert([
            // 'created_by_auth_session_id' => 172200221970068,
            'country_id' => 31,
            'phone' => '11998456734',
            'e164_format' => '+5511998456734',
            'raw' => '+5511998456734',            
            'carrier_company_id' => 1722004520052,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);

        DB::table('phones')->insert([
            // 'created_by_auth_session_id' => 172200221970068,
            'country_id' => 31,
            'phone' => '19987350729',
            'e164_format' => '+5519987350729',
            'raw' => '(19) 98735-0729',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);


        DB::table('phones')->insert([
            // 'created_by_auth_session_id' => 172200221970069,
            'country_id' => 31,
            'phone' => '21945697712',
            'e164_format' => '+5521945697712',
            'raw' => '21 94569 7712',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);
    }
}
