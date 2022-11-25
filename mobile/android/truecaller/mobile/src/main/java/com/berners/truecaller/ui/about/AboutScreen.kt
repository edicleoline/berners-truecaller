package com.berners.truecaller.ui.about

//import com.berners.truecaller.ui.AppDrawer
//import com.berners.truecaller.ui.Screen
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun AboutScreen(
//    navigateTo: (Screen) -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onBack: () -> Unit
) {


    // Returns a [CoroutineScope] that is scoped to the lifecycle of [HomeScreen]. When this
    // screen is removed from composition, the scope will be cancelled.
    val coroutineScope = rememberCoroutineScope()

    AboutScreen(
        onToggleFavorite = { /*TODO*/ },
        onRefreshPosts = { /*TODO*/ },
        onErrorDismiss = { /*TODO*/ },
//        navigateTo = navigateTo,
        scaffoldState = scaffoldState,
        onBack = onBack
    )
}

@Composable
fun AboutScreen(
    onToggleFavorite: (String) -> Unit,
    onRefreshPosts: () -> Unit,
    onErrorDismiss: () -> Unit,
//    navigateTo: (Screen) -> Unit,
    scaffoldState: ScaffoldState,
    onBack: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()
    Text("test123")
}

@Composable
private fun LoadingContent(
    empty: Boolean,
    emptyContent: @Composable () -> Unit,
    loading: Boolean,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit
) {
    if (empty) {
        emptyContent()
    } else {
        SwipeRefresh(
            state = rememberSwipeRefreshState(loading),
            onRefresh = onRefresh,
            content = content,
        )
    }
}