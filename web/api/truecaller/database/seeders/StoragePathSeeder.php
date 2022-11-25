<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class StoragePathSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('storage_paths')->insert([
            'disk_name' => 's3',
            'path' => 'icon',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  
        
        DB::table('storage_paths')->insert([
            'disk_name' => 's3',
            'path' => 'image',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);  
    }
}
