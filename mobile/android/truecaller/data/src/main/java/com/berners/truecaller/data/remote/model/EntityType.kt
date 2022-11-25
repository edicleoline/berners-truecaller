package com.berners.truecaller.data.remote.model

import com.squareup.moshi.*

enum class EntityType {
    COMPANY,
    PEOPLE,
    UNKNOWN;

    companion object Adapter {
        @ToJson
        fun toJson(type: EntityType): String = type.name.lowercase()

        @FromJson
        fun fromJson(name: String): EntityType =
                values().first { it.name == name.uppercase() }
    }
}

fun EntityType.toModel(): com.berners.truecaller.model.EntityType =
    when(this) {
        EntityType.COMPANY -> com.berners.truecaller.model.EntityType.COMPANY
        EntityType.PEOPLE -> com.berners.truecaller.model.EntityType.PEOPLE
        EntityType.UNKNOWN -> com.berners.truecaller.model.EntityType.PEOPLE
    }