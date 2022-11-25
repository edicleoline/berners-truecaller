package com.berners.truecaller.data.repositories

import com.berners.truecaller.data.datasources.TopSpammerDataSource
import com.berners.truecaller.model.TopSpammer
import com.berners.truecaller.data.Result
import com.berners.truecaller.data.Result.Success
import com.berners.truecaller.data.data
import com.berners.truecaller.data.succeeded
import com.berners.truecaller.model.IncomingType
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TopSpammerRepository @Inject constructor(
    private val remoteTopSpammerDataSource: TopSpammerDataSource,
    private val localTopSpammerDataSource: TopSpammerDataSource
) {
    suspend fun listByIncomingType(incomingType: IncomingType, maxResults: Int): Flow<Result<List<TopSpammer>>> {
        return flow {
            emit(Result.Loading)
            combine(localTopSpammerDataSource.listByIncomingType(incomingType, maxResults),
                remoteTopSpammerDataSource.listByIncomingType(incomingType, maxResults)) { local, remote ->
                when (remote) {
                    is Result.Success, is Result.Error -> {
                        if (remote.succeeded && remote.data != null) {
                            emit(Result.Success(remote.data!!))
                            remote.data!!.forEach {
                                it.incomingType = incomingType
                            }
                            localTopSpammerDataSource.saveAll(remote.data!!)
                        } else {
                            emit(Result.Success(local.data!!))
                        }
                    }
                    is Result.Loading -> { remote }
                }
            }.collect { }
        }
    }

//    suspend fun isBlacklisted(e164Format: String): Flow<Result<Boolean>> {
//        return flow {
//            emit(Result.Loading)
//            localTopSpammerDataSource.
//        }
//    }
}