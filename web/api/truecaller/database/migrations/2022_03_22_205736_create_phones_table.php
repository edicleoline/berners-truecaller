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
        Schema::create('phones', function (Blueprint $table) {
          $table->id();          
          $table->unsignedMediumInteger('country_id');
          $table->unsignedBigInteger('carrier_company_id')->nullable();
          $table->string('phone', 16);
          $table->string('e164_format', 20);
          $table->string('raw', 25);
          $table->unsignedBigInteger('crawler_job_id')->nullable();
          $table->boolean('has_parse_error');
          $table->timestamps();

          $table->foreign('country_id')->references('id')->on('countries');
          $table->foreign('carrier_company_id')->references('id')->on('companies');
          $table->foreign('crawler_job_id')->references('id')->on('crawler_jobs');

          $table->index(['e164_format']);
          $table->index(['phone', 'country_id']);
        });

        DB::update("ALTER TABLE phones AUTO_INCREMENT = 1722004730021;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phones');
    }
};
