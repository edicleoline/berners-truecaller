package com.berners.truecaller.model

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime

data class IncomingState(
    val events: List<IncomingEvent>,
    val decision: IncomingDecision? = null
) {
    val createdAt: Instant
        get() {
            return this.events.first().createdAt
        }

    val missed: Boolean
        get() {
            return events.any { it.type == IncomingEventType.MISSED }
        }

    val declined: Boolean
        get() {
            return events.any { it.type == IncomingEventType.DECLINED }
        }

    val blocked: Boolean
        get() {
            return decision != null && decision.type == IncomingDecisionType.BLOCK
        }

    val spam: Boolean
        get() {
            return decision != null && decision.spam
        }
}

data class IncomingDecision(
    val owner: Owner,
    val type: IncomingDecisionType,
    val spam: Boolean,
    val message: String? = null
)

data class IncomingEvent(
    val type: IncomingEventType,
    val createdAt: Instant
)

enum class IncomingDecisionType {
    ALLOW,
    BLOCK
}

enum class IncomingEventType {
    CREATED,
    STARTED,
    MISSED,
    DECLINED
}