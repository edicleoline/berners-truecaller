package com.berners.truecaller.shared.domain.settings

import com.berners.truecaller.shared.data.prefs.PreferenceStorage
import com.berners.truecaller.shared.di.IoDispatcher
import com.berners.truecaller.shared.domain.FlowUseCase
import com.berners.truecaller.shared.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAnalyticsSettingUseCase @Inject constructor(
    private val preferenceStorage: PreferenceStorage,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Boolean>(dispatcher) {
    override fun execute(parameters: Unit) =
        preferenceStorage.sendUsageStatistics.map { Result.Success(it) }
}
