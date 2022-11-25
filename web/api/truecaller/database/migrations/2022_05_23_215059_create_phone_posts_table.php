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
        Schema::create('phone_posts', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('phone_id');
            $table->unsignedBigInteger('post_id');
            $table->unsignedBigInteger('phone_report_id')->nullable();
            $table->timestamps();

            $table->foreign('phone_id')->references('id')->on('phones');
            $table->foreign('post_id')->references('id')->on('posts');
            $table->foreign('phone_report_id')->references('id')->on('phone_reports');
        });

        DB::update("ALTER TABLE phone_posts AUTO_INCREMENT = 1722002280720374;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phone_posts');
    }
};
