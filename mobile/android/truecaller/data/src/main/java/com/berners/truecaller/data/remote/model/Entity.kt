package com.berners.truecaller.data.remote.model

import com.squareup.moshi.Json

data class Entity(

    @Json(name = "id")
    val id: Long? = null,

    @Json(name = "type")
    val type: EntityType = EntityType.PEOPLE,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "verified")
    val verified: Boolean = false,

    @Json(name = "profile_image_url")
    val profileImageUrl: String? = null,

    @Json(name = "default_profile_image")
    val defaultProfileImage: Boolean = true,

    val primaryColor: String = "#daceb4",

    val isUser: Boolean = false,

    val isUserPremium: Boolean = false
)

fun Entity.toModel(): com.berners.truecaller.model.Entity {
    return com.berners.truecaller.model.Entity(
        rid = this.id,
        type = this.type.toModel(),
        name = this.name,
        verified = this.verified,
        profileImageUrl = this.profileImageUrl,
        primaryColor = this.primaryColor,
        isUser = this.isUser,
        isUserPremium = this.isUserPremium
    )
}