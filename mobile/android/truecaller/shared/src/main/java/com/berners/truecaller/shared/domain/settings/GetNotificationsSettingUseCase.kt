package com.berners.truecaller.shared.domain.settings

import com.berners.truecaller.shared.data.prefs.PreferenceStorage
import com.berners.truecaller.shared.di.IoDispatcher
import com.berners.truecaller.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetNotificationsSettingUseCase @Inject constructor(
    private val preferenceStorage: PreferenceStorage,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Unit, Boolean>(dispatcher) {
    // TODO use preferToReceiveNotifications as flow
    override suspend fun execute(parameters: Unit) =
        preferenceStorage.preferToReceiveNotifications.first()
}
