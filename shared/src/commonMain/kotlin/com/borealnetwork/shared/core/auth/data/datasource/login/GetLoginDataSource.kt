package com.borealnetwork.shared.core.auth.data.datasource.login

import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import dev.gitlive.firebase.auth.AuthCredential
import dev.gitlive.firebase.auth.FirebaseUser


interface GetLoginDataSource {
    suspend fun executeEmailLogin(
        request: AuthLoginEmailModel
    ): ApiResponse<FirebaseUser>

    suspend fun executeGoogleLogin(
        signInCredential: AuthCredential
    ): ApiResponse<FirebaseUser>
}