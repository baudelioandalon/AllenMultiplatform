package com.borealnetwork.shared.core.network.domain.models

import com.borealnetwork.shared.core.network.domain.models.error_handler.AuthenticationErrorEnum
import com.borealnetwork.shared.domain.models.StateApi


data class FirestoreAuthResponse(
    val failure: AuthenticationErrorEnum? = null,
    val authType: AuthenticationType = AuthenticationType.EMAIL,
    val status: StateApi = StateApi.None
)