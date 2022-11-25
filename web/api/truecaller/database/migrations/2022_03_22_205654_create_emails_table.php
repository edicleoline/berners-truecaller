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
        Schema::create('emails', function (Blueprint $table) {
          $table->id();
          $table->string('email');
        //   $table->unsignedBigInteger('created_by_auth_session_id');
        //   $table->unsignedBigInteger('deleted_by_auth_session_id')->nullable(); 
          $table->timestamps();
        //   $table->softDeletes();

        //   $table->foreign('created_by_auth_session_id')->references('id')->on('auth_sessions');
        //   $table->foreign('deleted_by_auth_session_id')->references('id')->on('auth_sessions');
        });

        DB::update("ALTER TABLE emails AUTO_INCREMENT = 1722001760041;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('emails');
    }
};
