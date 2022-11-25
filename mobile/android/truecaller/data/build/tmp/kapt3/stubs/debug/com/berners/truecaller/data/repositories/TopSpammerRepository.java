package com.berners.truecaller.data.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J3\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/berners/truecaller/data/repositories/TopSpammerRepository;", "", "remoteTopSpammerDataSource", "Lcom/berners/truecaller/data/datasources/TopSpammerDataSource;", "localTopSpammerDataSource", "(Lcom/berners/truecaller/data/datasources/TopSpammerDataSource;Lcom/berners/truecaller/data/datasources/TopSpammerDataSource;)V", "listByIncomingType", "Lkotlinx/coroutines/flow/Flow;", "Lcom/berners/truecaller/data/Result;", "", "Lcom/berners/truecaller/model/TopSpammer;", "incomingType", "Lcom/berners/truecaller/model/IncomingType;", "maxResults", "", "(Lcom/berners/truecaller/model/IncomingType;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class TopSpammerRepository {
    private final com.berners.truecaller.data.datasources.TopSpammerDataSource remoteTopSpammerDataSource = null;
    private final com.berners.truecaller.data.datasources.TopSpammerDataSource localTopSpammerDataSource = null;
    
    @javax.inject.Inject()
    public TopSpammerRepository(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.datasources.TopSpammerDataSource remoteTopSpammerDataSource, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.datasources.TopSpammerDataSource localTopSpammerDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object listByIncomingType(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingType incomingType, int maxResults, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.berners.truecaller.data.Result<? extends java.util.List<com.berners.truecaller.model.TopSpammer>>>> continuation) {
        return null;
    }
}