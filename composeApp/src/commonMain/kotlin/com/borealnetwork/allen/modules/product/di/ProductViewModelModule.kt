package com.borealnetwork.allen.modules.product.di

import com.borealnetwork.allen.modules.home_client.domain.view_model.HomeClientViewModel
import com.borealnetwork.allen.modules.product.domain.view_models.ShowProductViewModel
import com.borealnetwork.shared.viewModelDefinition
import org.koin.core.qualifier.named
import org.koin.dsl.module

val productViewModelModule = module {

    viewModelDefinition {
        HomeClientViewModel(
            get(
                qualifier = named("ProductsUseCase")
            )
        )
    }
    viewModelDefinition {
        ShowProductViewModel()
    }
}