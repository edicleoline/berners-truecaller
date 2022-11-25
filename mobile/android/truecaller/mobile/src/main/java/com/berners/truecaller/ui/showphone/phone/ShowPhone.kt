package com.berners.truecaller.ui.showphone.phone

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.hilt.navigation.compose.hiltViewModel
import com.berners.truecaller.R
import com.berners.truecaller.ui.compose.*
import com.berners.truecaller.ui.compose.Layout.bodyMargin
import com.berners.truecaller.ui.compose.Layout.gutter
import com.berners.truecaller.ui.theme.TruecallerTheme
import com.berners.truecaller.ui.theme.Typography

@Composable
fun ShowPhone(
    navigateUp: () -> Unit,
    openShowPhone: (phoneE164Format: String) -> Unit,
//    openEpisodeDetails: (episodeId: Long) -> Unit,
//    openSeasons: (showId: Long, seasonId: Long) -> Unit
) {
    ShowPhone(
        viewModel = hiltViewModel(),
        navigateUp = navigateUp,
        openShowPhone = openShowPhone,
//        openEpisodeDetails = openEpisodeDetails,
//        openSeasons = openSeasons
    )
}

@Composable
internal fun ShowPhone(
    viewModel: ShowPhoneViewModel,
    navigateUp: () -> Unit,
    openShowPhone: (phoneE164Format: String) -> Unit,
//    openEpisodeDetails: (episodeId: Long) -> Unit,
//    openSeasons: (showId: Long, seasonId: Long) -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val listState = rememberLazyListState()

    Scaffold(
        topBar = {
            var appBarHeight by remember { mutableStateOf(0) }
            val showAppBarBackground by remember {
                derivedStateOf {
                    val visibleItemsInfo = listState.layoutInfo.visibleItemsInfo
                    when {
                        visibleItemsInfo.isEmpty() -> false
                        appBarHeight <= 0 -> false
                        else -> {
                            val firstVisibleItem = visibleItemsInfo[0]
                            when {
                                // If the first visible item is > 0, we want to show the app bar background
                                firstVisibleItem.index > 0 -> true
                                // If the first item is visible, only show the app bar background once the only
                                // remaining part of the item is <= the app bar
                                else -> firstVisibleItem.size + firstVisibleItem.offset <= appBarHeight
                            }
                        }
                    }
                }
            }

            ShowPhoneAppBar(
                title = /*viewState.show.title*/"title test",
                isRefreshing = /*viewState.refreshing*/false,
                showAppBarBackground = showAppBarBackground,
                navigateUp = navigateUp,
                refresh = /*refresh*/{},
                modifier = Modifier
                    .fillMaxWidth()
                    .onSizeChanged { appBarHeight = it.height }
            )
        },
//        floatingActionButton = {
////            val expanded by remember {
////                derivedStateOf {
////                    listState.firstVisibleItemIndex > 0
////                }
////            }
////
////            ToggleShowFollowFloatingActionButton(
////                isFollowed = viewState.isFollowed,
////                expanded = { expanded },
////                onClick = onToggleShowFollowed
////            )
//        },
        snackbarHost = { snackBarHostState ->
            SwipeDismissSnackbarHost(
                hostState = snackBarHostState,
                modifier = Modifier
                    .padding(horizontal = bodyMargin)
                    .fillMaxWidth()
            )
        }
    ) { contentPadding ->
//        LogCompositions("ShowDetails")

        Surface(modifier = Modifier.bodyWidth()) {
            ShowPhoneScrollingContent(
                modifier = Modifier.fillMaxSize(),
                contentPadding = contentPadding,
                listState = listState,
            )
        }
    }
}

@Composable
private fun ShowPhoneScrollingContent(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues,
    listState: LazyListState,
) {
//    LogCompositions("ShowDetailsScrollingContent")

    LazyColumn(
        state = listState,
        contentPadding = contentPadding.copy(copyTop = false),
        modifier = modifier
    ) {
        item {
            BackdropHeader(
//                backdropImage = backdropImage,
                showTitle = "backimage title",
                modifier = Modifier
                    .fillMaxWidth()
//                    .aspectRatio(16f / 10)
                    .clipToBounds()
                    .offset {
                        IntOffset(
                            x = 0,
                            y = if (listState.firstVisibleItemIndex == 0) {
                                listState.firstVisibleItemScrollOffset / 2
                            } else 0
                        )
                    }
            )
        }

        item {
            Spacer(modifier = Modifier.height(max(gutter, bodyMargin)))
        }

        item {
            Text("item text before gutter")
        }

        gutterSpacer()

        item {
            Header(/*stringResource(R.string.details_about)*/"header title")
        }
    }
}

@Composable
private fun Header(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = bodyMargin, vertical = gutter)
            .height(650.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun ShowPhoneAppBar(
    title: String?,
    isRefreshing: Boolean,
    showAppBarBackground: Boolean,
    navigateUp: () -> Unit,
    refresh: () -> Unit,
    modifier: Modifier = Modifier
) {
//    LogCompositions("ShowDetailsAppBar")

    val backgroundColor by animateColorAsState(
        targetValue = when {
            showAppBarBackground -> /*MaterialTheme.colors.surface*/Color.Green
            else -> Color.Transparent
        },
        animationSpec = spring()
    )

    val elevation = 0.dp

    TopAppBar(
        title = {
            Crossfade(showAppBarBackground && title != null) { show ->
                if (show) Text(text = title!!)
                else {
                    Text(
                        text = "Identificado pelo Truecaller",
                        style = Typography.body2
                    )
                }
            }
        },
        contentPadding = WindowInsets.systemBars
            .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
            .asPaddingValues(),
        navigationIcon = {
            IconButton(
                onClick = navigateUp,
//                modifier = Modifier.iconButtonBackgroundScrim(enabled = !showAppBarBackground)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = /*stringResource(R.string.cd_navigate_up)*/null
                )
            }
        },
        actions = {
            if (isRefreshing) {
                AutoSizedCircularProgressIndicator(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxHeight()
                        .padding(16.dp)
                )
            } else {
                IconButton(
                    onClick = refresh,
//                    modifier = Modifier.iconButtonBackgroundScrim(enabled = !showAppBarBackground)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_overflow_menu_24dp),
                        contentDescription = /*stringResource(R.string.cd_refresh)*/null
                    )
                }
            }
        },
        elevation = elevation,
        backgroundColor = backgroundColor,
        modifier = modifier
    )
}

@Composable
private fun BackdropHeader(
    showTitle: String,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
//                .background(Color.Green)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(MaterialTheme.colors.secondary)
            ) {
//                Column(
////                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(WindowInsets.systemBars
//                            .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
//                            .asPaddingValues())
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .padding(top = 17.dp, start = 60.dp, end = 60.dp)
//
//                    ) {
//                        Text("test123")
//                    }
//                }

            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 0.dp)
                    .size(100.dp)
                    .padding(3.dp)
                    .clip(CircleShape)
                    .background(color = Color.White)
                    .padding(2.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                )
            }
        }
    }
}