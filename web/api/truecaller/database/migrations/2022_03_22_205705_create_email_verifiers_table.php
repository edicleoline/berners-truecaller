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
        Schema::create('email_verifiers', function (Blueprint $table) {
          $table->id();
          $table->uuid('uuid');
          $table->unsignedBigInteger('email_id');
          $table->string('token', 45);
          $table->timestamp('verified_at')->nullable();
          $table->integer('ttl');
          $table->timestamp('expires_at');
          $table->unsignedBigInteger('device_installation_id');
          $table->timestamps();

          $table->foreign('email_id')->references('id')->on('emails');
          $table->foreign('device_installation_id')->references('id')->on('device_installations');
        });

        DB::update("ALTER TABLE email_verifiers AUTO_INCREMENT = 1722004860021;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('email_verifiers');
    }
};
