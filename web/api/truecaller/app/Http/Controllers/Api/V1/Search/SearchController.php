<?php

namespace App\Http\Controllers\Api\V1\Search;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Core\Api\Response;
use App\Models\Search\Entity;
use App\Models\Search\Search;
use App\Models\Place\Country;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use App\Exceptions\ObjectNotFoundException;
use App\Core\Facades\Authentication;

class SearchController extends Controller
{
    public function search(Request $request)
    {
        $entities = [];
     
        $pagination = $this->paginationParams($request, [
            'max_results' => 'required|integer|min:1|max:20',
        ]);
        
        $country = null;
        if($request->has('country_code')) {            
            try {
                $country = Country::findOrFailByIsoCode2($request->country_code);
            }
            catch (ModelNotFoundException $exception) {
                throw ObjectNotFoundException::withQueryParam(['country_code' => $request->country_code]);
            }      
        }

        $session = Authentication::session();

        $search = new Search();
        $search->query = $request->q;
        $search->created_by_auth_session_id = $session->id;
        $search->save();

        $entities = Entity::search($request->q, $country, $pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $entities));
    }   
}
