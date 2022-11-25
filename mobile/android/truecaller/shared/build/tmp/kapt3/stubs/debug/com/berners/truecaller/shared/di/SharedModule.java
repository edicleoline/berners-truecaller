package com.berners.truecaller.shared.di;

import java.lang.System;

/**
 * Module where classes created in the shared module are created.
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/berners/truecaller/shared/di/SharedModule;", "", "()V", "provideAppConfigDataSource", "Lcom/berners/truecaller/shared/data/config/AppConfigDataSource;", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "configSettings", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfigSettings;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "provideArDebugFlagEndpoint", "Lcom/berners/truecaller/shared/data/ar/ArDebugFlagEndpoint;", "functions", "Lcom/google/firebase/functions/FirebaseFunctions;", "provideFirebaseFireStore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "provideFirebaseFunctions", "provideFirebaseRemoteConfig", "provideFirebaseRemoteConfigSettings", "provideTopicSubscriber", "Lcom/berners/truecaller/shared/fcm/TopicSubscriber;", "shared_debug"})
@dagger.Module()
public final class SharedModule {
    
    public SharedModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.google.firebase.firestore.FirebaseFirestore provideFirebaseFireStore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.google.firebase.functions.FirebaseFunctions provideFirebaseFunctions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.shared.data.ar.ArDebugFlagEndpoint provideArDebugFlagEndpoint(@org.jetbrains.annotations.NotNull()
    com.google.firebase.functions.FirebaseFunctions functions) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.shared.fcm.TopicSubscriber provideTopicSubscriber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings provideFirebaseRemoteConfigSettings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.google.firebase.remoteconfig.FirebaseRemoteConfig provideFirebaseRemoteConfig(@org.jetbrains.annotations.NotNull()
    com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings configSettings) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.berners.truecaller.shared.data.config.AppConfigDataSource provideAppConfigDataSource(@org.jetbrains.annotations.NotNull()
    com.google.firebase.remoteconfig.FirebaseRemoteConfig remoteConfig, @org.jetbrains.annotations.NotNull()
    com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings configSettings, @org.jetbrains.annotations.NotNull()
    @IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        return null;
    }
}