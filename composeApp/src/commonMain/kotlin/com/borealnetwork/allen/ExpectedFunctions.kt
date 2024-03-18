package com.borealnetwork.allen


internal expect fun platform(): Platform

internal interface Platform {
    val versionName: String
    val versionCode: String
    val currency: String
}

expect fun openUrl(url: String?)