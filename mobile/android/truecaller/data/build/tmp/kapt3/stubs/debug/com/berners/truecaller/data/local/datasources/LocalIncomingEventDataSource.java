package com.berners.truecaller.data.local.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/berners/truecaller/data/local/datasources/LocalIncomingEventDataSource;", "Lcom/berners/truecaller/data/datasources/IncomingEventDataSource;", "incomingEventDao", "Lcom/berners/truecaller/data/local/db/daos/IncomingEventDao;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/berners/truecaller/data/local/db/daos/IncomingEventDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "save", "", "event", "Lcom/berners/truecaller/model/IncomingEvent;", "incoming", "Lcom/berners/truecaller/model/Incoming;", "(Lcom/berners/truecaller/model/IncomingEvent;Lcom/berners/truecaller/model/Incoming;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public class LocalIncomingEventDataSource implements com.berners.truecaller.data.datasources.IncomingEventDataSource {
    private final com.berners.truecaller.data.local.db.daos.IncomingEventDao incomingEventDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    
    @javax.inject.Inject()
    public LocalIncomingEventDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.daos.IncomingEventDao incomingEventDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingEvent event, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.Incoming incoming, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}