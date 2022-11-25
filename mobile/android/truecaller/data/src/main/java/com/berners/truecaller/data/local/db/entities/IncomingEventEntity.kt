package com.berners.truecaller.data.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.berners.truecaller.model.EntityType
import com.berners.truecaller.model.IncomingDirection
import com.berners.truecaller.model.IncomingEventType
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

@Entity(
    tableName = "incoming_events",
    foreignKeys = [
        ForeignKey(
            entity = IncomingEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("incoming_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class IncomingEventEntity(
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

    @ColumnInfo(name = "incoming_id")
    var incomingId: Long = 0L,

    @ColumnInfo(name = "event_type")
    var type: IncomingEventType,

    @ColumnInfo(name = "timestamp")
    var timestamp: Long,

) : TrueEntity

fun IncomingEventEntity.toModel(): com.berners.truecaller.model.IncomingEvent {
    return com.berners.truecaller.model.IncomingEvent(
        type = this.type,
        createdAt = Instant.fromEpochMilliseconds(this.timestamp)
    )
}

fun List<IncomingEventEntity>.toModel(): List<com.berners.truecaller.model.IncomingEvent> {
    val list = arrayListOf<com.berners.truecaller.model.IncomingEvent>()
    for (item in this) list.add(item.toModel())
    return list.toList()
}

fun com.berners.truecaller.model.IncomingEvent.toEntity(): IncomingEventEntity {
    return IncomingEventEntity(
        type = this.type,
        timestamp = this.createdAt.toEpochMilliseconds()
    )
}