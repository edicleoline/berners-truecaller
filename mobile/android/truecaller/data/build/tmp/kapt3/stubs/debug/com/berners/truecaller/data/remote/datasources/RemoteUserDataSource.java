package com.berners.truecaller.data.remote.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/berners/truecaller/data/remote/datasources/RemoteUserDataSource;", "Lcom/berners/truecaller/data/datasources/UserDataSource;", "service", "Lcom/berners/truecaller/data/remote/services/UserService;", "(Lcom/berners/truecaller/data/remote/services/UserService;)V", "me", "Lkotlinx/coroutines/flow/Flow;", "Lcom/berners/truecaller/data/Result;", "Lcom/berners/truecaller/model/User;", "data_debug"})
public class RemoteUserDataSource implements com.berners.truecaller.data.datasources.UserDataSource {
    private final com.berners.truecaller.data.remote.services.UserService service = null;
    
    @javax.inject.Inject()
    public RemoteUserDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.remote.services.UserService service) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<com.berners.truecaller.model.User>> me() {
        return null;
    }
}