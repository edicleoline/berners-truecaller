package com.berners.truecaller.data.remote.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\nH\u00c6\u0003J9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/berners/truecaller/data/remote/model/TopSpammer;", "", "label", "", "reportsCount", "", "categories", "", "", "phone", "Lcom/berners/truecaller/data/remote/model/Phone;", "(Ljava/lang/String;ILjava/util/List;Lcom/berners/truecaller/data/remote/model/Phone;)V", "getCategories", "()Ljava/util/List;", "getLabel", "()Ljava/lang/String;", "getPhone", "()Lcom/berners/truecaller/data/remote/model/Phone;", "getReportsCount", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "data_debug"})
public final class TopSpammer {
    @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "label")
    private final java.lang.String label = null;
    @com.squareup.moshi.Json(name = "reports_count")
    private final int reportsCount = 0;
    @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "categories")
    private final java.util.List<java.lang.Long> categories = null;
    @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "phone")
    private final com.berners.truecaller.data.remote.model.Phone phone = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.remote.model.TopSpammer copy(@org.jetbrains.annotations.NotNull()
    java.lang.String label, int reportsCount, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Long> categories, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.remote.model.Phone phone) {
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
    
    public TopSpammer(@org.jetbrains.annotations.NotNull()
    java.lang.String label, int reportsCount, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Long> categories, @org.jetbrains.annotations.NotNull()
    com.berners.truecaller.data.remote.model.Phone phone) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getReportsCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.Long> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.Long> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.remote.model.Phone component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.berners.truecaller.data.remote.model.Phone getPhone() {
        return null;
    }
}