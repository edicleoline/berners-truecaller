<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class TagSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        /*education*/
        $id = DB::table('tags')->insertGetId([
            'label' => 'education',
            'ordering' => 100,
            'icon_id' => 17220153,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);      

        DB::table('tags')->insert([
            'label' => 'courses',
            'ordering' => 100.5,
            'parent_tag_id' => $id,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);      

        DB::table('tags')->insert([
            'label' => 'university',
            'ordering' => 100.6,
            'parent_tag_id' => $id,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);      
        
     
        /*finance*/
        $id = DB::table('tags')->insertGetId([
            'label' => 'finance_insurance',
            'ordering' => 150,
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]); 

        DB::table('tags')->insert([
            'label' => 'bank',
            'ordering' => 150.5,
            'parent_tag_id' => $id,            
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]); 
    }
}
