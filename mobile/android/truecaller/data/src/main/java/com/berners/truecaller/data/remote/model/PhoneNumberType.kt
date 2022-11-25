package com.berners.truecaller.data.remote.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

enum class PhoneNumberType {
    MOBILE,
    FIXED_LINE,
    UNKNOWN;

    companion object Adapter {
        @ToJson
        fun toJson(type: PhoneNumberType): String = type.name.lowercase()

        @FromJson
        fun fromJson(name: String): PhoneNumberType {
            return values().find { it.name == name.uppercase() } ?: UNKNOWN
        }
    }
}

fun PhoneNumberType.toModel(): com.berners.truecaller.model.PhoneNumberType =
    when(this) {
        PhoneNumberType.MOBILE -> com.berners.truecaller.model.PhoneNumberType.MOBILE
        PhoneNumberType.FIXED_LINE -> com.berners.truecaller.model.PhoneNumberType.FIXED_LINE
        PhoneNumberType.UNKNOWN -> com.berners.truecaller.model.PhoneNumberType.UNKNOWN
    }