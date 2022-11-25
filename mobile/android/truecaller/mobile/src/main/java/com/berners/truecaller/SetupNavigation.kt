package com.berners.truecaller

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.NavDestination.Companion.hierarchy
import com.berners.truecaller.ui.home.HomeScreen
import com.berners.truecaller.ui.onboarding.Onboarding
import com.berners.truecaller.ui.signin.SignIn
import com.berners.truecaller.ui.splash.Splash
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

sealed class SetupScreen(val route: String) {
    object Splash : SetupScreen("splash")
    object Home : SetupScreen("home")
    object SignIn : SetupScreen("signin")
    object Onboarding : SetupScreen("onboarding")
}

sealed class LeafSetupScreen(
    private val route: String
) {
    fun createRoute(root: SetupScreen) = "${root.route}/$route"

    object Splash : LeafSetupScreen("splash")
    object Home : LeafSetupScreen("home")
    object SignIn : LeafSetupScreen("signin")
    object Onboarding : LeafSetupScreen("onboarding")
}

@ExperimentalAnimationApi
@Composable
fun SetupNavigation(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = SetupScreen.Splash.route,
        enterTransition = { defaultTrueEnterTransition(initialState, targetState) },
        exitTransition = { defaultTrueExitTransition(initialState, targetState) },
        popEnterTransition = { defaultTruePopEnterTransition() },
        popExitTransition = { defaultTruePopExitTransition() },
    ) {
        addSplashTopLevel(navController)
        addOnboardingTopLevel(navController)
        addSignInTopLevel(navController)
        addHomeTopLevel(navController)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addSplashTopLevel(
    navController: NavController
) {
    navigation(
        route = SetupScreen.Splash.route,
        startDestination = LeafSetupScreen.Splash.createRoute(SetupScreen.Splash)
    ) {
        addSplash(navController, SetupScreen.Splash)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addSplash(
    navController: NavController,
    root: SetupScreen
) {
    composable(
        route = LeafSetupScreen.Splash.createRoute(root)
    ) {
        Splash(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addHomeTopLevel(
    navController: NavController
) {
    navigation(
        route = SetupScreen.Home.route,
        startDestination = LeafSetupScreen.Home.createRoute(SetupScreen.Home)
    ) {
        addHome(navController, SetupScreen.Home)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addHome(
    navController: NavController,
    root: SetupScreen
) {
    composable(
        route = LeafSetupScreen.Home.createRoute(root)
    ) {
        HomeScreen(
            onOpenSettings = {}
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addSignInTopLevel(
    navController: NavController
) {
    navigation(
        route = SetupScreen.SignIn.route,
        startDestination = LeafSetupScreen.SignIn.createRoute(SetupScreen.SignIn)
    ) {
        addSignIn(navController, SetupScreen.SignIn)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addSignIn(
    navController: NavController,
    root: SetupScreen
) {
    composable(
        route = LeafSetupScreen.SignIn.createRoute(root)
    ) {
        SignIn(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addOnboardingTopLevel(
    navController: NavController
) {
    navigation(
        route = SetupScreen.Onboarding.route,
        startDestination = LeafSetupScreen.Onboarding.createRoute(SetupScreen.Onboarding)
    ) {
        addOnboarding(navController, SetupScreen.Onboarding)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addOnboarding(
    navController: NavController,
    root: SetupScreen
) {
    composable(
        route = LeafSetupScreen.Onboarding.createRoute(root)
    ) {
//        Onboarding(navController = navController)
    }
}

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultTrueEnterTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry
): EnterTransition {
    val initialNavGraph = initial.destination.hostNavGraph
    val targetNavGraph = target.destination.hostNavGraph
    // If we're crossing nav graphs (bottom navigation graphs), we crossfade
    if (initialNavGraph.id != targetNavGraph.id) {
        return fadeIn()
    }
    // Otherwise we're in the same nav graph, we can imply a direction
    return fadeIn() + slideIntoContainer(AnimatedContentScope.SlideDirection.Start)
}

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultTrueExitTransition(
    initial: NavBackStackEntry,
    target: NavBackStackEntry
): ExitTransition {
    val initialNavGraph = initial.destination.hostNavGraph
    val targetNavGraph = target.destination.hostNavGraph
    // If we're crossing nav graphs (bottom navigation graphs), we crossfade
    if (initialNavGraph.id != targetNavGraph.id) {
        return fadeOut()
    }
    // Otherwise we're in the same nav graph, we can imply a direction
    return fadeOut() + slideOutOfContainer(AnimatedContentScope.SlideDirection.Start)
}

private val NavDestination.hostNavGraph: NavGraph
    get() = hierarchy.first { it is NavGraph } as NavGraph

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultTruePopEnterTransition(): EnterTransition {
    return fadeIn() + slideIntoContainer(AnimatedContentScope.SlideDirection.End)
}

@ExperimentalAnimationApi
private fun AnimatedContentScope<*>.defaultTruePopExitTransition(): ExitTransition {
    return fadeOut() + slideOutOfContainer(AnimatedContentScope.SlideDirection.End)
}