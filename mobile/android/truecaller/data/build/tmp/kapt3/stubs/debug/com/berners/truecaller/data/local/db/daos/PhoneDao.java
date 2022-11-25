package com.berners.truecaller.data.local.db.daos;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/berners/truecaller/data/local/db/daos/PhoneDao;", "Lcom/berners/truecaller/data/local/db/daos/TrueDao;", "Lcom/berners/truecaller/data/local/db/entities/PhoneEntity;", "()V", "getPhoneByE164Format", "e164Format", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneByRid", "rid", "data_debug"})
public abstract class PhoneDao extends com.berners.truecaller.data.local.db.daos.TrueDao<com.berners.truecaller.data.local.db.entities.PhoneEntity> {
    
    public PhoneDao() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM phones WHERE id = :id")
    public abstract java.lang.Object getPhoneById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.local.db.entities.PhoneEntity> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM phones WHERE e164_format like :e164Format")
    public abstract java.lang.Object getPhoneByE164Format(@org.jetbrains.annotations.NotNull()
    java.lang.String e164Format, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.local.db.entities.PhoneEntity> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM phones WHERE rid = :rid")
    public abstract java.lang.Object getPhoneByRid(long rid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.local.db.entities.PhoneEntity> continuation);
}