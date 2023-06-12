package com.kcv.counter.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kcv.counter.data.local.Item
import com.kcv.counter.ui.theme.CounterTheme

@Composable
fun ItemCounterColumn(
    itemList: List<Item>,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    onDeleteItemClick: (Item) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
        .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(itemList) { item ->
                ItemCounter(
                    item = item,
                    onMinusClick = onMinusClick,
                    onPlusClick = onPlusClick,
                    onDeleteItemClick = onDeleteItemClick
                )
            }
        }
    }
}

@Preview
@Composable
fun ItemCounterColumnPreview() {
    CounterTheme {
        ItemCounterColumn(
            itemList = listOf(
                Item(id = "hsjsks", title = "Hola", count = 45),
                Item(id = "hsjssdadks", title = "Hola", count = 45)
            ),
            onMinusClick = {},
            onPlusClick = {},
            onDeleteItemClick = { (Item(id = "hsjsks", title = "Hola", count = 45)) }
        )
    }
}
