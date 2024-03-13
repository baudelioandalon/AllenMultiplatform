package com.borealnetwork.allen

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.resource
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import platform.Foundation.NSURL
import platform.Foundation.NSUUID
import platform.UIKit.UIApplication
import platform.UIKit.UIDevice

internal actual fun openUrl(url: String?) {
    val nsUrl = url?.let { NSURL.URLWithString(it) } ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}

internal actual fun randomUUID(): String = NSUUID().UUIDString()

internal actual fun platform(): Platform = IOSPlatform()
internal class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val osName = UIDevice.currentDevice.systemName()
    override val versionName = BuildConfig.versionName
    override val versionCode = BuildConfig.versionCode
    override val currency = BuildConfig.currency
}

private val cache: MutableMap<String, Font> = mutableMapOf()

@Composable
actual fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font {
    return cache.getOrPut(res) {
        val byteArray = runBlocking {
            resource("font/$res.ttf").readBytes()
        }
        androidx.compose.ui.text.platform.Font(res, byteArray, weight, style)
    }
}

actual inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = factory(qualifier = qualifier, definition = definition)