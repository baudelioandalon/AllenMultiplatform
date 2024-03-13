package com.borealnetwork.allen

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.borealnetwork.allen.di.initKoin
import com.google.firebase.Firebase
import com.google.firebase.initialize
import org.koin.android.ext.koin.androidContext
import java.util.UUID
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier


class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        initKoin().apply {
            androidContext(this@AndroidApp)
        }
        INSTANCE = this
    }
}

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Firebase
        Firebase.initialize(this)
        setContent {
            App()
        }
    }
}



actual inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = viewModel(qualifier = qualifier, definition = definition)

internal actual fun openUrl(url: String?) {
    val uri = url?.let { Uri.parse(it) } ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    AndroidApp.INSTANCE.startActivity(intent)
}

internal actual fun randomUUID() = UUID.randomUUID().toString()

internal actual fun platform(): Platform = AndroidPlatform()

class AndroidPlatform : Platform {
    override val name = "Android ${Build.VERSION.SDK_INT}"
    override val osName = "Android"
    override val versionName = BuildConfig.versionName
    override val versionCode = BuildConfig.versionCode
    override val currency = BuildConfig.currency
}

@Composable
actual fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font {
    val context = LocalContext.current
    val id = context.resources.getIdentifier(res, "font", context.packageName)
    return Font(id, weight, style)
}