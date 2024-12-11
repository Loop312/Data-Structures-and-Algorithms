package org.example.algorithms

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform