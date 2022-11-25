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
        Schema::create('api_resources', function (Blueprint $table) {
            $table->id();
            $table->string('name', 40);
            $table->string('uri', 140);
            $table->string('version', 10);
            $table->timestamps();
            $table->softDeletes();
        });

        DB::update("ALTER TABLE api_resources AUTO_INCREMENT = 1722002310940652;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('api_resources');
    }
};
