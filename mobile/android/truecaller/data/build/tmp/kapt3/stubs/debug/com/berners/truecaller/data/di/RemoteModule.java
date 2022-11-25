package com.berners.truecaller.data.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u0012\u0010\u0011\u001a\u00020\r2\b\b\u0001\u0010\u0012\u001a\u00020\tH\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0015H\u0007J\u0012\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u00020\u00192\b\b\u0001\u0010\f\u001a\u00020\rH\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/berners/truecaller/data/di/RemoteModule;", "", "()V", "provideHttpClient", "Lokhttp3/OkHttpClient;", "interceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideHttpLoggingInterceptor", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "providePhoneService", "Lcom/berners/truecaller/data/remote/services/PhoneService;", "retrofit", "Lretrofit2/Retrofit;", "provideRemotePhoneDataSource", "Lcom/berners/truecaller/data/remote/datasources/RemotePhoneDataSource;", "service", "provideRetrofitBuilder", "moshi", "provideTopSpammerDataSource", "Lcom/berners/truecaller/data/remote/datasources/RemoteTopSpammerDataSource;", "Lcom/berners/truecaller/data/remote/services/TopSpammerService;", "provideTopSpammerService", "provideUserDataSource", "Lcom/berners/truecaller/data/remote/datasources/RemoteUserDataSource;", "Lcom/berners/truecaller/data/remote/services/UserService;", "provideUserService", "data_debug"})
@dagger.Module()
public final class RemoteModule {
    
    public RemoteModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final okhttp3.logging.HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final okhttp3.OkHttpClient provideHttpClient(@org.jetbrains.annotations.NotNull()
    okhttp3.logging.HttpLoggingInterceptor interceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "moshi")
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.squareup.moshi.Moshi provideMoshi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "retrofit")
    @dagger.Provides()
    @javax.inject.Singleton()
    public final retrofit2.Retrofit provideRetrofitBuilder(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "moshi")
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.remote.services.PhoneService providePhoneService(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "retrofit")
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.remote.datasources.RemotePhoneDataSource provideRemotePhoneDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.remote.services.PhoneService service) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.remote.services.TopSpammerService provideTopSpammerService(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "retrofit")
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.remote.datasources.RemoteTopSpammerDataSource provideTopSpammerDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.remote.services.TopSpammerService service) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.remote.services.UserService provideUserService(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "retrofit")
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.data.remote.datasources.RemoteUserDataSource provideUserDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.remote.services.UserService service) {
        return null;
    }
}