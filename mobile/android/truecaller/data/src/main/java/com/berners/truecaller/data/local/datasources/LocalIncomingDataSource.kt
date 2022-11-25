package com.berners.truecaller.data.local.datasources

import com.berners.truecaller.data.local.db.entities.toModel
import com.berners.truecaller.data.datasources.IncomingDataSource
import com.berners.truecaller.data.local.db.daos.IncomingDao
import com.berners.truecaller.data.local.db.entities.toEntity
import com.berners.truecaller.model.Incoming
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

open class LocalIncomingDataSource @Inject constructor(
    private val incomingDao: IncomingDao,
    private val localPhoneDataSource: LocalPhoneDataSource,
    private val localIncomingEventDataSource: LocalIncomingEventDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IncomingDataSource {

    override suspend fun save(incoming: Incoming): Incoming {
        val source = localPhoneDataSource.save(incoming.source)
        val target = localPhoneDataSource.save(incoming.target)

        val newIncoming = incoming.copy(source = source, target = target).toEntity()

        incomingDao.save(newIncoming)

        for (event in incoming.state.events) {
            localIncomingEventDataSource.save(event, newIncoming.toModel())
        }

        return newIncoming.toModel()
    }
}