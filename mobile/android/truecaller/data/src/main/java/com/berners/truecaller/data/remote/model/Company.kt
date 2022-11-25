package com.berners.truecaller.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class Company(
    @Json(name = "id")
    val id: Long,

    @Json(name = "name")
    val name: String,
)