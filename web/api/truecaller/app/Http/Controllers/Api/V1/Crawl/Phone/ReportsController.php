<?php

namespace App\Http\Controllers\Api\V1\Crawl\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Carbon\Carbon;
use Carbon\Exceptions\InvalidFormatException;
use App\Models\Place\Country;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use App\Exceptions\ObjectNotFoundException;
use App\Models\Crawling\Crawler as CrawlerModel;
use App\Core\Crawling\PhoneReportCrawler;
use App\Jobs\ProcessCrawler;

class ReportsController extends Controller
{  
    public function telguarder(Request $request)
    {        
        $this->validateAdminAuthorization();

        $request->validate([
            'filename' => 'required',
            'country_code' => 'required'
        ]);

        $country = null;
        try {
            $country = Country::findOrFailByIsoCode2($request->country_code);
        }
        catch (ModelNotFoundException $exception) {
            throw ObjectNotFoundException::withQueryParam(['country_code' => $request->country_code]);
        }

        // $filename = "/home/berners/Documents/dev/web/truecaller/crawler/telguarder/crawled/reports_2022-05-14.csv";

        $crawlerModel = CrawlerModel::firstOrCreate([
            'name' => 'telguarder_br',
            'url' => 'https://www.telguarder.com/br'
        ]);

        $crawlerModel->dictionary = [
            'categories' => [
                'Golpista' => 'scam',
                'Outro' => 'other',
                'Televendedor' => 'sales',
                'Pesquisa De Mercado' => 'market_research',
                'PesquisadordeOpinião' => 'survey_research',
                'Seguro' => 'insurance'
            ]
        ];

        $crawlerModel->transformers = [
            'created_at' => function($value, $item, $options) {
                try {
                    return Carbon::createFromFormat('Y.m.d H:i:s', $value . ':' . rand(10, 59));
                }
                catch(InvalidFormatException $e) {

                }  

                return null;
            },
            'country_code' => function($value, $item, $options) use ($country) {
                return $country->iso2;
            }
        ];

        $crawler = new PhoneReportCrawler($request->filename, $crawlerModel);

        $crawler->importCsv();
        // ProcessCrawler::dispatch($crawler);
    }  

}
