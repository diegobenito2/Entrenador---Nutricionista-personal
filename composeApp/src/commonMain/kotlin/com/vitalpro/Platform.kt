package com.vitalpro

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform