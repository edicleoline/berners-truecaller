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
        Schema::create('storage_paths', function (Blueprint $table) {
            $table->id();
            $table->string('disk_name', 45);
            $table->string('path', 140);
            $table->timestamps();

            $table->unique(['disk_name', 'path']);
        });

        DB::update("ALTER TABLE storage_paths AUTO_INCREMENT = 17220022;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('storage_paths');
    }
};
