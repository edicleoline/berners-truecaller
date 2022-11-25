package com.berners.truecaller.data.remote.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0003\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003Jn\u0010%\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0002\u0010&J\u0013\u0010\'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006,"}, d2 = {"Lcom/berners/truecaller/data/remote/model/Entity;", "", "id", "", "type", "Lcom/berners/truecaller/data/remote/model/EntityType;", "name", "", "verified", "", "profileImageUrl", "defaultProfileImage", "primaryColor", "isUser", "isUserPremium", "(Ljava/lang/Long;Lcom/berners/truecaller/data/remote/model/EntityType;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZZ)V", "getDefaultProfileImage", "()Z", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getPrimaryColor", "getProfileImageUrl", "getType", "()Lcom/berners/truecaller/data/remote/model/EntityType;", "getVerified", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Lcom/berners/truecaller/data/remote/model/EntityType;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZZ)Lcom/berners/truecaller/data/remote/model/Entity;", "equals", "other", "hashCode", "", "toString", "data_debug"})
public final class Entity {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull()
    private final com.berners.truecaller.data.remote.model.EntityType type = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    private final boolean verified = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String profileImageUrl = null;
    private final boolean defaultProfileImage = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String primaryColor = null;
    private final boolean isUser = false;
    private final boolean isUserPremium = false;
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.remote.model.Entity copy(@org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "id")
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "type")
    com.berners.truecaller.data.remote.model.EntityType type, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "name")
    java.lang.String name, @com.squareup.moshi.Json(name = "verified")
    boolean verified, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "profile_image_url")
    java.lang.String profileImageUrl, @com.squareup.moshi.Json(name = "default_profile_image")
    boolean defaultProfileImage, @org.jetbrains.annotations.NotNull()
    java.lang.String primaryColor, boolean isUser, boolean isUserPremium) {
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
    
    public Entity() {
        super();
    }
    
    public Entity(@org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "id")
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "type")
    com.berners.truecaller.data.remote.model.EntityType type, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "name")
    java.lang.String name, @com.squareup.moshi.Json(name = "verified")
    boolean verified, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "profile_image_url")
    java.lang.String profileImageUrl, @com.squareup.moshi.Json(name = "default_profile_image")
    boolean defaultProfileImage, @org.jetbrains.annotations.NotNull()
    java.lang.String primaryColor, boolean isUser, boolean isUserPremium) {
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
    public final com.berners.truecaller.data.remote.model.EntityType component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.remote.model.EntityType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getVerified() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProfileImageUrl() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getDefaultProfileImage() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrimaryColor() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean isUser() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean isUserPremium() {
        return false;
    }
}