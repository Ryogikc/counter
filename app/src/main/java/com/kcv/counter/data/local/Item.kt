package com.kcv.counter.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kcv.counter.domain.model.ItemDom

@Entity(
    tableName = "item"
)
data class Item(
    @PrimaryKey val id: String = "",
    val title: String,
    val count: Int,
)

fun ItemDom.toDatabase() = Item(title = title, count = count)
