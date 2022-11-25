package com.berners.truecaller.shared.analytics;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\rH&\u00a8\u0006\u0010"}, d2 = {"Lcom/berners/truecaller/shared/analytics/AnalyticsHelper;", "", "logUiEvent", "", "itemId", "", "action", "sendScreenView", "screenName", "activity", "Landroid/app/Activity;", "setUserRegistered", "isRegistered", "", "setUserSignedIn", "isSignedIn", "shared_debug"})
public abstract interface AnalyticsHelper {
    
    public abstract void sendScreenView(@org.jetbrains.annotations.NotNull()
    java.lang.String screenName, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity);
    
    public abstract void logUiEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId, @org.jetbrains.annotations.NotNull()
    java.lang.String action);
    
    public abstract void setUserSignedIn(boolean isSignedIn);
    
    public abstract void setUserRegistered(boolean isRegistered);
}