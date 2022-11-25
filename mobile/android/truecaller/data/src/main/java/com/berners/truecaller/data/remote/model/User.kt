package com.berners.truecaller.data.remote.model

import com.berners.truecaller.data.local.db.entities.UserEntity
import com.squareup.moshi.Json

data class User (
    @field:Json(name = "id")
    val id: Long,

    @field:Json(name = "name")
    val name: String? = null,
)

fun User.toModel(): com.berners.truecaller.model.User {
    return com.berners.truecaller.model.User(
        id = this.id,
        name = this.name
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name
    )
}