package com.borealnetwork.shared.core.auth.domain.use_cases

import com.borealnetwork.shared.core.auth.domain.interfaces.LoginEmailRepository
import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import com.borealnetwork.shared.domain.models.In
import com.borealnetwork.shared.domain.models.Out
import com.borealnetwork.shared.domain.models.UseCase
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class LoginEmailUseCase(private val loginNormalRepository: LoginEmailRepository) :
    UseCase<LoginEmailUseCase.Input, LoginEmailUseCase.Output> {

    class Input(val request: AuthLoginEmailModel) : In()
    inner class Output(val result: ApiResponse<FirebaseUser>) :
        Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return loginNormalRepository.executeLogin(input.request).flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }

}