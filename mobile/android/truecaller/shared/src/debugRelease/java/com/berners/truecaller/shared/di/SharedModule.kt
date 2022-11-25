/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.berners.truecaller.shared.di

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.functions.FirebaseFunctions
import com.google.firebase.functions.ktx.functions
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.berners.truecaller.shared.BuildConfig
import com.berners.truecaller.shared.R
//import com.berners.truecaller.shared.data.BootstrapConferenceDataSource
//import com.berners.truecaller.shared.data.ConferenceDataRepository
//import com.berners.truecaller.shared.data.ConferenceDataSource
//import com.berners.truecaller.shared.data.NetworkConferenceDataSource
import com.berners.truecaller.shared.data.ar.ArDebugFlagEndpoint
import com.berners.truecaller.shared.data.ar.DefaultArDebugFlagEndpoint
import com.berners.truecaller.shared.data.config.AppConfigDataSource
import com.berners.truecaller.shared.data.config.RemoteAppConfigDataSource
//import com.berners.truecaller.shared.data.db.AppDatabase
//import com.berners.truecaller.shared.data.feed.AnnouncementDataSource
//import com.berners.truecaller.shared.data.feed.DefaultFeedRepositorycom.berners.truecaller
//import com.berners.truecaller.shared.data.feed.FeedRepository
//import com.berners.truecaller.shared.data.feed.FirestoreAnnouncementDataSource
//import com.berners.truecaller.shared.data.feed.FirestoreMomentDataSource
//import com.berners.truecaller.shared.data.feed.MomentDataSource
//import com.berners.truecaller.shared.data.feedback.DefaultFeedbackEndpoint
//import com.berners.truecaller.shared.data.feedback.FeedbackEndpoint
//import com.berners.truecaller.shared.data.session.DefaultSessionRepository
//import com.berners.truecaller.shared.data.session.SessionRepository
//import com.berners.truecaller.shared.data.userevent.DefaultSessionAndUserEventRepository
//import com.berners.truecaller.shared.data.userevent.FirestoreUserEventDataSource
//import com.berners.truecaller.shared.data.userevent.SessionAndUserEventRepository
//import com.berners.truecaller.shared.data.userevent.UserEventDataSource
//import com.berners.truecaller.shared.domain.search.FtsMatchStrategy
//import com.berners.truecaller.shared.domain.search.SessionTextMatchStrategy
//import com.berners.truecaller.shared.domain.search.SimpleMatchStrategy
import com.berners.truecaller.shared.fcm.FcmTopicSubscriber
import com.berners.truecaller.shared.fcm.TopicSubscriber
//import com.berners.truecaller.shared.time.DefaultTimeProvider
//import com.berners.truecaller.shared.time.TimeProvider
import com.berners.truecaller.shared.util.NetworkUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named
import javax.inject.Singleton

/**
 * Module where classes created in the shared module are created.
 */
