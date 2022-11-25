<?php

namespace App\Core\Api;
use Illuminate\Database\Query\Builder;
use JsonSerializable;

class CursorPagination implements JsonSerializable
{
    protected $items;
    protected $total;
    protected $perPage;    
    protected $currentPage;
    protected $hasNext;
    protected $hasPrevious;

    public function __construct($items, int $total, int $perPage, int $currentPage = 1) {
        $this->items = $items;
        $this->total = $total;
        $this->perPage = $perPage;
        $this->currentPage = $currentPage;

        $this->hasNext = $total > ($perPage * $currentPage);
        $this->hasPrevious = $currentPage > 1;
    }

    public static function paginate(Builder $builder, int $perPage = 1, ?string $token = null) {
        $total = $builder->getCountForPagination();
        $items = [];

        if(empty($token)) {
            $items = $builder
                ->take($perPage)
                ->get();
                
            $pagination = new CursorPagination($items, $total, $perPage, 1);
            return $pagination;
        }

        $tokenParameters = CursorPagination::fromEncoded($token);
        $items = $builder
            ->skip($perPage * ($tokenParameters['page'] - 1))
            ->take($perPage)
            ->get();
    
        $pagination = new CursorPagination($items, $total, $perPage, $tokenParameters['page']);
        return $pagination;
    }

    public function items() {
        return $this->items;
    }

    public function previousCursor() {
        if(!$this->hasPrevious) return null;

        $cursor = [
            '_pointsToPreviousItems' => true,
            'page' => $this->currentPage - 1
        ];

        return $this->encode($cursor);
    }

    public function nextCursor() {
        if(!$this->hasNext) return null;

        $cursor = [
            '_pointsToNextItems' => true,
            'page' => $this->currentPage + 1
        ];

        return $this->encode($cursor);
    }

    public function encode(array $array) {
        return str_replace(['+', '/', '='], ['-', '_', ''], base64_encode(json_encode($array)));
    }

    public static function fromEncoded($encodedString)
    {
        if (!is_string($encodedString)) {
            return null;
        }

        $parameters = json_decode(base64_decode(str_replace(['-', '_'], ['+', '/'], $encodedString)), true);

        return $parameters;
    }

    public function toArray()
    {
        return [
            'data' => $this->items->toArray(),   
            'paging' => [
                'total' => $this->total,
                'cursors' => [
                    'previous' => $this->previousCursor(),
                    'next' => $this->nextCursor()
                ]
            ]            
        ];
    }

    public function jsonSerialize(): array
    {
        return $this->toArray();
    }
}