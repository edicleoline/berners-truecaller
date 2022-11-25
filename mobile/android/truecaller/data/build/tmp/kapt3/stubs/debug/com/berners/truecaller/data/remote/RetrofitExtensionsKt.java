package com.berners.truecaller.data.remote;

import java.lang.System;

@kotlin.Suppress(names = {"NOTHING_TO_INLINE"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a_\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u000f2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0015H\u0086\b\u00a2\u0006\u0002\u0010\u0016\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"retryAfter", "", "Lretrofit2/HttpException;", "getRetryAfter", "(Lretrofit2/HttpException;)Ljava/lang/Long;", "defaultShouldRetry", "", "throwable", "", "withRetry", "T", "defaultDelay", "maxAttempts", "", "shouldRetry", "Lkotlin/Function1;", "block", "Lkotlin/coroutines/Continuation;", "", "(JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bodyOrThrow", "Lretrofit2/Response;", "(Lretrofit2/Response;)Ljava/lang/Object;", "data_debug"})
public final class RetrofitExtensionsKt {
    
    public static final <T extends java.lang.Object>T bodyOrThrow(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<T> $this$bodyOrThrow) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>java.lang.Object withRetry(long defaultDelay, int maxAttempts, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> shouldRetry, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> block, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super T> continuation) {
        return null;
    }
    
    private static final java.lang.Long getRetryAfter(retrofit2.HttpException $this$retryAfter) {
        return null;
    }
    
    private static final boolean defaultShouldRetry(java.lang.Throwable throwable) {
        return false;
    }
}