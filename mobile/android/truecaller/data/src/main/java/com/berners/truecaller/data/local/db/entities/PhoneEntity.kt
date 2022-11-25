package com.berners.truecaller.data.local.db.entities

import androidx.room.*
import com.berners.truecaller.model.Location
import com.berners.truecaller.model.PhoneNumberType

@Entity(
    tableName = "phones",
//    foreignKeys = [
//        ForeignKey(
//            entity = EntityEntity::class,
//            parentColumns = arrayOf("id"),
//            childColumns = arrayOf("entity_id"),
//            onUpdate = ForeignKey.CASCADE,
//            onDelete = ForeignKey.CASCADE
//        )
//    ]
)
data class PhoneEntity(
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

    @ColumnInfo(name = "phone")
    var phone: String,

    @ColumnInfo(name = "e164_format")
    var e164Format: String,

    @ColumnInfo(name = "national_format")
    var nationalFormat: String? = null,

    @ColumnInfo(name = "dialing_code")
    var dialingCode: String? = null,

    @ColumnInfo(name = "country_code")
    var countryCode: String? = null,

    @ColumnInfo(name = "number_type")
    var numberType: PhoneNumberType? = null,

    @ColumnInfo(name = "location_formatted")
    var locationFormatted: String? = null,

    @ColumnInfo(name = "entity_id")
    var entityId: Long? = null,

) : TrueEntity

fun PhoneEntity.toModel(): com.berners.truecaller.model.Phone {
    return com.berners.truecaller.model.Phone(
        id = this.id,
        rid = this.rid,
        phone = this.phone,
        e164Format = this.e164Format,
        nationalFormat = this.nationalFormat,
        dialingCode = this.dialingCode,
        countryCode = this.countryCode,
        numberType = this.numberType,
        location = if (this.locationFormatted != null && this.locationFormatted!!.isNotBlank()) Location(formatted = this.locationFormatted!!) else null
    )
}

fun com.berners.truecaller.model.Phone.toEntity(): PhoneEntity {
    return PhoneEntity(
        id = this.id,
        rid = this.rid,
        phone = this.phone,
        e164Format = this.e164Format,
        nationalFormat = this.nationalFormat,
        dialingCode = this.dialingCode,
        countryCode = this.countryCode,
        numberType = this.numberType,
        locationFormatted = this.location?.formatted
    )
}