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
        Schema::create('phone_reports', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('phone_id');
            $table->unsignedBigInteger('phone_report_category_id')->nullable();
            $table->boolean('anonymous_mode')->default(false);
            $table->enum('entity_type', EntityType::getValues())->nullable();
            $table->timestamp('verified_at')->nullable();
            $table->unsignedBigInteger('created_by_auth_session_id')->nullable();
            $table->unsignedBigInteger('deleted_by_auth_session_id')->nullable(); 
            $table->unsignedBigInteger('crawler_job_id')->nullable();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('phone_id')->references('id')->on('phones');
            $table->foreign('created_by_auth_session_id')->references('id')->on('auth_sessions');
            $table->foreign('deleted_by_auth_session_id')->references('id')->on('auth_sessions');
            $table->foreign('crawler_job_id')->references('id')->on('crawler_jobs');

            $table->index(['created_by_auth_session_id', 'phone_id']);
        });

        DB::update("ALTER TABLE phone_reports AUTO_INCREMENT = 172200221540021;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phone_reports');
    }
};
