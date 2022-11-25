package com.berners.truecaller.data.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.berners.truecaller.model.*

@Entity(tableName = "incomings")
data class IncomingEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override var id: Long? = null,

    @ColumnInfo(name = "rid")
    var rid: Long? = null,

    @ColumnInfo(name = "created_at")
    override var createdAt: Long? = null,

    @ColumnInfo(name = "updated_at")
    override var updatedAt: Long? = null,

    @ColumnInfo(name = "deleted_at")
    override var deletedAt: Long? = null,

    @ColumnInfo(name = "source_id")
    var sourceId: Long,

    @ColumnInfo(name = "target_id")
    var targetId: Long,

    @ColumnInfo(name = "direction")
    var direction: IncomingDirection,

    @ColumnInfo(name = "decision_owner")
    var decisionOwner: Owner? = null,

    @ColumnInfo(name = "decision_type")
    var decisionType: IncomingDecisionType? = null,

    @ColumnInfo(name = "decision_spam")
    var decisionSpam: Boolean? = null,

    @ColumnInfo(name = "decision_message")
    var decisionMessage: String? = null,

) : TrueEntity

fun IncomingEntity.toModel(): com.berners.truecaller.model.Incoming {
    return com.berners.truecaller.model.Incoming(
        id = this.id,
        rid = this.rid,
        source = Phone(),
        target = Phone(),
        direction = this.direction,
        state = IncomingState(
            events = emptyList(),
            decision = try {
                if (this.decisionType != null) {
                    IncomingDecision(owner = this.decisionOwner!!, type = this.decisionType!!, spam = this.decisionSpam!!, message = this.decisionMessage!!)
                } else null
            } catch (e: Exception) {
                null
            }
        )
    )
}

fun com.berners.truecaller.model.Incoming.toEntity(): IncomingEntity {
    return IncomingEntity(
        id = this.id,
        rid = this.rid,
        sourceId = this.source.id!!,
        targetId = this.target.id!!,
        direction = this.direction,
        decisionType = this.state.decision?.type,
        decisionOwner = this.state.decision?.owner,
        decisionSpam = this.state.decision?.spam,
        decisionMessage = this.state.decision?.message
    )
}