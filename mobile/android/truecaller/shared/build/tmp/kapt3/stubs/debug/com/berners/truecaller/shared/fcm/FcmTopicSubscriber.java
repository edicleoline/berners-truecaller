package com.berners.truecaller.shared.fcm;

import java.lang.System;

/**
 * A [TopicSubscriber] that uses Firebase Cloud Messaging to subscribe a user to server topics.
 *
 * Calls are lightweight and can be repeated multiple times.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/berners/truecaller/shared/fcm/FcmTopicSubscriber;", "Lcom/berners/truecaller/shared/fcm/TopicSubscriber;", "()V", "subscribeToAttendeeUpdates", "", "subscribeToScheduleUpdates", "unsubscribeFromAttendeeUpdates", "Companion", "shared_debug"})
public final class FcmTopicSubscriber implements com.berners.truecaller.shared.fcm.TopicSubscriber {
    @org.jetbrains.annotations.NotNull()
    public static final com.berners.truecaller.shared.fcm.FcmTopicSubscriber.Companion Companion = null;
    private static final java.lang.String CONFERENCE_DATA_UPDATE_TOPIC_KEY = "CONFERENCE_DATA_SYNC_2018";
    private static final java.lang.String REGISTERED_USER_TOPIC_KEY = "REGISTERED_2018";
    
    public FcmTopicSubscriber() {
        super();
    }
    
    @java.lang.Override()
    public void subscribeToScheduleUpdates() {
    }
    
    @java.lang.Override()
    public void subscribeToAttendeeUpdates() {
    }
    
    @java.lang.Override()
    public void unsubscribeFromAttendeeUpdates() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/berners/truecaller/shared/fcm/FcmTopicSubscriber$Companion;", "", "()V", "CONFERENCE_DATA_UPDATE_TOPIC_KEY", "", "REGISTERED_USER_TOPIC_KEY", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}