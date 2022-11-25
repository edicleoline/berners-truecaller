package com.berners.truecaller.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berners.truecaller.shared.domain.prefs.OnboardingCompletedUseCase
import com.berners.truecaller.shared.result.Result.Loading
import com.berners.truecaller.shared.result.data
import com.berners.truecaller.ui.LaunchNavigatonAction.NavigateToMainActivityAction
import com.berners.truecaller.ui.LaunchNavigatonAction.NavigateToOnboardingAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    onboardingCompletedUseCase: OnboardingCompletedUseCase
) : ViewModel() {
    val launchDestination = onboardingCompletedUseCase(Unit).map { result ->
        if (result.data == false) {
            NavigateToOnboardingAction
        } else {
            NavigateToMainActivityAction
        }
    }.stateIn(viewModelScope, Eagerly, Loading)
}

sealed class LaunchNavigatonAction {
    object NavigateToOnboardingAction : LaunchNavigatonAction()
    object NavigateToMainActivityAction : LaunchNavigatonAction()
}
