<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
use Illuminate\Support\Facades\DB;
use App\Core\Enum\EntityType;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('phone_entities', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('phone_id');
            $table->string('name', 60);
            $table->enum('entity_type', EntityType::getValues())->nullable();
            $table->timestamp('verified_at')->nullable();   
            $table->boolean('is_public')->default(false);    
            $table->unsignedBigInteger('created_by_auth_session_id')->nullable();
            $table->unsignedBigInteger('deleted_by_auth_session_id')->nullable();
            $table->unsignedBigInteger('crawler_job_id')->nullable();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('phone_id')->references('id')->on('phones');
            $table->foreign('created_by_auth_session_id')->references('id')->on('auth_sessions');
            $table->foreign('deleted_by_auth_session_id')->references('id')->on('auth_sessions');
            $table->foreign('crawler_job_id')->references('id')->on('crawler_jobs');
        });

        DB::update("ALTER TABLE phone_entities AUTO_INCREMENT = 1722002210820592;");    
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phone_entities');
    }
};
