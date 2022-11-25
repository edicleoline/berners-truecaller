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
        Schema::create('phone_report_categories', function (Blueprint $table) {
            $table->id();
            $table->string('label');
            $table->unsignedBigInteger('icon_id')->nullable();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('icon_id')->references('id')->on('icons');
        });

        DB::update("ALTER TABLE phone_report_categories AUTO_INCREMENT = 172200221010005;");

        Schema::table('phone_reports', function (Blueprint $table) {            
            $table->foreign('phone_report_category_id')->references('id')->on('phone_report_categories');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::table('phone_reports', function (Blueprint $table) {
            $table->dropForeign('phone_reports_phone_report_category_id_foreign');
        });

        Schema::dropIfExists('phone_report_categories');
    }
};
