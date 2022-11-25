<?php

namespace App\Core\Crawling;

use App\Models\Phone\Phone;
use App\Models\Crawling\Crawler as CrawlerModel;
use App\Models\Crawling\CrawlerJob as CrawlerJobModel;
use App\Models\Phone\Report\Category;
use Exception;
use Illuminate\Support\Facades\Log;
use App\Models\Posting\Post;
use App\Core\Facades\Authentication;
use App\Models\Phone\PhonePost;
use App\Models\Account\Auth\Session;
use App\Core\Crawling\CrawlerInterface;

class PhoneReportCrawler implements CrawlerInterface
{
    protected $filename;
    protected $items;

    protected CrawlerModel $crawler;
    protected CrawlerJobModel $crawlerJob;

    // protected $loggerChannel;
    // protected $loggerStack;

    protected $categories;

    public function __construct($filename, CrawlerModel $crawler)
    {
        $this->filename = $filename;
        $this->items = [];

        // $this->loggerChannel = Log::build([
        //     'driver' => 'single',
        //     'path' => storage_path('logs/crawler.log'),
        // ]);

        // $this->loggerStack = Log::stack([$this->loggerChannel]);

        $this->crawler = $crawler;

        $this->crawlerJob = CrawlerJobModel::firstOrCreate([
            'crawler_id' => $crawler->id,
            'filename' => $filename
        ]);
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

    protected function readCsvFile() {
        if (($open = fopen($this->filename, "r")) !== FALSE) {
            while (($data = fgetcsv($open, 5000, ",", '"')) !== FALSE) {
                $this->items[] = $data;
            }

            fclose($open);
        }
    }

    protected function transformAttribute(string $name, mixed $value, array $item = [], array $options = []) {
        if(!isset($this->crawler->transformers) || !isset($this->crawler->transformers[$name])) {
            return $value;
        }
        
        return $this->crawler->transformers[$name]($value, $item, $options);
    }

    public function importCsv() {
        $loggerChannel = Log::build([
            'driver' => 'single',
            'path' => storage_path('logs/crawler.log'),
        ]);

        $loggerStack = Log::stack([$loggerChannel]);

        $session = Session::where('user_id', '1722001690041')->first();

        $this->readCsvFile();

        $count = 0;
        foreach($this->items as $index => $item) {
            try {
                $loggerStack->info('Crawling', ['item' => $item]);

                $number = $this->transformAttribute('number', trim($item[0]), $item);
            
                $category = $this->transformCategory(trim($item[1]));
                $category = $this->transformAttribute('category', $category, $item);
    
                $comment = $this->transformAttribute('comment', trim($item[2]), $item);
                $comment = str_replace('\"', '"', $comment);
    
                $created_at = $this->transformAttribute('created_at', trim($item[3]), $item);
    
                $country_code = $this->transformAttribute('country_code', null, $item);
    
                $phone = Phone::findOrCreate($number, $country_code, true);
    
                $phone->crawler_job_id = $this->crawlerJob->id;
                $phone->save();
    
                $report = $phone->addReport($category, null, true, $session);
                
                if(!is_null($created_at)) {
                    $report->created_at = $created_at;                
                }
    
                $report->crawler_job_id = $this->crawlerJob->id;
                $report->save();

                if(!empty(trim($comment))) {
                    $post = new Post();
                    $post->text = $comment;
                    $post->anonymous_mode = true;
                    $post->created_by_auth_session_id = $session->id;
                    $post->save();

                    $phonePost = new PhonePost;
                    $phonePost->phone_id = $phone->id;
                    $phonePost->post_id = $post->id;
                    $phonePost->phone_report_id = $report->id;   
                    $phonePost->save();
                }
                
            }
            catch(Exception $e) {
                $loggerStack->error($e);
                // throw $e;
            }

            $count = $count + 1;
            if($count > 10) break;
        }
    }

    public function import() {
        $this->importCsv();
    }
}