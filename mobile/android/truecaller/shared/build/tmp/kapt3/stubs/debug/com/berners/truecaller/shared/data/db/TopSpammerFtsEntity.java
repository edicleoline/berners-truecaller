package com.berners.truecaller.shared.data.db;

import java.lang.System;

/**
 * This class represents TopSpammer data for searching with FTS.
 *
 * The [ColumnInfo] name is explicitly declared to allow flexibility for renaming the data class
 * properties without requiring changing the column name.
 */
@androidx.room.Fts4()
@androidx.room.Entity(tableName = "topSpammersFts")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/berners/truecaller/shared/data/db/TopSpammerFtsEntity;", "", "topSpammerId", "", "phoneE164Format", "label", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getPhoneE164Format", "getTopSpammerId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "shared_debug"})
public final class TopSpammerFtsEntity {
    
    /**
     * An FTS entity table always has a column named rowid that is the equivalent of an
     * INTEGER PRIMARY KEY index. Therefore, an FTS entity can only have a single field
     * annotated with PrimaryKey, it must be named rowid and must be of INTEGER affinity.
     *
     * The field can be optionally omitted in the class (as is done here),
     * but can still be used in queries.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "top_spammer_id")
    private final java.lang.String topSpammerId = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "phone_e164_format")
    private final java.lang.String phoneE164Format = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "label")
    private final java.lang.String label = null;
    
    /**
     * This class represents TopSpammer data for searching with FTS.
     *
     * The [ColumnInfo] name is explicitly declared to allow flexibility for renaming the data class
     * properties without requiring changing the column name.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.shared.data.db.TopSpammerFtsEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String topSpammerId, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneE164Format, @org.jetbrains.annotations.NotNull()
    java.lang.String label) {
        return null;
    }
    
    /**
     * This class represents TopSpammer data for searching with FTS.
     *
     * The [ColumnInfo] name is explicitly declared to allow flexibility for renaming the data class
     * properties without requiring changing the column name.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * This class represents TopSpammer data for searching with FTS.
     *
     * The [ColumnInfo] name is explicitly declared to allow flexibility for renaming the data class
     * properties without requiring changing the column name.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * This class represents TopSpammer data for searching with FTS.
     *
     * The [ColumnInfo] name is explicitly declared to allow flexibility for renaming the data class
     * properties without requiring changing the column name.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public TopSpammerFtsEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String topSpammerId, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneE164Format, @org.jetbrains.annotations.NotNull()
    java.lang.String label) {
        super();
    }
    
    /**
     * An FTS entity table always has a column named rowid that is the equivalent of an
     * INTEGER PRIMARY KEY index. Therefore, an FTS entity can only have a single field
     * annotated with PrimaryKey, it must be named rowid and must be of INTEGER affinity.
     *
     * The field can be optionally omitted in the class (as is done here),
     * but can still be used in queries.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    /**
     * An FTS entity table always has a column named rowid that is the equivalent of an
     * INTEGER PRIMARY KEY index. Therefore, an FTS entity can only have a single field
     * annotated with PrimaryKey, it must be named rowid and must be of INTEGER affinity.
     *
     * The field can be optionally omitted in the class (as is done here),
     * but can still be used in queries.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTopSpammerId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneE164Format() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
}