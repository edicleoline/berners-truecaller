<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        // Schema::create('countries', function (Blueprint $table) {
        //   $table->id();
        //   $table->string('name');
        //   $table->string('iso_code_2', 2);
        //   $table->string('iso_code_3', 3);
        //   $table->text('address_format')->nullable();
        //   $table->integer('dialling_code');
        //   $table->timestamps();
        //   $table->softDeletes();
        // });

        // DB::unprepared(File::get(dirname(__FILE__) . '/../dumps/countries.sql'));


        
        // DB::unprepared(File::get(dirname(__FILE__) . '/../dumps/countries-states-cities-database/sql/countries.sql'));
        // DB::unprepared(File::get(dirname(__FILE__) . '/../dumps/countries-states-cities-database/sql/states.sql'));
        // DB::unprepared(File::get(dirname(__FILE__) . '/../dumps/countries-states-cities-database/sql/cities.sql'));
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        // Schema::dropIfExists('cities');
        // Schema::dropIfExists('states');
        // Schema::dropIfExists('countries');            
    }
};
