package com.berners.truecaller.model

data class Phone(
    val id: Long? = null,

    val rid: Long? = null,

    val phone: String = "",

    val e164Format: String = "",

    var nationalFormat: String? = "",

    val dialingCode: String? = "",

    val countryCode: String? = "",

    val numberType: PhoneNumberType? = null,

    val carrier: Company? = null,

    var location: Location? = null,

    val entity: Entity? = null,

    val tag: Tag? = null
) {
    companion object {
        val mock = PhoneMock
    }
}

class PhoneMock {
    companion object {
        val myPhone = Phone(
            rid = 10,
            nationalFormat = "(11) 99442-3173",
            e164Format = "+5511994423173",
            phone = "11994423173",
            numberType = PhoneNumberType.MOBILE,
            dialingCode = "55",
            countryCode = "BR",
            location = Location(formatted = "São Paulo, SP")
        )
    }
}