@InstallIn(SingletonComponent::class)
@Module
class SharedModule {

// Define the data source implementations that should be used. All data sources are singletons.

//    @Singleton
//    @Provides
//    @Named("remoteConfDatasource")
//    fun provideConferenceDataSource(
//        @ApplicationContext context: Context,
//        networkUtils: NetworkUtils
//    ): ConferenceDataSource {
//        return NetworkConferenceDataSource(context, networkUtils)
//    }

//    @Singleton
//    @Provides
//    @Named("bootstrapConfDataSource")
//    fun provideBootstrapRemoteSessionDataSource(): ConferenceDataSource {
//        return BootstrapConferenceDataSource
//    }
//
//    @Singleton
//    @Provides
//    fun provideConferenceDataRepository(
//        @Named("remoteConfDatasource") remoteDataSource: ConferenceDataSource,
//        @Named("bootstrapConfDataSource") boostrapDataSource: ConferenceDataSource,
//        appDatabase: AppDatabase
//    ): ConferenceDataRepository {
//        return ConferenceDataRepository(remoteDataSource, boostrapDataSource, appDatabase)
//    }
//
//    @Singleton
//    @Provides
//    fun provideAnnouncementDataSource(firestore: FirebaseFirestore): AnnouncementDataSource {
//        return FirestoreAnnouncementDataSource(firestore)
//    }
//
//    @Singleton
//    @Provides
//    fun provideMomentsDataSource(firestore: FirebaseFirestore): MomentDataSource {
//        return FirestoreMomentDataSource(firestore)
//    }
//
//    @Singleton
//    @Provides
//    fun provideFeedRepository(
//        dataSource: AnnouncementDataSource,
//        momentsDataSource: MomentDataSource
//    ): FeedRepository {
//        return DefaultFeedRepository(dataSource, momentsDataSource)
//    }
//
//    @Singleton
//    @Provides
//    fun provideSessionRepository(
//        conferenceDataRepository: ConferenceDataRepository
//    ): SessionRepository {
//        return DefaultSessionRepository(conferenceDataRepository)
//    }
//
//    @Singleton
//    @Provides
//    fun provideUserEventDataSource(
//        firestore: FirebaseFirestore,
//        @IoDispatcher ioDispatcher: CoroutineDispatcher
//    ): UserEventDataSource {
//        return FirestoreUserEventDataSource(firestore, ioDispatcher)
//    }
//
//    @Singleton
//    @Provides
//    fun provideFeedbackEndpoint(functions: FirebaseFunctions): FeedbackEndpoint {
//        return DefaultFeedbackEndpoint(functions)
//    }
//
//    @Singleton
//    @Provides
//    fun provideSessionAndUserEventRepository(
//        userEventDataSource: UserEventDataSource,
//        sessionRepository: SessionRepository
//    ): SessionAndUserEventRepository {
//        return DefaultSessionAndUserEventRepository(
//            userEventDataSource,
//            sessionRepository
//        )
//    }

    @Singleton
    @Provides
    fun provideFirebaseFireStore(): FirebaseFirestore {
        return Firebase.firestore.apply {
            // This is to enable the offline data
            // https://firebase.google.com/docs/firestore/manage-data/enable-offline
            firestoreSettings = firestoreSettings { isPersistenceEnabled = true }
        }
    }

    @Singleton
    @Provides
    fun provideFirebaseFunctions(): FirebaseFunctions {
        return Firebase.functions
    }

    @Singleton
    @Provides
    fun provideArDebugFlagEndpoint(functions: FirebaseFunctions): ArDebugFlagEndpoint {
        return DefaultArDebugFlagEndpoint(functions)
    }

    @Singleton
    @Provides
    fun provideTopicSubscriber(): TopicSubscriber {
        return FcmTopicSubscriber()
    }

    @Singleton
    @Provides
    fun provideFirebaseRemoteConfigSettings(): FirebaseRemoteConfigSettings {
        return if (BuildConfig.DEBUG) {
            remoteConfigSettings { minimumFetchIntervalInSeconds = 0 }
        } else {
            remoteConfigSettings { }
        }
    }

    @Singleton
    @Provides
    fun provideFirebaseRemoteConfig(
        configSettings: FirebaseRemoteConfigSettings
    ): FirebaseRemoteConfig {
        return Firebase.remoteConfig.apply {
            setConfigSettingsAsync(configSettings)
            setDefaultsAsync(R.xml.remote_config_defaults)
        }
    }

    @Singleton
    @Provides
    fun provideAppConfigDataSource(
        remoteConfig: FirebaseRemoteConfig,
        configSettings: FirebaseRemoteConfigSettings,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): AppConfigDataSource {
        return RemoteAppConfigDataSource(remoteConfig, configSettings, ioDispatcher)
    }

//    @Singleton
//    @Provides
//    fun provideTimeProvider(): TimeProvider {
//        return DefaultTimeProvider
//    }
//
//    @Singleton
//    @Provides
//    fun provideSessionTextMatchStrategy(
//        @SearchUsingRoomEnabledFlag useRoom: Boolean,
//        appDatabase: AppDatabase
//    ): SessionTextMatchStrategy {
//        return if (useRoom) FtsMatchStrategy(appDatabase) else SimpleMatchStrategy
//    }
}
