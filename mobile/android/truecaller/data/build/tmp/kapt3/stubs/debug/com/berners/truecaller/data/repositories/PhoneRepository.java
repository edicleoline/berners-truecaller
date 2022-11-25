package com.berners.truecaller.data.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J!\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00100\n2\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/berners/truecaller/data/repositories/PhoneRepository;", "", "remotePhoneDataSource", "Lcom/berners/truecaller/data/datasources/PhoneDataSource;", "localPhoneDataSource", "(Lcom/berners/truecaller/data/datasources/PhoneDataSource;Lcom/berners/truecaller/data/datasources/PhoneDataSource;)V", "getLocalPhoneDataSource", "()Lcom/berners/truecaller/data/datasources/PhoneDataSource;", "getRemotePhoneDataSource", "findByE164Format", "Lkotlinx/coroutines/flow/Flow;", "Lcom/berners/truecaller/model/Phone;", "e164Format", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneByIdStream", "Lcom/berners/truecaller/data/Result;", "id", "", "data_debug"})
public final class PhoneRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.berners.truecaller.data.datasources.PhoneDataSource remotePhoneDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final com.berners.truecaller.data.datasources.PhoneDataSource localPhoneDataSource = null;
    
    @javax.inject.Inject()
    public PhoneRepository(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.datasources.PhoneDataSource remotePhoneDataSource, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.datasources.PhoneDataSource localPhoneDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.datasources.PhoneDataSource getRemotePhoneDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.datasources.PhoneDataSource getLocalPhoneDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<com.berners.truecaller.model.Phone>> getPhoneByIdStream(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object findByE164Format(@org.jetbrains.annotations.NotNull()
    java.lang.String e164Format, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.berners.truecaller.model.Phone>> continuation) {
        return null;
    }
}