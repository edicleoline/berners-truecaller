package com.berners.truecaller.data.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.berners.truecaller.model.EntityType

@Entity(tableName = "entities")
data class EntityEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override var id: Long? = null,

    @ColumnInfo(name = "rid")
    var rid: Long? = null,

    @ColumnInfo(name = "created_at")
    override var createdAt: Long? = null,

    @ColumnInfo(name = "updated_at")
    override var updatedAt: Long? = null,

    @ColumnInfo(name = "deleted_at")
    override var deletedAt: Long? = null,

    @ColumnInfo(name = "entity_type")
    var type: EntityType,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "verified")
    var verified: Boolean,

    @ColumnInfo(name = "profile_image_url")
    var profileImageUrl: String? = null,

    @ColumnInfo(name = "primary_color")
    var primaryColor: String = "#daceb4",

    @ColumnInfo(name = "is_user")
    var isUser: Boolean,

    @ColumnInfo(name = "is_user_premium")
    var isUserPremium: Boolean,

) : TrueEntity

fun EntityEntity.toModel(): com.berners.truecaller.model.Entity {
    return com.berners.truecaller.model.Entity(
        id = this.id,
        rid = this.rid,
        type = this.type,
        name = this.name,
        verified = this.verified,
        profileImageUrl = this.profileImageUrl,
        isUser = this.isUser,
        isUserPremium = this.isUserPremium
    )
}

fun com.berners.truecaller.model.Entity.toEntity(): EntityEntity {
    return EntityEntity(
        id = this.id,
        rid = this.rid,
        type = this.type,
        name = this.name,
        verified = this.verified,
        profileImageUrl = this.profileImageUrl,
        isUser = this.isUser,
        isUserPremium = this.isUserPremium
    )
}