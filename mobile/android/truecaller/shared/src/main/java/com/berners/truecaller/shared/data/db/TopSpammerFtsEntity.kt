package com.berners.truecaller.shared.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4

/**
 * This class represents TopSpammer data for searching with FTS.
 *
 * The [ColumnInfo] name is explicitly declared to allow flexibility for renaming the data class
 * properties without requiring changing the column name.
 */
@Entity(tableName = "topSpammersFts")
@Fts4
data class TopSpammerFtsEntity(

    /**
     * An FTS entity table always has a column named rowid that is the equivalent of an
     * INTEGER PRIMARY KEY index. Therefore, an FTS entity can only have a single field
     * annotated with PrimaryKey, it must be named rowid and must be of INTEGER affinity.
     *
     * The field can be optionally omitted in the class (as is done here),
     * but can still be used in queries.
     */

    @ColumnInfo(name = "top_spammer_id")
    val topSpammerId: String,

    @ColumnInfo(name = "phone_e164_format")
    val phoneE164Format: String,

    @ColumnInfo(name = "label")
    val label: String
)
