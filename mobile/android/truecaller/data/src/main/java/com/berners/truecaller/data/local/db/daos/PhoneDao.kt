package com.berners.truecaller.data.local.db.daos

import androidx.room.Dao
import androidx.room.Query
import com.berners.truecaller.data.local.db.entities.PhoneEntity

@Dao
abstract class PhoneDao : TrueDao<PhoneEntity>() {
    @Query("SELECT * FROM phones WHERE id = :id")
    abstract suspend fun getPhoneById(id: Long) : PhoneEntity?

    @Query("SELECT * FROM phones WHERE e164_format like :e164Format")
    abstract suspend fun getPhoneByE164Format(e164Format: String): PhoneEntity?

    @Query("SELECT * FROM phones WHERE rid = :rid")
    abstract suspend fun getPhoneByRid(rid: Long) : PhoneEntity?
}
