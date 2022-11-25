package com.berners.truecaller.data.local.db.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "top_spammers", indices = {@androidx.room.Index(unique = true, value = {"phone_e164_format", "incoming_type"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u00c6\u0003JD\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0007H\u00d6\u0001J\t\u0010!\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/berners/truecaller/data/local/db/entities/TopSpammerEntity;", "", "id", "", "label", "", "reportsCount", "", "phoneE164Format", "incomingType", "Lcom/berners/truecaller/model/IncomingType;", "(Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Lcom/berners/truecaller/model/IncomingType;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIncomingType", "()Lcom/berners/truecaller/model/IncomingType;", "getLabel", "()Ljava/lang/String;", "getPhoneE164Format", "getReportsCount", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Lcom/berners/truecaller/model/IncomingType;)Lcom/berners/truecaller/data/local/db/entities/TopSpammerEntity;", "equals", "", "other", "hashCode", "toString", "data_debug"})
public final class TopSpammerEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "label")
    private final java.lang.String label = null;
    @androidx.room.ColumnInfo(name = "reports_count")
    private final int reportsCount = 0;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "phone_e164_format")
    private final java.lang.String phoneE164Format = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "incoming_type")
    private final com.berners.truecaller.model.IncomingType incomingType = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.local.db.entities.TopSpammerEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    java.lang.String label, int reportsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneE164Format, @org.jetbrains.annotations.Nullable()
    com.berners.truecaller.model.IncomingType incomingType) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public TopSpammerEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    java.lang.String label, int reportsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneE164Format, @org.jetbrains.annotations.Nullable()
    com.berners.truecaller.model.IncomingType incomingType) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getReportsCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneE164Format() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.model.IncomingType component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.model.IncomingType getIncomingType() {
        return null;
    }
}