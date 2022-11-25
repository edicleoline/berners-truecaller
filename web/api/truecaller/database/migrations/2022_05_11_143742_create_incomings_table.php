<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
use App\Core\Incoming\Direction;
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
        Schema::create('incomings', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('created_by_auth_session_id');
            $table->unsignedBigInteger('source_phone_id')->nullable();
            $table->unsignedBigInteger('target_phone_id')->nullable();
            $table->enum('direction', Direction::getValues());
            $table->string('sms_text', 190)->nullable();
            $table->timestamps();

            $table->foreign('created_by_auth_session_id')->references('id')->on('auth_sessions');
            $table->foreign('source_phone_id')->references('id')->on('phones');
            $table->foreign('target_phone_id')->references('id')->on('phones');
        });

        DB::update("ALTER TABLE incomings AUTO_INCREMENT = 1722004970081;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('incomings');
    }
};
