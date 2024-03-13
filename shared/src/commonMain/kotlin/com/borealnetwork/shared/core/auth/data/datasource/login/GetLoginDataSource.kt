package com.borealnetwork.shared.core.auth.data.datasource.login

import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import com.borealnetwork.shared.core.network.domain.models.FirestoreAuthResponse
import dev.gitlive.firebase.auth.AuthCredential


interface GetLoginDataSource {
    suspend fun executeEmailLogin(
        request: AuthLoginEmailModel
    ): FirestoreAuthResponse

    suspend fun executeGoogleLogin(
        signInCredential: AuthCredential
    ): FirestoreAuthResponse
}