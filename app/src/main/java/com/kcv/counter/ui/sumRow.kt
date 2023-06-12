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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kcv.counter.R
import com.kcv.counter.ui.theme.CounterTheme
import com.kcv.counter.ui.vm.ItemViewModel
import kotlinx.coroutines.launch

@Composable
fun sumRow(
    itemCount: Int,
    modifier: Modifier = Modifier,
    viewModel: ItemViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = stringResource(R.string.sum_counters),
                textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp)
        )
        Text(text = itemCount.toString(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
        )
        OutlinedButton(
            onClick = {
                      coroutineScope.launch {
                          viewModel.deleteAll()
                      }
            },
            border = BorderStroke(1.dp, Color.Red),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, end = 8.dp)
                .width(50.dp)
        ) {
            Text(stringResource(R.string.delete_all_items))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun sumRowPreview() {
    CounterTheme {
        sumRow(
           itemCount = 80,
        )
    }
}