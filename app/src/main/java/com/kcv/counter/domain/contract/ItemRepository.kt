package com.kcv.counter.domain.contract

import com.kcv.counter.data.local.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItems(): Flow<List<Item>>

    suspend fun createItem(
        title: String,
        counter: Int,
    )

    suspend fun deleteAll()

    suspend fun deleteItemById(item: Item)

    fun getSumOfCounters(): Flow<Int>
}