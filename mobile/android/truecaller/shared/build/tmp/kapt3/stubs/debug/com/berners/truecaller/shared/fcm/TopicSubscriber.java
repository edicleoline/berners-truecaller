package com.berners.truecaller.shared.fcm;

import java.lang.System;

/**
 * Used to subscribe users to server topics.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/berners/truecaller/shared/fcm/TopicSubscriber;", "", "subscribeToAttendeeUpdates", "", "subscribeToScheduleUpdates", "unsubscribeFromAttendeeUpdates", "shared_debug"})
public abstract interface TopicSubscriber {
    
    /**
     * Used to subscribe all users that open the schedule screen to a topic, to receive future
     * updates.
     */
    public abstract void subscribeToScheduleUpdates();
    
    /**
     * If a user is registered subscribe them to the "registered" topic.
     */
    public abstract void subscribeToAttendeeUpdates();
    
    /**
     * If a user is registered and signs out, unsubscribe them from the "registered" topic to stop
     * receiving notifications.
     */
    public abstract void unsubscribeFromAttendeeUpdates();
}