package com.borealnetwork.allen.modules.auth.di

import com.borealnetwork.allen.modules.auth.domain.view_models.LoginViewModel
import com.borealnetwork.shared.viewModelDefinition
import org.koin.core.qualifier.named
import org.koin.dsl.module

val authModule = module {

    viewModelDefinition {
        LoginViewModel(
            get(
                qualifier = named("LoginEmailUseCase")
            ))
    }
}