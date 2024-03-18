package com.borealnetwork.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier



expect fun randomUUID(): String

expect fun platform(): Platform

@Composable
expect fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font
interface Platform {
    val name: String
    val osName: String
}

internal interface BasicData {
    val currency: String
}

expect inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier? = null,
    noinline definition: Definition<T>
): KoinDefinition<T>


@Composable
expect fun SystemAppearance(isDark: Boolean)