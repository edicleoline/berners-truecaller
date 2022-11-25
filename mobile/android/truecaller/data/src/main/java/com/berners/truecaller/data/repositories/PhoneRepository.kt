package com.berners.truecaller.data.repositories

import com.berners.truecaller.data.datasources.PhoneDataSource
import com.berners.truecaller.model.Phone
import com.berners.truecaller.data.Result
import com.berners.truecaller.data.Result.Success
import com.berners.truecaller.data.data
import com.berners.truecaller.data.succeeded
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class PhoneRepository @Inject constructor(
    val remotePhoneDataSource: PhoneDataSource,
    val localPhoneDataSource: PhoneDataSource
) {
    fun getPhoneByIdStream(id: Long): Flow<Result<Phone?>> {
        return flow {
            emit(Result.Loading)
            combine(localPhoneDataSource.getPhoneByIdStream(id), remotePhoneDataSource.getPhoneByIdStream(id)) { local, remote ->
                when (remote) {
                    is Success, is Result.Error -> {
                        if (remote.succeeded && remote.data != null) {
                            emit(Success(remote.data))
                            localPhoneDataSource.save(remote.data!!)
                        } else {
                            emit(Success(local.data))
                        }
                    }
                    is Result.Loading -> { remote }
                }
            }.collect { }
        }
    }

    suspend fun findByE164Format(e164Format: String): Flow<Phone?> {
//        var phone = localPhoneDataSource.findByE164Format(e164Format)
//
//        return phone

        TODO()
    }
}