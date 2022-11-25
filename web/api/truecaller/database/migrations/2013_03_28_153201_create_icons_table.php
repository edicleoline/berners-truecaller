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
        Schema::create('icons', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('storage_path_id')->nullable();
            $table->string('path', 240);
            $table->timestamps();

            $table->foreign('storage_path_id')->references('id')->on('storage_paths');
            $table->unique(['storage_path_id', 'path']);
        });

        DB::update("ALTER TABLE icons AUTO_INCREMENT = 17220149;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('icons');
    }
};
