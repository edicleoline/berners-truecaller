package com.berners.truecaller.data.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\t2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\t2\u0006\u0010\u000b\u001a\u00020\fH&J+\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u00030\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H&J+\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J(\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u00030\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H&J\u0019\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/berners/truecaller/data/datasources/PhoneDataSource;", "", "getPhoneByE164Format", "Lcom/berners/truecaller/data/Result;", "Lcom/berners/truecaller/model/Phone;", "e164Format", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneByE164FormatStream", "Lkotlinx/coroutines/flow/Flow;", "getPhoneById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhoneByIdStream", "getPhonesByE164Formats", "", "e164Formats", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPhonesByE164FormatsStream", "getPhonesByIds", "ids", "getPhonesByIdsStream", "save", "phone", "(Lcom/berners/truecaller/model/Phone;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface PhoneDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<com.berners.truecaller.model.Phone>> getPhoneByIdStream(long id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<com.berners.truecaller.model.Phone>> getPhoneByE164FormatStream(@org.jetbrains.annotations.NotNull()
    java.lang.String e164Format);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<java.util.List<com.berners.truecaller.model.Phone>>> getPhonesByIdsStream(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> ids);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.berners.truecaller.data.Result<java.util.List<com.berners.truecaller.model.Phone>>> getPhonesByE164FormatsStream(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> e164Formats);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPhoneById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.Result<com.berners.truecaller.model.Phone>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPhoneByE164Format(@org.jetbrains.annotations.NotNull()
    java.lang.String e164Format, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.Result<com.berners.truecaller.model.Phone>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPhonesByIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> ids, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.Result<? extends java.util.List<com.berners.truecaller.model.Phone>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPhonesByE164Formats(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> e164Formats, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.data.Result<? extends java.util.List<com.berners.truecaller.model.Phone>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.Phone phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.berners.truecaller.model.Phone> continuation);
}