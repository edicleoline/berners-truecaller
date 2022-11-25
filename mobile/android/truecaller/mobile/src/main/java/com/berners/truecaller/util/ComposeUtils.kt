package com.berners.truecaller.util

import android.os.Bundle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

//import com.example.android.architecture.blueprints.todoapp.TodoApplication
//import com.example.android.architecture.blueprints.todoapp.ViewModelFactory
//import com.google.accompanist.swiperefresh.SwipeRefresh
//import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
//
//val primaryDarkColor: Color = Color(0xFF263238)
//
///**
// * Obtain the [ViewModelFactory] for ViewModels in this app
// */
//@Composable
//fun getViewModelFactory(defaultArgs: Bundle? = null): ViewModelFactory {
//    val repository = (LocalContext.current.applicationContext as TodoApplication).taskRepository
//    return ViewModelFactory(repository, LocalSavedStateRegistryOwner.current, defaultArgs)
//}
//
/**
 * Display an initial empty state or swipe to refresh content.
 *
 * @param loading (state) when true, display a loading spinner over [content]
 * @param empty (state) when true, display [emptyContent]
 * @param emptyContent (slot) the content to display for the empty state
 * @param onRefresh (event) event to request refresh
 * @param modifier the modifier to apply to this layout.
 * @param content (slot) the main content to show
 */
@Composable
fun LoadingContent(
    modifier: Modifier = Modifier,
    loading: Boolean,
    empty: Boolean,
    emptyContent: @Composable () -> Unit,
    swipeRefresh: Boolean = false,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit
) {
    if (empty) {
        emptyContent()
    } else {
        if (swipeRefresh) {
            SwipeRefresh(
                state = rememberSwipeRefreshState(loading),
                onRefresh = onRefresh,
                modifier = modifier,
                content = content,
            )
        } else {
            if (loading) {
                Text(text = "loading")
            } else {
                content()
            }
        }

    }
}