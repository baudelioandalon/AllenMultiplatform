package com.borealnetwork.shared.core.auth.di


import com.borealnetwork.shared.core.auth.data.datasource.login.GetLoginDataSource
import com.borealnetwork.shared.core.auth.data.datasource.login.remote.RemoteLoginDataSource
import com.borealnetwork.shared.core.auth.data.repository.login.DefaultLoginEmailRepository
import com.borealnetwork.shared.core.auth.data.repository.login.DefaultLoginGoogleRepository
import com.borealnetwork.shared.core.auth.domain.interfaces.LoginEmailRepository
import com.borealnetwork.shared.core.auth.domain.interfaces.LoginGoogleRepository
import com.borealnetwork.shared.core.auth.domain.use_cases.LoginEmailUseCase
import com.borealnetwork.shared.domain.models.UseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val loginModule = module {
    single<GetLoginDataSource> { RemoteLoginDataSource() }
//    single<GetAuthUserDataSource>(named("ALocalAuthDataSource")) {
//        ALocalAuthDataSource()
//    }
    single<LoginEmailRepository> { DefaultLoginEmailRepository(
        get(named("RemoteLoginDataSource"))
    ) }

    single<LoginGoogleRepository> { DefaultLoginGoogleRepository(get()) }

//    single<AuthRepository>(named("DefaultAuthRepository")) {
//        DefaultAuthRepository(
//            get(named("ALocalAuthDataSource"))
//        )
//    }
    single<UseCase<LoginEmailUseCase.Input, LoginEmailUseCase.Output>>(named("LoginEmailUseCase")) {
        LoginEmailUseCase(get(named("DefaultLoginEmailRepository")))
    }

//    single<UseCase<LoginGoogleUseCase.Input, LoginGoogleUseCase.Output>> { LoginGoogleUseCase(get()) }

}