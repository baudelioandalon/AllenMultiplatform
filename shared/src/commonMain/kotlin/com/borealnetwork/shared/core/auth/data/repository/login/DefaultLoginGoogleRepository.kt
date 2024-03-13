package com.borealnetwork.shared.core.auth.data.repository.login

import com.borealnetwork.shared.core.auth.data.datasource.login.GetLoginDataSource
import com.borealnetwork.shared.core.auth.domain.interfaces.LoginGoogleRepository
import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import com.borealnetwork.shared.core.network.domain.models.AuthModel
import com.borealnetwork.shared.core.network.domain.models.FirestoreAuthResponse
import com.borealnetwork.shared.core.network.domain.models.error_handler.AuthenticationErrorEnum
import dev.gitlive.firebase.auth.AuthCredential
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultLoginGoogleRepository(
    private val getLoginDataSource: GetLoginDataSource
) : LoginGoogleRepository {

    override suspend fun executeGoogleLogin(signInCredential: AuthCredential): Flow<FirestoreAuthResponse> =
        flow {
            emit(getLoginDataSource.executeGoogleLogin(signInCredential))
        }
}