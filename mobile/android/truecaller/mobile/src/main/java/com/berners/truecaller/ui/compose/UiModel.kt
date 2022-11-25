package com.berners.truecaller.ui.compose

data class UiModel<T>(
    val data: T,
    var selected: Boolean = false,
    var loading: Boolean = false
) {

}

fun Any.toUiModel(): UiModel<Any> {
    return UiModel(data = this)
}

fun <T> List<T>.toUiModel(): List<UiModel<T>> {
    val list = ArrayList<UiModel<T>>()

    for (item in this) {
        list.add(UiModel(data = item))
    }

    return list
}