package com.berners.truecaller.data.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u001f\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/berners/truecaller/data/datasources/TopSpammerDataSource;", "", "listByIncomingType", "Lkotlinx/coroutines/flow/Flow;", "Lcom/berners/truecaller/data/Result;", "", "Lcom/berners/truecaller/model/TopSpammer;", "incomingType", "Lcom/berners/truecaller/model/IncomingType;", "maxResults", "", "saveAll", "", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface TopSpammerDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<java.util.List<com.berners.truecaller.model.TopSpammer>>> listByIncomingType(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingType incomingType, int maxResults);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.berners.truecaller.model.TopSpammer> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}