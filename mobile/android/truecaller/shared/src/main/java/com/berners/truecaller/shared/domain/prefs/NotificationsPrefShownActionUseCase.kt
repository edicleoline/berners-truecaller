package com.berners.truecaller.shared.domain.prefs

import com.berners.truecaller.shared.data.prefs.PreferenceStorage
import com.berners.truecaller.shared.di.IoDispatcher
import com.berners.truecaller.shared.domain.UseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

class NotificationsPrefShownActionUseCase @Inject constructor(
    private val preferenceStorage: PreferenceStorage,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Boolean, Unit>(dispatcher) {
    override suspend fun execute(parameters: Boolean) {
        preferenceStorage.showNotificationsPreference(parameters)
    }
}
