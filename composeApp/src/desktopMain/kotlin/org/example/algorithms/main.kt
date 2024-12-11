package org.example.algorithms

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Data Structures and Algorithms",
    ) {
        App()
    }
}