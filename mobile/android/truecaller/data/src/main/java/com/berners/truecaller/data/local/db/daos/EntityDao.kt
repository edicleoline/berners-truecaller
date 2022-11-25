package com.berners.truecaller.data.local.db.daos

import androidx.room.Dao
import androidx.room.Query
import com.berners.truecaller.data.local.db.entities.EntityEntity

@Dao
abstract class EntityDao : TrueDao<EntityEntity>() {
    @Query("SELECT * FROM entities WHERE rid = :rid")
    abstract suspend fun getEntityByRid(rid: Long) : EntityEntity?
}
