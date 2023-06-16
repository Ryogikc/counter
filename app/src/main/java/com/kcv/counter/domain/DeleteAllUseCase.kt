package com.kcv.counter.domain

import com.kcv.counter.domain.contract.ItemRepository
import javax.inject.Inject

class DeleteAllUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    suspend operator fun invoke() {
        return repository.deleteAll()
    }
}
