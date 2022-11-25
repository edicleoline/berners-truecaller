<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
use Illuminate\Support\Facades\DB;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('device_installations', function (Blueprint $table) {
            $table->id();
            $table->uuid('uuid');
            $table->unsignedBigInteger('app_id');
            $table->unsignedBigInteger('device_id');
            $table->string('lang', 2);
            $table->unsignedMediumInteger('country_id');
            $table->string('region', 40)->nullable();
            $table->timestamps();

            $table->foreign('app_id')->references('id')->on('apps');
            $table->foreign('device_id')->references('id')->on('devices');
            $table->foreign('country_id')->references('id')->on('countries');
        });

        DB::update("ALTER TABLE device_installations AUTO_INCREMENT = 1722002280729493;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('device_installations');
    }
};
