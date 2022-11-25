package com.berners.truecaller.data.remote.model

import com.berners.truecaller.data.local.db.entities.TopSpammerEntity
import com.squareup.moshi.Json

//@JsonClass(generateAdapter = true)
data class TopSpammer(

    @field:Json(name = "label")
    val label: String,

    @field:Json(name = "reports_count")
    val reportsCount: Int,

    @field:Json(name = "categories")
    val categories: List<Long>?,

    @field:Json(name = "phone")
    val phone: Phone
)


fun TopSpammer.toModel(): com.berners.truecaller.model.TopSpammer {
    return com.berners.truecaller.model.TopSpammer(
        label = this.label,
        reportsCount = this.reportsCount,
        categories = this.categories,
        phone = this.phone.toModel()
    )
}

fun List<TopSpammer>.toModelList(): List<com.berners.truecaller.model.TopSpammer> {
    val list : MutableList<com.berners.truecaller.model.TopSpammer> = mutableListOf()
    this.forEach {
        list.add(it.toModel())
    }

    return list
}

fun TopSpammer.toEntity(): TopSpammerEntity {
    return TopSpammerEntity(
        id = 0L,
        label = this.label,
        reportsCount = this.reportsCount,
        phoneE164Format = this.phone.e164Format!!
    )
}