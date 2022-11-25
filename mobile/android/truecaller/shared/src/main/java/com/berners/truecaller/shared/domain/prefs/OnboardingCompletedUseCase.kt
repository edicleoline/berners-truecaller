package com.berners.truecaller.shared.domain.prefs

import com.berners.truecaller.shared.data.prefs.PreferenceStorage
import com.berners.truecaller.shared.di.IoDispatcher
import com.berners.truecaller.shared.domain.FlowUseCase
import com.berners.truecaller.shared.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

open class OnboardingCompletedUseCase @Inject constructor(
    private val preferenceStorage: PreferenceStorage,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Boolean>(dispatcher) {
    override fun execute(parameters: Unit): Flow<Result<Boolean>> =
        preferenceStorage.onboardingCompleted.map { Result.Success(it) }
}