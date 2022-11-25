package com.berners.truecaller

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.NavDestination.Companion.hierarchy
import com.berners.truecaller.ui.home.messages.Messages
//import app.tivi.account.AccountUi
//import app.tivi.episodedetails.EpisodeDetails
//import app.tivi.home.discover.Discover
//import app.tivi.home.followed.Followed
//import app.tivi.home.popular.PopularShows
//import app.tivi.home.recommended.RecommendedShows
//import app.tivi.home.search.Search
//import app.tivi.home.trending.TrendingShows
//import app.tivi.home.watched.Watched
//import app.tivi.showdetails.details.ShowDetails
//import app.tivi.showdetails.seasons.ShowSeasons
import com.berners.truecaller.ui.home.calls.Calls
import com.berners.truecaller.ui.showphone.phone.ShowPhone
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import timber.log.Timber

internal sealed class Screen(val route: String) {
    object Calls : Screen("calls")
    object Messages : Screen("messages")
    object Contacts : Screen("contacts")
    object Settings : Screen("settings")
}

private sealed class LeafScreen(
    private val route: String
) {
    fun createRoute(root: Screen) = "${root.route}/$route"

    object Calls : LeafScreen("calls")
    object Messages : LeafScreen("messages")
    object Contacts : LeafScreen("contacts")
    object Settings : LeafScreen("settings")

    object ShowPhone : LeafScreen("phone/{phoneE164Format}") {
        fun createRoute(root: Screen, phoneE164Format: String): String {
            return "${root.route}/phone/$phoneE164Format"
        }
    }

//    object EpisodeDetails : LeafScreen("episode/{episodeId}") {
//        fun createRoute(root: Screen, episodeId: Long): String {
//            return "${root.route}/episode/$episodeId"
//        }
//    }
//
//    object ShowSeasons : LeafScreen("show/{showId}/seasons?seasonId={seasonId}") {
//        fun createRoute(
//            root: Screen,
//            showId: Long,
//            seasonId: Long? = null
//        ): String {
//            return "${root.route}/show/$showId/seasons".let {
//                if (seasonId != null) "$it?seasonId=$seasonId" else it
//            }
//        }
//    }

//    object RecommendedShows : LeafScreen("recommendedshows")
//    object Watched : LeafScreen("watched")
//    object Search : LeafScreen("search")
//    object Account : LeafScreen("account")
}

