package com.berners.truecaller.data.local.db.daos

import androidx.room.*
import com.berners.truecaller.data.local.db.entities.TrueEntity

abstract class TrueDao<in E : TrueEntity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entity: E): Long

    @Insert
    abstract suspend fun insertAll(vararg entity: E)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(entities: List<E>)

    @Update
    abstract suspend fun update(entity: E)

    @Delete
    abstract suspend fun deleteEntity(entity: E): Int

    @Transaction
    open suspend fun withTransaction(tx: suspend () -> Unit) = tx()

    suspend fun save(entity: E) {
        if (entity.id == null) {
            entity.id = insert(entity.apply {
                createdAt = System.currentTimeMillis()
            })
        } else {
            update(entity.apply {
                updatedAt = System.currentTimeMillis()
            })
        }
    }

    @Transaction
    open suspend fun save(entities: List<E>) {
        entities.forEach {
            save(it)
        }
    }
}