package com.berners.truecaller.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.berners.truecaller.data.local.db.daos.*
import com.berners.truecaller.data.local.db.entities.*
import com.berners.truecaller.data.local.db.resultentities.PhoneEntityDetailed

//import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [
        UserEntity::class,
        TopSpammerEntity::class,

        EntityEntity::class,
        PhoneEntity::class,
        IncomingEntity::class,
        IncomingEventEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun topSpammerDao(): TopSpammerDao

    abstract fun entityDao(): EntityDao
    abstract fun phoneDao(): PhoneDao
    abstract fun incomingDao(): IncomingDao
    abstract fun incomingStateDao(): IncomingEventDao

    companion object {

        @Volatile private var instance: AppDatabase? = null

        private const val databaseName = "berners_truecaller_local"

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                .addCallback(
                    object : RoomDatabase.Callback() {
//                        override fun onCreate(db: SupportSQLiteDatabase) {
//                            super.onCreate(db)
//                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
//                                .setInputData(workDataOf(KEY_FILENAME to PLANT_DATA_FILENAME))
//                                .build()
//                            WorkManager.getInstance(context).enqueue(request)
//                        }
                    }
                )
                .build()
        }
    }
}
