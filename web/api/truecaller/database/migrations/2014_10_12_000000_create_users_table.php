<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
use App\Core\Person\Gender;
use App\Core\Enum\Visibility;
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
        Schema::create('users', function (Blueprint $table) {
            $table->id();
            $table->string('name')->nullable();
            $table->date('birthday')->nullable();
            $table->enum('gender', Gender::getValues())->nullable();
            $table->unsignedBigInteger('location_id');
            $table->string('lang', 2)->nullable();
            $table->unsignedBigInteger('profile_image_id')->nullable();
            $table->enum('visibility', Visibility::getValues())->default(Visibility::_Public);
            $table->string('bio', 40)->nullable();
            $table->string('job_title', 80)->nullable();
            $table->unsignedBigInteger('job_company_id')->nullable();
            $table->string('social_id_facebook', 30)->nullable();
            $table->string('social_id_twitter', 30)->nullable();
            $table->string('social_id_instagram', 30)->nullable();
            $table->string('url', 240)->nullable();
            $table->timestamp('verified_at')->nullable();
            $table->unsignedBigInteger('user_group_id')->nullable();
            $table->string('password')->nullable();
            $table->rememberToken();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('location_id')->references('id')->on('locations');
            $table->foreign('job_company_id')->references('id')->on('companies');
        });

        DB::update("ALTER TABLE users AUTO_INCREMENT = 1722001690041;");

        // DB::statement('ALTER TABLE users ADD FULLTEXT users_search(name)');
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('users');
    }
};
