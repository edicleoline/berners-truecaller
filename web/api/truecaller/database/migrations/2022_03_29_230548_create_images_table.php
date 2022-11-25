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
        Schema::create('images', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('media_id');
            $table->string('alias', 10)->nullable();
            $table->integer('width');
            $table->integer('height');
            $table->timestamps();
            $table->softDeletes();

            $table->unique(['media_id', 'alias']);
            $table->foreign('media_id')->references('id')->on('medias');
        });

        DB::update("ALTER TABLE images AUTO_INCREMENT = 172200221740021;");        
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('images');
    }
};
