package com.berners.truecaller.model

import kotlinx.datetime.Instant

data class Incoming(
    val id: Long? = null,

    val rid: Long? = null,

    val source: Phone,

    val target: Phone,

    val direction: IncomingDirection,

    val state: IncomingState,

) {
    companion object {
        val mock = IncomingMock
    }
}

class IncomingMock {
    companion object {
        val list = listOf(
            Incoming(
                source = Phone(
                    rid = 1, nationalFormat = "(52) 99456-6978", e164Format = "+5552994566978", phone = "52994566978", numberType = PhoneNumberType.MOBILE, dialingCode = "55", countryCode = "BR", location = Location(formatted = "Brasília"),
                    entity = Entity(type = EntityType.PEOPLE, name = "Jair Messias Bolsonaro", verified = false, profileImageUrl = "https://pbs.twimg.com/profile_images/1057631480459886595/9VPdGJJz_200x200.jpg", isUser = true, isUserPremium = false)
                ),
                target = Phone.mock.myPhone,
                direction = IncomingDirection.INCOMING,
                state = IncomingState(
                    events = listOf(
                        IncomingEvent(type = IncomingEventType.CREATED, createdAt = Instant.parse("2022-06-29T14:10:44.475Z"))
                    ),
                    decision = IncomingDecision(owner = Owner.SYSTEM, type = IncomingDecisionType.BLOCK, spam = true)
                )
            ),
            Incoming(
                source = Phone(
                    rid = 2, nationalFormat = "(11) 99456-6978", e164Format = "+5511994566978", phone = "11994566978", numberType = PhoneNumberType.MOBILE, dialingCode = "55", countryCode = "BR", location = Location(formatted = "São Paulo"),
                    entity = Entity(type = EntityType.COMPANY, name = "Banco do Brasil", verified = true, profileImageUrl = "https://scontent.fcgh38-1.fna.fbcdn.net/v/t39.30808-6/270855214_4884897094865454_2906185910092635527_n.jpg?_nc_cat=1&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=-YWrtAERedgAX_PvqkZ&_nc_zt=23&_nc_ht=scontent.fcgh38-1.fna&oh=00_AT8fgnlcWxEO24KNh3Tv8CKCrWoLhW5BW22IqhlYAvXrIQ&oe=62E7C314", primaryColor = "#c5b9d1", isUser = false, isUserPremium = false),
                    tag = Tag(id = 1234, "bank", "Banco", null)
                ),
                target = Phone.mock.myPhone,
                direction = IncomingDirection.INCOMING,
                state = IncomingState(
                    events = listOf(
                        IncomingEvent(type = IncomingEventType.CREATED, createdAt = Instant.parse("2022-06-30T14:10:34.475Z")),
                        IncomingEvent(type = IncomingEventType.MISSED, createdAt = Instant.parse("2022-06-30T14:10:44.475Z"))
                    ),
                    decision = IncomingDecision(owner = Owner.SYSTEM, type = IncomingDecisionType.ALLOW, spam = false)
                )
            ),
            Incoming(
                source = Phone.mock.myPhone,
                target = Phone(
                    nationalFormat = "(48) 93123-0079", e164Format = "+5548931230079", phone = "48931230079", numberType = PhoneNumberType.MOBILE, dialingCode = "55", countryCode = "BR", location = Location(formatted = "Blumenau, SC"),
                    entity = Entity(type = EntityType.PEOPLE, name = "Pedro Cardoso", verified = false, profileImageUrl = "https://pbs.twimg.com/profile_images/859982100904148992/hv5soju7_reasonably_small.jpg", isUser = true, isUserPremium = false)
                ),
                direction = IncomingDirection.OUTGOING,
                state = IncomingState(
                    events = listOf(
                        IncomingEvent(type = IncomingEventType.CREATED, createdAt = Instant.parse("2022-05-30T14:10:44.475Z"))
                    )
                )
            ),
            Incoming(
                target = Phone.mock.myPhone,
                source = Phone(
                    nationalFormat = "(32) 96458-0096", e164Format = "+5532964580096", phone = "32964580096", numberType = PhoneNumberType.MOBILE, dialingCode = "55", countryCode = "BR", location = Location(formatted = "Belo Horizonte, MG"),
                ),
                direction = IncomingDirection.INCOMING,
                state = IncomingState(
                    events = listOf(
                        IncomingEvent(type = IncomingEventType.CREATED, createdAt = Instant.parse("2022-05-19T14:10:44.475Z"))
                    ),
                    decision = IncomingDecision(owner = Owner.USER, type = IncomingDecisionType.BLOCK, spam = false)
                )
            ),
            Incoming(
                source = Phone(
                    rid = 5, nationalFormat = "(11) 4237-9659", e164Format = "+551142399659", phone = "1142399659", numberType = PhoneNumberType.FIXED_LINE, dialingCode = "55", countryCode = "BR", location = Location(formatted = "Jandira, SP"),
                    entity = Entity(id = 123456, type = EntityType.PEOPLE, name = null, verified = false, profileImageUrl = "https://pbs.twimg.com/profile_images/1057631480459886595/9VPdGJJz_200x200.jpg", isUser = true, isUserPremium = false)
                ),
                target = Phone.mock.myPhone,
                direction = IncomingDirection.INCOMING,
                state = IncomingState(
                    events = listOf(
                        IncomingEvent(type = IncomingEventType.CREATED, createdAt = Instant.parse("2022-05-10T14:10:44.475Z")),
                        IncomingEvent(type = IncomingEventType.DECLINED, createdAt = Instant.parse("2022-05-10T14:10:46.475Z"))
                    ),
                    decision = IncomingDecision(owner = Owner.SYSTEM, type = IncomingDecisionType.ALLOW, spam = false)
                )
            ),
            Incoming(
                source = Phone(
                    rid = 6, nationalFormat = "(11) 3637-7840", e164Format = "+551136377840", phone = "1136377840", numberType = PhoneNumberType.FIXED_LINE, dialingCode = "55", countryCode = "BR", location = Location(formatted = "Barueri, SP"),
                ),
                target = Phone.mock.myPhone,
                direction = IncomingDirection.INCOMING,
                state = IncomingState(
                    events = listOf(
                        IncomingEvent(type = IncomingEventType.CREATED, createdAt = Instant.parse("2021-12-26T14:10:44.475Z"))
                    ),
                    decision = IncomingDecision(owner = Owner.SYSTEM, type = IncomingDecisionType.ALLOW, spam = false)
                )
            )
        )
    }
}