package com.berners.truecaller.data.local.db.daos;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/berners/truecaller/data/local/db/daos/TopSpammerDao;", "", "all", "", "Lcom/berners/truecaller/data/local/db/entities/TopSpammerEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listByIncomingType", "incomingType", "Lcom/berners/truecaller/model/IncomingType;", "(Lcom/berners/truecaller/model/IncomingType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface TopSpammerDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM top_spammers")
    public abstract java.lang.Object all(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.berners.truecaller.data.local.db.entities.TopSpammerEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM top_spammers WHERE incoming_type LIKE :incomingType")
    public abstract java.lang.Object listByIncomingType(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingType incomingType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.berners.truecaller.data.local.db.entities.TopSpammerEntity>> continuation);
}