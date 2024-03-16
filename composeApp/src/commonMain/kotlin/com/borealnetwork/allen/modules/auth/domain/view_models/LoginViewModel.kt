package com.borealnetwork.allen.modules.auth.domain.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.borealnetwork.allen.domain.model.BirdImage
import com.borealnetwork.allen.tools.isEmailValid
import com.borealnetwork.shared.core.auth.domain.use_cases.LoginEmailUseCase
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import com.borealnetwork.shared.core.network.domain.models.AuthLoginEmailModel
import com.borealnetwork.shared.core.network.domain.models.error
import com.borealnetwork.shared.core.network.domain.models.loading
import com.borealnetwork.shared.core.network.domain.models.success
import com.borealnetwork.shared.domain.models.StateApi
import com.borealnetwork.shared.domain.models.UseCase
import dev.gitlive.firebase.auth.FirebaseUser
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class BirdsUiState(
    val images: List<BirdImage> = emptyList(),
    val selectedCategory: String? = null
) {
    val categories = images.map { it.category }.toSet()
    val selectedImages = images.filter { it.category == selectedCategory }
}


class LoginViewModel(
    private val getLoginEmailUseCase: UseCase<LoginEmailUseCase.Input, LoginEmailUseCase.Output>
) : ViewModel() {


//    private val getAuthLoginUseCase: UseCase<LoginGoogleUseCase.Input, LoginGoogleUseCase.Output> by Koin()

    private val _uiState = MutableStateFlow(BirdsUiState())
    val uiState = _uiState.asStateFlow()
    var loginEmailUser by mutableStateOf("baudelioandalon@gmail.com")
    var loginTokenUser by mutableStateOf("yeyo132A")

    var loginUserState by mutableStateOf<StateApi>(StateApi.None)
    var loginTokenState by mutableStateOf<StateApi>(StateApi.None)
    private val _loginResult = MutableStateFlow<ApiResponse<FirebaseUser>?>(null)
    val loginResult = _loginResult.asStateFlow()

    init {
//        updateImages()
    }

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    override fun onCleared() {
        httpClient.close()
    }

    fun selectCategory(category: String) {
        _uiState.update {
            it.copy(selectedCategory = category)
        }
    }

    fun updateImages() {
        viewModelScope.launch {
            val images = getImages()
            _uiState.update {
                it.copy(images = images)
            }
        }
    }

    private suspend fun getImages(): List<BirdImage> {
        return httpClient
            .get("https://sebi.io/demo-image-api/pictures.json")
            .body<List<BirdImage>>()
    }

    fun login(success: () -> Unit) {
        if (!loginEmailUser.isEmailValid()) {
            loginUserState = StateApi.Error.error("El usuario es invalido")
        } else if (loginTokenUser.isEmpty()) {
            loginTokenState = StateApi.Error.error("Contraseña no valida")
        } else if (loginTokenUser.length < 8) {
            loginTokenState = StateApi.Error.error("Minimo 8 caracteres")
        } else {
            //GoToLogin
            viewModelScope.launch {
                _loginResult.update {
                    loading()
                }
                getLoginEmailUseCase.execute(
                    LoginEmailUseCase.Input(
                        AuthLoginEmailModel(
                            email = loginEmailUser,
                            token = loginTokenUser
                        )
                    )
                ).collect {
                    if(it.result.status == StateApi.Success){
                        delay(2000)
                    }
                    it.result.success { response ->
                        _loginResult.update {
                            success()
                            response
                        }
                    }
                    it.result.error { error ->
                        _loginResult.update {
                            error
                        }
                    }

                }
            }

        }
    }

    fun resetLoginError() {
        loginUserState = StateApi.None
        loginTokenState = StateApi.None
    }

}