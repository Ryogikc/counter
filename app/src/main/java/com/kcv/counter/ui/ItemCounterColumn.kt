package com.kcv.counter.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kcv.counter.data.local.Item

@Composable
fun ItemCounterColumn(
    itemList: List<Item>,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    onDeleteItemClick: (Item) -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(itemList) { item ->
                itemCounter(
                    item = item,
                    onMinusClick = onMinusClick,
                    onPlusClick = onPlusClick,
                    onDeleteItemClick = onDeleteItemClick
                )
            }
        }
    }
}
