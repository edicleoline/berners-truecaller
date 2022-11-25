package com.berners.truecaller.data.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/berners/truecaller/data/di/LocalModule;", "", "()V", "provideLocalEntityDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalEntityDataSource;", "appDatabase", "Lcom/berners/truecaller/data/local/db/AppDatabase;", "provideLocalIncomingDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalIncomingDataSource;", "provideLocalIncomingEventDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalIncomingEventDataSource;", "provideLocalPhoneDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalPhoneDataSource;", "provideLocalTopSpammerDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalTopSpammerDataSource;", "data_debug"})
@dagger.Module()
public final class LocalModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.berners.truecaller.data.di.LocalModule INSTANCE = null;
    
    private LocalModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.local.datasources.LocalEntityDataSource provideLocalEntityDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.AppDatabase appDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.local.datasources.LocalPhoneDataSource provideLocalPhoneDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.AppDatabase appDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.local.datasources.LocalIncomingDataSource provideLocalIncomingDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.AppDatabase appDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.local.datasources.LocalIncomingEventDataSource provideLocalIncomingEventDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.AppDatabase appDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.local.datasources.LocalTopSpammerDataSource provideLocalTopSpammerDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.AppDatabase appDatabase) {
        return null;
    }
}