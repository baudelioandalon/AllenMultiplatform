package com.borealnetwork.allen

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

internal actual fun platform(): Platform = IOSPlatform()
internal class IOSPlatform : Platform {
    override val versionName = BuildConfig.versionName
    override val versionCode = BuildConfig.versionCode
    override val currency = BuildConfig.currency
}


actual fun openUrl(url: String?) {
    val nsUrl = url?.let { NSURL.URLWithString(it) } ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}