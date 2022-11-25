<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class PhoneCompanySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('phone_companies')->insert([
            'phone_id' => 1722004730021,
            'company_id' => 1722004520053,
            'created_by_auth_session_id' => 172200221970068,
            'is_public' => true,
            'verified_at' =>  Carbon::now(),
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);       
    }
}
