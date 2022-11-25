package com.berners.truecaller.shared.domain.settings;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/berners/truecaller/shared/domain/settings/SetAnalyticsSettingUseCase;", "Lcom/berners/truecaller/shared/domain/UseCase;", "", "preferenceStorage", "Lcom/berners/truecaller/shared/data/prefs/PreferenceStorage;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/berners/truecaller/shared/data/prefs/PreferenceStorage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "parameters", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared_debug"})
public class SetAnalyticsSettingUseCase extends com.berners.truecaller.shared.domain.UseCase<java.lang.Boolean, java.lang.Boolean> {
    private final com.berners.truecaller.shared.data.prefs.PreferenceStorage preferenceStorage = null;
    
    @javax.inject.Inject()
    public SetAnalyticsSettingUseCase(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.shared.data.prefs.PreferenceStorage preferenceStorage, @org.jetbrains.annotations.NotNull()
    @com.berners.truecaller.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object execute(boolean parameters, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}