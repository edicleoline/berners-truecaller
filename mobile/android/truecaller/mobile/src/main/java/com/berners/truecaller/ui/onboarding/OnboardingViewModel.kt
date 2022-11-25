package com.berners.truecaller.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berners.truecaller.shared.domain.prefs.OnboardingCompleteActionUseCase
import com.berners.truecaller.ui.splash.SplashViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val onboardingCompleteActionUseCase: OnboardingCompleteActionUseCase,
) : ViewModel() {

    private val _navigationActions = Channel<OnboardingNavigationAction>(Channel.CONFLATED)
    // OnboardingViewModel is a shared ViewModel. Therefore, the navigation actions could be
    // received by multiple collectors at the same time. With `receiveAsFlow`, we make sure only
    // one collector will process the navigation event to avoid multiple back stack entries.
    val navigationActions = _navigationActions.receiveAsFlow()


    fun complete() {
        Timber.d("complete!!!! click")
        viewModelScope.launch {
            onboardingCompleteActionUseCase(true)
            _navigationActions.send(OnboardingNavigationAction.NavigateToMainScreen)
        }
    }
}

sealed class OnboardingNavigationAction {
    object NavigateToMainScreen : OnboardingNavigationAction()
    object NavigateToSignInDialog : OnboardingNavigationAction()
}