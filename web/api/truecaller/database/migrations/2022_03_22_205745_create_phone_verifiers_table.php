<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
use Illuminate\Support\Facades\DB;
use App\Core\Enum\PhoneVerifierMethod;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('phone_verifiers', function (Blueprint $table) {
          $table->id();
          $table->uuid('uuid');
          $table->unsignedBigInteger('phone_id');
          $table->enum('method', PhoneVerifierMethod::getValues());
          $table->string('token', 45);
          $table->timestamp('verified_at')->nullable();
          $table->integer('ttl');
          $table->timestamp('expires_at');
        //   $table->unsignedBigInteger('created_by_auth_session_id')->nullable();
          $table->unsignedBigInteger('device_installation_id');
          $table->timestamps();

          $table->foreign('phone_id')->references('id')->on('phones');
        //   $table->foreign('created_by_auth_session_id')->references('id')->on('auth_sessions');
          $table->foreign('device_installation_id')->references('id')->on('device_installations');
        });

        DB::update("ALTER TABLE phone_verifiers AUTO_INCREMENT = 1722004280021;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phone_verifiers');
    }
};
