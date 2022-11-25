package com.berners.truecaller.data.local.db.resultentities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/berners/truecaller/data/local/db/resultentities/IncomingEntityDetailed;", "", "()V", "events", "", "Lcom/berners/truecaller/data/local/db/entities/IncomingEventEntity;", "getEvents", "()Ljava/util/List;", "setEvents", "(Ljava/util/List;)V", "incomingEntity", "Lcom/berners/truecaller/data/local/db/entities/IncomingEntity;", "getIncomingEntity", "()Lcom/berners/truecaller/data/local/db/entities/IncomingEntity;", "setIncomingEntity", "(Lcom/berners/truecaller/data/local/db/entities/IncomingEntity;)V", "source", "Lcom/berners/truecaller/data/local/db/resultentities/PhoneEntityDetailed;", "getSource", "()Lcom/berners/truecaller/data/local/db/resultentities/PhoneEntityDetailed;", "setSource", "(Lcom/berners/truecaller/data/local/db/resultentities/PhoneEntityDetailed;)V", "target", "getTarget", "setTarget", "equals", "", "other", "hashCode", "", "data_debug"})
public final class IncomingEntityDetailed {
    @androidx.room.Embedded()
    public com.berners.truecaller.data.local.db.entities.IncomingEntity incomingEntity;
    @androidx.room.Relation(parentColumn = "id", entityColumn = "incoming_id")
    public java.util.List<com.berners.truecaller.data.local.db.entities.IncomingEventEntity> events;
    @androidx.room.Relation(parentColumn = "source_id", entityColumn = "id", entity = com.berners.truecaller.data.local.db.entities.PhoneEntity.class)
    public com.berners.truecaller.data.local.db.resultentities.PhoneEntityDetailed source;
    @androidx.room.Relation(parentColumn = "target_id", entityColumn = "id", entity = com.berners.truecaller.data.local.db.entities.PhoneEntity.class)
    public com.berners.truecaller.data.local.db.resultentities.PhoneEntityDetailed target;
    
    public IncomingEntityDetailed() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.local.db.entities.IncomingEntity getIncomingEntity() {
        return null;
    }
    
    public final void setIncomingEntity(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.entities.IncomingEntity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.berners.truecaller.data.local.db.entities.IncomingEventEntity> getEvents() {
        return null;
    }
    
    public final void setEvents(@org.jetbrains.annotations.NotNull()
    java.util.List<com.berners.truecaller.data.local.db.entities.IncomingEventEntity> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.local.db.resultentities.PhoneEntityDetailed getSource() {
        return null;
    }
    
    public final void setSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.resultentities.PhoneEntityDetailed p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.local.db.resultentities.PhoneEntityDetailed getTarget() {
        return null;
    }
    
    public final void setTarget(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.resultentities.PhoneEntityDetailed p0) {
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
}