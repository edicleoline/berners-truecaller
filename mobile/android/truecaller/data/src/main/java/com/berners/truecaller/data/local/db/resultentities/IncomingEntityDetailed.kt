package com.berners.truecaller.data.local.db.resultentities

import androidx.room.Embedded
import androidx.room.Relation
import com.berners.truecaller.data.local.db.entities.IncomingEntity
import com.berners.truecaller.data.local.db.entities.IncomingEventEntity
import com.berners.truecaller.data.local.db.entities.PhoneEntity
import com.berners.truecaller.data.local.db.entities.toModel
import com.berners.truecaller.model.IncomingDecision
import com.berners.truecaller.model.IncomingState
import java.util.*

class IncomingEntityDetailed {
    @Embedded
    lateinit var incomingEntity: IncomingEntity

    @Relation(parentColumn = "id", entityColumn = "incoming_id")
    lateinit var events: List<IncomingEventEntity>

    @Relation(parentColumn = "source_id", entityColumn = "id", entity = PhoneEntity::class)
    lateinit var source: PhoneEntityDetailed

    @Relation(parentColumn = "target_id", entityColumn = "id", entity = PhoneEntity::class)
    lateinit var target: PhoneEntityDetailed

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is IncomingEntityDetailed -> incomingEntity == other.incomingEntity && events == other.events
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(incomingEntity, events)
}

fun IncomingEntityDetailed.toModel(): com.berners.truecaller.model.Incoming {
    return com.berners.truecaller.model.Incoming(
        id = this.incomingEntity.id,
        rid = this.incomingEntity.rid,
        source = this.source.toModel(),
        target = this.target.toModel(),
        direction = this.incomingEntity.direction,
        state = IncomingState(
            events = events.toModel(),
            decision = try {
                if (this.incomingEntity.decisionType != null) {
                    IncomingDecision(
                        owner = this.incomingEntity.decisionOwner!!,
                        type = this.incomingEntity.decisionType!!,
                        spam = this.incomingEntity.decisionSpam!!,
                        message = this.incomingEntity.decisionMessage)
                } else null
            } catch (e: Exception) {
                null
            }
        )
    )
}

fun List<IncomingEntityDetailed>.toModel(): List<com.berners.truecaller.model.Incoming> {
    val list = arrayListOf<com.berners.truecaller.model.Incoming>()
    for (item in this) list.add(item.toModel())
    return list.toList()
}