package com.borealnetwork.shared.core.auth.data.datasource.login.remote

import com.borealnetwork.shared.core.auth.domain.base.FirestoreRepository
import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import com.borealnetwork.shared.core.network.domain.models.FirestoreAuthResponse
import com.borealnetwork.shared.core.network.domain.models.error_handler.AuthenticationErrorEnum
import com.borealnetwork.shared.domain.models.StateApi
import dev.gitlive.firebase.auth.AuthCredential
import dev.gitlive.firebase.auth.GoogleAuthProvider

class LoginDataSource {
    companion object : FirestoreRepository() {
        suspend fun getEmailLogin(
            request: AuthLoginEmailModel,
        ): FirestoreAuthResponse {
            return with(
                firebaseAuth.signInWithEmailAndPassword(request.email, request.token)
            ) {
                try {
                    if (user != null) {
                        FirestoreAuthResponse(
                            status = StateApi.Success(user)
                        )
                    } else {
                        FirestoreAuthResponse(
                            failure = AuthenticationErrorEnum.ERROR_DEFAULT,
                            status = StateApi.Error
                        )
                    }

                } catch (exception: Exception) {
                    FirestoreAuthResponse(
                        failure = authenticationValidException(exception),
                        status = StateApi.Error
                    )
                }
            }
        }

        suspend fun getGoogleLogin(
            signInCredential: AuthCredential,
        ): FirestoreAuthResponse {
            return with(
                firebaseAuth.signInWithCredential(
                    GoogleAuthProvider.credential(
                        signInCredential.providerId,
                        null
                    )
                )
            ) {
                try {
                    if (user != null) {
                        FirestoreAuthResponse(
                            status = StateApi.Success(user)
                        )
                    } else {
                        FirestoreAuthResponse(
                            failure = AuthenticationErrorEnum.ERROR_DEFAULT,
                            status = StateApi.Error
                        )
                    }

                } catch (exception: Exception) {
                    FirestoreAuthResponse(
                        failure = authenticationValidException(exception),
                        status = StateApi.Error
                    )
                }
            }
        }
    }
}