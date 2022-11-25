package com.berners.truecaller.data.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/berners/truecaller/data/domain/ResultInteractor;", "P", "R", "", "()V", "doWork", "params", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeSync", "invoke", "Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "data_debug"})
public abstract class ResultInteractor<P extends java.lang.Object, R extends java.lang.Object> {
    
    public ResultInteractor() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<R> invoke(P params) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object executeSync(P params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super R> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected abstract java.lang.Object doWork(P params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super R> continuation);
}