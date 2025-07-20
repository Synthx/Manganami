package org.yezebi.manga.model

import kotlinx.coroutines.flow.MutableStateFlow

data class LazyState<T>(
    val data: T,
    val isLoading: Boolean = false,
    val error: Throwable? = null
)

fun <T> MutableLazyStateFlow(initialValue: T): MutableStateFlow<LazyState<T>> {
    return MutableStateFlow(LazyState(initialValue))
}
