package com.berners.truecaller.ui.home.calls

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.IconButton
import androidx.compose.material.Icon
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.berners.truecaller.R
import com.berners.truecaller.ui.components.TrueScrollableTabRow
import com.berners.truecaller.ui.compose.Layout
import com.berners.truecaller.ui.compose.SwipeDismissSnackbarHost
import com.berners.truecaller.ui.widget.CallHistory
import com.berners.truecaller.ui.widget.MainSearchBar
import com.berners.truecaller.util.LoadingContent
import com.berners.truecaller.util.collectAsStateWithLifecycle
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun Calls(
    openShowPhone: (phoneE164Format: String) -> Unit,
) {
    Calls(
        viewModel = hiltViewModel(),
        openShowPhone = openShowPhone,
    )
}

@Composable
internal fun Calls(
    viewModel: CallsViewModel,
    openShowPhone: (phoneE164Format: String) -> Unit,
) {
    val viewState by viewModel.state.collectAsStateWithLifecycle()

    val selectOnClickState = remember(viewState.selectItemOnClick) { mutableStateOf(viewState.selectItemOnClick) }
    val topBarState = remember(viewState.topBar) { mutableStateOf(viewState.topBar) }

    val onCallSelectChanged = viewModel::stateItemToggleSelect

    val scaffoldState = rememberScaffoldState()

    var selectedTabIndex by remember { mutableStateOf(viewState.tabs.indexOf(viewState.filteringInfo.tabItem)) }

    LaunchedEffect(viewState.filteringInfo) {
        selectedTabIndex = viewState.tabs.indexOf(viewState.filteringInfo.tabItem)
    }

    viewState.message?.let { message ->
        LaunchedEffect(message) {
            scaffoldState.snackbarHostState.showSnackbar(message.message)
            viewModel.clearMessage(message.id)
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.test()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            when(topBarState.value) {
                TopBar.SELECT_ACTIONS -> {
                    val selectedCount = viewState.items.filter { it.selected }.size
                    val totalCount = viewState.items.size

                    SelectableBar(
                        title = "$selectedCount/$totalCount",
                        onCancelClick = viewModel::stateItemsUnselectAll,
                        onBlockClick = viewModel::stateItemsBlockSelected,
                        onDeleteClick = viewModel::stateItemsDeleteSelected
                    )
                }
                else -> {}
            }
        },
        snackbarHost = { snackbarHostState ->
            SwipeDismissSnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier
                    .padding(horizontal = Layout.bodyMargin)
                    .fillMaxWidth()
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Surface(
            modifier = Modifier
//                .padding(paddingValues + PaddingValues(horizontal = Layout.bodyMargin))
                .padding(WindowInsets.systemBars
                    .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                    .asPaddingValues())
//                .padding(padding)
        ) {
            LoadingContent(
                loading = viewState.isLoading,
                empty = viewState.items.isEmpty() && !viewState.isLoading,
                emptyContent = { CallsEmptyContent(filteringInfo = viewState.filteringInfo) },
                onRefresh = { }
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentPadding = PaddingValues(top = 56.dp),
                ) {

                    item {
                        MainSearchBar(
                            modifier = Modifier
                                .padding(start = 15.dp, top = 5.dp, end = 15.dp, bottom = 10.dp)
                        )
                    }

                    item {
                        TrueScrollableTabRow(
                            tabs = viewState.tabs,
                            selectedTabIndex = selectedTabIndex,
                            backgroundColor = Color.Unspecified,
                            contentColor = MaterialTheme.colors.secondary,
                            onTabClick = { tabIndex ->
                                selectedTabIndex = tabIndex
                                viewModel.setFiltering(viewState.tabs[tabIndex].filterType)
                            }
                        )
                    }

                    items(items = viewState.items) { item ->
                        CallHistory(
                            modifier = Modifier,
                            incoming = item.data,
                            selected = item.selected,
                            selectOnClick = selectOnClickState.value,
                            onSelectChanged = {
                                onCallSelectChanged(item.data, it, true)
                            },
                            onShowDetailsClick = { phone ->
                                openShowPhone(phone.e164Format)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CallsEmptyContent(
    filteringInfo: FilteringInfo
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "no calls")
        Text(text = filteringInfo.tabItem.filterType.toString())
    }
}

@Composable
fun SelectableBar(
    modifier: Modifier = Modifier,
    title: String,
    onCancelClick: () -> Unit,
    onBlockClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface,
        contentPadding = WindowInsets.systemBars
            .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
            .asPaddingValues(),
        modifier = modifier,
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onCancelClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tcx_close),
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = { onBlockClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tcx_block_24dp),
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null
                )
            }
            IconButton(onClick = { onDeleteClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tcx_action_delete_outline_24dp),
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null
                )
            }
        }
    )
}

//@Preview
//@Composable
//private fun SelectableBarPreview() {
//    TruecallerTheme {
//        SelectableBar()
//    }
//}


