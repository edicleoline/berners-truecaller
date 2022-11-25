package com.berners.truecaller.data.local.db.entities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/berners/truecaller/data/local/db/entities/TrueEntity;", "", "createdAt", "", "getCreatedAt", "()Ljava/lang/Long;", "setCreatedAt", "(Ljava/lang/Long;)V", "deletedAt", "getDeletedAt", "setDeletedAt", "id", "getId", "setId", "updatedAt", "getUpdatedAt", "setUpdatedAt", "data_debug"})
public abstract interface TrueEntity {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Long getId();
    
    public abstract void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Long getCreatedAt();
    
    public abstract void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Long getUpdatedAt();
    
    public abstract void setUpdatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Long getDeletedAt();
    
    public abstract void setDeletedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0);
}