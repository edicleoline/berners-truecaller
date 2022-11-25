package com.berners.truecaller.data.local.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0019\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/berners/truecaller/data/local/datasources/LocalEntityDataSource;", "Lcom/berners/truecaller/data/datasources/EntityDataSource;", "entityDao", "Lcom/berners/truecaller/data/local/db/daos/EntityDao;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/berners/truecaller/data/local/db/daos/EntityDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getEntityByIdStream", "Lkotlinx/coroutines/flow/Flow;", "Lcom/berners/truecaller/data/Result;", "Lcom/berners/truecaller/model/Entity;", "id", "", "save", "entity", "(Lcom/berners/truecaller/model/Entity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public class LocalEntityDataSource implements com.berners.truecaller.data.datasources.EntityDataSource {
    private final com.berners.truecaller.data.local.db.daos.EntityDao entityDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    
    @javax.inject.Inject()
    public LocalEntityDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.daos.EntityDao entityDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<com.berners.truecaller.model.Entity>> getEntityByIdStream(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.Entity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.model.Entity> continuation) {
        return null;
    }
}