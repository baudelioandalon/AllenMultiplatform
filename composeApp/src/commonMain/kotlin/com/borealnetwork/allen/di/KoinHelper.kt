package com.borealnetwork.allen.di

import com.borealnetwork.allen.modules.auth.di.authModule
import com.borealnetwork.shared.core.auth.di.loginModule
import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(
        loginModule,
        authModule
    )
}