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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kcv.counter.ui.theme.CounterTheme
import androidx.navigation.compose.rememberNavController
import com.kcv.counter.ui.ItemCounterColumn
import com.kcv.counter.ui.createCounterRow
import com.kcv.counter.ui.sumRow

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
private fun CounterApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        content = { padding ->
            createCounterRow(
                itemName =,
                itemCount =,
                titleToSearchChanged =,
                onAddItemClick = { /*TODO*/ },
                modifier = Modifier.padding(padding))

            ItemCounterColumn(
                itemList =,
                onMinusClick = { /*TODO*/ },
                onPlusClick = { /*TODO*/ },
                onDeleteItemClick =
            )
            sumRow(itemCount =, onDeleteAllItems = { /*TODO*/ })
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

    }
}