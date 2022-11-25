<?php

namespace App\Http\Controllers\Api\V1\Phone;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Phone\Phone;
use App\Core\Api\Response;
use App\Models\Phone\PhoneEntity;
use App\Core\Enum\Rules\EnumKey;
use App\Core\Enum\EntityType;

class PhoneEntitiesController extends Controller
{  
    public function list(Request $request, $phoneId)
    {      
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);

        $pagination = $this->paginationParams($request);        
        $entities = PhoneEntity::listByPhone($phone, $pagination->max_results, $pagination->pagination_token);

        return response(Response::content($request, $entities));          
    }

    public function store(Request $request, $phoneId)
    {   
        $request->validate([
            'name' => 'required',
            'entity_type' => ['required', new EnumKey(EntityType::class)],
        ]);

        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $entity = $phone->addEntity($request->name, EntityType::fromKey($request->entity_type));

        return response(Response::content($request, $entity), 201);                  
    }

    public function destroy(Request $request, $phoneId, $entityId)
    {           
        $phone = $this->findOrFail(Phone::class, $phoneId, ['phone_id' => $phoneId]);
        $entity = $this->findOrFail(PhoneEntity::class, $entityId, ['entity_id' => $entityId]);

        $this->validateBasicAuthorization($entity->createdBy()->user_id);

        $entity->delete();

        return response()->noContent();
    }
}
