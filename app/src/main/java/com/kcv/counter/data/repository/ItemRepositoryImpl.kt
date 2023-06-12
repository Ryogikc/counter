package com.kcv.counter.data.repository

import com.kcv.counter.data.local.Item
import com.kcv.counter.data.local.ItemDao
import com.kcv.counter.domain.contract.ItemRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao
) : ItemRepository {

    override fun getItems() = itemDao.observeAll()

    override suspend fun createItem(
        title: String,
        counter: Int,
    ) {
        val item = Item((title+counter).hashCode().toString() ,title, counter)
        itemDao.insertItem(item)
    }

    override suspend fun deleteAll() = itemDao.deleteAll()

    override suspend fun deleteItemById(itemId: String) = itemDao.deleteItemById(itemId)

    override fun getSumOfCounters() = itemDao.getSumOfCounters()

    override suspend fun minusCounter(itemId: String) = itemDao.minusCounter(itemId)

    override suspend fun plusCounter(itemId: String) = itemDao.plusCounter(itemId)
}
