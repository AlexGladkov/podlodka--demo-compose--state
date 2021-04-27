package ru.neura.podlodkaandroiddemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import ru.neura.podlodkaandroiddemo.ui.theme.PodlodkaAndroidDemoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.neura.podlodkaandroiddemo.policy.customMutationPolicy

class MainActivity : ComponentActivity() {

    val count = mutableStateOf(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodlodkaAndroidDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PolicyTest()
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()) {
    val count: Int by viewModel.count.observeAsState(3)

    val test = remember { mutableStateOf(3) }
    KittenView(count = count, onNewKitten = { viewModel.releaseNewKittens() })
}

@Composable
fun Circus(viewModel: CircusViewModel = CircusViewModel()) {
    val viewState = viewModel.viewState.observeAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            "Welcome to ${viewState.value?.title} Circus",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        if (viewState.value?.ticketsCount == 0) {
            Text("Tickets Not Available")
        } else {
            Text("We have ${viewState.value?.ticketsCount} tickets",
                modifier = Modifier.clickable {
                    viewModel.soldOut()
                })
        }
    }
}

@Composable
fun PolicyTest() {
    val count = remember { mutableStateOf(3, customMutationPolicy()) }
    val count1 = remember { mutableStateOf(3, customMutationPolicy()) }
    val count2 = remember { mutableStateOf(3, customMutationPolicy()) }

    Column(modifier = Modifier.padding(16.dp)) {
        if (count.value > 0) {
            Text("Positive value")
        } else if (count.value < 0) {
            Text("Negative value")
        } else {
            Text("Zero value")
        }

        Button(
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
            onClick = { count.value += 1 }) { Text("Increase") }
        Button(onClick = { count.value -= 1 }) { Text("Decrease") }

        if (count1.value > 0) {
            Text("Positive value")
        } else if (count1.value < 0) {
            Text("Negative value")
        } else {
            Text("Zero value")
        }

        Button(
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
            onClick = { count1.value += 1 }) { Text("Increase") }
        Button(onClick = { count1.value -= 1 }) { Text("Decrease") }

        if (count2.value > 0) {
            Text("Positive value")
        } else if (count2.value < 0) {
            Text("Negative value")
        } else {
            Text("Zero value")
        }

        Button(
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
            onClick = { count2.value += 1 }) { Text("Increase") }
        Button(onClick = { count2.value -= 1 }) { Text("Decrease") }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PodlodkaAndroidDemoTheme {
        Circus()
    }
}