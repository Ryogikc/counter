package com.kcv.counter.domain

import com.kcv.counter.domain.contract.ItemRepository
import javax.inject.Inject

class InsertItemUseCase @Inject constructor(
    private val repository: ItemRepository) {
    suspend operator fun invoke(title: String, counter: Int)  {
        return repository.createItem(title = title,
        counter = counter)
    }
}