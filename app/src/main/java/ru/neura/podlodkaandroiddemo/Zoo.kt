package ru.neura.podlodkaandroiddemo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun KittenHouse() {
    var count by remember { mutableStateOf(10) }
    KittenView(count) { count += 1 }
}

@Composable
fun Zoo() {
    var kittens by remember { mutableStateOf(1) }
    KittenView(kittens) { kittens *= 2 }
}

@Composable
fun TestCall() {
    var testValue by remember { mutableStateOf(-1) }
    KittenView(testValue) { testValue -= 1 }
}