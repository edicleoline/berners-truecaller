<?php

namespace App\Core\Incoming\Sentinel;

use App\Models\Phone\Phone;
use App\Models\Account\User;
use App\Models\Incoming\Incoming;
use App\Core\Incoming\IncomingType;
use App\Core\Scrapping\Url;
use App\Core\Incoming\Sentinel\Event;
use App\Core\Incoming\Sentinel\EventType;
use App\Core\Incoming\Sentinel\Response;
use App\Core\Incoming\Sentinel\DecisionType;
use App\Core\Incoming\Sentinel\Decision;

class Engine
{
    protected $incoming;
    protected array $events;

    public function __construct(Incoming $incoming) { 
        $this->incoming = $incoming;
        $this->events = [];
    }    

    protected function registerEvent(Event $event) {
        $this->events[] = $event;
    }

    public function getEvents() {
        return $this->events;
    }

    public function execute() {
        $response = new Response($this->incoming);

        $source = $this->incoming->source;

        if(!is_null($source) && $source->whitelisted_by === true) {
            $response->setDecision(new Decision(DecisionType::fromValue(DecisionType::Allow), __('incoming.allowed_cause_phone_whitelisted_by')));
            return $response;
        }

        if(!is_null($source) && $source->blacklisted_by === true) {
            $response->setDecision(new Decision(DecisionType::fromValue(DecisionType::Block), __('incoming.blocked_cause_phone_blacklisted_by')));
            return $response;
        }

        // $this->processSmsIfPresent();
        // $this->processPhoneReports();
        // dd($this->getEvents());

        $response->setDecision(new Decision(DecisionType::fromValue(DecisionType::Allow), __('incoming.seems_everything_normal')));
        return $response;    
    }

    protected function processPhoneReports() {

    }

    protected function processSmsIfPresent() {
        if(!isset($this->incoming->sms_text) || empty($this->incoming->sms_text)) {
            return false;
        }

        $this->processUrlsIfPresent($this->incoming->sms_text);
        $this->processBadWordsIfPresent($this->incoming->sms_text);

        return true;
    }

    protected function processBadWordsIfPresent(string $text) {
        //todo
    }

    protected function processUrlsIfPresent(string $text) {
        $urls = Url::scrapAll($text);

        if(is_null($urls) || count($urls) < 1) return false;

        //todo store urls to post process

        $this->registerEvent(new Event(EventType::fromValue(EventType::UnverifiedUrl)));
    }
}