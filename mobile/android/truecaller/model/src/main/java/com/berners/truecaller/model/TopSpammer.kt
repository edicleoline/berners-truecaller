package com.berners.truecaller.model

data class TopSpammer(
    val label: String,

    val reportsCount: Int,

    val categories: List<Long>? = null,

    var incomingType: IncomingType? = null,

    val phone: Phone

)