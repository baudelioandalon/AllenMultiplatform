package com.borealnetwork.shared.core.auth.domain.interfaces

import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import dev.gitlive.firebase.auth.AuthCredential
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface LoginGoogleRepository {
    suspend fun executeGoogleLogin(signInCredential: AuthCredential):
            Flow<ApiResponse<FirebaseUser>>
}