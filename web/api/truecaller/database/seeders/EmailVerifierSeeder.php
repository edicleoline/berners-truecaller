<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class EmailVerifierSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // DB::table('email_verifiers')->insert([
        //     'email_id' => 1722001760041,
        //     'token' => '1234',
        //     'expires_at' =>  Carbon::now()->addSecond(60 * 60 * 24),
        //     'created_by_auth_session_id' => 172200221970068,
        //     'verified_at' => Carbon::now(),
        //     'created_at' =>  Carbon::now(),
        //     'updated_at' =>  Carbon::now()
        // ]);
    }
}
