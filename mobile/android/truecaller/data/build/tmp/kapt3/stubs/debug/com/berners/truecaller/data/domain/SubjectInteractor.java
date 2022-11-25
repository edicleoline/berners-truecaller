package com.berners.truecaller.data.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\t\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/berners/truecaller/data/domain/SubjectInteractor;", "P", "", "T", "()V", "paramState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "createObservable", "Lkotlinx/coroutines/flow/Flow;", "params", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "invoke", "", "(Ljava/lang/Object;)V", "observe", "data_debug"})
public abstract class SubjectInteractor<P extends java.lang.Object, T extends java.lang.Object> {
    private final kotlinx.coroutines.flow.MutableSharedFlow<P> paramState = null;
    
    public SubjectInteractor() {
        super();
    }
    
    public final void invoke(@org.jetbrains.annotations.NotNull()
    P params) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract kotlinx.coroutines.flow.Flow<T> createObservable(@org.jetbrains.annotations.NotNull()
    P params);
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<T> observe() {
        return null;
    }
}