package org.example.algorithms

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Algorithms {
    //compares 2 side by side and swaps them if they are out of order
    fun bubbleSort() {
        CoroutineScope(Dispatchers.Main).launch {
            isSorting = true
            for (i in array.size - 1 downTo 0) {
                delay(1)
                for (j in 0 until i) {
                    delay(1)
                    if (array[j] > array[j + 1]) {
                        val temp = array[j]
                        array[j] = array[j + 1]
                        array[j + 1] = temp
                    }
                }
            }
            isSorting = false
        }
    }

    //gets the smallest value and places it at the start
    fun selectionSort(){
        CoroutineScope(Dispatchers.Main).launch {
            isSorting = true
            for (i in array.indices) {
                var minIndex = i
                delay(1)
                for (j in i + 1 until array.size) {
                    delay(1)
                    if (array[j] < array[minIndex]) {
                        minIndex = j
                    }
                }
                if (minIndex != i) {
                    val temp = array[i]
                    array[i] = array[minIndex]
                    array[minIndex] = temp
                }
            }
            isSorting = false
        }
    }

    //keeps one side of the array sorted and inserts the current element into the correct position
    fun insertionSort() {
        CoroutineScope(Dispatchers.Main).launch {
            isSorting = true
            for (i in 1 until array.size) {
                delay(1)
                val key = array[i]
                var j = i - 1
                while (j >= 0 && array[j] > key) {
                    delay(1)
                    array[j + 1] = array[j]
                    j--
                }
                array[j + 1] = key
            }
            isSorting = false
        }
    }
}