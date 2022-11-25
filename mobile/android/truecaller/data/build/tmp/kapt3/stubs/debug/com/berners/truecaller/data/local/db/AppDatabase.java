package com.berners.truecaller.data.local.db;

import java.lang.System;

@androidx.room.Database(entities = {com.berners.truecaller.data.local.db.entities.UserEntity.class, com.berners.truecaller.data.local.db.entities.TopSpammerEntity.class, com.berners.truecaller.data.local.db.entities.EntityEntity.class, com.berners.truecaller.data.local.db.entities.PhoneEntity.class, com.berners.truecaller.data.local.db.entities.IncomingEntity.class, com.berners.truecaller.data.local.db.entities.IncomingEventEntity.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lcom/berners/truecaller/data/local/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "entityDao", "Lcom/berners/truecaller/data/local/db/daos/EntityDao;", "incomingDao", "Lcom/berners/truecaller/data/local/db/daos/IncomingDao;", "incomingStateDao", "Lcom/berners/truecaller/data/local/db/daos/IncomingEventDao;", "phoneDao", "Lcom/berners/truecaller/data/local/db/daos/PhoneDao;", "topSpammerDao", "Lcom/berners/truecaller/data/local/db/daos/TopSpammerDao;", "userDao", "Lcom/berners/truecaller/data/local/db/daos/UserDao;", "Companion", "data_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.berners.truecaller.data.local.db.AppDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.berners.truecaller.data.local.db.AppDatabase instance;
    private static final java.lang.String databaseName = "berners_truecaller_local";
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.berners.truecaller.data.local.db.daos.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.berners.truecaller.data.local.db.daos.TopSpammerDao topSpammerDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.berners.truecaller.data.local.db.daos.EntityDao entityDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.berners.truecaller.data.local.db.daos.PhoneDao phoneDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.berners.truecaller.data.local.db.daos.IncomingDao incomingDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.berners.truecaller.data.local.db.daos.IncomingEventDao incomingStateDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/berners/truecaller/data/local/db/AppDatabase$Companion;", "", "()V", "databaseName", "", "instance", "Lcom/berners/truecaller/data/local/db/AppDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "getInstance", "data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.berners.truecaller.data.local.db.AppDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.berners.truecaller.data.local.db.AppDatabase buildDatabase(android.content.Context context) {
            return null;
        }
    }
}