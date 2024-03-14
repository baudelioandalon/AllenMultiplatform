package com.borealnetwork.shared.core.auth.data.datasource.login.remote

import com.borealnetwork.shared.core.auth.domain.base.FirestoreRepository
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import com.borealnetwork.shared.domain.models.StateApi
import dev.gitlive.firebase.auth.AuthCredential
import dev.gitlive.firebase.auth.GoogleAuthProvider

class LoginDataSource {
    companion object : FirestoreRepository() {
        suspend fun getEmailLogin(
            request: AuthLoginEmailModel,
        ) = try {
            val user = firebaseAuth.signInWithEmailAndPassword(request.email, request.token)
            ApiResponse(
                response = user.user,
                status = StateApi.Success
            )
        } catch (exception: Exception) {
            ApiResponse(
                failure = errorResponse(exception),
                status = StateApi.Error
            )
        }


        suspend fun getGoogleLogin(
            signInCredential: AuthCredential,
        ) = try {
            val user = firebaseAuth.signInWithCredential(
                GoogleAuthProvider.credential(
                    signInCredential.providerId,
                    null
                )
            )
            ApiResponse(
                response = user.user,
                status = StateApi.Success
            )

        } catch (exception: Exception) {
            ApiResponse(
                failure = errorResponse(exception),
                status = StateApi.Error
            )
        }
    }


}