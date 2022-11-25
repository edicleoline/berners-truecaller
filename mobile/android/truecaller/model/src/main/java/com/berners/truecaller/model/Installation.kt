package com.berners.truecaller.model

data class Installation(
    val lang: String,

    val countryCode: String,

//    val device: Device? = null
    val device: Device
)
