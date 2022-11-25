<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;
use Illuminate\Support\Facades\DB;
use App\Core\Incoming\Event\EventType;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('incoming_events', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('incoming_id');
            $table->enum('event_type', EventType::getValues());
            $table->timestamp('fired_at');
            $table->timestamps();

            $table->foreign('incoming_id')->references('id')->on('incomings');
        });
        
        DB::update("ALTER TABLE incoming_events AUTO_INCREMENT = 1722003940091;");
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('incoming_events');
    }
};
