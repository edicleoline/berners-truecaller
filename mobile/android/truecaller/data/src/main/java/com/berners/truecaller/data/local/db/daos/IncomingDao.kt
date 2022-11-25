package com.berners.truecaller.data.local.db.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.berners.truecaller.data.local.db.entities.IncomingEntity
import com.berners.truecaller.data.local.db.entities.PhoneEntity
import com.berners.truecaller.data.local.db.resultentities.IncomingEntityDetailed
import kotlinx.coroutines.flow.Flow

@Dao
abstract class IncomingDao : TrueDao<IncomingEntity>() {
    @Transaction
    @Query("SELECT * FROM incomings ORDER BY created_at ASC")
    abstract fun incomingsObservable(): Flow<List<IncomingEntity>>

    @Transaction
    @Query("SELECT * FROM incomings ORDER BY created_at ASC")
    abstract fun incomingsDetailedObservable(): Flow<List<IncomingEntityDetailed>>
}
