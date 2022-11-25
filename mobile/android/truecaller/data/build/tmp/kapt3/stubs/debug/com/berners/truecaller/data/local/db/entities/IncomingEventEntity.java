package com.berners.truecaller.data.local.db.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "incoming_events", foreignKeys = {@androidx.room.ForeignKey(entity = com.berners.truecaller.data.local.db.entities.IncomingEntity.class, childColumns = {"incoming_id"}, onUpdate = 5, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\nH\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003Jh\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u00d6\u0003J\t\u00102\u001a\u000203H\u00d6\u0001J\t\u00104\u001a\u000205H\u00d6\u0001R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010\u00a8\u00066"}, d2 = {"Lcom/berners/truecaller/data/local/db/entities/IncomingEventEntity;", "Lcom/berners/truecaller/data/local/db/entities/TrueEntity;", "id", "", "rid", "createdAt", "updatedAt", "deletedAt", "incomingId", "type", "Lcom/berners/truecaller/model/IncomingEventType;", "timestamp", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;JLcom/berners/truecaller/model/IncomingEventType;J)V", "getCreatedAt", "()Ljava/lang/Long;", "setCreatedAt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDeletedAt", "setDeletedAt", "getId", "setId", "getIncomingId", "()J", "setIncomingId", "(J)V", "getRid", "setRid", "getTimestamp", "setTimestamp", "getType", "()Lcom/berners/truecaller/model/IncomingEventType;", "setType", "(Lcom/berners/truecaller/model/IncomingEventType;)V", "getUpdatedAt", "setUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;JLcom/berners/truecaller/model/IncomingEventType;J)Lcom/berners/truecaller/data/local/db/entities/IncomingEventEntity;", "equals", "", "other", "", "hashCode", "", "toString", "", "data_debug"})
public final class IncomingEventEntity implements com.berners.truecaller.data.local.db.entities.TrueEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Long id;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "rid")
    private java.lang.Long rid;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "created_at")
    private java.lang.Long createdAt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "updated_at")
    private java.lang.Long updatedAt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "deleted_at")
    private java.lang.Long deletedAt;
    @androidx.room.ColumnInfo(name = "incoming_id")
    private long incomingId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "event_type")
    private com.berners.truecaller.model.IncomingEventType type;
    @androidx.room.ColumnInfo(name = "timestamp")
    private long timestamp;
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.local.db.entities.IncomingEventEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long rid, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long deletedAt, long incomingId, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingEventType type, long timestamp) {
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
    
    public IncomingEventEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long rid, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long deletedAt, long incomingId, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingEventType type, long timestamp) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getId() {
        return null;
    }
    
    @java.lang.Override()
    public void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getRid() {
        return null;
    }
    
    public final void setRid(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getCreatedAt() {
        return null;
    }
    
    @java.lang.Override()
    public void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getUpdatedAt() {
        return null;
    }
    
    @java.lang.Override()
    public void setUpdatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getDeletedAt() {
        return null;
    }
    
    @java.lang.Override()
    public void setDeletedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final long getIncomingId() {
        return 0L;
    }
    
    public final void setIncomingId(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.model.IncomingEventType component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.model.IncomingEventType getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingEventType p0) {
    }
    
    public final long component8() {
        return 0L;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    public final void setTimestamp(long p0) {
    }
}