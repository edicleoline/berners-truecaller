package com.berners.truecaller.data.local.db.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "incomings")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b9\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u000b\u0010>\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u000b\u0010@\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u0098\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00c6\u0001\u00a2\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u00112\b\u0010L\u001a\u0004\u0018\u00010MH\u00d6\u0003J\t\u0010N\u001a\u00020OH\u00d6\u0001J\t\u0010P\u001a\u00020\u0013H\u00d6\u0001R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018\u00a8\u0006Q"}, d2 = {"Lcom/berners/truecaller/data/local/db/entities/IncomingEntity;", "Lcom/berners/truecaller/data/local/db/entities/TrueEntity;", "id", "", "rid", "createdAt", "updatedAt", "deletedAt", "sourceId", "targetId", "direction", "Lcom/berners/truecaller/model/IncomingDirection;", "decisionOwner", "Lcom/berners/truecaller/model/Owner;", "decisionType", "Lcom/berners/truecaller/model/IncomingDecisionType;", "decisionSpam", "", "decisionMessage", "", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;JJLcom/berners/truecaller/model/IncomingDirection;Lcom/berners/truecaller/model/Owner;Lcom/berners/truecaller/model/IncomingDecisionType;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCreatedAt", "()Ljava/lang/Long;", "setCreatedAt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDecisionMessage", "()Ljava/lang/String;", "setDecisionMessage", "(Ljava/lang/String;)V", "getDecisionOwner", "()Lcom/berners/truecaller/model/Owner;", "setDecisionOwner", "(Lcom/berners/truecaller/model/Owner;)V", "getDecisionSpam", "()Ljava/lang/Boolean;", "setDecisionSpam", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDecisionType", "()Lcom/berners/truecaller/model/IncomingDecisionType;", "setDecisionType", "(Lcom/berners/truecaller/model/IncomingDecisionType;)V", "getDeletedAt", "setDeletedAt", "getDirection", "()Lcom/berners/truecaller/model/IncomingDirection;", "setDirection", "(Lcom/berners/truecaller/model/IncomingDirection;)V", "getId", "setId", "getRid", "setRid", "getSourceId", "()J", "setSourceId", "(J)V", "getTargetId", "setTargetId", "getUpdatedAt", "setUpdatedAt", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;JJLcom/berners/truecaller/model/IncomingDirection;Lcom/berners/truecaller/model/Owner;Lcom/berners/truecaller/model/IncomingDecisionType;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/berners/truecaller/data/local/db/entities/IncomingEntity;", "equals", "other", "", "hashCode", "", "toString", "data_debug"})
public final class IncomingEntity implements com.berners.truecaller.data.local.db.entities.TrueEntity {
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
    @androidx.room.ColumnInfo(name = "source_id")
    private long sourceId;
    @androidx.room.ColumnInfo(name = "target_id")
    private long targetId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "direction")
    private com.berners.truecaller.model.IncomingDirection direction;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "decision_owner")
    private com.berners.truecaller.model.Owner decisionOwner;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "decision_type")
    private com.berners.truecaller.model.IncomingDecisionType decisionType;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "decision_spam")
    private java.lang.Boolean decisionSpam;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "decision_message")
    private java.lang.String decisionMessage;
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.local.db.entities.IncomingEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long rid, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long deletedAt, long sourceId, long targetId, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingDirection direction, @org.jetbrains.annotations.Nullable()
    com.berners.truecaller.model.Owner decisionOwner, @org.jetbrains.annotations.Nullable()
    com.berners.truecaller.model.IncomingDecisionType decisionType, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean decisionSpam, @org.jetbrains.annotations.Nullable()
    java.lang.String decisionMessage) {
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
    
    public IncomingEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long rid, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long deletedAt, long sourceId, long targetId, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingDirection direction, @org.jetbrains.annotations.Nullable()
    com.berners.truecaller.model.Owner decisionOwner, @org.jetbrains.annotations.Nullable()
    com.berners.truecaller.model.IncomingDecisionType decisionType, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean decisionSpam, @org.jetbrains.annotations.Nullable()
    java.lang.String decisionMessage) {
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
    
    public final long getSourceId() {
        return 0L;
    }
    
    public final void setSourceId(long p0) {
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final long getTargetId() {
        return 0L;
    }
    
    public final void setTargetId(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.model.IncomingDirection component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.model.IncomingDirection getDirection() {
        return null;
    }
    
    public final void setDirection(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingDirection p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.model.Owner component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.model.Owner getDecisionOwner() {
        return null;
    }
    
    public final void setDecisionOwner(@org.jetbrains.annotations.Nullable()
    com.berners.truecaller.model.Owner p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.model.IncomingDecisionType component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.model.IncomingDecisionType getDecisionType() {
        return null;
    }
    
    public final void setDecisionType(@org.jetbrains.annotations.Nullable()
    com.berners.truecaller.model.IncomingDecisionType p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getDecisionSpam() {
        return null;
    }
    
    public final void setDecisionSpam(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDecisionMessage() {
        return null;
    }
    
    public final void setDecisionMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
}