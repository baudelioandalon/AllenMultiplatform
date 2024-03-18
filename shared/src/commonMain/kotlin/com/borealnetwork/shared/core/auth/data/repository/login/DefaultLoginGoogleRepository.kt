package com.borealnetwork.shared.core.auth.data.repository.login

import com.borealnetwork.shared.core.auth.data.data_source.login.GetLoginDataSource
import com.borealnetwork.shared.core.auth.domain.interfaces.LoginGoogleRepository
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import dev.gitlive.firebase.auth.AuthCredential
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultLoginGoogleRepository(
    private val getLoginDataSource: GetLoginDataSource
) : LoginGoogleRepository {

    override suspend fun executeGoogleLogin(signInCredential: AuthCredential): Flow<ApiResponse<FirebaseUser>> =
        flow {
            emit(getLoginDataSource.executeGoogleLogin(signInCredential))
        }
}