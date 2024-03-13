package com.borealnetwork.allen

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

internal expect fun openUrl(url: String?)

internal expect fun randomUUID(): String

internal expect fun platform(): Platform

@Composable
expect fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font
internal interface Platform {
    val name: String
    val osName: String
    val versionName: String
    val versionCode: String
    val currency: String
}

internal interface BasicData {
    val currency: String
}

expect inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier? = null,
    noinline definition: Definition<T>
): KoinDefinition<T>