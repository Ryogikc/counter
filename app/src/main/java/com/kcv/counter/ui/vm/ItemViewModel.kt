package com.kcv.counter.ui.vm

import androidx.lifecycle.ViewModel
import com.kcv.counter.data.repository.ItemRepositoryImpl
import com.kcv.counter.data.local.Item
import com.kcv.counter.domain.contract.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject internal constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {

    val itemCounterList: Flow<List<Item>> = itemRepository.getItems()

    suspend fun newItem(
        title: String,
        count: Int,
    ) {
        itemRepository.createItem(title, count)
    }

    suspend fun deleteAll() {
        itemRepository.deleteAll()
    }
}
