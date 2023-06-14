package com.kcv.counter.domain

import com.kcv.counter.domain.contract.ItemRepository
import com.kcv.counter.domain.model.ItemDom
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(private val repository: ItemRepository) {
    operator fun invoke(): Flow<List<ItemDom>> {
        return repository.getItems()
    }
}
