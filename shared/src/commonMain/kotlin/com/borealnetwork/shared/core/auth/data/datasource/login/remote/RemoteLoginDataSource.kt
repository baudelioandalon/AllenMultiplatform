package com.borealnetwork.shared.core.auth.data.datasource.login.remote

import com.borealnetwork.shared.core.auth.data.datasource.login.GetLoginDataSource
import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import dev.gitlive.firebase.auth.AuthCredential

class RemoteLoginDataSource : GetLoginDataSource {

    override suspend fun executeEmailLogin(request: AuthLoginEmailModel) =
        LoginDataSource.getEmailLogin(request)

    override suspend fun executeGoogleLogin(signInCredential: AuthCredential) =
        LoginDataSource.getGoogleLogin(signInCredential)

}
