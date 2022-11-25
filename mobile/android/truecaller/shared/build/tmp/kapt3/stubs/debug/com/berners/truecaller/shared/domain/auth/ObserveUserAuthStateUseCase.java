package com.berners.truecaller.shared.domain.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/berners/truecaller/shared/domain/auth/ObserveUserAuthStateUseCase;", "Lcom/berners/truecaller/shared/domain/FlowUseCase;", "", "Lcom/berners/truecaller/shared/data/signin/AuthenticatedUserInfo;", "externalScope", "Lkotlinx/coroutines/CoroutineScope;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "authStateChanges", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/berners/truecaller/shared/result/Result;", "observeUserRegisteredChangesJob", "Lkotlinx/coroutines/Job;", "execute", "Lkotlinx/coroutines/flow/Flow;", "parameters", "shared_debug"})
@javax.inject.Singleton()
public class ObserveUserAuthStateUseCase extends com.berners.truecaller.shared.domain.FlowUseCase<java.lang.Object, com.berners.truecaller.shared.data.signin.AuthenticatedUserInfo> {
    private final kotlinx.coroutines.CoroutineScope externalScope = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private kotlinx.coroutines.Job observeUserRegisteredChangesJob;
    private final kotlinx.coroutines.flow.SharedFlow<com.berners.truecaller.shared.result.Result<com.berners.truecaller.shared.data.signin.AuthenticatedUserInfo>> authStateChanges = null;
    
    @javax.inject.Inject()
    public ObserveUserAuthStateUseCase(@org.jetbrains.annotations.NotNull()
    @com.berners.truecaller.shared.di.ApplicationScope()
    kotlinx.coroutines.CoroutineScope externalScope, @org.jetbrains.annotations.NotNull()
    @com.berners.truecaller.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected kotlinx.coroutines.flow.Flow<com.berners.truecaller.shared.result.Result<com.berners.truecaller.shared.data.signin.AuthenticatedUserInfo>> execute(@org.jetbrains.annotations.NotNull()
    java.lang.Object parameters) {
        return null;
    }
}