<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use Carbon\Carbon;

class UserPhoneSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('user_phones')->insert([
            'created_by_auth_session_id' => 172200221970068,            
            'phone_id' => 1722004730021,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);            
    }
}
