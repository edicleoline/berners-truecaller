package com.berners.truecaller.data.local.datasources

import com.berners.truecaller.data.datasources.PhoneDataSource
import com.berners.truecaller.data.local.db.daos.PhoneDao
import com.berners.truecaller.data.local.db.entities.toModel
import com.berners.truecaller.model.Entity
import com.berners.truecaller.data.Result
import com.berners.truecaller.data.datasources.EntityDataSource
import com.berners.truecaller.data.local.db.daos.EntityDao
import com.berners.truecaller.data.local.db.entities.toEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject
import kotlin.reflect.full.createInstance

open class LocalEntityDataSource @Inject constructor(
    private val entityDao: EntityDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : EntityDataSource {
    override fun getEntityByIdStream(id: Long): Flow<Result<Entity>> {
        return flow {
            emit(Result.Loading)
//            val entity = try {
//                entityDao.getPhoneById(id)
//            }
//            catch (exception: IOException) {
//                emit(Result.Error(exception))
//                null
//            }
//            if (entity != null) {
//                emit(Result.Success(entity.toModel()))
//            } else {
//                emit(Result.Error(Exception("phone not found")))
//            }
        }

    }

    override suspend fun save(entity: Entity): Entity {
        var newEntity = entity.toEntity()
        val oldEntity = if (entity.rid != null) entityDao.getEntityByRid(entity.rid!!) else null

        if (oldEntity != null) {
            newEntity = newEntity.copy(id = oldEntity.id, createdAt = oldEntity.createdAt)
        }

        entityDao.save(newEntity)

        return newEntity.toModel()
    }
}