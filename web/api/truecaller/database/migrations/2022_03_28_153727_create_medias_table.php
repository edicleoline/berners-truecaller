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
        Schema::create('medias', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('upload_id');
            $table->tinyInteger('category');
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('upload_id')->references('id')->on('uploads');
        });

        DB::update("ALTER TABLE medias AUTO_INCREMENT = 1722056015402319206;");

        Schema::table('users', function (Blueprint $table) {            
            $table->foreign('profile_image_id')->references('id')->on('medias');
        });

        Schema::table('companies', function (Blueprint $table) {            
            $table->foreign('profile_image_id')->references('id')->on('medias');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::table('users', function (Blueprint $table) {
            $table->dropForeign('users_profile_image_id_foreign');
        });

        Schema::table('companies', function (Blueprint $table) {
            $table->dropForeign('companies_profile_image_id_foreign');
        });

        Schema::dropIfExists('medias');
    }
};
