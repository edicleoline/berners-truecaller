package com.berners.truecaller.data.datasources

import com.berners.truecaller.model.TopSpammer
import com.berners.truecaller.data.Result
import com.berners.truecaller.model.IncomingType
import kotlinx.coroutines.flow.Flow

interface TopSpammerDataSource {
    fun listByIncomingType(incomingType: IncomingType, maxResults: Int): Flow<Result<List<TopSpammer>>>

    suspend fun saveAll(items: List<TopSpammer>)
}