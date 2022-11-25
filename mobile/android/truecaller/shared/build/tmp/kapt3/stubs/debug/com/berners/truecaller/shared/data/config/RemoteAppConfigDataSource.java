package com.berners.truecaller.shared.data.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\u0011\u0010\u001b\u001a\u00020\u001cH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/berners/truecaller/shared/data/config/RemoteAppConfigDataSource;", "Lcom/berners/truecaller/shared/data/config/AppConfigDataSource;", "firebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "configSettings", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfigSettings;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;Lcom/google/firebase/remoteconfig/FirebaseRemoteConfigSettings;Lkotlinx/coroutines/CoroutineDispatcher;)V", "cacheExpirySeconds", "", "times", "", "", "getTimes", "()Ljava/util/Map;", "getTimestamp", "key", "isAssistantAppFeatureEnabled", "", "isCodelabsFeatureEnabled", "isExploreArFeatureEnabled", "isFeedEnabled", "isMapFeatureEnabled", "isReservationFeatureEnabled", "isSearchScheduleFeatureEnabled", "isSearchUsingRoomFeatureEnabled", "syncStrings", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStrings", "Companion", "shared_debug"})
public final class RemoteAppConfigDataSource implements com.berners.truecaller.shared.data.config.AppConfigDataSource {
    private final com.google.firebase.remoteconfig.FirebaseRemoteConfig firebaseRemoteConfig = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> times = null;
    private final long cacheExpirySeconds = 0L;
    @org.jetbrains.annotations.NotNull()
    public static final com.berners.truecaller.shared.data.config.RemoteAppConfigDataSource.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WIFI_SSID_KEY = "wifi_ssid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WIFI_PASSWORD_KEY = "wifi_password";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAP_FEATURE_ENABLED = "map_enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXPLORE_AR_FEATURE_ENABLED = "explore_ar_enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CODELABS_FEATURE_ENABLED = "codelabs_enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SEARCH_SCHEDULE_FEATURE_ENABLED = "search_schedule_enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SEARCH_USING_ROOM_FEATURE_ENABLED = "search_using_room_enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ASSISTANT_APP_FEATURE_ENABLED = "io_assistant_app_enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESERVATION_FEATURE_ENABLED = "reservation_enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FEED_FEATURE_ENABLED = "feed_enabled";
    private static final long DEFAULT_CACHE_EXPIRY_S = 0L;
    
    @javax.inject.Inject()
    public RemoteAppConfigDataSource(@org.jetbrains.annotations.NotNull()
    com.google.firebase.remoteconfig.FirebaseRemoteConfig firebaseRemoteConfig, @org.jetbrains.annotations.NotNull()
    com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings configSettings, @org.jetbrains.annotations.NotNull()
    @com.berners.truecaller.shared.di.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getTimes() {
        return null;
    }
    
    private final void updateStrings() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object syncStrings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTimestamp(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isMapFeatureEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isExploreArFeatureEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isCodelabsFeatureEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isSearchScheduleFeatureEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isSearchUsingRoomFeatureEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isAssistantAppFeatureEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isReservationFeatureEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isFeedEnabled() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/berners/truecaller/shared/data/config/RemoteAppConfigDataSource$Companion;", "", "()V", "ASSISTANT_APP_FEATURE_ENABLED", "", "CODELABS_FEATURE_ENABLED", "DEFAULT_CACHE_EXPIRY_S", "", "getDEFAULT_CACHE_EXPIRY_S", "()J", "EXPLORE_AR_FEATURE_ENABLED", "FEED_FEATURE_ENABLED", "MAP_FEATURE_ENABLED", "RESERVATION_FEATURE_ENABLED", "SEARCH_SCHEDULE_FEATURE_ENABLED", "SEARCH_USING_ROOM_FEATURE_ENABLED", "WIFI_PASSWORD_KEY", "WIFI_SSID_KEY", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final long getDEFAULT_CACHE_EXPIRY_S() {
            return 0L;
        }
    }
}