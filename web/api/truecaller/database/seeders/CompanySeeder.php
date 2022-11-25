<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class CompanySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {        
        DB::table('companies')->insert([
            'name' => 'Vivo',
            'legal_name' => 'Vivo S.A',
            'social_id_facebook' => 'vivo_brasil',
            'social_id_instagram' => '@vivo',
            'social_id_twitter' => '@vivo_br',
            'url' => 'https://vivo.com.br',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);       

        DB::table('companies')->insert([
            'name' => 'Banco do Brasil',
            'legal_name' => 'Banco do Brasil S.A.',
            'social_id_facebook' => 'banco_brasil',
            'social_id_instagram' => '@bb',
            'social_id_twitter' => '@bb_br',
            'url' => 'https://bb.com.br',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);   
    }
}
