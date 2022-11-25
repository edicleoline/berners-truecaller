package com.berners.truecaller.model

data class Tag(
    val id: Long? = null,

    val label: String,

    val labelTranslated: String,

    val parentTagId: Long? = null,

)
