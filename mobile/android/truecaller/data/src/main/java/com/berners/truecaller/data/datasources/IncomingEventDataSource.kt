package com.berners.truecaller.data.datasources

import com.berners.truecaller.model.Entity
import com.berners.truecaller.data.Result
import com.berners.truecaller.model.Incoming
import com.berners.truecaller.model.IncomingEvent
import com.berners.truecaller.model.IncomingState
import kotlinx.coroutines.flow.Flow

interface IncomingEventDataSource {
//    fun getEntityByIdStream(id: Long): Flow<Result<Entity>>

    suspend fun save(event: IncomingEvent, incoming: Incoming)
}