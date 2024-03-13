package com.borealnetwork.shared.core.auth.domain.interfaces

import com.borealnetwork.shared.core.network.domain.models.FirestoreAuthResponse
import dev.gitlive.firebase.auth.AuthCredential
import kotlinx.coroutines.flow.Flow

interface LoginGoogleRepository {
    suspend fun executeGoogleLogin(signInCredential: AuthCredential):
            Flow<FirestoreAuthResponse>
}