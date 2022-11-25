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
        Schema::create('tags', function (Blueprint $table) {
            $table->id();
            $table->string('label');
            $table->unsignedBigInteger('parent_tag_id')->nullable();
            $table->unsignedBigInteger('icon_id')->nullable();
            $table->float('ordering')->default(0);
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('icon_id')->references('id')->on('icons');
            $table->foreign('parent_tag_id')->references('id')->on('tags');
        });

        DB::update("ALTER TABLE tags AUTO_INCREMENT = 172200221020049;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('tags');
    }
};
