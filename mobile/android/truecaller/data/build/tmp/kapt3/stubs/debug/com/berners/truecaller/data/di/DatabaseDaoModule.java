package com.berners.truecaller.data.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/berners/truecaller/data/di/DatabaseDaoModule;", "", "()V", "provideIncomingDao", "Lcom/berners/truecaller/data/local/db/daos/IncomingDao;", "db", "Lcom/berners/truecaller/data/local/db/AppDatabase;", "data_debug"})
@dagger.Module()
public final class DatabaseDaoModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.berners.truecaller.data.di.DatabaseDaoModule INSTANCE = null;
    
    private DatabaseDaoModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.berners.truecaller.data.local.db.daos.IncomingDao provideIncomingDao(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.AppDatabase db) {
        return null;
    }
}