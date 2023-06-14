package com.kcv.counter.domain.contract

import com.kcv.counter.domain.model.ItemDom
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItems(): Flow<List<ItemDom>>

    suspend fun createItem(
        title: String,
        counter: Int,
    )

    suspend fun deleteAll()

    suspend fun deleteItemById(itemId: String)

    fun getSumOfCounters(): Flow<Int>

    suspend fun minusCounter(itemId: String)

    suspend fun plusCounter(itemId: String)
}
