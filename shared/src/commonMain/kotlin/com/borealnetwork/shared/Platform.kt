package com.borealnetwork.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform