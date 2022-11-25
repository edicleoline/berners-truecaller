package com.berners.truecaller.data.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/berners/truecaller/data/di/RepositoryModule;", "", "()V", "provideIncomingEventRepository", "Lcom/berners/truecaller/data/repositories/IncomingEventRepository;", "localIncomingStateDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalIncomingEventDataSource;", "provideIncomingRepository", "Lcom/berners/truecaller/data/repositories/IncomingRepository;", "localIncomingDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalIncomingDataSource;", "providePhoneRepository", "Lcom/berners/truecaller/data/repositories/PhoneRepository;", "remotePhoneDataSource", "Lcom/berners/truecaller/data/remote/datasources/RemotePhoneDataSource;", "localPhoneDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalPhoneDataSource;", "provideTopSpammerRepository", "Lcom/berners/truecaller/data/repositories/TopSpammerRepository;", "remoteTopSpammerDataSource", "Lcom/berners/truecaller/data/remote/datasources/RemoteTopSpammerDataSource;", "localTopSpammerDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalTopSpammerDataSource;", "data_debug"})
@dagger.Module()
public final class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.repositories.PhoneRepository providePhoneRepository(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.remote.datasources.RemotePhoneDataSource remotePhoneDataSource, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.datasources.LocalPhoneDataSource localPhoneDataSource) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.repositories.IncomingRepository provideIncomingRepository(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.datasources.LocalIncomingDataSource localIncomingDataSource) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.repositories.IncomingEventRepository provideIncomingEventRepository(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.datasources.LocalIncomingEventDataSource localIncomingStateDataSource) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.repositories.TopSpammerRepository provideTopSpammerRepository(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.remote.datasources.RemoteTopSpammerDataSource remoteTopSpammerDataSource, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.datasources.LocalTopSpammerDataSource localTopSpammerDataSource) {
        return null;
    }
}