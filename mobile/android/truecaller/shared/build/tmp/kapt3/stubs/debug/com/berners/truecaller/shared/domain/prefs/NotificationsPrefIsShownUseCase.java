package com.berners.truecaller.shared.domain.prefs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/berners/truecaller/shared/domain/prefs/NotificationsPrefIsShownUseCase;", "Lcom/berners/truecaller/shared/domain/UseCase;", "", "", "preferenceStorage", "Lcom/berners/truecaller/shared/data/prefs/PreferenceStorage;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/berners/truecaller/shared/data/prefs/PreferenceStorage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "parameters", "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared_debug"})
public class NotificationsPrefIsShownUseCase extends com.berners.truecaller.shared.domain.UseCase<kotlin.Unit, java.lang.Boolean> {
    private final com.berners.truecaller.shared.data.prefs.PreferenceStorage preferenceStorage = null;
    
    @javax.inject.Inject()
    public NotificationsPrefIsShownUseCase(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.shared.data.prefs.PreferenceStorage preferenceStorage, @org.jetbrains.annotations.NotNull()
    @com.berners.truecaller.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    kotlin.Unit parameters, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}