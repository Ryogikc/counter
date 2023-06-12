package com.kcv.counter.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import retrofit2.http.DELETE

@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun observeAll(): Flow<List<Item>>

    @Upsert
    suspend fun insertItem(item: Item)

    @Query("DELETE FROM item")
    suspend fun deleteAll()

    @Query("SELECT SUM(count) AS value FROM item")
    fun getSumOfCounters(): Flow<Int>

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun deleteItemById(id: String)
}
