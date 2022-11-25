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
        Schema::create('searches', function (Blueprint $table) {
            $table->id();
            $table->string("query");
            $table->unsignedBigInteger('created_by_auth_session_id');
            $table->timestamps();

            $table->foreign('created_by_auth_session_id')->references('id')->on('auth_sessions');
        });

        DB::update("ALTER TABLE searches AUTO_INCREMENT = 1722002210840352;"); 
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('searches');
    }
};
