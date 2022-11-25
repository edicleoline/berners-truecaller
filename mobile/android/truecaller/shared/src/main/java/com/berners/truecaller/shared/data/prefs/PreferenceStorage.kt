package com.berners.truecaller.shared.data.prefs

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.berners.truecaller.shared.data.prefs.DataStorePreferenceStorage.PreferencesKeys.PREF_CONFERENCE_TIME_ZONE
import com.berners.truecaller.shared.data.prefs.DataStorePreferenceStorage.PreferencesKeys.PREF_MY_LOCATION_OPTED_IN
import com.berners.truecaller.shared.data.prefs.DataStorePreferenceStorage.PreferencesKeys.PREF_NOTIFICATIONS_SHOWN
import com.berners.truecaller.shared.data.prefs.DataStorePreferenceStorage.PreferencesKeys.PREF_ONBOARDING
import com.berners.truecaller.shared.data.prefs.DataStorePreferenceStorage.PreferencesKeys.PREF_RECEIVE_NOTIFICATIONS
import com.berners.truecaller.shared.data.prefs.DataStorePreferenceStorage.PreferencesKeys.PREF_SCHED_UI_HINTS_SHOWN
import com.berners.truecaller.shared.data.prefs.DataStorePreferenceStorage.PreferencesKeys.PREF_SELECTED_THEME
import com.berners.truecaller.shared.data.prefs.DataStorePreferenceStorage.PreferencesKeys.PREF_SEND_USAGE_STATISTICS
import com.berners.truecaller.shared.data.prefs.DataStorePreferenceStorage.PreferencesKeys.PREF_SNACKBAR_IS_STOPPED
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

interface PreferenceStorage {
    suspend fun completeOnboarding(complete: Boolean)
    val onboardingCompleted: Flow<Boolean>

    suspend fun showScheduleUiHints(show: Boolean)
    suspend fun areScheduleUiHintsShown(): Boolean

    suspend fun showNotificationsPreference(show: Boolean)
    val notificationsPreferenceShown: Flow<Boolean>

    suspend fun preferToReceiveNotifications(prefer: Boolean)
    val preferToReceiveNotifications: Flow<Boolean>

    suspend fun optInMyLocation(optIn: Boolean)
    val myLocationOptedIn: Flow<Boolean>

    suspend fun stopSnackbar(stop: Boolean)
    // TODO make this a flow or a suspend function
    suspend fun isSnackbarStopped(): Boolean

    suspend fun sendUsageStatistics(send: Boolean)
    val sendUsageStatistics: Flow<Boolean>

    suspend fun preferTimeZone(preferTimeZone: Boolean)
    val preferTimeZone: Flow<Boolean>

//    suspend fun selectTheme(theme: String)
//    val selectedTheme: Flow<String>
}

@Singleton
class DataStorePreferenceStorage @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : PreferenceStorage {
    companion object {
        const val PREFS_NAME = "truecaller"
    }

    object PreferencesKeys {
        val PREF_ONBOARDING = booleanPreferencesKey("pref_onboarding")
        val PREF_SCHED_UI_HINTS_SHOWN = booleanPreferencesKey("pref_sched_ui_hints_shown")
        val PREF_NOTIFICATIONS_SHOWN = booleanPreferencesKey("pref_notifications_shown")
        val PREF_RECEIVE_NOTIFICATIONS = booleanPreferencesKey("pref_receive_notifications")
        val PREF_MY_LOCATION_OPTED_IN = booleanPreferencesKey("pref_my_location_opted_in")
        val PREF_SNACKBAR_IS_STOPPED = booleanPreferencesKey("pref_snackbar_is_stopped")
        val PREF_SEND_USAGE_STATISTICS = booleanPreferencesKey("pref_send_usage_statistics")
        val PREF_CONFERENCE_TIME_ZONE = booleanPreferencesKey("pref_conference_time_zone")
        val PREF_SELECTED_THEME = stringPreferencesKey("pref_dark_mode")
    }

    override suspend fun completeOnboarding(complete: Boolean) {
        dataStore.edit {
            it[PREF_ONBOARDING] = complete
        }
    }

    override val onboardingCompleted: Flow<Boolean> =
        dataStore.data.map { it[PREF_ONBOARDING] ?: false }

    override suspend fun showScheduleUiHints(show: Boolean) {
        dataStore.edit {
            it[PREF_SCHED_UI_HINTS_SHOWN] = show
        }
    }

    override suspend fun areScheduleUiHintsShown() =
        dataStore.data.map { it[PREF_SCHED_UI_HINTS_SHOWN] ?: false }.first()

    override suspend fun showNotificationsPreference(show: Boolean) {
        dataStore.edit {
            it[PREF_NOTIFICATIONS_SHOWN] = show
        }
    }

    override val notificationsPreferenceShown = dataStore.data.map {
        it[PREF_NOTIFICATIONS_SHOWN] ?: false
    }

    override suspend fun preferToReceiveNotifications(prefer: Boolean) {
        dataStore.edit {
            it[PREF_RECEIVE_NOTIFICATIONS] = prefer
        }
    }

    override val preferToReceiveNotifications = dataStore.data.map {
        it[PREF_RECEIVE_NOTIFICATIONS] ?: false
    }

    override suspend fun optInMyLocation(optIn: Boolean) {
        dataStore.edit {
            it[PREF_MY_LOCATION_OPTED_IN] = optIn
        }
    }

    override val myLocationOptedIn = dataStore.data.map {
        it[PREF_MY_LOCATION_OPTED_IN] ?: false
    }

    override suspend fun stopSnackbar(stop: Boolean) {
        dataStore.edit {
            it[PREF_SNACKBAR_IS_STOPPED] = stop
        }
    }

    override suspend fun isSnackbarStopped(): Boolean {
        return dataStore.data.map { it[PREF_SNACKBAR_IS_STOPPED] ?: false }.first()
    }

    override suspend fun sendUsageStatistics(send: Boolean) {
        dataStore.edit {
            it[PREF_SEND_USAGE_STATISTICS] = send
        }
    }

    override val sendUsageStatistics = dataStore.data.map {
        it[PREF_SEND_USAGE_STATISTICS] ?: true
    }

    override suspend fun preferTimeZone(preferTimeZone: Boolean) {
        dataStore.edit {
            it[PREF_CONFERENCE_TIME_ZONE] = preferTimeZone
        }
    }

    override val preferTimeZone =
        dataStore.data.map { it[PREF_CONFERENCE_TIME_ZONE] ?: true }

//    override suspend fun selectTheme(theme: String) {
//        dataStore.edit {
//            it[PREF_SELECTED_THEME] = theme
//        }
//    }

//    override val selectedTheme =
//        dataStore.data.map { it[PREF_SELECTED_THEME] ?: Resources.Theme.SYSTEM.storageKey }

}