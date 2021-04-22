package ru.neura.podlodkaandroiddemo

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun KittenView(count: Int, onNewKitten: () -> Unit) {
    Column {
        Text(text = "We have $count kittens")
        Button(onClick = onNewKitten) {
            Text("Release new Kitten")
        }
    }
}