package com.kcv.counter.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun observeAll(): Flow<List<Item>>

    @Insert
    suspend fun insertItem(item: Item)

    @Query("DELETE FROM item")
    suspend fun deleteAll()

    @Query("SELECT SUM(count) FROM item")
    suspend fun getSumOfCounters(): Int

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun deleteItemById(id: String)
}
