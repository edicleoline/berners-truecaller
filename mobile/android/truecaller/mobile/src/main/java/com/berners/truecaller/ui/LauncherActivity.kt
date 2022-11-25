package com.berners.truecaller.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.WindowCompat
import androidx.lifecycle.*
import com.berners.truecaller.ContentViewSetter
import com.berners.truecaller.ui.LaunchNavigatonAction.NavigateToMainActivityAction
import com.berners.truecaller.ui.LaunchNavigatonAction.NavigateToOnboardingAction
import com.berners.truecaller.ui.home.HomeScreen
import com.berners.truecaller.ui.onboarding.OnboardingActivity
import com.berners.truecaller.ui.theme.TruecallerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@AndroidEntryPoint
class LauncherActivity : AppCompatActivity() {

    @Inject
    internal lateinit var contentViewSetter: ContentViewSetter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val viewModel: LaunchViewModel by viewModels()

        val composeView = ComposeView(this).apply {
            setContent {
                LauncherContent()
            }
        }

        contentViewSetter.setContentView(this, composeView)

//        lifecycleScope.launch {
//            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.launchDestination.collect { action ->
//                    when (action) {
//                        is NavigateToMainActivityAction -> startActivity(
//                            Intent(this@LauncherActivity, MainActivity::class.java)
//                        )
//                        is NavigateToOnboardingAction -> startActivity(
//                            Intent(this@LauncherActivity, OnboardingActivity::class.java)
//                        )
//                    }
//                    finish()
//                }
//            }
//        }
    }
}

@Composable
private fun LauncherContent() {
    TruecallerTheme {
        Text("asd")
    }
}