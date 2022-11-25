package com.berners.truecaller.ui.splash

import com.berners.truecaller.LeafSetupScreen
import com.berners.truecaller.SetupScreen

data class SplashViewState(
    val route: String = LeafSetupScreen.Splash.createRoute(SetupScreen.Splash)
) {
    companion object {
        val Empty = SplashViewState()
    }
}