package com.berners.truecaller.data.local.db.daos;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005H\'\u00a8\u0006\t"}, d2 = {"Lcom/berners/truecaller/data/local/db/daos/IncomingDao;", "Lcom/berners/truecaller/data/local/db/daos/TrueDao;", "Lcom/berners/truecaller/data/local/db/entities/IncomingEntity;", "()V", "incomingsDetailedObservable", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/berners/truecaller/data/local/db/resultentities/IncomingEntityDetailed;", "incomingsObservable", "data_debug"})
public abstract class IncomingDao extends com.berners.truecaller.data.local.db.daos.TrueDao<com.berners.truecaller.data.local.db.entities.IncomingEntity> {
    
    public IncomingDao() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM incomings ORDER BY created_at ASC")
    @androidx.room.Transaction()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.berners.truecaller.data.local.db.entities.IncomingEntity>> incomingsObservable();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM incomings ORDER BY created_at ASC")
    @androidx.room.Transaction()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.berners.truecaller.data.local.db.resultentities.IncomingEntityDetailed>> incomingsDetailedObservable();
}