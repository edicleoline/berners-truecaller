package com.berners.truecaller.data.di

import android.content.Context
import com.berners.truecaller.data.local.datasources.*
import com.berners.truecaller.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalModule {
    @Singleton
    @Provides
    fun provideLocalEntityDataSource(
        appDatabase: AppDatabase
    ): LocalEntityDataSource {
        return LocalEntityDataSource(appDatabase.entityDao())
    }

    @Singleton
    @Provides
    fun provideLocalPhoneDataSource(
        appDatabase: AppDatabase
    ): LocalPhoneDataSource {
        return LocalPhoneDataSource(appDatabase.phoneDao(), provideLocalEntityDataSource(appDatabase))
    }

    @Singleton
    @Provides
    fun provideLocalIncomingDataSource(
        appDatabase: AppDatabase
    ): LocalIncomingDataSource {
        return LocalIncomingDataSource(
            appDatabase.incomingDao(),
            provideLocalPhoneDataSource(appDatabase),
            provideLocalIncomingEventDataSource(appDatabase)
        )
    }

    @Singleton
    @Provides
    fun provideLocalIncomingEventDataSource(
        appDatabase: AppDatabase
    ): LocalIncomingEventDataSource {
        return LocalIncomingEventDataSource(appDatabase.incomingStateDao())
    }

    @Singleton
    @Provides
    fun provideLocalTopSpammerDataSource(
        appDatabase: AppDatabase
    ): LocalTopSpammerDataSource {
        return LocalTopSpammerDataSource(appDatabase.topSpammerDao())
    }
}