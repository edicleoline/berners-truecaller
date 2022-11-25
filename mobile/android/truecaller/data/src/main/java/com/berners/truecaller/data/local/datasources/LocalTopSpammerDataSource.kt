package com.berners.truecaller.data.local.datasources

import com.berners.truecaller.data.datasources.TopSpammerDataSource
import com.berners.truecaller.data.local.db.daos.TopSpammerDao
import com.berners.truecaller.data.local.db.entities.toEntityList
import com.berners.truecaller.data.local.db.entities.toModelList
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

open class LocalTopSpammerDataSource @Inject constructor(private val topSpammerDao: TopSpammerDao) : TopSpammerDataSource {
    override fun listByIncomingType(incomingType: IncomingType, maxResults: Int): Flow<Result<List<TopSpammer>>> {
        return flow {
            emit(Loading)
            val entities = try {
                topSpammerDao.listByIncomingType(incomingType)
            }
            catch (exception: IOException) {
                emit(Error(exception))
                null
            }
            if (entities != null) {
                emit(Success(entities.toModelList()))
            } else {
                emit(Success(emptyList()))
            }
        }
    }

    override suspend fun saveAll(items: List<TopSpammer>) {
//        topSpammerDao.insertAll(items.toEntityList())
    }
}