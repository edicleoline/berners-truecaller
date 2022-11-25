package com.berners.truecaller.data.local.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/berners/truecaller/data/local/datasources/LocalIncomingDataSource;", "Lcom/berners/truecaller/data/datasources/IncomingDataSource;", "incomingDao", "Lcom/berners/truecaller/data/local/db/daos/IncomingDao;", "localPhoneDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalPhoneDataSource;", "localIncomingEventDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalIncomingEventDataSource;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/berners/truecaller/data/local/db/daos/IncomingDao;Lcom/berners/truecaller/data/local/datasources/LocalPhoneDataSource;Lcom/berners/truecaller/data/local/datasources/LocalIncomingEventDataSource;Lkotlinx/coroutines/CoroutineDispatcher;)V", "save", "Lcom/berners/truecaller/model/Incoming;", "incoming", "(Lcom/berners/truecaller/model/Incoming;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public class LocalIncomingDataSource implements com.berners.truecaller.data.datasources.IncomingDataSource {
    private final com.berners.truecaller.data.local.db.daos.IncomingDao incomingDao = null;
    private final com.berners.truecaller.data.local.datasources.LocalPhoneDataSource localPhoneDataSource = null;
    private final com.berners.truecaller.data.local.datasources.LocalIncomingEventDataSource localIncomingEventDataSource = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    
    @javax.inject.Inject()
    public LocalIncomingDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.daos.IncomingDao incomingDao, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.datasources.LocalPhoneDataSource localPhoneDataSource, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.datasources.LocalIncomingEventDataSource localIncomingEventDataSource, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.Incoming incoming, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.model.Incoming> continuation) {
        return null;
    }
}