package com.berners.truecaller.data.remote.datasources

import com.berners.truecaller.data.datasources.PhoneDataSource
import com.berners.truecaller.data.remote.model.toModel
import com.berners.truecaller.model.Phone
import com.berners.truecaller.data.remote.services.PhoneService
import com.berners.truecaller.data.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

open class RemotePhoneDataSource @Inject constructor(private val service: PhoneService) : PhoneDataSource {
    override fun getPhoneByIdStream(id: Long): Flow<Result<Phone>> {
        return flow {
            emit(Result.Loading)
            val response = try {
                service.findById(id)
            }
            catch (exception: IOException) {
                emit(Result.Error(exception))
                null
            }
            if (response?.data != null) {
                emit(Result.Success(response.data.toModel()))
            } else if (response != null) {
                emit(Result.Error(Exception("Phone not found")))
            }
        }
    }

    override fun getPhoneByE164FormatStream(e164Format: String): Flow<Result<Phone>> {
//        return phoneDao.findByE164Format(e164Format)?.toModel()
        TODO("Not yet")
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
        TODO()
    }
}