package com.berners.truecaller.data.local.datasources

import com.berners.truecaller.data.datasources.PhoneDataSource
import com.berners.truecaller.data.local.db.daos.PhoneDao
import com.berners.truecaller.data.local.db.entities.toEntity
import com.berners.truecaller.data.local.db.entities.toModel
import com.berners.truecaller.model.Phone
import com.berners.truecaller.data.Result
import com.berners.truecaller.data.local.db.daos.EntityDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

open class LocalPhoneDataSource @Inject constructor(
    private val phoneDao: PhoneDao,
    private val localEntityDataSource: LocalEntityDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PhoneDataSource {
    override fun getPhoneByIdStream(id: Long): Flow<Result<Phone>> {
        return flow {
            emit(Result.Loading)
            val entity = try {
                phoneDao.getPhoneById(id)
            }
            catch (exception: IOException) {
                emit(Result.Error(exception))
                null
            }
            if (entity != null) {
                emit(Result.Success(entity.toModel()))
            } else {
                emit(Result.Error(Exception("phone not found")))
            }
        }
    }

    override fun getPhoneByE164FormatStream(e164Format: String): Flow<Result<Phone>> {
//        return flow {
//            phoneDao.findByE164Format(e164Format)?.toModel()
//        }
        TODO()
    }

    override fun getPhonesByIdsStream(ids: List<Long>): Flow<Result<List<Phone>>> {
        TODO("Not yet implemented")
    }

    override fun getPhonesByE164FormatsStream(e164Formats: List<String>): Flow<Result<List<Phone>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhoneById(id: Long): Result<Phone> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhoneByE164Format(e164Format: String): Result<Phone> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhonesByIds(ids: List<Long>): Result<List<Phone>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhonesByE164Formats(e164Formats: List<String>): Result<List<Phone>> {
        TODO("Not yet implemented")
    }

    override suspend fun save(phone: Phone): Phone {
        var entity = phone.entity

        if (entity != null) {
            entity = localEntityDataSource.save(entity)
        }

        val newPhone = phone.toEntity()
        val oldPhone = phoneDao.getPhoneByE164Format(phone.e164Format)

        if (oldPhone != null) {
            newPhone.id = oldPhone.id
            newPhone.createdAt = oldPhone.createdAt
        }

        newPhone.entityId = entity?.id

        phoneDao.save(newPhone)

        return newPhone.toModel()
    }
}