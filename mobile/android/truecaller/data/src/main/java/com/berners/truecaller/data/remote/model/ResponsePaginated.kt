package com.berners.truecaller.data.remote.model

import com.squareup.moshi.Json

//@JsonClass(generateAdapter = true)
data class ResponsePaginated<T>(
    @Json(name = "data")
    val data: List<T>,

    @Json(name = "paging")
    val paging: Paging
)

//@JsonClass(generateAdapter = true)
data class Paging(
    @Json(name = "cursors")
    val cursors: Cursors
)

//@JsonClass(generateAdapter = true)
data class Cursors(
    @Json(name = "previous")
    val previous: String? = null,

    @Json(name = "next")
    val next: String? = null,
)