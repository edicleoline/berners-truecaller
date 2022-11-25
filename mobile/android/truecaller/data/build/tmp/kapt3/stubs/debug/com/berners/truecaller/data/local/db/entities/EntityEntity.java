package com.berners.truecaller.data.local.db.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "entities")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b4\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0012J\u0010\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u00103\u001a\u00020\u000bH\u00c6\u0003J\t\u00104\u001a\u00020\rH\u00c6\u0003J\t\u00105\u001a\u00020\rH\u00c6\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010:\u001a\u00020\tH\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010<\u001a\u00020\rH\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u0094\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\rH\u00c6\u0001\u00a2\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\r2\b\u0010A\u001a\u0004\u0018\u00010BH\u00d6\u0003J\t\u0010C\u001a\u00020DH\u00d6\u0001J\t\u0010E\u001a\u00020\u000bH\u00d6\u0001R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001e\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0011\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u001c\"\u0004\b\u001f\u0010\u001eR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R \u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b\'\u0010#R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001e\u00a8\u0006F"}, d2 = {"Lcom/berners/truecaller/data/local/db/entities/EntityEntity;", "Lcom/berners/truecaller/data/local/db/entities/TrueEntity;", "id", "", "rid", "createdAt", "updatedAt", "deletedAt", "type", "Lcom/berners/truecaller/model/EntityType;", "name", "", "verified", "", "profileImageUrl", "primaryColor", "isUser", "isUserPremium", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/berners/truecaller/model/EntityType;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZ)V", "getCreatedAt", "()Ljava/lang/Long;", "setCreatedAt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDeletedAt", "setDeletedAt", "getId", "setId", "()Z", "setUser", "(Z)V", "setUserPremium", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPrimaryColor", "setPrimaryColor", "getProfileImageUrl", "setProfileImageUrl", "getRid", "setRid", "getType", "()Lcom/berners/truecaller/model/EntityType;", "setType", "(Lcom/berners/truecaller/model/EntityType;)V", "getUpdatedAt", "setUpdatedAt", "getVerified", "setVerified", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/berners/truecaller/model/EntityType;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZ)Lcom/berners/truecaller/data/local/db/entities/EntityEntity;", "equals", "other", "", "hashCode", "", "toString", "data_debug"})
public final class EntityEntity implements com.berners.truecaller.data.local.db.entities.TrueEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Long id;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "rid")
    private java.lang.Long rid;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "created_at")
    private java.lang.Long createdAt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "updated_at")
    private java.lang.Long updatedAt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "deleted_at")
    private java.lang.Long deletedAt;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "entity_type")
    private com.berners.truecaller.model.EntityType type;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "name")
    private java.lang.String name;
    @androidx.room.ColumnInfo(name = "verified")
    private boolean verified;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "profile_image_url")
    private java.lang.String profileImageUrl;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "primary_color")
    private java.lang.String primaryColor;
    @androidx.room.ColumnInfo(name = "is_user")
    private boolean isUser;
    @androidx.room.ColumnInfo(name = "is_user_premium")
    private boolean isUserPremium;
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.local.db.entities.EntityEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long rid, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long deletedAt, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.EntityType type, @org.jetbrains.annotations.Nullable()
    java.lang.String name, boolean verified, @org.jetbrains.annotations.Nullable()
    java.lang.String profileImageUrl, @org.jetbrains.annotations.NotNull()
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
    
    public EntityEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long rid, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long deletedAt, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.EntityType type, @org.jetbrains.annotations.Nullable()
    java.lang.String name, boolean verified, @org.jetbrains.annotations.Nullable()
    java.lang.String profileImageUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String primaryColor, boolean isUser, boolean isUserPremium) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getId() {
        return null;
    }
    
    @java.lang.Override()
    public void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getRid() {
        return null;
    }
    
    public final void setRid(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getCreatedAt() {
        return null;
    }
    
    @java.lang.Override()
    public void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getUpdatedAt() {
        return null;
    }
    
    @java.lang.Override()
    public void setUpdatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getDeletedAt() {
        return null;
    }
    
    @java.lang.Override()
    public void setDeletedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.model.EntityType component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.model.EntityType getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull()
    com.berners.truecaller.model.EntityType p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getVerified() {
        return false;
    }
    
    public final void setVerified(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProfileImageUrl() {
        return null;
    }
    
    public final void setProfileImageUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrimaryColor() {
        return null;
    }
    
    public final void setPrimaryColor(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean isUser() {
        return false;
    }
    
    public final void setUser(boolean p0) {
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean isUserPremium() {
        return false;
    }
    
    public final void setUserPremium(boolean p0) {
    }
}