package com.berners.truecaller.data.di

import com.berners.truecaller.data.BuildConfig
import com.berners.truecaller.data.remote.model.EntityType
import com.berners.truecaller.data.remote.model.PhoneNumberType
import com.berners.truecaller.data.remote.interceptors.AuthInterceptor
import com.berners.truecaller.data.remote.datasources.RemotePhoneDataSource
import com.berners.truecaller.data.remote.datasources.RemoteTopSpammerDataSource
import com.berners.truecaller.data.remote.datasources.RemoteUserDataSource
import com.berners.truecaller.data.remote.interceptors.HandlingExceptionInterceptor
import com.berners.truecaller.data.remote.services.PhoneService
import com.berners.truecaller.data.remote.services.TopSpammerService
import com.berners.truecaller.data.remote.services.UserService
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.EnumJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(interceptor)
        }
        clientBuilder.addInterceptor(AuthInterceptor())
        clientBuilder.addInterceptor(HandlingExceptionInterceptor())
        return clientBuilder.build()
    }

    @Singleton
    @Provides
    @Named("moshi")
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(EntityType.Adapter)
            .add(
                EntityType::class.java, EnumJsonAdapter.create(EntityType::class.java)
                .withUnknownFallback(EntityType.UNKNOWN))
            .add(PhoneNumberType.Adapter)
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    @Named("retrofit")
    fun provideRetrofitBuilder(@Named("moshi") moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.TRUECALLER_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(provideHttpClient(provideHttpLoggingInterceptor()))
            .build()

    @Singleton
    @Provides
    fun providePhoneService(@Named("retrofit") retrofit: Retrofit): PhoneService = retrofit.create(PhoneService::class.java)

    @Singleton
    @Provides
    fun provideRemotePhoneDataSource(service: PhoneService) = RemotePhoneDataSource(service)

    @Singleton
    @Provides
    fun provideTopSpammerService(@Named("retrofit") retrofit: Retrofit): TopSpammerService = retrofit.create(TopSpammerService::class.java)

    @Singleton
    @Provides
    fun provideTopSpammerDataSource(service: TopSpammerService) = RemoteTopSpammerDataSource(service)

    @Singleton
    @Provides
    fun provideUserService(@Named("retrofit") retrofit: Retrofit): UserService = retrofit.create(UserService::class.java)

    @Singleton
    @Provides
    fun provideUserDataSource(service: UserService) = RemoteUserDataSource(service)


}