package com.berners.truecaller.data.local.datasources

import com.berners.truecaller.data.datasources.IncomingEventDataSource
import com.berners.truecaller.data.local.db.daos.IncomingEventDao
import com.berners.truecaller.data.local.db.entities.toEntity
import com.berners.truecaller.model.Incoming
import com.berners.truecaller.model.IncomingEvent
import com.berners.truecaller.model.IncomingState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

open class LocalIncomingEventDataSource @Inject constructor(
    private val incomingEventDao: IncomingEventDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IncomingEventDataSource {

    override suspend fun save(event: IncomingEvent, incoming: Incoming) {
//        val source = localPhoneDataSource.save(incoming.source)
//        val target = localPhoneDataSource.save(incoming.target)
//
//        val newIncoming = incoming.copy(source = source, target = target)
//
//        incomingDao.save(newIncoming.toEntity())
//
//        return newIncoming
        if (incoming.id == null) {
            return
        }

        val incomingEventEntity = event.toEntity()
        incomingEventEntity.incomingId = incoming.id!!
        incomingEventDao.save(incomingEventEntity)
    }
}