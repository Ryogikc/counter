package com.kcv.counter.ui.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.kcv.counter.data.local.Item
import com.kcv.counter.domain.contract.ItemRepository
import com.kcv.counter.ui.ItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject internal constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ItemUiState())
    val uiState: StateFlow<ItemUiState> = _uiState.asStateFlow()
    var itemName by mutableStateOf("")
    var itemCounter by mutableStateOf(0)
    val itemCounterList: Flow<List<Item>> = itemRepository.getItems()
    val getSumOfCounters: Flow<Int> = itemRepository.getSumOfCounters()

    suspend fun newItem(
        title: String,
        count: Int,
    ) {
        itemRepository.createItem(title, count)
    }

    suspend fun deleteAll() {
        itemRepository.deleteAll()
    }

    private fun loadItems() {
        _uiState.update {
            it.copy(isLoading = true)
        }
    }

    fun updateItemName(newItemName: String) {
        itemName = newItemName
    }

    fun updateCounterName(newItemCounter: String) {
        itemCounter = newItemCounter.toInt()
    }

    suspend fun deleteItemById(item: Item) {
        itemRepository.deleteItemById(item)
    }

    /*    suspend fun plusCounter(item: Item){

        }

        suspend fun minusCounter(item: Item){

        }*/
}
