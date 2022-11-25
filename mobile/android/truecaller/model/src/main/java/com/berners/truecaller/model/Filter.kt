package com.berners.truecaller.model

data class Filter(
    val id: Long? = null,

    val filterType: String,

    val rule: String,

    val value: String,

    val attributes: List<FilterAttribute>
)
