package com.berners.truecaller.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.berners.truecaller.shared.analytics.AnalyticsHelper
import com.berners.truecaller.ui.theme.TruecallerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.lifecycle.ViewTreeViewModelStoreOwner
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.berners.truecaller.ContentViewSetter
import com.berners.truecaller.ui.home.HomeScreen
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    @Inject
    lateinit var analytics: AnalyticsHelper

    @Inject internal lateinit var contentViewSetter: ContentViewSetter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        val composeView = ComposeView(this).apply {
            setContent {
                TrueContent()
            }
        }

        // Copied from setContent {} ext-fun
        setOwners()

        contentViewSetter.setContentView(this, composeView)
    }

    @Composable
    private fun TrueContent() {
        CompositionLocalProvider(
//            LocalTiviDateFormatter provides tiviDateFormatter,
//            LocalTiviTextCreator provides textCreator
        ) {
//            val systemUiController = rememberSystemUiController()
//            val useDarkIcons = MaterialTheme.colors.isLight
//            SideEffect {
//                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = useDarkIcons)
//            }

            TruecallerTheme {
                HomeScreen(
//                    analytics = analytics,
                    onOpenSettings = {}
                )
            }
        }
    }
}

private fun ComponentActivity.setOwners() {
    val decorView = window.decorView
    if (ViewTreeLifecycleOwner.get(decorView) == null) {
        ViewTreeLifecycleOwner.set(decorView, this)
    }
    if (ViewTreeViewModelStoreOwner.get(decorView) == null) {
        ViewTreeViewModelStoreOwner.set(decorView, this)
    }
    if (decorView.findViewTreeSavedStateRegistryOwner() == null) {
        decorView.setViewTreeSavedStateRegistryOwner(this)
    }
}

