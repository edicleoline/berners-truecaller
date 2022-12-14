package com.berners.truecaller.shared.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * The [Room] database for this app.
 */
@Database(
    entities = [
        TopSpammerFtsEntity::class,
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun topSpammerFtsDao(): TopSpammerFtsDao

    companion object {
        private const val databaseName = "truecaller-db"

        fun buildDatabase(context: Context): AppDatabase {
            // Since Room is only used for FTS, destructive migration is enough because the tables
            // are cleared every time the app launches.
            // https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
            return Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
