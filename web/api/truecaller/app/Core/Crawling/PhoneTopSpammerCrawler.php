<?php

namespace App\Core\Crawling;

use App\Models\Phone\Phone;
use App\Models\Crawling\Crawler as CrawlerModel;
use App\Models\Crawling\CrawlerJob as CrawlerJobModel;
use Exception;
use Illuminate\Support\Facades\Log;
use App\Core\Crawling\CrawlerInterface;
use App\Models\Phone\TopSpammer;
use App\Models\Account\Auth\Session;
use App\Models\Phone\PhoneEntity;
use App\Models\Phone\Report\Category;

class PhoneTopSpammerCrawler implements CrawlerInterface
{
    protected $filename;
    protected $items;

    protected CrawlerModel $crawler;
    protected CrawlerJobModel $crawlerJob;

    protected $loggerChannel;
    protected $loggerStack;

    protected $categories;

    public function __construct($filename, CrawlerModel $crawler)
    {
        $this->filename = $filename;
        $this->items = [];

        $this->crawler = $crawler;

        $this->crawlerJob = new CrawlerJobModel();
        $this->crawlerJob->crawler_id = $crawler->id;
        $this->crawlerJob->filename = $filename;
        $this->crawlerJob->save();
    }

    protected function readJsonFile() {
        $content = file_get_contents($this->filename);
        $json = json_decode($content, true);

        $this->items = $json['data'];
    }

    protected function transformAttribute(string $name, mixed $value, array $item = [], array $options = []) {
        if(!isset($this->crawler->transformers) || !isset($this->crawler->transformers[$name])) {
            return $value;
        }
        
        return $this->crawler->transformers[$name]($value, $item, $options);
    }

    protected function findCategory(string $label) {
        if(!isset($this->categories)) {
            $this->categories = Category::all();
        }

        foreach($this->categories as $category) {
            if($category->label === $label) {
                return $category;
            }
        }

        return null;
    }

    protected function transformCategory(?string $reason) {        
        if(is_null($reason) || empty($reason) || !isset($this->crawler->dictionary['categories'])) {
            return $this->findCategory('other');
        }
                
        foreach($this->crawler->dictionary['categories'] as $key => $label) {
            if(trim(strtolower($key)) === trim(strtolower($reason))) {
                return $this->findCategory($label);
            }
        }
        
        return Category::where('label', 'other')->first();
    }

    protected function getLoggerChannel() {
        if(isset($this->loggerChannel)) {
            return $this->loggerChannel;
        }

        $this->loggerChannel = Log::build([
            'driver' => 'single',
            'path' => storage_path('logs/crawler/phone-top-spammer/job-' . $this->crawlerJob->id . '.log'),
        ]);

        return $this->loggerChannel;
    }

    protected function getLoggerStack() {
        if(isset($this->loggerStack)) {
            return $this->loggerStack;
        }

        $this->loggerStack = Log::stack([$this->getLoggerChannel()]);
        return $this->loggerStack;
    }

    public function importJson() {
        $loggerStack = $this->getLoggerStack();

        try {
            $this->readJsonFile();
        }
        catch(Exception $e) {
            $loggerStack->error($e);
            throw $e;
        }        

        $count = 0;
        foreach($this->items as $index => $item) {
            try {
                $loggerStack->info('Crawling', ['item' => $item]);

                $country_code = $this->transformAttribute('country_code', null, $item);
                $incomingType = $this->transformAttribute('incoming_type', null, $item);

                $phone = Phone::findOrCreate($item['value'], $country_code, true);
                $phone->crawler_job_id = $this->crawlerJob->id;
                $phone->save();
                
                $topSpammer = TopSpammer::firstOrNew([
                    'country_iso2' => $country_code,
                    'phone_id' => $phone->id,
                    'incoming_type' => $incomingType
                ]);

                if(is_null($topSpammer->id)) {
                    $categories = [];
                    if($item['categories']) {
                        foreach($item['categories'] as $key => $value) {
                            $categories[] = $this->transformCategory($value)->id;
                        }
                    }
                    $topSpammer->categories = $categories;                    

                    $topSpammer->phone_e164_format = $phone->e164_format;
                }
                                
                $topSpammer->label = $item['label'];
                $topSpammer->reports_count = $item['reports'];
                $topSpammer->incoming_type = $incomingType;
                $topSpammer->original_crawled = $item;
                $topSpammer->crawler_job_id = $this->crawlerJob->id;                
                $topSpammer->save();

                $phoneEntity = PhoneEntity::selectRaw('phone_entities.*')
                    ->where('phone_entities.phone_id', $phone->id)
                    ->where('phone_entities.is_public', 1)
                    ->whereNotNull('phone_entities.crawler_job_id')
                    ->first();

                if(is_null($phoneEntity)) {
                    $phoneEntity = new PhoneEntity();
                    $phoneEntity->phone_id = $phone->id;
                    $phoneEntity->is_public = true;
                    $phoneEntity->crawler_job_id = $this->crawlerJob->id;  
                    $phoneEntity->name = $item['label'];                  
                    $phoneEntity->save();
                }                
            }
            catch(Exception $e) {
                $loggerStack->error($e);
            }

            $count = $count + 1;
            if($count > 10) break;
        }
    }

    public function import() {
        $this->importJson();
    }
}