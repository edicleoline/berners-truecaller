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
        Schema::create('device_sims', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('device_id');
            $table->string('serial', 90)->nullable();
            $table->string('imsi', 40)->nullable();
            $table->string('mcc', 40)->nullable();
            $table->string('mnc', 40)->nullable();
            $table->string('operator', 140)->nullable();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('device_id')->references('id')->on('devices');
        });

        DB::update("ALTER TABLE device_sims AUTO_INCREMENT = 1722002280729493;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('device_sims');
    }
};
