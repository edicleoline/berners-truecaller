package com.berners.truecaller.shared.data.db;

import java.lang.System;

/**
 * The Data Access Object for the [TopSpammerFtsEntity] class.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\bH\'\u00a8\u0006\n"}, d2 = {"Lcom/berners/truecaller/shared/data/db/TopSpammerFtsDao;", "", "insertAll", "", "topSpammers", "", "Lcom/berners/truecaller/shared/data/db/TopSpammerFtsEntity;", "searchAllTopSpammers", "", "query", "shared_debug"})
public abstract interface TopSpammerFtsDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.berners.truecaller.shared.data.db.TopSpammerFtsEntity> topSpammers);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT top_spammer_id FROM topSpammersFts WHERE topSpammersFts MATCH :query")
    public abstract java.util.List<java.lang.String> searchAllTopSpammers(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
}