package com.berners.truecaller.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
//    observeTraktAuthState: ObserveTraktAuthState,
//    private val updateUserDetails: UpdateUserDetails,
//    observeUserDetails: ObserveUserDetails,
//    private val clearTraktAuthState: ClearTraktAuthState,
//    private val logger: Logger
) : ViewModel() {
    init {
//        viewModelScope.launch {
//            observeUserDetails.flow.collect { user ->
//                logger.setUserId(user?.username ?: "")
//            }
//        }
//        observeUserDetails(ObserveUserDetails.Params("me"))
//
//        viewModelScope.launch {
//            observeTraktAuthState.flow.collect { state ->
//                if (state == TraktAuthState.LOGGED_IN) refreshMe()
//            }
//        }
//        observeTraktAuthState(Unit)
    }

    private fun refreshMe() {
//        viewModelScope.launch {
//            try {
//                updateUserDetails.executeSync(UpdateUserDetails.Params("me", false))
//            } catch (e: HttpException) {
//                if (e.code() == 401) {
//                    // If we got a 401 back from Trakt, we should clear out the auth state
//                    clearTraktAuthState.executeSync(Unit)
//                }
//            } catch (t: Throwable) {
//                // no-op
//            }
//        }
    }
}