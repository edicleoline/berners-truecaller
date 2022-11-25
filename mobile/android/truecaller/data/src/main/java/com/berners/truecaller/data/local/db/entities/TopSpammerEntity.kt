package com.berners.truecaller.data.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index
import com.berners.truecaller.model.IncomingType

@Entity(
    tableName = "top_spammers",
    indices = [
        Index(value = ["phone_e164_format", "incoming_type"], unique = true)
    ]
)
data class TopSpammerEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id: Long?,

    @ColumnInfo(name = "label")
    val label: String,

    @ColumnInfo(name = "reports_count")
    val reportsCount: Int,

    @ColumnInfo(name = "phone_e164_format")
    val phoneE164Format: String,

    @ColumnInfo(name = "incoming_type")
    val incomingType: IncomingType? = null,

    )

fun TopSpammerEntity.toModel(): com.berners.truecaller.model.TopSpammer {
    return com.berners.truecaller.model.TopSpammer(
        label = this.label,
        reportsCount = this.reportsCount,
        incomingType = this.incomingType,
        phone = com.berners.truecaller.model.Phone(
            e164Format = this.phoneE164Format
        )
    )
}

fun List<TopSpammerEntity>.toModelList(): List<com.berners.truecaller.model.TopSpammer> {
    val list : MutableList<com.berners.truecaller.model.TopSpammer> = mutableListOf()
    this.forEach {
        list.add(it.toModel())
    }

    return list
}

fun com.berners.truecaller.model.TopSpammer.toEntity(): TopSpammerEntity {
    return TopSpammerEntity(
        id = 0L,
        label = this.label,
        reportsCount = this.reportsCount,
        phoneE164Format = this.phone.e164Format!!,
        incomingType = this.incomingType
    )
}

fun List<com.berners.truecaller.model.TopSpammer>.toEntityList(): List<TopSpammerEntity> {
    val list : MutableList<TopSpammerEntity> = mutableListOf()
    this.forEach {
        list.add(it.toEntity())
    }

    return list
}