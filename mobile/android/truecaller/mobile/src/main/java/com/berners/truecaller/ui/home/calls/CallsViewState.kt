package com.berners.truecaller.ui.home.calls

import androidx.annotation.StringRes
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.berners.truecaller.R
import com.berners.truecaller.calls.CallsFilterType
import com.berners.truecaller.model.Incoming
import com.berners.truecaller.ui.components.TabItem
import com.berners.truecaller.ui.compose.UiMessage
import com.berners.truecaller.ui.compose.UiModel
import kotlinx.coroutines.flow.MutableStateFlow

data class CallsViewState(
    val tabs: List<CallsTabItem> = listOf(
        CallsTabItem(icon = null, title = R.string.tab_all_calls, filterType = CallsFilterType.ALL_CALLS),
        CallsTabItem(icon = R.drawable.ic_type_outgoing_call, title = R.string.tab_outgoing_calls, filterType = CallsFilterType.OUTGOING_CALLS),
        CallsTabItem(icon = R.drawable.ic_type_incoming_call, title = R.string.tab_incoming_calls, filterType = CallsFilterType.INCOMING_CALLS),
        CallsTabItem(icon = R.drawable.ic_tcx_event_missed_call_16dp, title = R.string.tab_missed_calls, filterType = CallsFilterType.MISSED_CALLS),
        CallsTabItem(icon = R.drawable.ic_tcx_event_blocked_16dp, title = R.string.tab_blocked_calls, filterType = CallsFilterType.BLOCKED_CALLS)
    ),
    val items: SnapshotStateList<UiModel<Incoming>> = mutableStateListOf(),
    val isLoading: Boolean = false,
    val filteringInfo: FilteringInfo = FilteringInfo(tabs.first { it.filterType == CallsFilterType.ALL_CALLS }),
    val message: UiMessage? = null,
    val topBar: TopBar = TopBar.SEARCH_BAR,
    val selectItemOnClick: Boolean = false,
) {
    companion object {
        val Empty = CallsViewState(isLoading = true)
    }
}

data class CallsTabItem (
    override var icon: Int?,
    @StringRes override var title: Int,
    var filterType: CallsFilterType
) : TabItem

enum class TopBar {
    SEARCH_BAR,
    SELECT_ACTIONS
}

data class FilteringInfo(
    val tabItem: CallsTabItem
)