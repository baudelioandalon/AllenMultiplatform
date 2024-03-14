package com.borealnetwork.shared.core.auth.domain.use_cases

import com.borealnetwork.shared.core.auth.domain.interfaces.LoginGoogleRepository
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import com.borealnetwork.shared.domain.models.In
import com.borealnetwork.shared.domain.models.Out
import com.borealnetwork.shared.domain.models.UseCase
import dev.gitlive.firebase.auth.AuthCredential
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class LoginGoogleUseCase(private val loginGoogleRepository: LoginGoogleRepository) :
    UseCase<LoginGoogleUseCase.Input, LoginGoogleUseCase.Output> {

    class Input(val request: AuthCredential) : In()
    inner class Output(val response: ApiResponse<FirebaseUser>) :
        Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return loginGoogleRepository.executeGoogleLogin(input.request).flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }

}