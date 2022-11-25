package com.berners.truecaller.shared.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The Data Access Object for the [TopSpammerFtsEntity] class.
 */
@Dao
interface TopSpammerFtsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(topSpammers: List<TopSpammerFtsEntity>)

    @Query("SELECT top_spammer_id FROM topSpammersFts WHERE topSpammersFts MATCH :query")
    fun searchAllTopSpammers(query: String): List<String>
}
