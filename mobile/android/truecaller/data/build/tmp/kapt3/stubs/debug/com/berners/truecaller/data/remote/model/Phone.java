package com.berners.truecaller.data.remote.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003Jx\u0010)\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014\u00a8\u00061"}, d2 = {"Lcom/berners/truecaller/data/remote/model/Phone;", "", "id", "", "phone", "", "e164Format", "nationalFormat", "dialingCode", "countryCode", "numberType", "Lcom/berners/truecaller/data/remote/model/PhoneNumberType;", "carrier", "Lcom/berners/truecaller/data/remote/model/Company;", "entity", "Lcom/berners/truecaller/data/remote/model/Entity;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/berners/truecaller/data/remote/model/PhoneNumberType;Lcom/berners/truecaller/data/remote/model/Company;Lcom/berners/truecaller/data/remote/model/Entity;)V", "getCarrier", "()Lcom/berners/truecaller/data/remote/model/Company;", "getCountryCode", "()Ljava/lang/String;", "getDialingCode", "getE164Format", "getEntity", "()Lcom/berners/truecaller/data/remote/model/Entity;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNationalFormat", "getNumberType", "()Lcom/berners/truecaller/data/remote/model/PhoneNumberType;", "getPhone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/berners/truecaller/data/remote/model/PhoneNumberType;Lcom/berners/truecaller/data/remote/model/Company;Lcom/berners/truecaller/data/remote/model/Entity;)Lcom/berners/truecaller/data/remote/model/Phone;", "equals", "", "other", "hashCode", "", "toString", "data_debug"})
public final class Phone {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String phone = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String e164Format = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String nationalFormat = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String dialingCode = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String countryCode = null;
    @org.jetbrains.annotations.Nullable()
    private final com.berners.truecaller.data.remote.model.PhoneNumberType numberType = null;
    @org.jetbrains.annotations.Nullable()
    private final com.berners.truecaller.data.remote.model.Company carrier = null;
    @org.jetbrains.annotations.Nullable()
    private final com.berners.truecaller.data.remote.model.Entity entity = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.remote.model.Phone copy(@org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "id")
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "phone")
    java.lang.String phone, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "e164_format")
    java.lang.String e164Format, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "national_format")
    java.lang.String nationalFormat, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "dialing_code")
    java.lang.String dialingCode, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "country_code")
    java.lang.String countryCode, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "number_type")
    com.berners.truecaller.data.remote.model.PhoneNumberType numberType, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "carrier")
    com.berners.truecaller.data.remote.model.Company carrier, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "entity")
    com.berners.truecaller.data.remote.model.Entity entity) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Phone() {
        super();
    }
    
    public Phone(@org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "id")
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "phone")
    java.lang.String phone, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "e164_format")
    java.lang.String e164Format, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "national_format")
    java.lang.String nationalFormat, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "dialing_code")
    java.lang.String dialingCode, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "country_code")
    java.lang.String countryCode, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "number_type")
    com.berners.truecaller.data.remote.model.PhoneNumberType numberType, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "carrier")
    com.berners.truecaller.data.remote.model.Company carrier, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "entity")
    com.berners.truecaller.data.remote.model.Entity entity) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getE164Format() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNationalFormat() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDialingCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCountryCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.data.remote.model.PhoneNumberType component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.data.remote.model.PhoneNumberType getNumberType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.data.remote.model.Company component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.data.remote.model.Company getCarrier() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.data.remote.model.Entity component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.berners.truecaller.data.remote.model.Entity getEntity() {
        return null;
    }
}