package com.berners.truecaller.data.remote.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J+\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u00060\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0016J+\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J(\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u00060\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0016J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/berners/truecaller/data/remote/datasources/RemotePhoneDataSource;", "Lcom/berners/truecaller/data/datasources/PhoneDataSource;", "service", "Lcom/berners/truecaller/data/remote/services/PhoneService;", "(Lcom/berners/truecaller/data/remote/services/PhoneService;)V", "getPhoneByE164Format", "Lcom/berners/truecaller/data/Result;", "Lcom/berners/truecaller/model/Phone;", "e164Format", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneByE164FormatStream", "Lkotlinx/coroutines/flow/Flow;", "getPhoneById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneByIdStream", "getPhonesByE164Formats", "", "e164Formats", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhonesByE164FormatsStream", "getPhonesByIds", "ids", "getPhonesByIdsStream", "save", "phone", "(Lcom/berners/truecaller/model/Phone;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public class RemotePhoneDataSource implements com.berners.truecaller.data.datasources.PhoneDataSource {
    private final com.berners.truecaller.data.remote.services.PhoneService service = null;
    
    @javax.inject.Inject()
    public RemotePhoneDataSource(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.remote.services.PhoneService service) {
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