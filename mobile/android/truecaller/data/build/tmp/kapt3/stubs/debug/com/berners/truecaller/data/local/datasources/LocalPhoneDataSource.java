package com.berners.truecaller.data.local.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00102\u0006\u0010\f\u001a\u00020\rH\u0016J\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J+\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00170\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00170\n0\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u0016J+\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00170\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J(\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00170\n0\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017H\u0016J\u0019\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/berners/truecaller/data/local/datasources/LocalPhoneDataSource;", "Lcom/berners/truecaller/data/datasources/PhoneDataSource;", "phoneDao", "Lcom/berners/truecaller/data/local/db/daos/PhoneDao;", "localEntityDataSource", "Lcom/berners/truecaller/data/local/datasources/LocalEntityDataSource;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/berners/truecaller/data/local/db/daos/PhoneDao;Lcom/berners/truecaller/data/local/datasources/LocalEntityDataSource;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPhoneByE164Format", "Lcom/berners/truecaller/data/Result;", "Lcom/berners/truecaller/model/Phone;", "e164Format", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneByE164FormatStream", "Lkotlinx/coroutines/flow/Flow;", "getPhoneById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneByIdStream", "getPhonesByE164Formats", "", "e164Formats", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhonesByE164FormatsStream", "getPhonesByIds", "ids", "getPhonesByIdsStream", "save", "phone", "(Lcom/berners/truecaller/model/Phone;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public class LocalPhoneDataSource implements com.berners.truecaller.data.datasources.PhoneDataSource {
    private final com.berners.truecaller.data.local.db.daos.PhoneDao phoneDao = null;
    private final com.berners.truecaller.data.local.datasources.LocalEntityDataSource localEntityDataSource = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    
    @javax.inject.Inject()
    public LocalPhoneDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.db.daos.PhoneDao phoneDao, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.local.datasources.LocalEntityDataSource localEntityDataSource, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<com.berners.truecaller.model.Phone>> getPhoneByIdStream(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<com.berners.truecaller.model.Phone>> getPhoneByE164FormatStream(@org.jetbrains.annotations.NotNull()
    java.lang.String e164Format) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<java.util.List<com.berners.truecaller.model.Phone>>> getPhonesByIdsStream(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> ids) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<java.util.List<com.berners.truecaller.model.Phone>>> getPhonesByE164FormatsStream(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> e164Formats) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPhoneById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.Result<com.berners.truecaller.model.Phone>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPhoneByE164Format(@org.jetbrains.annotations.NotNull()
    java.lang.String e164Format, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.Result<com.berners.truecaller.model.Phone>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPhonesByIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> ids, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.Result<? extends java.util.List<com.berners.truecaller.model.Phone>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPhonesByE164Formats(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> e164Formats, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.Result<? extends java.util.List<com.berners.truecaller.model.Phone>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.Phone phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.model.Phone> continuation) {
        return null;
    }
}