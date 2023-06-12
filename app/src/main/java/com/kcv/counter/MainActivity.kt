package com.kcv.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kcv.counter.ui.theme.CounterTheme
import androidx.hilt.navigation.compose.hiltViewModel
import com.kcv.counter.ui.ItemCounterColumn
import com.kcv.counter.ui.createCounterRow
import com.kcv.counter.ui.sumRow
import com.kcv.counter.ui.vm.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CounterApp(
    itemViewModel: ItemViewModel = hiltViewModel(),
) {
   // val navController = rememberNavController()
    val itemUiState by itemViewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { TopBar() },
        content = { padding ->

            createCounterRow(
                itemName = itemViewModel.itemName,
                itemCount = itemViewModel.itemCounter.toString(),
                itemNameChanged = {itemViewModel.updateItemName(it)},
                itemCountChanged = {itemViewModel.updateCounterName(it.toInt())},
                onAddItemClick = {
                    coroutineScope.launch {
                    itemViewModel.newItem(it.title, it.count)
                } },
                modifier = Modifier.padding(padding))

            ItemCounterColumn(
                itemList = itemUiState.counterList,
                onMinusClick = { /*TODO*/ },
                onPlusClick = { /*TODO*/ },
                onDeleteItemClick = {}
            )
            sumRow(itemCount = "", onDeleteAllItems = { /*TODO*/ })
        },
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(){
    TopAppBar(
        title = { Text(text = stringResource(R.string.sum_counters), fontSize = 18.sp)}
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
        CounterApp()
    }
}