package com.berners.truecaller.shared.domain.internal;

import java.lang.System;

/**
 * A forwarding interface for [Handler] to support mocking in tests.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/berners/truecaller/shared/domain/internal/TruecallerHandler;", "", "post", "", "runnable", "Ljava/lang/Runnable;", "postDelayed", "millis", "", "removeCallbacks", "", "shared_debug"})
public abstract interface TruecallerHandler {
    
    /**
     * See [Handler.post]
     */
    public abstract boolean post(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable);
    
    /**
     * See [Handler.postDelayed]
     */
    public abstract boolean postDelayed(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable, long millis);
    
    /**
     * See [Handler.removeCallbacks]
     */
    public abstract void removeCallbacks(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable);
}