package com.borealnetwork.allen

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

internal expect fun openUrl(url: String?)

internal expect fun randomUUID(): String

internal expect fun platform(): Platform

expect fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font
internal interface Platform {
    val name: String
    val osName: String
    val versionName: String
}