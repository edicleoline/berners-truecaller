package com.berners.truecaller.ui.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.berners.truecaller.LeafSetupScreen
import com.berners.truecaller.SetupScreen
import com.berners.truecaller.ui.splash.SplashViewModel
import com.berners.truecaller.util.collectAsStateWithLifecycle
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SignIn(navController: NavController) {

    SignIn(
        viewModel = hiltViewModel(),
        navController = navController
    )
}

@Composable
fun SignIn(
    viewModel: SplashViewModel,
    navController: NavController
) {
    val viewState by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "SignIn", color = Color.White)
        }
    }
}