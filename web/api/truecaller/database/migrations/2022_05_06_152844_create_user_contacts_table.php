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
        Schema::create('user_contacts', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('phone_id');
            $table->unsignedBigInteger('created_by_auth_session_id');
            $table->unsignedBigInteger('deleted_by_auth_session_id')->nullable(); 
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('phone_id')->references('id')->on('phones');
            $table->foreign('created_by_auth_session_id')->references('id')->on('auth_sessions');
            $table->foreign('deleted_by_auth_session_id')->references('id')->on('auth_sessions');
        });

        DB::update("ALTER TABLE user_contacts AUTO_INCREMENT = 1722002585340056;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('user_contacts');
    }
};
