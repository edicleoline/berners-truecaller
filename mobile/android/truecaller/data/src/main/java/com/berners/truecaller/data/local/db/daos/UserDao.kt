package com.berners.truecaller.data.local.db.daos

import androidx.room.Dao
import androidx.room.Query
import com.berners.truecaller.data.local.db.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM phones WHERE id = :id")
    abstract suspend fun findById(id: Long) : UserEntity?
}
