package org.example.algorithms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview

val algorithms = Algorithms()
var array by mutableStateOf(intArrayOf())
var isSorting by mutableStateOf(false)
var timer by mutableStateOf(0f)
var arraySize = 50
var selectedIndex1 by mutableStateOf(-1)
var selectedIndex2 by mutableStateOf(-1)

@Composable
@Preview
fun App() {
    LaunchedEffect(Unit) {
        for (i in 0 until arraySize) {
            array += (0..100).random()
            //array += 100 - i
            //array += i
            delay(1)
        }
        //algorithms.bubbleSort()
        //algorithms.selectionSort()
        algorithms.insertionSort()
    }

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

    //timer
    LaunchedEffect (isSorting){
        while (isSorting) {
            timer += 0.02f
            delay(10)
        }
    }
}
