<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class EmailSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('emails')->insert([
            // 'created_by_auth_session_id' => 172200221970068,
            'email' => 'joao.silva@gmail.com',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);

        DB::table('emails')->insert([
            // 'created_by_auth_session_id' => 172200221970069,
            'email' => 'joao.silva@google.com',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);


        DB::table('emails')->insert([
            // 'created_by_auth_session_id' => 172200221970070,
            'email' => 'maria.santos@gmail.com',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);
    }
}