@ExperimentalAnimationApi
@Composable
internal fun AppNavigation(
    navController: NavHostController,
    onOpenSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Calls.route,
        enterTransition = { defaultTrueEnterTransition(initialState, targetState) },
        exitTransition = { defaultTrueExitTransition(initialState, targetState) },
        popEnterTransition = { defaultTruePopEnterTransition() },
        popExitTransition = { defaultTruePopExitTransition() },
        modifier = modifier
    ) {
        addCallsTopLevel(navController, onOpenSettings)
        addMessagesTopLevel(navController, onOpenSettings)
        addContactsTopLevel(navController, onOpenSettings)
        addSettingsTopLevel(navController, onOpenSettings)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addCallsTopLevel(
    navController: NavController,
    openSettings: () -> Unit
) {
    navigation(
        route = Screen.Calls.route,
        startDestination = LeafScreen.Calls.createRoute(Screen.Calls)
    ) {
        addCalls(navController, Screen.Calls)
//        addAccount(Screen.Calls, openSettings)
        addShowPhone(navController, Screen.Calls)
//        addShowSeasons(navController, Screen.Calls)
//        addEpisodeDetails(navController, Screen.Calls)
//        addRecommendedShows(navController, Screen.Calls)
//        addTrendingShows(navController, Screen.Calls)
//        addPopularShows(navController, Screen.Calls)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addMessagesTopLevel(
    navController: NavController,
    openSettings: () -> Unit
) {
    navigation(
        route = Screen.Messages.route,
        startDestination = LeafScreen.Messages.createRoute(Screen.Messages)
    ) {
        addMessages(navController, Screen.Messages)
//        addAccount(Screen.Messages, openSettings)
//        addShowDetails(navController, Screen.Messages)
//        addShowSeasons(navController, Screen.Messages)
//        addEpisodeDetails(navController, Screen.Messages)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addContactsTopLevel(
    navController: NavController,
    openSettings: () -> Unit
) {
    navigation(
        route = Screen.Contacts.route,
        startDestination = LeafScreen.Contacts.createRoute(Screen.Contacts)
    ) {
//        addWatchedShows(navController, Screen.Contacts)
//        addAccount(Screen.Contacts, openSettings)
//        addShowDetails(navController, Screen.Contacts)
//        addShowSeasons(navController, Screen.Contacts)
//        addEpisodeDetails(navController, Screen.Contacts)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addSettingsTopLevel(
    navController: NavController,
    openSettings: () -> Unit
) {
    navigation(
        route = Screen.Settings.route,
        startDestination = LeafScreen.Settings.createRoute(Screen.Settings)
    ) {
//        addSearch(navController, Screen.Settings)
//        addAccount(Screen.Settings, openSettings)
//        addShowDetails(navController, Screen.Settings)
//        addShowSeasons(navController, Screen.Settings)
//        addEpisodeDetails(navController, Screen.Settings)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addCalls(
    navController: NavController,
    root: Screen
) {
    composable(
        route = LeafScreen.Calls.createRoute(root)
    ) {
        Calls(
            openShowPhone = { phoneE164Format: String ->
                Timber.d(phoneE164Format)
                navController.navigate(LeafScreen.ShowPhone.createRoute(root, phoneE164Format))

//                // If we have an season id, we also open that
//                if (phoneE164Format != null) {
//                    navController.navigate(
//                        LeafScreen.ShowSeasons.createRoute(root, showId, seasonId)
//                    )
//                }
//                // If we have an episodeId, we also open that
//                if (episodeId != null) {
//                    navController.navigate(LeafScreen.EpisodeDetails.createRoute(root, episodeId))
//                }
            },
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addMessages(
    navController: NavController,
    root: Screen
) {
    composable(
        route = LeafScreen.Messages.createRoute(root)
    ) {
        Messages(
//            openShowDetails = { showId ->
//                navController.navigate(LeafScreen.ShowPhone.createRoute(root, showId))
//            },
//            openUser = {
//                navController.navigate(LeafScreen.Account.createRoute(root))
//            }
        )
    }
}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addWatchedShows(
//    navController: NavController,
//    root: Screen
//) {
//    composable(
//        route = LeafScreen.Watched.createRoute(root),
//        debugLabel = "Watched()"
//    ) {
//        Watched(
//            openShowDetails = { showId ->
//                navController.navigate(LeafScreen.ShowPhone.createRoute(root, showId))
//            },
//            openUser = {
//                navController.navigate(LeafScreen.Account.createRoute(root))
//            }
//        )
//    }
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addSearch(
//    navController: NavController,
//    root: Screen
//) {
//    composable(LeafScreen.Search.createRoute(root)) {
//        Search(
//            openShowDetails = { showId ->
//                navController.navigate(LeafScreen.ShowPhone.createRoute(root, showId))
//            }
//        )
//    }
//}
//
@ExperimentalAnimationApi
private fun NavGraphBuilder.addShowPhone(
    navController: NavController,
    root: Screen
) {
    composable(
        route = LeafScreen.ShowPhone.createRoute(root),
        arguments = listOf(
            navArgument("phoneE164Format") { type = NavType.StringType }
        )
    ) {
        ShowPhone(
            navigateUp = navController::navigateUp,
            openShowPhone = { phoneE164Format ->
                navController.navigate(LeafScreen.ShowPhone.createRoute(root, phoneE164Format))
            }
        )
//        ShowDetails(
//            navigateUp = navController::navigateUp,
//            openShowDetails = { showId ->
//                navController.navigate(LeafScreen.ShowPhone.createRoute(root, showId))
//            },
//            openEpisodeDetails = { episodeId ->
//                navController.navigate(LeafScreen.EpisodeDetails.createRoute(root, episodeId))
//            },
//            openSeasons = { showId, seasonId ->
//                navController.navigate(LeafScreen.ShowSeasons.createRoute(root, showId, seasonId))
//            }
//        )
    }
}
//
//@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterialApi::class)
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addEpisodeDetails(
//    navController: NavController,
//    root: Screen
//) {
//    bottomSheet(
//        route = LeafScreen.EpisodeDetails.createRoute(root),
//        debugLabel = "EpisodeDetails()",
//        arguments = listOf(
//            navArgument("episodeId") { type = NavType.LongType }
//        )
//    ) {
//        val bottomSheetNavigator = navController.navigatorProvider
//            .getNavigator(BottomSheetNavigator::class.java)
//        EpisodeDetails(
//            expandedValue = bottomSheetNavigator.navigatorSheetState.currentValue,
//            navigateUp = navController::navigateUp
//        )
//    }
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addRecommendedShows(
//    navController: NavController,
//    root: Screen
//) {
//    composable(
//        route = LeafScreen.RecommendedShows.createRoute(root),
//        debugLabel = "RecommendedShows()"
//    ) {
//        RecommendedShows(
//            openShowDetails = { showId ->
//                navController.navigate(LeafScreen.ShowPhone.createRoute(root, showId))
//            },
//            navigateUp = navController::navigateUp
//        )
//    }
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addTrendingShows(
//    navController: NavController,
//    root: Screen
//) {
//    composable(
//        route = LeafScreen.Contacts.createRoute(root),
//        debugLabel = "TrendingShows()"
//    ) {
//        TrendingShows(
//            openShowDetails = { showId ->
//                navController.navigate(LeafScreen.ShowPhone.createRoute(root, showId))
//            },
//            navigateUp = navController::navigateUp
//        )
//    }
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addPopularShows(
//    navController: NavController,
//    root: Screen
//) {
//    composable(
//        route = LeafScreen.Settings.createRoute(root),
//        debugLabel = "PopularShows()"
//    ) {
//        PopularShows(
//            openShowDetails = { showId ->
//                navController.navigate(LeafScreen.ShowPhone.createRoute(root, showId))
//            },
//            navigateUp = navController::navigateUp
//        )
//    }
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addAccount(
//    root: Screen,
//    onOpenSettings: () -> Unit
//) {
//    dialog(
//        route = LeafScreen.Account.createRoute(root),
//        debugLabel = "AccountUi()"
//    ) {
//        AccountUi(
//            openSettings = onOpenSettings
//        )
//    }
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addShowSeasons(
//    navController: NavController,
//    root: Screen
//) {
//    composable(
//        route = LeafScreen.ShowSeasons.createRoute(root),
//        debugLabel = "ShowSeasons()",
//        arguments = listOf(
//            navArgument("showId") {
//                type = NavType.LongType
//            },
//            navArgument("seasonId") {
//                type = NavType.StringType
//                nullable = true
//            }
//        )
//    ) {
//        ShowSeasons(
//            navigateUp = navController::navigateUp,
//            openEpisodeDetails = { episodeId ->
//                navController.navigate(LeafScreen.EpisodeDetails.createRoute(root, episodeId))
//            },
//            initialSeasonId = it.arguments?.getString("seasonId")?.toLong()
//        )
//    }
//}

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