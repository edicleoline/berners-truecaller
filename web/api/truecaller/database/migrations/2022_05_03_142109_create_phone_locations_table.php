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
        Schema::create('phone_locations', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('phone_id');
            $table->unsignedBigInteger('location_id');
            $table->timestamp('verified_at')->nullable();   
            $table->boolean('is_public')->default(false);   
            $table->unsignedBigInteger('created_by_auth_session_id')->nullable();
            $table->unsignedBigInteger('deleted_by_auth_session_id')->nullable();                  
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('phone_id')->references('id')->on('phones');
            $table->foreign('location_id')->references('id')->on('locations');
            $table->foreign('created_by_auth_session_id')->references('id')->on('auth_sessions');
            $table->foreign('deleted_by_auth_session_id')->references('id')->on('auth_sessions');
        });

        DB::update("ALTER TABLE phone_locations AUTO_INCREMENT = 1722002210310842;");        
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phone_locations');
    }
};
