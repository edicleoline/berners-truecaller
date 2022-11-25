package com.berners.truecaller.di

import android.content.ClipboardManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.berners.truecaller.shared.analytics.AnalyticsHelper
//import com.berners.truecaller.shared.data.agenda.AgendaRepository
//import com.berners.truecaller.shared.data.agenda.DefaultAgendaRepository
import com.berners.truecaller.shared.data.config.AppConfigDataSource
import com.berners.truecaller.shared.data.db.AppDatabase
import com.berners.truecaller.shared.data.prefs.PreferenceStorage
import com.berners.truecaller.shared.di.ApplicationScope
import com.berners.truecaller.shared.di.DefaultDispatcher
import com.berners.truecaller.shared.di.MainThreadHandler
import com.berners.truecaller.shared.domain.internal.TruecallerHandler
import com.berners.truecaller.shared.domain.internal.TruecallerMainHandler
//import com.berners.truecaller.ui.signin.SignInViewModelDelegate
import com.berners.truecaller.util.FirebaseAnalyticsHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

/**
 * Defines all the classes that need to be provided in the scope of the app.
 *
 * Define here all objects that are shared throughout the app, like SharedPreferences, navigators or
 * others. If some of those objects are singletons, they should be annotated with `@Singleton`.
 */
@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideWifiManager(@ApplicationContext context: Context): WifiManager =
        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager =
        context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager

    @Provides
    fun provideClipboardManager(@ApplicationContext context: Context): ClipboardManager =
        context.applicationContext.getSystemService(Context.CLIPBOARD_SERVICE)
            as ClipboardManager

    @ApplicationScope
    @Singleton
    @Provides
    fun providesApplicationScope(
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + defaultDispatcher)

    @Singleton
    @Provides
    @MainThreadHandler
    fun provideMainThreadHandler(): TruecallerHandler = TruecallerMainHandler()

    @Singleton
    @Provides
    fun provideAnalyticsHelper(
        @ApplicationScope applicationScope: CoroutineScope,
//        signInDelegate: SignInViewModelDelegate,
        preferenceStorage: PreferenceStorage
    ): AnalyticsHelper =
        FirebaseAnalyticsHelper(applicationScope, /*signInDelegate,*/ preferenceStorage)

//    @Singleton
//    @Provides
//    fun provideAgendaRepository(appConfigDataSource: AppConfigDataSource): AgendaRepository =
//        DefaultAgendaRepository(appConfigDataSource)

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.buildDatabase(context)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
}
