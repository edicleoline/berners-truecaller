package com.berners.truecaller.data.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/berners/truecaller/data/datasources/UserDataSource;", "", "me", "Lkotlinx/coroutines/flow/Flow;", "Lcom/berners/truecaller/data/Result;", "Lcom/berners/truecaller/model/User;", "data_debug"})
public abstract interface UserDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<com.berners.truecaller.model.User>> me();
}