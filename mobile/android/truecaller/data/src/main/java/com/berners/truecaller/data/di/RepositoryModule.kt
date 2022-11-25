package com.berners.truecaller.data.di

import com.berners.truecaller.data.local.datasources.LocalPhoneDataSource
import com.berners.truecaller.data.remote.datasources.RemotePhoneDataSource
import com.berners.truecaller.data.local.datasources.LocalTopSpammerDataSource
import com.berners.truecaller.data.remote.datasources.RemoteTopSpammerDataSource
import com.berners.truecaller.data.local.datasources.LocalIncomingDataSource
import com.berners.truecaller.data.local.datasources.LocalIncomingEventDataSource
import com.berners.truecaller.data.repositories.IncomingRepository
import com.berners.truecaller.data.repositories.IncomingEventRepository
import com.berners.truecaller.data.repositories.PhoneRepository
import com.berners.truecaller.data.repositories.TopSpammerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module

class RepositoryModule {
    @Singleton
    @Provides
    fun providePhoneRepository(
        remotePhoneDataSource: RemotePhoneDataSource,
        localPhoneDataSource: LocalPhoneDataSource,
    ): PhoneRepository {
        return PhoneRepository(remotePhoneDataSource, localPhoneDataSource)
    }

    @Singleton
    @Provides
    fun provideIncomingRepository(
//        remotePhoneDataSource: RemotePhoneDataSource,
        localIncomingDataSource: LocalIncomingDataSource,
    ): IncomingRepository {
        return IncomingRepository(localIncomingDataSource)
    }

    @Singleton
    @Provides
    fun provideIncomingEventRepository(
//        remotePhoneDataSource: RemotePhoneDataSource,
        localIncomingStateDataSource: LocalIncomingEventDataSource,
    ): IncomingEventRepository {
        return IncomingEventRepository(localIncomingStateDataSource)
    }

    @Singleton
    @Provides
    fun provideTopSpammerRepository(
        remoteTopSpammerDataSource: RemoteTopSpammerDataSource,
        localTopSpammerDataSource: LocalTopSpammerDataSource,
    ): TopSpammerRepository {
        return TopSpammerRepository(remoteTopSpammerDataSource, localTopSpammerDataSource)
    }
}