package com.berners.truecaller.data.datasources

import com.berners.truecaller.model.Entity
import com.berners.truecaller.data.Result
import com.berners.truecaller.model.Incoming
import kotlinx.coroutines.flow.Flow

interface IncomingDataSource {
//    fun getEntityByIdStream(id: Long): Flow<Result<Entity>>

    suspend fun save(incoming: Incoming): Incoming
}