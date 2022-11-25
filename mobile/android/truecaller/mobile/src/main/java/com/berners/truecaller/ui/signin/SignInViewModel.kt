package com.berners.truecaller.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(

) : ViewModel() {

    fun onSignIn() {
        viewModelScope.launch {
            Timber.d("Sign in requested")
//            emitSignInRequest()
        }
    }

    fun onSignOut() {
        viewModelScope.launch {
            Timber.d("Sign out requested")
//            emitSignOutRequest()
        }
    }
}
