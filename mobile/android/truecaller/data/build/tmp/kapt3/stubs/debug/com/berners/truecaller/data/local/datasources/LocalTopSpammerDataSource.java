package com.berners.truecaller.data.local.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001f\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/berners/truecaller/data/local/datasources/LocalTopSpammerDataSource;", "Lcom/berners/truecaller/data/datasources/TopSpammerDataSource;", "topSpammerDao", "Lcom/berners/truecaller/data/local/db/daos/TopSpammerDao;", "(Lcom/berners/truecaller/data/local/db/daos/TopSpammerDao;)V", "listByIncomingType", "Lkotlinx/coroutines/flow/Flow;", "Lcom/berners/truecaller/data/Result;", "", "Lcom/berners/truecaller/model/TopSpammer;", "incomingType", "Lcom/berners/truecaller/model/IncomingType;", "maxResults", "", "saveAll", "", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public class LocalTopSpammerDataSource implements com.berners.truecaller.data.datasources.TopSpammerDataSource {
    private final com.berners.truecaller.data.local.db.daos.TopSpammerDao topSpammerDao = null;
    
    @javax.inject.Inject()
    public LocalTopSpammerDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.daos.TopSpammerDao topSpammerDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<java.util.List<com.berners.truecaller.model.TopSpammer>>> listByIncomingType(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingType incomingType, int maxResults) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object saveAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.berners.truecaller.model.TopSpammer> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}