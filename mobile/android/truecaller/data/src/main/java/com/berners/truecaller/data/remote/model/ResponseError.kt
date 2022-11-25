package com.berners.truecaller.data.remote.model

import com.squareup.moshi.Json

//@JsonClass(generateAdapter = true)
data class ResponseError(
    @Json(name = "error")
    val error: Error
)

//@JsonClass(generateAdapter = true)
data class Error(
    @Json(name = "message")
    val message: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "code")
    val code: String? = null
)