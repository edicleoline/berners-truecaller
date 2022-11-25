package com.berners.truecaller.data.local.db.resultentities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.berners.truecaller.data.local.db.entities.*
import com.berners.truecaller.model.IncomingState
import com.berners.truecaller.model.Location
import java.util.*

class PhoneEntityDetailed {
    @Embedded
    lateinit var phoneEntity: PhoneEntity

    @Relation(parentColumn = "entity_id", entityColumn = "id")
    var entity: EntityEntity? = null
//
//    @Relation(parentColumn = "location_id", entityColumn = "id")
//    lateinit var location: LocationEntity
//
//    @Relation(parentColumn = "target_id", entityColumn = "id")
//    lateinit var target: PhoneEntity

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is PhoneEntityDetailed -> phoneEntity == other.phoneEntity
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(phoneEntity)
}

fun PhoneEntityDetailed.toModel(): com.berners.truecaller.model.Phone {
    return com.berners.truecaller.model.Phone(
        id = this.phoneEntity.id,
        rid = this.phoneEntity.rid,
        phone = this.phoneEntity.phone,
        e164Format = this.phoneEntity.e164Format,
        nationalFormat = this.phoneEntity.nationalFormat,
        dialingCode = this.phoneEntity.dialingCode,
        countryCode = this.phoneEntity.countryCode,
        numberType = this.phoneEntity.numberType,
        carrier = null,
        location = if (this.phoneEntity.locationFormatted != null && this.phoneEntity.locationFormatted!!.isNotBlank()) {
            Location(formatted = this.phoneEntity.locationFormatted!!)
        } else null,
        entity = this.entity?.toModel()
    )
}

//fun List<IncomingEntityDetailed>.toModel(): List<com.berners.truecaller.model.Incoming> {
//    val list = arrayListOf<com.berners.truecaller.model.Incoming>()
//    for (item in this) list.add(item.toModel())
//    return list.toList()
//}