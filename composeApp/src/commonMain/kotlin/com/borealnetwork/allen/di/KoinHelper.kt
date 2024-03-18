package com.borealnetwork.allen.di

import com.borealnetwork.allen.modules.auth.di.authViewModelModule
import com.borealnetwork.allen.modules.product.di.productViewModelModule
import com.borealnetwork.shared.core.auth.di.authModule
import com.borealnetwork.shared.core.firestore.di.productsModule
import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(
        authModule,
        authViewModelModule,
        productViewModelModule,
        productsModule
    )
}