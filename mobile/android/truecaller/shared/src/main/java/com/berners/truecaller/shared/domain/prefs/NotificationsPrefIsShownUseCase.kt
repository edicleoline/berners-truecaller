package com.berners.truecaller.shared.domain.prefs

import com.berners.truecaller.shared.data.prefs.PreferenceStorage
import com.berners.truecaller.shared.di.IoDispatcher
import com.berners.truecaller.shared.domain.UseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first

open class NotificationsPrefIsShownUseCase @Inject constructor(
    private val preferenceStorage: PreferenceStorage,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Unit, Boolean>(dispatcher) {
    // TODO use as flow
    override suspend fun execute(parameters: Unit): Boolean =
        preferenceStorage.notificationsPreferenceShown.first()
}
