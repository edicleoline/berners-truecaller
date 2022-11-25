package com.berners.truecaller.ui.home.calls

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.*
import com.berners.truecaller.calls.CallsFilterType
import com.berners.truecaller.calls.CallsFilterType.*
import com.berners.truecaller.data.Result
import com.berners.truecaller.data.Result.Success
import com.berners.truecaller.data.domain.observers.ObserveIncomings
import com.berners.truecaller.data.repositories.IncomingRepository
import com.berners.truecaller.data.repositories.PhoneRepository
import com.berners.truecaller.extensions.combine
import com.berners.truecaller.model.*
import com.berners.truecaller.ui.compose.UiMessage
import com.berners.truecaller.ui.compose.UiMessageManager
import com.berners.truecaller.ui.compose.UiModel
import com.berners.truecaller.ui.compose.toUiModel
import com.berners.truecaller.util.Async
import com.berners.truecaller.util.WhileUiSubscribed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class CallsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    observeIncomings: ObserveIncomings,

    private val incomingRepository: IncomingRepository,
    private val phoneRepository: PhoneRepository
) : ViewModel() {

    private val incomings = MutableStateFlow<Result<SnapshotStateList<UiModel<Incoming>>>>(Result.Loading)

    private val savedFilterType = savedStateHandle.getLiveData(CALLS_FILTER_SAVED_STATE_KEY, ALL_CALLS).asFlow()
    private val filterUiInfo = savedFilterType.map { getFilteringInfo(it) }.distinctUntilChanged()
    private val isLoading = MutableStateFlow(false)
    private val selectItemOnClick = MutableStateFlow(false)
    private val topBar = MutableStateFlow(TopBar.SEARCH_BAR)
    private val lastTimeChangedItems = MutableLiveData(0L)

    private val uiMessageManager = UiMessageManager()

    private val filteredCallsAsync = combine(
        incomings,
        savedFilterType
    ) { calls, type ->
        filter(calls, type)
    }
    .map { Async.Success(it) }
    .onStart<Async<SnapshotStateList<UiModel<Incoming>>>> { emit(Async.Loading) }

    val state: StateFlow<CallsViewState> = combine(
        filterUiInfo,
        isLoading,
        uiMessageManager.message,
        filteredCallsAsync,
        topBar,
        selectItemOnClick
    ) { filterUiInfo, isLoading, message, callsAsync, topBar, selectItemOnClick
        ->
        stateItemsRefresh(true)
        when (callsAsync) {
            Async.Loading -> {
                CallsViewState(isLoading = true)
            }
            is Async.Success -> {
                CallsViewState(
                    items = callsAsync.data,
                    filteringInfo = filterUiInfo,
                    isLoading = isLoading,
                    message = message,
                    topBar = topBar,
                    selectItemOnClick = selectItemOnClick
                )
            }
        }
    }
    .stateIn(
        scope = viewModelScope,
        started = WhileUiSubscribed,
        initialValue = CallsViewState.Empty
    )

    private val stateItemsObserver = Observer<Long> {
        val anySelected = state.value.items.find { it.selected }

        selectItemOnClick.value = anySelected != null

        if (anySelected == null) {
            topBar.value = TopBar.SEARCH_BAR
        } else {
            topBar.value = TopBar.SELECT_ACTIONS
        }
    }

    private fun updateItem() {

    }

    private fun updateItemsFromRemoteSource() = viewModelScope.launch {
        delay(3000)
//        val phone = phoneRepository.getPhoneByIdStream(1722004730021)
//        phone.collect { result ->
//            when (result) {
//                is Result.Loading -> { Timber.d("LOADING THIS SHIT") }
//                is Success -> {
//                    Timber.d(result.data?.nationalFormat)
//
//                    if (result.data != null) {
//                        val item = state.value.items.last()
//                        item.data.source = result.data!!
//                        stateItemsRefresh()
//                    }
//
//                }
//                is Error -> { Timber.d(result.exception.message) }
//            }
//        }
    }

    fun setFiltering(requestType: CallsFilterType) {
        stateItemsUnselectAll()
        savedStateHandle[CALLS_FILTER_SAVED_STATE_KEY] = requestType
    }

//    fun refresh() {
//        _isLoading.value = true
//        viewModelScope.launch {
//            state.value.items.drop(2)
//
//            delay(2000)
//            _isLoading.value = false
//        }
//    }

    fun test() = viewModelScope.launch {

//        for (item in Incoming.mock.list) {
////            phoneRepository.localPhoneDataSource.save(item.source)
////            phoneRepository.localPhoneDataSource.save(item.target)
//
//            incomingRepository.localIncomingDataSource.save(item)
//        }

//        delay(10000)
//
//        for (item in historyItems) {
//            incomingRepository.localIncomingDataSource.save(item)
//        }

//        updateItemsFromRemoteSource()
//        uiMessageManager.emitMessage(UiMessage("Test 123456 end test"))
//        viewModelScope.launch {
//            val phone = phoneRepository.findById(1722004730021)
//            phone.collect { result ->
//                when (result) {
//                    is Result.Loading -> { Timber.d("LOADING THIS SHIT") }
//                    is Success -> { Timber.d(result.data?.nationalFormat) }
//                    is Error -> { Timber.d(result.exception.message) }
//                }
//            }
//        }
    }

    fun stateItemsUnselectAll() {
        state.value.items.filter { it.selected }.forEach {
            stateItemToggleSelect(incoming = it.data, selected = false, refresh = false)
        }

        stateItemsRefresh()
    }

    fun stateItemsBlockSelected() = viewModelScope.launch {
        uiMessageManager.emitMessage(UiMessage("you blocked"))
    }

    fun stateItemsDeleteSelected() = viewModelScope.launch {
        state.value.items.filter { it.selected }.forEach {
            Timber.d(it.data.id.toString())
        }
    }

    fun stateItemToggleSelect(incoming: Incoming, selected: Boolean, refresh: Boolean = true) = viewModelScope.launch {
        state.value.items.filter {
            it.data.id == incoming.id
        }.forEach { it.selected = selected }

        if (refresh) {
            stateItemsRefresh()
        }
    }

    fun clearMessage(id: Long) {
        viewModelScope.launch {
            uiMessageManager.clearMessage(id)
        }
    }

    private fun stateItemsRefresh(readonly: Boolean = false) = viewModelScope.launch {
        if (state.value.items.isNotEmpty() && !readonly) {
            val last = state.value.items.last()
            state.value.items.remove(last)
            state.value.items.add(last)
        }

        lastTimeChangedItems.value = System.currentTimeMillis()
    }

    private fun filter(
        callsResult: Result<SnapshotStateList<UiModel<Incoming>>>,
        filteringType: CallsFilterType
    ): SnapshotStateList<UiModel<Incoming>> = if (callsResult is Success) {
        filterItems(callsResult.data, filteringType)
    } else {
//        showSnackbarMessage(R.string.loading_tasks_error)
        mutableStateListOf()
    }

    private fun filterItems(calls: SnapshotStateList<UiModel<Incoming>>, filteringType: CallsFilterType): SnapshotStateList<UiModel<Incoming>> {
        val itemsToShow = mutableStateListOf<UiModel<Incoming>>()

        for (call in calls) {
            when(filteringType) {
                ALL_CALLS -> itemsToShow.add(call)
                INCOMING_CALLS -> if (call.data.direction == IncomingDirection.INCOMING
                    && !call.data.state.missed && !call.data.state.blocked) {
                    itemsToShow.add(call)
                }
                OUTGOING_CALLS -> if (call.data.direction == IncomingDirection.OUTGOING) {
                    itemsToShow.add(call)
                }
                MISSED_CALLS -> if (call.data.state.missed) {
                    itemsToShow.add(call)
                }
                BLOCKED_CALLS -> if (call.data.state.blocked) {
                    itemsToShow.add(call)
                }
            }
        }

        return itemsToShow
    }

    private fun getFilteringInfo(requestType: CallsFilterType): FilteringInfo =
        when (requestType) {
            ALL_CALLS -> { FilteringInfo(state.value.tabs.first { it.filterType == ALL_CALLS }) }
            OUTGOING_CALLS -> { FilteringInfo(state.value.tabs.first { it.filterType == OUTGOING_CALLS }) }
            INCOMING_CALLS -> { FilteringInfo(state.value.tabs.first { it.filterType == INCOMING_CALLS }) }
            MISSED_CALLS -> { FilteringInfo(state.value.tabs.first { it.filterType == MISSED_CALLS }) }
            BLOCKED_CALLS -> { FilteringInfo(state.value.tabs.first { it.filterType == BLOCKED_CALLS }) }
        }

    init {
        observeIncomings(ObserveIncomings.Params(10))
        lastTimeChangedItems.observeForever(stateItemsObserver)
        Timber.d("init CallsViewModel")

        viewModelScope.launch {
            observeIncomings.observe().collect { items ->

                val t: SnapshotStateList<UiModel<Incoming>> = mutableStateListOf()
                for (item in items.toUiModel()) {
                    t.add(item)
                }
                this@CallsViewModel.incomings.emit(Success(t))


                val test = items
                val e = items.size
            }
        }
    }

    override fun onCleared() {
        lastTimeChangedItems.removeObserver(stateItemsObserver)
        super.onCleared()
        Timber.d("cleared CallsViewModel")
    }
}

const val CALLS_FILTER_SAVED_STATE_KEY = "CALLS_FILTER_SAVED_STATE_KEY"





