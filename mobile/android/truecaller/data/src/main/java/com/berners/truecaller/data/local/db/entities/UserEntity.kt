package com.berners.truecaller.data.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id")
    val id: Long?,

    @ColumnInfo(name = "name")
    val name: String? = null,

)

fun UserEntity.toModel(): com.berners.truecaller.model.User {
    return com.berners.truecaller.model.User(
        id = this.id,
        name = this.name
    )
}

fun com.berners.truecaller.model.User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name
    )
}