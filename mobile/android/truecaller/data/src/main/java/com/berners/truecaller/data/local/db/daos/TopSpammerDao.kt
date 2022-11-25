package com.berners.truecaller.data.local.db.daos

import androidx.room.Dao
import androidx.room.Query
import com.berners.truecaller.data.local.db.entities.TopSpammerEntity
import com.berners.truecaller.model.IncomingType

@Dao
interface TopSpammerDao {
    @Query("SELECT * FROM top_spammers")
    suspend fun all(): List<TopSpammerEntity>

    @Query("SELECT * FROM top_spammers WHERE incoming_type LIKE :incomingType")
    suspend fun listByIncomingType(incomingType: IncomingType): List<TopSpammerEntity>
}
