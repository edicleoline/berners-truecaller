package com.berners.truecaller.ui.splash

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berners.truecaller.LeafSetupScreen
import com.berners.truecaller.SetupScreen
import com.berners.truecaller.data.domain.observers.ObserveIncomings
import com.berners.truecaller.data.repositories.IncomingRepository
import com.berners.truecaller.data.repositories.PhoneRepository
import com.berners.truecaller.model.Incoming
import com.berners.truecaller.shared.data.prefs.PreferenceStorage
import com.berners.truecaller.shared.domain.auth.ObserveUserAuthStateUseCase
import com.berners.truecaller.shared.domain.prefs.OnboardingCompleteActionUseCase
import com.berners.truecaller.shared.domain.prefs.OnboardingCompletedUseCase
import com.berners.truecaller.shared.result.Result
import com.berners.truecaller.shared.result.data
import com.berners.truecaller.ui.home.calls.CallsViewState
import com.berners.truecaller.util.WhileUiSubscribed
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    onboardingCompletedUseCase: OnboardingCompletedUseCase,
    observeUserAuthStateUseCase: ObserveUserAuthStateUseCase,
    private val incomingRepository: IncomingRepository,
) : ViewModel() {

//    private val _state = MutableStateFlow(SplashViewState.Empty)
//    val state: StateFlow<SplashViewState> = _state

    val state: StateFlow<SplashViewState> = combine(
        onboardingCompletedUseCase.invoke(Unit),
        observeUserAuthStateUseCase.invoke(Unit)
    ) { onboardingCompletedUseCase, observeUserAuthStateUseCase
        ->
        var route = LeafSetupScreen.Splash.createRoute(SetupScreen.Splash)

        if (onboardingCompletedUseCase.data == false) {
            route = LeafSetupScreen.Onboarding.createRoute(SetupScreen.Onboarding)
        } else {
            route = LeafSetupScreen.Home.createRoute(SetupScreen.Home)
        }

        Timber.d(route)

        SplashViewState(route = route)
    }
    .stateIn(
        scope = viewModelScope,
        started = Eagerly,
        initialValue = SplashViewState.Empty
    )

//    val launchDestination = onboardingCompletedUseCase(Unit).map { result ->
//        if (result.data == false) {
//            _state.value = _state.value.copy(route = LeafSetupScreen.Onboarding.createRoute(SetupScreen.Onboarding))
//        }
//    }.stateIn(viewModelScope, Eagerly, Result.Loading)

    fun test() = viewModelScope.launch {
        delay(5000)

        for (item in Incoming.mock.list) {
            incomingRepository.localIncomingDataSource.save(item)
        }



//        _state.value = _state.value.copy(route = LeafSetupScreen.Home.createRoute(SetupScreen.Home))
//        _state.value = _state.value.copy(route = LeafSetupScreen.SignIn.createRoute(SetupScreen.SignIn))
//        _state.value = _state.value.copy(route = LeafSetupScreen.Onboarding.createRoute(SetupScreen.Onboarding))
    }

    init {

    }
}