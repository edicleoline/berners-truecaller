package com.berners.truecaller.data.local.db.resultentities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/berners/truecaller/data/local/db/resultentities/PhoneEntityDetailed;", "", "()V", "entity", "Lcom/berners/truecaller/data/local/db/entities/EntityEntity;", "getEntity", "()Lcom/berners/truecaller/data/local/db/entities/EntityEntity;", "setEntity", "(Lcom/berners/truecaller/data/local/db/entities/EntityEntity;)V", "phoneEntity", "Lcom/berners/truecaller/data/local/db/entities/PhoneEntity;", "getPhoneEntity", "()Lcom/berners/truecaller/data/local/db/entities/PhoneEntity;", "setPhoneEntity", "(Lcom/berners/truecaller/data/local/db/entities/PhoneEntity;)V", "equals", "", "other", "hashCode", "", "data_debug"})
public final class PhoneEntityDetailed {
    @androidx.room.Embedded()
    public com.berners.truecaller.data.local.db.entities.PhoneEntity phoneEntity;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Relation(parentColumn = "entity_id", entityColumn = "id")
    private com.berners.truecaller.data.local.db.entities.EntityEntity entity;
    
    public PhoneEntityDetailed() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.local.db.entities.PhoneEntity getPhoneEntity() {
        return null;
    }
    
    public final void setPhoneEntity(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.entities.PhoneEntity p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.data.local.db.entities.EntityEntity getEntity() {
        return null;
    }
    
    public final void setEntity(@org.jetbrains.annotations.Nullable()
    com.berners.truecaller.data.local.db.entities.EntityEntity p0) {
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