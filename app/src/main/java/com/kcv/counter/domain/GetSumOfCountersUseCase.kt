package com.kcv.counter.domain

import com.kcv.counter.domain.contract.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSumOfCountersUseCase @Inject constructor(private val repository: ItemRepository) {
    operator fun invoke(): Flow<Int> {
        return repository.getSumOfCounters()
    }
}
