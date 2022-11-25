<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
use App\Core\Uploading\UploadType;
use App\Core\Uploading\UploadError;
use App\Core\Uploading\UploadState;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('uploads', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('author_id')->nullable();
            $table->string('client_original_name')->nullable();
            $table->unsignedBigInteger('base_path_id');
            $table->string('path')->nullable();
            $table->string('filename')->nullable();
            $table->unsignedBigInteger('total_bytes');
            $table->string('mime_type');
            $table->unsignedInteger('expires_after_secs')->nullable();
            $table->enum('upload_type', UploadType::getValues())->nullable();
            $table->enum('upload_state', UploadState::getValues())->nullable();
            $table->enum('upload_error', UploadError::getValues())->nullable();            
            $table->tinyInteger('progress_percent')->nullable();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('author_id')->references('id')->on('users');
            $table->foreign('base_path_id')->references('id')->on('storage_paths');
        });

        DB::update("ALTER TABLE uploads AUTO_INCREMENT = 172200001680041;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('uploads');
    }
};
