<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
use Illuminate\Support\Facades\DB;
use App\Core\Incoming\IncomingType;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('top_phone_spammers', function (Blueprint $table) {
            $table->id();
            $table->char('country_iso2');
            $table->unsignedBigInteger('phone_id');
            $table->string('phone_e164_format', 18);
            $table->string('label', 190);
            $table->integer('reports_count');
            $table->json('categories')->nullable();
            $table->enum('incoming_type', IncomingType::getValues())->nullable();
            $table->json('original_crawled')->nullable();
            $table->unsignedBigInteger('crawler_job_id')->nullable();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('phone_id')->references('id')->on('phones');
            $table->foreign('crawler_job_id')->references('id')->on('crawler_jobs');
        });

        DB::update("ALTER TABLE top_phone_spammers AUTO_INCREMENT = 1722002280420582;");   
    }    

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('top_phone_spammers');
    }
};
