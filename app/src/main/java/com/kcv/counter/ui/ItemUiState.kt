package com.kcv.counter.ui

import com.kcv.counter.data.local.Item

data class ItemUiState(
    val isLoading: Boolean = false,
    val title: String = "",
    val counter: String = "",
    val counterList: List<Item> = emptyList(),
    val sumAllCounterResult: Int = 0,
)
