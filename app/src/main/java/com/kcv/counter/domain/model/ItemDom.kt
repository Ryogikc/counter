package com.kcv.counter.domain.model

import com.kcv.counter.data.local.Item
import com.kcv.counter.data.model.ItemModel

data class ItemDom(
    val id: String,
    val title: String,
    val count: Int,
)

fun ItemModel.toDomain() = ItemDom(id, title, count)
fun Item.toDomain() = ItemDom(id, title, count)