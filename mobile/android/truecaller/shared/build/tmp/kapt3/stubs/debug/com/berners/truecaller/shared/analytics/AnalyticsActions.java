package com.berners.truecaller.shared.analytics;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/berners/truecaller/shared/analytics/AnalyticsActions;", "", "()V", "CLICK", "", "DISABLE", "ENABLE", "HOME_TO_ANNOUNCEMENTS", "HOME_TO_LIVESTREAM", "HOME_TO_MAP", "HOME_TO_SCHEDULE", "HOME_TO_SESSION_DETAIL", "HOME_TO_SIGN_IN", "MAP_MARKER_DETAILS", "MAP_MARKER_SELECT", "RESERVE", "RESERVE_FAILED", "RES_CANCEL", "RES_CANCEL_FAILED", "SEARCH_QUERY_SUBMIT", "SEARCH_RESULT_CLICK", "STARRED", "WIFI_CONNECT", "YOUTUBE_LINK", "shared_debug"})
public final class AnalyticsActions {
    @org.jetbrains.annotations.NotNull()
    public static final com.berners.truecaller.shared.analytics.AnalyticsActions INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STARRED = "Bookmarked";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CLICK = "Clicked";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESERVE = "Reserved";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESERVE_FAILED = "Reserved (Failed)";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RES_CANCEL_FAILED = "Reservation Cancellation (Failed)";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RES_CANCEL = "Reservation Cancellation";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAP_MARKER_SELECT = "Selected Map Marker";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAP_MARKER_DETAILS = "Viewed Map Marker Details";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WIFI_CONNECT = "Connected to Wifi";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String YOUTUBE_LINK = "Youtube link click";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SEARCH_QUERY_SUBMIT = "Submitted search query";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SEARCH_RESULT_CLICK = "Clicked on search result";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_TO_MAP = "Home to Map transition";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_TO_SCHEDULE = "Home to Schedule transition";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_TO_SESSION_DETAIL = "Home to Session Detail transition";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_TO_SIGN_IN = "Home to Sign In transition";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_TO_LIVESTREAM = "Home to Live stream transition";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_TO_ANNOUNCEMENTS = "Home to Announcements transition";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENABLE = "Enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISABLE = "Disabled";
    
    private AnalyticsActions() {
        super();
    }
}