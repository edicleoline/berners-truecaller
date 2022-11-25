<?php

namespace App\Jobs;

use Illuminate\Bus\Queueable;
use Illuminate\Contracts\Queue\ShouldBeUnique;
use Illuminate\Contracts\Queue\ShouldQueue;
use Illuminate\Foundation\Bus\Dispatchable;
use Illuminate\Queue\InteractsWithQueue;
use Illuminate\Queue\SerializesModels;
use App\Core\Crawling\CrawlerInterface;

class ProcessCrawler implements ShouldQueue
{
    use Dispatchable, InteractsWithQueue, Queueable, SerializesModels;

    // public $timeout = 50400; //20h
    protected $crawler;

    public function __construct(CrawlerInterface $crawler)
    {
        $this->crawler = $crawler;
    }

    public function handle()
    {
        $this->crawler->import();
    }
}
