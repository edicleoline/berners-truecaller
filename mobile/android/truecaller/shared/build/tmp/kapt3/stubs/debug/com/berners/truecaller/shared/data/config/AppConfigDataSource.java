package com.berners.truecaller.shared.data.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\u0011\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/berners/truecaller/shared/data/config/AppConfigDataSource;", "", "getTimestamp", "", "key", "isAssistantAppFeatureEnabled", "", "isCodelabsFeatureEnabled", "isExploreArFeatureEnabled", "isFeedEnabled", "isMapFeatureEnabled", "isReservationFeatureEnabled", "isSearchScheduleFeatureEnabled", "isSearchUsingRoomFeatureEnabled", "syncStrings", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shared_debug"})
public abstract interface AppConfigDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getTimestamp(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    /**
     * Sync the strings with the latest values with Remote Config
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object syncStrings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    public abstract boolean isMapFeatureEnabled();
    
    public abstract boolean isExploreArFeatureEnabled();
    
    public abstract boolean isCodelabsFeatureEnabled();
    
    public abstract boolean isSearchScheduleFeatureEnabled();
    
    public abstract boolean isSearchUsingRoomFeatureEnabled();
    
    public abstract boolean isAssistantAppFeatureEnabled();
    
    public abstract boolean isReservationFeatureEnabled();
    
    public abstract boolean isFeedEnabled();
}