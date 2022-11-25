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
        Schema::create('phone_companies', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('phone_id');            
            $table->unsignedBigInteger('company_id')->nullable();            
            $table->timestamp('verified_at')->nullable();
            $table->boolean('is_public')->default(false);
            $table->unsignedBigInteger('created_by_auth_session_id');
            $table->unsignedBigInteger('deleted_by_auth_session_id')->nullable();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('phone_id')->references('id')->on('phones');
            $table->foreign('company_id')->references('id')->on('companies');
            $table->foreign('created_by_auth_session_id')->references('id')->on('auth_sessions');
            $table->foreign('deleted_by_auth_session_id')->references('id')->on('auth_sessions');
        });

        DB::update("ALTER TABLE phone_companies AUTO_INCREMENT = 1722002210820309;");    
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phone_companies');
    }
};
