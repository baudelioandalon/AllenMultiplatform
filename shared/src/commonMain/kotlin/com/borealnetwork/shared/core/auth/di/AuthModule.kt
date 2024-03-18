package com.borealnetwork.shared.core.auth.di


import com.borealnetwork.shared.core.auth.data.data_source.login.GetLoginDataSource
import com.borealnetwork.shared.core.auth.data.data_source.login.remote.RemoteLoginDataSource
import com.borealnetwork.shared.core.auth.data.repository.login.DefaultLoginEmailRepository
import com.borealnetwork.shared.core.auth.data.repository.login.DefaultLoginGoogleRepository
import com.borealnetwork.shared.core.auth.domain.interfaces.LoginEmailRepository
import com.borealnetwork.shared.core.auth.domain.interfaces.LoginGoogleRepository
import com.borealnetwork.shared.core.auth.domain.use_cases.LoginEmailUseCase
import com.borealnetwork.shared.domain.models.UseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val authModule = module {
    single<GetLoginDataSource>(named("RemoteLoginDataSource")) { RemoteLoginDataSource() }

    single<LoginEmailRepository>(named("DefaultLoginEmailRepository")) {
        DefaultLoginEmailRepository(
            get(named("RemoteLoginDataSource"))
        )
    }

    single<LoginGoogleRepository>(named("DefaultLoginGoogleRepository")) {
        DefaultLoginGoogleRepository(
            get()
        )
    }

    single<UseCase<LoginEmailUseCase.Input, LoginEmailUseCase.Output>>(named("LoginEmailUseCase")) {
        LoginEmailUseCase(get(named("DefaultLoginEmailRepository")))
    }

}