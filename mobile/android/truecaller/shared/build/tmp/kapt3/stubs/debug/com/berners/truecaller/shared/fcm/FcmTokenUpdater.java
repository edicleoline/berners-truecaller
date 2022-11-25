package com.berners.truecaller.shared.fcm;

import java.lang.System;

/**
 * Saves the FCM ID tokens in Firestore.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/berners/truecaller/shared/fcm/FcmTokenUpdater;", "", "externalScope", "Lkotlinx/coroutines/CoroutineScope;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/google/firebase/firestore/FirebaseFirestore;)V", "getFirestore", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "updateTokenForUser", "", "userId", "", "Companion", "shared_debug"})
public final class FcmTokenUpdater {
    private final kotlinx.coroutines.CoroutineScope externalScope = null;
    private final kotlinx.coroutines.CoroutineDispatcher mainDispatcher = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.berners.truecaller.shared.fcm.FcmTokenUpdater.Companion Companion = null;
    private static final java.lang.String USERS_COLLECTION = "users";
    private static final java.lang.String LAST_VISIT_KEY = "lastVisit";
    private static final java.lang.String TOKEN_ID_KEY = "tokenId";
    private static final java.lang.String FCM_IDS_COLLECTION = "fcmTokens";
    private static final int TOKEN_ID_LENGTH = 25;
    
    @javax.inject.Inject()
    public FcmTokenUpdater(@org.jetbrains.annotations.NotNull()
    @com.berners.truecaller.shared.di.ApplicationScope()
    kotlinx.coroutines.CoroutineScope externalScope, @org.jetbrains.annotations.NotNull()
    @com.berners.truecaller.shared.di.MainDispatcher()
    kotlinx.coroutines.CoroutineDispatcher mainDispatcher, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.FirebaseFirestore getFirestore() {
        return null;
    }
    
    public final void updateTokenForUser(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/berners/truecaller/shared/fcm/FcmTokenUpdater$Companion;", "", "()V", "FCM_IDS_COLLECTION", "", "LAST_VISIT_KEY", "TOKEN_ID_KEY", "TOKEN_ID_LENGTH", "", "USERS_COLLECTION", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}