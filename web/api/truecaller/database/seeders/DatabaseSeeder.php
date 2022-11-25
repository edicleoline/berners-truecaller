<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
      $this->call([
          StoragePathSeeder::class,
          IconSeeder::class,
          LocationSeeder::class,
          ApiResourceSeeder::class,
          ApiQuerySeeder::class,
          UserGroupSeeder::class,          
          UserSeeder::class,
          AuthSessionSeeder::class,
          TagSeeder::class,
          CompanySeeder::class,          
          EmailSeeder::class,
          EmailVerifierSeeder::class,
          PhoneReportCategorySeeder::class,
          PhoneSeeder::class,
          PhoneCompanySeeder::class,
          UserPhoneSeeder::class
      ]);
    }
}
