package com.borealnetwork.allen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.borealnetwork.allen.domain.login.StateApi
import com.borealnetwork.allen.domain.model.BirdImage
import com.borealnetwork.allen.tools.isEmailValid
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
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

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(BirdsUiState())
    val uiState = _uiState.asStateFlow()
    var loginEmailUser by mutableStateOf("")
    var loginTokenUser by mutableStateOf("")

    var loginUserState by mutableStateOf<StateApi>(StateApi.None)
    var loginTokenState by mutableStateOf<StateApi>(StateApi.None)

    init {
        updateImages()
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
            success()
        }
    }

    fun resetLoginError() {
        loginUserState = StateApi.None
        loginTokenState = StateApi.None
    }

}