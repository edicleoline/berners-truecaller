package com.berners.truecaller.shared.domain.settings

import com.berners.truecaller.shared.data.prefs.PreferenceStorage
import com.berners.truecaller.shared.di.IoDispatcher
import com.berners.truecaller.shared.domain.UseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

open class SetAnalyticsSettingUseCase @Inject constructor(
    private val preferenceStorage: PreferenceStorage,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<Boolean, Boolean>(dispatcher) {
    override suspend fun execute(parameters: Boolean): Boolean {
        preferenceStorage.sendUsageStatistics(parameters)
        return parameters
    }
}
