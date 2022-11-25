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
        Schema::create('videos', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('media_id');
            $table->string('alias', 10);
            $table->string('filename');
            $table->string('content_type', 45);
            $table->integer('width')->nullable();
            $table->integer('height')->nullable();
            $table->integer('kilo_bitrate')->nullable();
            $table->timestamps();
            $table->softDeletes();

            $table->unique(['media_id', 'alias', 'content_type']);
            $table->foreign('media_id')->references('id')->on('medias');
        });

        DB::update("ALTER TABLE videos AUTO_INCREMENT = 172200221540021;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('videos');
    }
};
