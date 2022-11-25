package com.berners.truecaller.data.remote.model

import com.squareup.moshi.Json

data class Phone(
    @Json(name = "id")
    val id: Long? = null,

    @Json(name = "phone")
    val phone: String = "",

    @Json(name = "e164_format")
    val e164Format: String? = null,

    @Json(name = "national_format")
    val nationalFormat: String? = null,

    @Json(name = "dialing_code")
    val dialingCode: String? = null,

    @Json(name = "country_code")
    val countryCode: String? = null,

    @Json(name = "number_type")
    val numberType: PhoneNumberType? = null,

    @Json(name = "carrier")
    val carrier: Company? = null,

    @Json(name = "entity")
    val entity: Entity? = null,
)

fun Phone.toModel(): com.berners.truecaller.model.Phone {
    return com.berners.truecaller.model.Phone(
        rid = this.id,
        phone = this.phone,
        e164Format = this.e164Format ?: this.phone,
        nationalFormat = this.nationalFormat,
        dialingCode = this.dialingCode,
        countryCode = this.countryCode,
        numberType = this.numberType?.toModel(),
        entity = this.entity?.toModel()
    )
}

//fun Phone.toEntity(): PhoneEntity {
//    return PhoneEntity(
//        rid = this.id,
//        phone = this.phone,
//        e164Format = this.e164Format,
//        nationalFormat = this.nationalFormat,
//        dialingCode = this.dialingCode,
//        countryCode = this.countryCode,
////        entity = this.entity
//    )
//}