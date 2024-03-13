package com.borealnetwork.shared.core.auth.data.repository.login

import com.borealnetwork.shared.core.auth.data.datasource.login.GetLoginDataSource
import com.borealnetwork.shared.core.auth.domain.interfaces.LoginEmailRepository
import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import com.borealnetwork.shared.core.network.domain.models.FirestoreAuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultLoginEmailRepository(
    private val getLoginDataSource: GetLoginDataSource
) : LoginEmailRepository {

    override suspend fun executeLogin(request: AuthLoginEmailModel): Flow<FirestoreAuthResponse> =
        flow {
            emit(getLoginDataSource.executeEmailLogin(request))
        }
}