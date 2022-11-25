package com.berners.truecaller.data.local.db.daos;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/berners/truecaller/data/local/db/daos/EntityDao;", "Lcom/berners/truecaller/data/local/db/daos/TrueDao;", "Lcom/berners/truecaller/data/local/db/entities/EntityEntity;", "()V", "getEntityByRid", "rid", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract class EntityDao extends com.berners.truecaller.data.local.db.daos.TrueDao<com.berners.truecaller.data.local.db.entities.EntityEntity> {
    
    public EntityDao() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM entities WHERE rid = :rid")
    public abstract java.lang.Object getEntityByRid(long rid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.local.db.entities.EntityEntity> continuation);
}