package com.kcv.counter.domain

import com.kcv.counter.domain.contract.ItemRepository
import javax.inject.Inject

class MinusCounterUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(itemId: String) {
        return repository.minusCounter(itemId)
    }
}
