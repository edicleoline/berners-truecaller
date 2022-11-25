<?php

namespace App\Core\Api;
use Illuminate\Pagination\CursorPaginator;
use App\Core\Util\ArrayUtil;
use Illuminate\Http\Request;
use App\Core\Api\CursorPagination;
use JsonSerializable;
use Illuminate\Contracts\Support\Jsonable;
use Illuminate\Contracts\Support\Arrayable;
use App\Models\Api\Query;

class Response implements Arrayable, JsonSerializable, Jsonable
{
    protected $fields;
    protected $apiQuery;
    // protected $nested = false;

    public function __construct(public Request $request, public mixed $data, public mixed $paging = null) {
        if($request->has('rq')) {
            $this->apiQuery = Query::findById($request->rq);
        }

        $fields = null;
        if(!is_null($this->apiQuery)) {
            $fields = $this->apiQuery->fields;
        }

        if($request->has('fields')) {
            $fields = $request->fields;            
        }

        if(!is_null($fields)) {
            $this->fields = array_map('trim', explode(',', $fields));
        }
    }

    public function dataToArray() {
        $this->data = json_encode($this->data, 15);
        $this->data = json_decode($this->data, true);
    }

    public function sparseFields(&$data, $fields) {        
        if(is_null($fields) || (count($fields) == 1 && $fields[0] === '*')) {
            return false;
        }

        $data = ArrayUtil::merge($data, function($path, $value, $depth) use ($fields) {            
            $pathExploded = explode('.', $path);
            array_pop($pathExploded);
            $pathWildcard = implode('.', $pathExploded);
            if(!empty($pathWildcard)) {
                $pathWildcard .= '.*';
                if(in_array($pathWildcard, $fields)) {
                    return true;
                }
            }        

            return in_array($path, $fields);
        });

        return true;
    }

    public function sanitize(&$data) {
        if(is_null($data)) return $data;
        $data = ArrayUtil::arrayFilterRecursive($data);
    }

    public static function content(Request $request, mixed $data) {
        if($data instanceof CursorPaginator) {
            $nextCursor = $data->nextCursor();
            $previousCursor = $data->previousCursor();

            $response = new Response(
                $request,
                $data->items(), 
                [
                    'cursors' => [
                        'previous' => $previousCursor ? $previousCursor->encode() : null,
                        'next' => $nextCursor ? $nextCursor->encode() : null
                    ]
                ]
            );
        }
        else if($data instanceof CursorPagination) {
            $response = new Response(
                $request,
                $data->items(), 
                [
                    'cursors' => [
                        'previous' => $data->previousCursor(),
                        'next' => $data->nextCursor()
                    ]
                ]
            );            
        }

        if($data instanceof CursorPaginator || $data instanceof CursorPagination) {            
            $response->dataToArray();

            foreach ($response->data as $d => &$value) {
                $response->sparseFields($value, $response->fields);
                $response->sanitize($value);
            }

            return $response;
        }

        $response = new Response($request, $data);
        $response->dataToArray();
        $response->sparseFields($response->data, $response->fields);
        $response->sanitize($response->data);
        // $response->nested = true;

        return $response;
    }

    public function toArray() : mixed {
        $response = array_filter([
            'data' => $this->data,
            'paging' => $this->paging
        ]);

        if(!isset($response['data'])) {
            $response['data'] = null;
            unset($response['paging']);
        }

        // if($this->nested) { 
        //     return array_reduce($response, 'array_merge', array());
        // }      

        return $response;
    }

    public function jsonSerialize() {
        return $this->toArray();
    }

    public function toJson($options = 0)
    {
        return json_encode($this->jsonSerialize(), $options);
    }    
}
