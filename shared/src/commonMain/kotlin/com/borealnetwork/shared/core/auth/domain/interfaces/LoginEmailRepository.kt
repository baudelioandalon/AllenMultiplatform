package com.borealnetwork.shared.core.auth.domain.interfaces

import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface LoginEmailRepository {
    suspend fun executeLogin(request: AuthLoginEmailModel):
            Flow<ApiResponse<FirebaseUser>>
}