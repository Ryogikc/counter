package com.kcv.counter.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "item"
)
data class Item(
    @PrimaryKey val id: String,
    val title: String,
    val count: Int,
)
