package com.berners.truecaller

import android.app.Application
import android.content.Context
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy.Builder
import com.berners.truecaller.shared.analytics.AnalyticsHelper
import com.berners.truecaller.util.CrashlyticsTree
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

/**
 * Initialization of libraries.
 */
@HiltAndroidApp
class MainApplication : Application() {

    companion object {
        lateinit var instance: MainApplication
            private set
    }

    // Even if the var isn't used, needs to be initialized at application startup.
    @Inject lateinit var analyticsHelper: AnalyticsHelper

    override fun onCreate() {
        // ThreeTenBP for times and dates, called before super to be available for objects
        AndroidThreeTen.init(this)

        // Enable strict mode before Dagger creates graph
        if (BuildConfig.DEBUG) {
            enableStrictMode()
        }

        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashlyticsTree())
        }
    }

    private fun enableStrictMode() {
        StrictMode.setThreadPolicy(
            Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build()
        )
    }
}