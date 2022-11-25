package com.berners.truecaller.shared.data.signin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\nJ\n\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/berners/truecaller/shared/data/signin/RegisteredUserInfo;", "Lcom/berners/truecaller/shared/data/signin/AuthenticatedUserInfo;", "basicUserInfo", "Lcom/berners/truecaller/shared/data/signin/AuthenticatedUserInfoBasic;", "isRegistered", "", "(Lcom/berners/truecaller/shared/data/signin/AuthenticatedUserInfoBasic;Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCreationTimestamp", "", "()Ljava/lang/Long;", "getDisplayName", "", "getEmail", "getLastSignInTimestamp", "getPhoneNumber", "getPhotoUrl", "Landroid/net/Uri;", "getProviderId", "getUid", "isAnonymous", "()Ljava/lang/Boolean;", "isEmailVerified", "isRegistrationDataReady", "isSignedIn", "shared_debug"})
public final class RegisteredUserInfo implements com.berners.truecaller.shared.data.signin.AuthenticatedUserInfo {
    private final com.berners.truecaller.shared.data.signin.AuthenticatedUserInfoBasic basicUserInfo = null;
    private final java.lang.Boolean isRegistered = null;
    
    public RegisteredUserInfo(@org.jetbrains.annotations.Nullable()
    com.berners.truecaller.shared.data.signin.AuthenticatedUserInfoBasic basicUserInfo, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRegistered) {
        super();
    }
    
    @java.lang.Override()
    public boolean isRegistered() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isSignedIn() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Boolean isAnonymous() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getPhoneNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getUid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Boolean isEmailVerified() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.net.Uri getPhotoUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getProviderId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getLastSignInTimestamp() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Long getCreationTimestamp() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isRegistrationDataReady() {
        return false;
    }
}