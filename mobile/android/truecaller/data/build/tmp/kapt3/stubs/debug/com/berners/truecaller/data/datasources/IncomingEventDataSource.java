package com.berners.truecaller.data.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/berners/truecaller/data/datasources/IncomingEventDataSource;", "", "save", "", "event", "Lcom/berners/truecaller/model/IncomingEvent;", "incoming", "Lcom/berners/truecaller/model/Incoming;", "(Lcom/berners/truecaller/model/IncomingEvent;Lcom/berners/truecaller/model/Incoming;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface IncomingEventDataSource {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.IncomingEvent event, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.Incoming incoming, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}