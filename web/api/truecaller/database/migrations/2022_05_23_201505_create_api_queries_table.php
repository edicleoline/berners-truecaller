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
        Schema::create('api_queries', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('api_resource_id');
            $table->string('fields', 400);
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('api_resource_id')->references('id')->on('api_resources');
        });

        DB::update("ALTER TABLE api_queries AUTO_INCREMENT = 1722002310940652;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('api_queries');
    }
};
