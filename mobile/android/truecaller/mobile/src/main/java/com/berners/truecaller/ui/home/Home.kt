package com.berners.truecaller.ui.home

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailDefaults
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Call
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.berners.truecaller.AppNavigation
import com.berners.truecaller.R
import com.berners.truecaller.Screen
import com.berners.truecaller.shared.analytics.AnalyticsHelper
import com.berners.truecaller.ui.theme.TruecallerTheme
import com.berners.truecaller.ui.theme.Typography
import com.berners.truecaller.ui.theme.navigationItemText
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.insets.ui.BottomNavigation
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalMaterialApi::class,
    ExperimentalMaterialNavigationApi::class
)
@Composable
fun HomeScreen(
//    analytics: AnalyticsHelper,
    onOpenSettings: () -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = MaterialTheme.colors.isLight)


    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberAnimatedNavController(bottomSheetNavigator)

//    LaunchedEffect(navController, analytics) {
//        navController.currentBackStackEntryFlow.collect { entry ->
//            analytics.trackScreenView(
//                label = entry.debugLabel,
//                route = entry.destination.route,
//                arguments = entry.arguments
//            )
//        }
//    }

    val configuration = LocalConfiguration.current
    val useBottomNavigation by remember {
        derivedStateOf { configuration.smallestScreenWidthDp < 600 }
    }

    Scaffold(
        bottomBar = {
            if (useBottomNavigation) {
                val currentSelectedItem by navController.currentScreenAsState()
                HomeBottomNavigation(
                    selectedNavigation = currentSelectedItem,
                    onNavigationSelected = { selected ->
                        navController.navigate(selected.route) {
                            launchSingleTop = true
                            restoreState = true

                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Spacer(
                    Modifier
                        .windowInsetsBottomHeight(WindowInsets.navigationBars)
                        .fillMaxWidth()
                )
            }
        }
    ) {
        Row(Modifier.fillMaxSize()) {
            if (!useBottomNavigation) {
                val currentSelectedItem by navController.currentScreenAsState()
                HomeNavigationRail(
                    selectedNavigation = currentSelectedItem,
                    onNavigationSelected = { selected ->
                        navController.navigate(selected.route) {
                            launchSingleTop = true
                            restoreState = true

                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                    },
                    modifier = Modifier.fillMaxHeight()
                )

                Divider(
                    Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
            }

            ModalBottomSheetLayout(bottomSheetNavigator) {
                AppNavigation(
                    navController = navController,
                    onOpenSettings = onOpenSettings,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
            }
        }
    }
}

@Stable
@Composable
private fun NavController.currentScreenAsState(): State<Screen> {
    val selectedItem = remember { mutableStateOf<Screen>(Screen.Calls) }

    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when {
                destination.hierarchy.any { it.route == Screen.Calls.route } -> {
                    selectedItem.value = Screen.Calls
                }
                destination.hierarchy.any { it.route == Screen.Contacts.route } -> {
                    selectedItem.value = Screen.Contacts
                }
                destination.hierarchy.any { it.route == Screen.Messages.route } -> {
                    selectedItem.value = Screen.Messages
                }
                destination.hierarchy.any { it.route == Screen.Settings.route } -> {
                    selectedItem.value = Screen.Settings
                }
            }
        }
        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }

    return selectedItem
}

@Composable
internal fun HomeBottomNavigation(
    selectedNavigation: Screen,
    onNavigationSelected: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface/*.copy(alpha = AppBarAlphas.translucentBarAlpha())*/,
        contentColor = MaterialTheme.colors.primaryVariant,
//        contentColor = contentColorFor(MaterialTheme.colors.surface),
        contentPadding = WindowInsets.navigationBars.asPaddingValues(),
        modifier = modifier
    ) {
        HomeNavigationItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    HomeNavigationItemIcon(
                        item = item,
                        selected = selectedNavigation == item.screen
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.labelResId),
                        style = Typography.navigationItemText
                    )
                },
                selected = selectedNavigation == item.screen,
                onClick = { onNavigationSelected(item.screen) },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.primaryVariant,
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
internal fun HomeNavigationRail(
    selectedNavigation: Screen,
    onNavigationSelected: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colors.surface,
        elevation = NavigationRailDefaults.Elevation,
        modifier = modifier
    ) {
        NavigationRail(
            backgroundColor = Color.Transparent,
            contentColor = MaterialTheme.colors.onSurface,
            elevation = 0.dp,
            modifier = Modifier.padding(
                WindowInsets.systemBars
                    .only(WindowInsetsSides.Start + WindowInsetsSides.Vertical)
                    .asPaddingValues()
            )
        ) {
            HomeNavigationItems.forEach { item ->
                NavigationRailItem(
                    icon = {
                        HomeNavigationItemIcon(
                            item = item,
                            selected = selectedNavigation == item.screen
                        )
                    },
                    alwaysShowLabel = false,
                    label = {
                        Text(
                            text = stringResource(item.labelResId),
                            style = Typography.navigationItemText
                        )
                    },
                    selected = selectedNavigation == item.screen,
                    onClick = { onNavigationSelected(item.screen) }
                )
            }
        }
    }
}

@Composable
private fun HomeNavigationItemIcon(item: HomeNavigationItem, selected: Boolean) {
    val painter = when (item) {
        is HomeNavigationItem.ResourceIcon -> painterResource(item.iconResId)
        is HomeNavigationItem.ImageVectorIcon -> rememberVectorPainter(item.iconImageVector)
    }
    val selectedPainter = when (item) {
        is HomeNavigationItem.ResourceIcon -> item.selectedIconResId?.let { painterResource(it) }
        is HomeNavigationItem.ImageVectorIcon -> item.selectedImageVector?.let { rememberVectorPainter(it) }
    }

    if (selectedPainter != null) {
        Crossfade(targetState = selected) {
            Icon(
                painter = if (it) selectedPainter else painter,
                contentDescription = stringResource(item.contentDescriptionResId)
            )
        }
    } else {
        Icon(
            painter = painter,
            contentDescription = stringResource(item.contentDescriptionResId)
        )
    }
}

private sealed class HomeNavigationItem(
    val screen: Screen,
    @StringRes val labelResId: Int,
    @StringRes val contentDescriptionResId: Int
) {
    class ResourceIcon(
        screen: Screen,
        @StringRes labelResId: Int,
        @StringRes contentDescriptionResId: Int,
        @DrawableRes val iconResId: Int,
        @DrawableRes val selectedIconResId: Int? = null
    ) : HomeNavigationItem(screen, labelResId, contentDescriptionResId)

    class ImageVectorIcon(
        screen: Screen,
        @StringRes labelResId: Int,
        @StringRes contentDescriptionResId: Int,
        val iconImageVector: ImageVector,
        val selectedImageVector: ImageVector? = null
    ) : HomeNavigationItem(screen, labelResId, contentDescriptionResId)
}

private val HomeNavigationItems = listOf(
    HomeNavigationItem.ImageVectorIcon(
        screen = Screen.Calls,
        labelResId = R.string.home_calls,
        contentDescriptionResId = R.string.home_calls,
        iconImageVector = Icons.Outlined.Call,
        selectedImageVector = Icons.Default.Call
    ),
    HomeNavigationItem.ImageVectorIcon(
        screen = Screen.Messages,
        labelResId = R.string.home_messages,
        contentDescriptionResId = R.string.home_messages,
        iconImageVector = Icons.Default.Email,
        selectedImageVector = Icons.Default.Email
    ),
    HomeNavigationItem.ImageVectorIcon(
        screen = Screen.Contacts,
        labelResId = R.string.home_contacts,
        contentDescriptionResId = R.string.home_contacts,
        iconImageVector = Icons.Default.Person,
        selectedImageVector = Icons.Default.Person
    ),
    HomeNavigationItem.ImageVectorIcon(
        screen = Screen.Settings,
        labelResId = R.string.home_premium,
        contentDescriptionResId = R.string.home_premium,
        iconImageVector = Icons.Default.Star,
        selectedImageVector = Icons.Default.Star
    )
)