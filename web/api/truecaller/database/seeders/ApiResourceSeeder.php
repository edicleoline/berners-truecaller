<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class ApiResourceSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('api_resources')->insert([
            'name' => 'incoming',
            'uri' => 'v1/incomings',
            'version' => '1',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);        
        
    }
}
