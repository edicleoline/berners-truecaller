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
        Schema::create('crawler_jobs', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('crawler_id');
            $table->string('filename', 350);
            $table->timestamps();

            $table->foreign('crawler_id')->references('id')->on('crawlers');
        });

        DB::update("ALTER TABLE crawler_jobs AUTO_INCREMENT = 172200276080032;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('crawler_jobs');
    }
};
