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
        Schema::create('companies', function (Blueprint $table) {
            $table->id();
            $table->string('name', 60);
            $table->string('legal_name', 80)->nullable();
            $table->unsignedBigInteger('profile_image_id')->nullable();
            $table->string('social_id_facebook', 30)->nullable();
            $table->string('social_id_twitter', 30)->nullable();
            $table->string('social_id_instagram', 30)->nullable();
            $table->string('url', 240)->nullable();
            $table->timestamp('verified_at')->nullable();
            $table->timestamps();
            $table->softDeletes();
        });

        DB::update("ALTER TABLE companies AUTO_INCREMENT = 1722004520051;");

        DB::statement('ALTER TABLE companies ADD FULLTEXT companies_search_name(name)');
        DB::statement('ALTER TABLE companies ADD FULLTEXT companies_search_legal_name(legal_name)');
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('companies');
    }
};
