package com.borealnetwork.allen.modules.auth.di

import com.borealnetwork.allen.modules.auth.domain.view_model.LoginViewModel
import com.borealnetwork.shared.viewModelDefinition
import org.koin.core.qualifier.named
import org.koin.dsl.module

val authViewModelModule = module {

    viewModelDefinition {
        LoginViewModel(
            get(
                qualifier = named("LoginEmailUseCase")
            ))
    }
}