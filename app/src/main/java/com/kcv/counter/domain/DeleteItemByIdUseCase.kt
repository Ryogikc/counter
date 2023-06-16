package com.kcv.counter.domain

import com.kcv.counter.domain.contract.ItemRepository
import javax.inject.Inject

class DeleteItemByIdUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(itemId: String) {
        return repository.deleteItemById(itemId)
    }
}
