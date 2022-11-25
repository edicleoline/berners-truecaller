package com.berners.truecaller.data.remote.datasources

import com.berners.truecaller.data.datasources.TopSpammerDataSource
import com.berners.truecaller.data.remote.model.toModelList
import com.berners.truecaller.data.remote.services.TopSpammerService
import com.berners.truecaller.data.Result
import com.berners.truecaller.data.Result.Success
import com.berners.truecaller.data.Result.Error
import com.berners.truecaller.data.Result.Loading
import com.berners.truecaller.model.TopSpammer
import com.berners.truecaller.model.IncomingType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

open class RemoteTopSpammerDataSource @Inject constructor(private val service: TopSpammerService) : TopSpammerDataSource {
    override fun listByIncomingType(incomingType: IncomingType, maxResults: Int): Flow<Result<List<TopSpammer>>> {
        return flow {
            emit(Loading)
            val response = try {
                service.listByIncomingType(incomingType, maxResults)
            }
            catch (exception: IOException) {
                emit(Error(exception))
                null
            }
            if (response?.data != null) {
                emit(Success(response.data.toModelList()))
            } else if (response != null) {
                emit(Success(emptyList()))
            }
        }
    }

    override suspend fun saveAll(items: List<TopSpammer>) {
        TODO()
    }

}