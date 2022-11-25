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
        Schema::create('apps', function (Blueprint $table) {
            $table->id();
            $table->tinyInteger('build_version');
            $table->tinyInteger('major_version');
            $table->tinyInteger('minor_version');
            $table->string('store', 40);
            $table->timestamps();

            $table->unique(['build_version', 'major_version', 'minor_version', 'store']);
        });

        DB::update("ALTER TABLE apps AUTO_INCREMENT = 1722002280729493;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('apps');
    }
};
