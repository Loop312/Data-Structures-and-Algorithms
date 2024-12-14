package org.example.algorithms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

val algorithms = Algorithms()
var array by mutableStateOf(intArrayOf())
var isSorting by mutableStateOf(false)
var timer by mutableStateOf(0f)
var arraySize by mutableStateOf(50)
var selectedIndex1 by mutableStateOf(-1)
var selectedIndex2 by mutableStateOf(-1)
var filling by mutableStateOf(false)
var delayTime by mutableStateOf(1L)

@Composable
@Preview
fun App() {
    //the display
    Column {
        Box(Modifier.offset(0.dp, 20.dp)) {
            Row {
                for (i in array.indices) {
                    Spacer(Modifier.width(4.dp))
                    Box(
                        Modifier
                            .height(array[i].dp)
                            .background(if (i == selectedIndex1 || i == selectedIndex2) Color.Yellow else if (isSorting) Color.Red else Color.Green)
                            .align(Alignment.Bottom)
                    ) {
                        Text(
                            text = array[i].toString(),
                            color = if (i == selectedIndex1 || i == selectedIndex2) Color.Yellow else if (isSorting) Color.Red else Color.Green,
                            modifier = Modifier.offset(0.dp, -20.dp)
                        )
                    }
                }
            }
        }
        Text(timer.toString(), Modifier.offset(0.dp, 20.dp))
        Text("Selected Index 1: $selectedIndex1 \nSelected Index 2: $selectedIndex2", Modifier.offset(0.dp, 20.dp))
    }
    //settings
    Box (Modifier.fillMaxSize(), Alignment.BottomCenter) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Button(onClick = { algorithms.bubbleSort(); timer = 0f }) {
                    Text("Bubble Sort")
                }
                Button(onClick = { algorithms.selectionSort(); timer = 0f }) {
                    Text("Selection Sort")
                }
                Button(onClick = { algorithms.insertionSort(); timer = 0f }) {
                    Text("Insertion Sort")
                }
            }
            Row {
                Button(onClick = { loadArray(arraySize, 0) }) {
                    Text("Random")
                }
                Button(onClick = { loadArray(arraySize, 1) }) {
                    Text("Decreasing")
                }
                Button(onClick = { loadArray(arraySize, 2) }) {
                    Text("Increasing")
                }
            }
            Text("delay: $delayTime ms")
            Slider(delayTime.toFloat(),{ delayTime = it.toLong() }, valueRange = 0f..1000f)
            Text("size: $arraySize")
            Slider(arraySize.toFloat(),{ arraySize = it.toInt() }, valueRange = 0f..200f)
        }
    }

    //timer, System.nanoTime() didn't work and Clock didn't work either
    LaunchedEffect (isSorting){
        while (isSorting) {
            timer += 0.02f
            delay(10)
        }
    }
}

fun loadArray(size: Int = 100, type: Int = 0) {
    if (filling || isSorting) return //temporary measure to prevent multiple loads
    filling = true
    if (array.isNotEmpty()) array = intArrayOf()
    arraySize = size
    CoroutineScope(Dispatchers.Default).launch {
        for (i in 0 until arraySize) {
            when (type) {
                0 -> array += (0..arraySize).random()
                1 -> array += arraySize - i
                2 -> array += i
            }
            delay(1)
        }
        filling = false
    }
}