<?php

namespace App\Http\Controllers\Api\V1\Crawl\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Crawling\Crawler as CrawlerModel;
use App\Core\Crawling\PhoneTopSpammerCrawler;
use App\Jobs\ProcessCrawler;
use App\Core\Incoming\IncomingType;
use App\Core\Enum\Rules\EnumKey;
use App\Models\Place\Country;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use App\Exceptions\ObjectNotFoundException;

class TopSpammersController extends Controller
{  
    public function truecaller(Request $request)
    {
        $this->validateAdminAuthorization();

        $request->validate([
            'incoming_type' => ['required', new EnumKey(IncomingType::class)],
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
        
        // $filename = "/home/berners/Documents/dev/web/truecaller/crawler/truecaller/crawled/truecaller-top-spammers.json";

        $crawlerModel = CrawlerModel::firstOrCreate([
            'name' => 'truecaller_br',
            'url' => 'https://www.truecaller.com'
        ]);

        $crawlerModel->dictionary = [
            'categories' => [
                '1' => 'sales',
                '2' => 'scam',
                '4' => 'political',
                '5' => 'survey_research',
                '6' => 'robo_call',
            ]
        ];

        $incomingType = IncomingType::fromKey($request->incoming_type);

        $crawlerModel->transformers = [
            'country_code' => function($value, $item, $options) use ($country) {
                return $country->iso2;
            },
            'incoming_type' => function($value, $item, $options) use ($incomingType) {
                return $incomingType;
            }
        ];

        $crawler = new PhoneTopSpammerCrawler($request->filename, $crawlerModel);

        $crawler->import();
        // // ProcessCrawler::dispatch($crawler);
    }  

}
