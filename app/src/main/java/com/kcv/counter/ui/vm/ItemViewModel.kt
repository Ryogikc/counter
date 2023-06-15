package com.kcv.counter.ui.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.kcv.counter.domain.DeleteItemByIdUseCase
import com.kcv.counter.domain.GetSumOfCountersUseCase
import com.kcv.counter.domain.GetItemsUseCase
import com.kcv.counter.domain.InsertItemUseCase
import com.kcv.counter.domain.contract.ItemRepository
import com.kcv.counter.domain.model.ItemDom
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
    getItemsUseCase: GetItemsUseCase,
    getSumOfCountersUseCase: GetSumOfCountersUseCase,
    private val insertItemUseCase: InsertItemUseCase,
    private val deleteItemByIdUseCase: DeleteItemByIdUseCase,
    private val minusCounterUseCase: MinusCounterUseCase,
    private val plusCounterUseCase: PlusCounterUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ItemUiState())
    val uiState: StateFlow<ItemUiState> = _uiState.asStateFlow()
    var itemName by mutableStateOf("")
    var itemCounter by mutableStateOf(0)
    val itemCounterList: Flow<List<ItemDom>> = getItemsUseCase()
    val getSumOfCounters: Flow<Int> = getSumOfCountersUseCase()

    suspend fun newItem(
        title: String,
        count: Int,
    ) {
        insertItemUseCase(title, count)
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
        itemCounter = newItemCounter.toIntOrNull() ?: 0
    }

    suspend fun deleteItemById(itemId: String) {
        deleteItemByIdUseCase(itemId)
    }

    suspend fun minusCounter(itemId: String) {
        minusCounterUseCase(itemId)
        itemRepository.minusCounter(itemId)
    }

    suspend fun plusCounter(itemId: String) {
        plusCounterUseCase(itemId)
        itemRepository.plusCounter(itemId)
    }
}
