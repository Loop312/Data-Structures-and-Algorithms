package org.example.algorithms

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Algorithms {
    //compares 2 side by side and swaps them if they are out of order
    //can be optimized if the array is already sorted (to add)
    fun bubbleSort() {
        if (isSorting) return
        CoroutineScope(Dispatchers.Main).launch {
            isSorting = true
            for (i in array.size - 1 downTo 0) {
                delay(1)
                for (j in 0 until i) {
                    selectedIndex1 = j
                    delay(1)
                    if (array[j] > array[j + 1]) {
                        val temp = array[j]
                        array[j] = array[j + 1]
                        array[j + 1] = temp
                    }
                }
            }
            selectedIndex1 = -1
            isSorting = false
        }
    }

    //gets the smallest value and places it at the start
    fun selectionSort(){
        if (isSorting) return
        CoroutineScope(Dispatchers.Main).launch {
            isSorting = true
            for (i in array.indices) {
                var minIndex = i
                selectedIndex1 = i
                delay(1)
                for (j in i + 1 until array.size) {
                    delay(1)
                    if (array[j] < array[minIndex]) {
                        selectedIndex2 = j
                        minIndex = j
                    }
                }
                if (minIndex != i) {
                    val temp = array[i]
                    array[i] = array[minIndex]
                    array[minIndex] = temp
                }
            }
            selectedIndex1 = -1
            selectedIndex2 = -1
            isSorting = false
        }
    }

    //keeps one side of the array sorted and inserts the current element into the correct position
    fun insertionSort() {
        if (isSorting) return
        CoroutineScope(Dispatchers.Main).launch {
            isSorting = true
            for (i in 1 until array.size) {
                selectedIndex1 = i
                delay(1)
                val key = array[i]
                var j = i - 1
                while (j >= 0 && array[j] > key) {
                    selectedIndex2 = j
                    delay(1)
                    array[j + 1] = array[j]
                    j--
                }
                array[j + 1] = key
            }
            selectedIndex1 = -1
            selectedIndex2 = -1
            isSorting = false
        }
    }
}