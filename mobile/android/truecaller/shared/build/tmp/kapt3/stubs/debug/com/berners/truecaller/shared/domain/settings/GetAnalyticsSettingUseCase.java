package com.berners.truecaller.shared.domain.settings;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ!\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\n2\u0006\u0010\f\u001a\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/berners/truecaller/shared/domain/settings/GetAnalyticsSettingUseCase;", "Lcom/berners/truecaller/shared/domain/FlowUseCase;", "", "", "preferenceStorage", "Lcom/berners/truecaller/shared/data/prefs/PreferenceStorage;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/berners/truecaller/shared/data/prefs/PreferenceStorage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "Lkotlinx/coroutines/flow/Flow;", "Lcom/berners/truecaller/shared/result/Result$Success;", "parameters", "(Lkotlin/Unit;)Lkotlinx/coroutines/flow/Flow;", "shared_debug"})
public final class GetAnalyticsSettingUseCase extends com.berners.truecaller.shared.domain.FlowUseCase<kotlin.Unit, java.lang.Boolean> {
    private final com.berners.truecaller.shared.data.prefs.PreferenceStorage preferenceStorage = null;
    
    @javax.inject.Inject()
    public GetAnalyticsSettingUseCase(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.shared.data.prefs.PreferenceStorage preferenceStorage, @org.jetbrains.annotations.NotNull()
    @com.berners.truecaller.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected kotlinx.coroutines.flow.Flow<com.berners.truecaller.shared.result.Result.Success<java.lang.Boolean>> execute(@org.jetbrains.annotations.NotNull()
    kotlin.Unit parameters) {
        return null;
    }
}