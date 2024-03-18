package com.borealnetwork.shared

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.core.view.WindowCompat
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import java.util.UUID


actual inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = viewModel(qualifier = qualifier, definition = definition)

actual fun randomUUID() = UUID.randomUUID().toString()

actual fun platform(): Platform = AndroidPlatform()

class AndroidPlatform : Platform {
    override val name = "Android ${Build.VERSION.SDK_INT}"
    override val osName = "Android"
}

@Composable
actual fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font {
    val context = LocalContext.current
    val id = context.resources.getIdentifier(res, "font", context.packageName)
    return Font(id, weight, style)
}

@Composable
actual fun SystemAppearance(isDark: Boolean) {
    val view = LocalView.current
    val systemBarColor = Color.TRANSPARENT
    LaunchedEffect(isDark) {
        val window = (view.context as Activity).window
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = systemBarColor
//        window.navigationBarColor = systemBarColor//Esto es para el bottomNavigation
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = isDark
            isAppearanceLightNavigationBars = isDark
        }
    }
}