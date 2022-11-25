package com.berners.truecaller.model

data class Location(
    val id: Long? = null,
    val countryId: Long? = null,
    val stateId: Long? = null,
    val cityId: Long? = null,
    val formatted: String = ""
)
