package com.kcv.counter.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kcv.counter.data.local.Item

@Composable
fun itemCounter(
    item: Item,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    onDeleteItemClick: (Item) -> Unit,
) {
  Column(modifier = Modifier
      .height(180.dp)) {
      Row {
          Text(text = item.title,
              textAlign = TextAlign.Center,
              style = MaterialTheme.typography.bodyLarge,
              modifier = Modifier.padding(vertical = 6.dp, horizontal = 6.dp))

          Image(painter = painterResource(id = android.R.drawable.btn_minus),
              contentDescription = null,
              modifier = Modifier.padding(horizontal = 6.dp)
                  .clickable { onMinusClick() })
          Text(text = item.count.toString(),
              textAlign = TextAlign.Center,
              style = MaterialTheme.typography.bodyLarge,
              modifier = Modifier.padding(vertical = 6.dp, horizontal = 6.dp))
          Image(painter = painterResource(id = android.R.drawable.btn_plus),
              contentDescription = null,
              modifier = Modifier.padding(horizontal = 6.dp)
              .clickable { onPlusClick() })
          Image(painter = painterResource(id = android.R.drawable.ic_delete),
              contentDescription = null,
              modifier = Modifier.padding(horizontal = 6.dp)
              .clickable { onDeleteItemClick(item)})
      }
  }
}