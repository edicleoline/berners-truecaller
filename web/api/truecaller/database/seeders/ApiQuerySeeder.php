<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;
use App\Models\Api\Resource;

class ApiQuerySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('api_queries')->insert([
            'api_resource_id' => Resource::findByNameAndVersion('incoming', '1')->id,
            'fields' => 'id,source,source.id,source.phone,source.e164_format,sentinel,sentinel.*,sentinel.decision.*',
            'created_at' =>  Carbon::now(),
            'updated_at' =>  Carbon::now()
        ]);       
        
    }
}
