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
        Schema::create('devices', function (Blueprint $table) {
            $table->id();
            $table->string('device_id', 140)->nullable();
            $table->string('lang', 2)->nullable();
            $table->string('manufacturer', 140)->nullable();
            $table->string('model', 90)->nullable();
            $table->string('os_name', 140);
            $table->string('os_version', 10)->nullable();
            $table->timestamps();
        });

        DB::update("ALTER TABLE devices AUTO_INCREMENT = 1722002280729493;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('devices');
    }
};
