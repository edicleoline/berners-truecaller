<?php

namespace App\Core\Model;

use Illuminate\Pagination\LengthAwarePaginator;

class Pagination extends LengthAwarePaginator
{

    public function __construct(LengthAwarePaginator $paginator) {
        parent::__construct(
            $paginator->items(), 
            $paginator->total(), 
            $paginator->perPage(), 
            $paginator->currentPage(), 
            $paginator->getOptions()
        );
    }

    public function toArray() {
        return [
            'items' => $this->items(),
            'per_page' => $this->perPage(),
            'current_page' => $this->currentPage(),
            'last_page' => $this->lastPage(),
            'total' => $this->total()
        ];
    }
}