package com.kcv.counter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kcv.counter.R
import com.kcv.counter.data.local.Item
import com.kcv.counter.ui.theme.CounterTheme

@Composable
fun ItemCounter(
    item: Item,
    onMinusClick: (Item) -> Unit,
    onPlusClick: (Item) -> Unit,
    onDeleteItemClick: (Item) -> Unit,
) {
    Column(
        modifier = Modifier
            .height(30.dp)
            .fillMaxWidth()
    ) {
        Row() {
            Text(
                text = item.title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 6.dp, horizontal = 6.dp)
            )

            Image(painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 6.dp)
                    .width(30.dp)
                    .height(30.dp)
                    .clickable { onMinusClick(item) })
            Text(
                text = item.count.toString(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 6.dp, horizontal = 6.dp)
            )
            Image(painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 6.dp)
                    .width(30.dp)
                    .height(30.dp)
                    .clickable { onPlusClick(item) })
            Image(painter = painterResource(id = R.drawable.delete_cross),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 6.dp)
                    .width(30.dp)
                    .height(30.dp)
                    .clickable { onDeleteItemClick(item) })
        }
    }
}

@Preview
@Composable
fun ItemCounterPreview() {
    CounterTheme {
        ItemCounter(
            item = Item(id = "jdfhsdue", title = "apple", count = 45),
            onMinusClick = {},
            onPlusClick = {},
            onDeleteItemClick = {},
        )
    }
}