package com.kcv.counter.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kcv.counter.R
import com.kcv.counter.data.local.Item
import com.kcv.counter.ui.theme.CounterTheme

@Composable
fun CreateCounterRow(
    itemName: String,
    itemCount: String,
    itemNameChanged: (String) -> Unit,
    itemCountChanged: (String) -> Unit,
    onAddItemClick: (Item) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        OutlinedTextField(
            value = itemName,
            singleLine = true,
            modifier = modifier
                .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 12.dp)
                .width(160.dp),
            onValueChange = itemNameChanged,
            label = {
                Text(stringResource(R.string.item_name))
            },
            textStyle = MaterialTheme.typography.bodyLarge,
        )
        OutlinedTextField(
            value = itemCount,
            singleLine = true,
            modifier = modifier
                .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 12.dp)
                .width(80.dp),
            onValueChange = itemCountChanged,
            label = {
                Text(stringResource(R.string.item_count))
            },
            textStyle = MaterialTheme.typography.bodyLarge,
        )
        OutlinedButton(
            onClick = { onAddItemClick },
            border = BorderStroke(1.dp, Color.Gray),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 12.dp)
                .width(50.dp)
        ) {
            Text(stringResource(R.string.add_item))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateCounterRowPreview() {
    CounterTheme {
        CreateCounterRow(
            itemName = "Ice cream",
            itemCount = "2",
            itemNameChanged = {  },
            itemCountChanged = { },
            onAddItemClick = {  })
    }
}
