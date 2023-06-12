package com.kcv.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kcv.counter.ui.CreateCounterRow
import com.kcv.counter.ui.ItemCounterColumn
import com.kcv.counter.ui.sumRow
import com.kcv.counter.ui.theme.CounterTheme
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

@Composable
private fun CounterApp(
    itemViewModel: ItemViewModel = hiltViewModel(),
) {
    //val itemUiState by itemViewModel.uiState.collectAsState()
    val itemCounterList by itemViewModel.itemCounterList.collectAsState(initial = emptyList())
    val getSumOfCounters by itemViewModel.getSumOfCounters.collectAsState(initial = 0)
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { TopBar() },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {
                CreateCounterRow(
                    itemName = itemViewModel.itemName,
                    itemCount = itemViewModel.itemCounter.toString(),
                    itemNameChanged = { itemViewModel.updateItemName(it) },
                    itemCountChanged = { itemViewModel.updateCounterName(it) },
                    onAddItemClick = {
                        coroutineScope.launch {
                            itemViewModel.newItem(it.title, it.count)
                        }
                    },
                )

                ItemCounterColumn(
                    itemList = itemCounterList,
                    onMinusClick = { /*TODO*/ },
                    onPlusClick = { /*TODO*/ },
                    onDeleteItemClick = {
                        coroutineScope.launch {
                            itemViewModel.deleteItemById(it)
                        }
                    }
                )
                sumRow(
                    itemCount = getSumOfCounters,
                    onDeleteAllItems = {
                        coroutineScope.launch {
                            itemViewModel.deleteAll()
                        }
                    })
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.sum_counters), fontSize = 18.sp) }
    )
}
