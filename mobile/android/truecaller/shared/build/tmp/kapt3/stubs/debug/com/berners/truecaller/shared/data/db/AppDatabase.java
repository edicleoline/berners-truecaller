package com.berners.truecaller.shared.data.db;

import java.lang.System;

/**
 * The [Room] database for this app.
 */
@androidx.room.Database(entities = {com.berners.truecaller.shared.data.db.TopSpammerFtsEntity.class}, version = 3, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/berners/truecaller/shared/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "topSpammerFtsDao", "Lcom/berners/truecaller/shared/data/db/TopSpammerFtsDao;", "Companion", "shared_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.berners.truecaller.shared.data.db.AppDatabase.Companion Companion = null;
    private static final java.lang.String databaseName = "truecaller-db";
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.berners.truecaller.shared.data.db.TopSpammerFtsDao topSpammerFtsDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/berners/truecaller/shared/data/db/AppDatabase$Companion;", "", "()V", "databaseName", "", "buildDatabase", "Lcom/berners/truecaller/shared/data/db/AppDatabase;", "context", "Landroid/content/Context;", "shared_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.berners.truecaller.shared.data.db.AppDatabase buildDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}