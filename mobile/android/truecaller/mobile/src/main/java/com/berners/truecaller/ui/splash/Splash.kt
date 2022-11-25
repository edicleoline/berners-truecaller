package com.berners.truecaller.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.berners.truecaller.LeafSetupScreen
import com.berners.truecaller.SetupScreen
import com.berners.truecaller.ui.home.calls.CallsViewModel
import com.berners.truecaller.util.collectAsStateWithLifecycle
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect

@Composable
fun Splash(navController: NavController) {

    Splash(
        viewModel = hiltViewModel(),
        navController = navController
    )

//    LaunchedEffect(key1 = true) {
//        delay(2000)
//        navController.navigate(LeafSetupScreen.Home.createRoute(SetupScreen.Home))
//    }
}

@Composable
fun Splash(
    viewModel: SplashViewModel,
    navController: NavController
) {
    val viewState by viewModel.state.collectAsStateWithLifecycle()

    viewModel.test()

    if (viewState.route == LeafSetupScreen.Splash.createRoute(SetupScreen.Splash)) {
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
    }

    LaunchedEffect(viewState.route) {
        if (viewState.route != LeafSetupScreen.Splash.createRoute(SetupScreen.Splash)) {
            navController.navigate(viewState.route)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
    ) {
//        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
//        val logoAnimationState =
//            animateLottieCompositionAsState(composition = composition)
//        LottieAnimation(
//            composition = composition,
//            progress = { logoAnimationState.progress }
//        )
//        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
//            navController.navigate(Screen.Home.route)
//        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Splash", color = Color.White)
        }
    }
}