package ru.neura.podlodkaandroiddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
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

class MainActivity : ComponentActivity() {

    val count = mutableStateOf(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodlodkaAndroidDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    KittenView(count = count)
                }
            }
        }
    }
}

@Composable
fun KittenView(count: MutableState<Int>) {
    Column {
        Text(text = "We have ${count.value} kittens")
        Button(onClick = {
            count.value += 1
        }) {
            Text("Release new Kitten")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PodlodkaAndroidDemoTheme {
        val count = mutableStateOf(3)
        KittenView(count = count)
    }
}