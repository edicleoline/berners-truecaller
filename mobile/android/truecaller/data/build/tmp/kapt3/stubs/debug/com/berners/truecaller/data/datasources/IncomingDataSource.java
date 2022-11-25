package com.berners.truecaller.data.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006"}, d2 = {"Lcom/berners/truecaller/data/datasources/IncomingDataSource;", "", "save", "Lcom/berners/truecaller/model/Incoming;", "incoming", "(Lcom/berners/truecaller/model/Incoming;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface IncomingDataSource {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.Incoming incoming, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.model.Incoming> continuation);
}