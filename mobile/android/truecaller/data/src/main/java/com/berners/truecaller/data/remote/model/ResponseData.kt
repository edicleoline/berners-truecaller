package com.berners.truecaller.data.remote.model

import com.squareup.moshi.Json

//@JsonClass(generateAdapter = true)
data class ResponseData<T>(
    @Json(name = "data")
    val data: T? = null
)