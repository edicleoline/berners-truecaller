package com.berners.truecaller.data.remote.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/berners/truecaller/data/remote/services/TopSpammerService;", "", "listByIncomingType", "Lcom/berners/truecaller/data/remote/model/ResponsePaginated;", "Lcom/berners/truecaller/data/remote/model/TopSpammer;", "incomingType", "Lcom/berners/truecaller/model/IncomingType;", "maxResults", "", "(Lcom/berners/truecaller/model/IncomingType;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface TopSpammerService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v1/top-spammers/{incomingType}")
    public abstract java.lang.Object listByIncomingType(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "incomingType")
    com.berners.truecaller.model.IncomingType incomingType, @retrofit2.http.Query(value = "max_results")
    int maxResults, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.remote.model.ResponsePaginated<com.berners.truecaller.data.remote.model.TopSpammer>> continuation);
}