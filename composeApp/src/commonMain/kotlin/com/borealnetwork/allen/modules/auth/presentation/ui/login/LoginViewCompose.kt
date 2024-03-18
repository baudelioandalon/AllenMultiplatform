package com.borealnetwork.allen.modules.auth.presentation.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allensharedui.components.BlueButton
import com.borealnetwork.allensharedui.components.CornerButton
import com.borealnetwork.allensharedui.components.CornerImgButton
import com.borealnetwork.allensharedui.components.EditTextTopLabel
import com.borealnetwork.allensharedui.components.SemiBoldText
import com.borealnetwork.allensharedui.components.SeparatorHorizontal
import com.borealnetwork.allensharedui.components.ToolbarImg
import com.borealnetwork.allensharedui.components.loading.Loading
import com.borealnetwork.allen.modules.auth.domain.navigation.AuthScreen
import com.borealnetwork.allen.modules.auth.domain.view_model.LoginViewModel
import com.borealnetwork.allen.modules.home_client.domain.navigation.HomeClientScreen
import com.borealnetwork.shared.domain.models.StateApi
import moe.tlaster.precompose.navigation.Navigator
import org.koin.compose.koinInject

@Composable
fun LoginViewCompose(
    navigator: Navigator,
    loginViewModel: LoginViewModel = koinInject()
) {

    val scrollState = rememberScrollState()
    val status = loginViewModel.loginResult.collectAsState().value

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        topBar = {
            ToolbarImg {
                navigator.navigate(AuthScreen.WelcomeScreen.route)
            }
        }) {

        Loading(showOrHide = status?.status == StateApi.Loading)
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .verticalScroll(scrollState)
        ) {
            SemiBoldText(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight().padding(top = 35.dp),
                fontSize = 20.sp,
                text = "Iniciar sesión"
            )
            EditTextTopLabel(
                modifier = Modifier.padding(top = 31.dp).fillMaxWidth(),
                placeHolderText = "correo@dominio.com",
                topLabelText = "Correo",
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.None),
                enabledHelper = true,
                isError = loginViewModel.loginUserState == StateApi.Error,
                value = loginViewModel.loginEmailUser,
                errorMessage = when (loginViewModel.loginUserState) {
                    is StateApi.Success, StateApi.Loading, StateApi.None -> {
                        ""
                    }

                    is StateApi.Error -> {
                        (loginViewModel.loginUserState as StateApi.Error).message.orEmpty()
                    }
                },
                onValueChange = {
                    loginViewModel.resetLoginError()
                    loginViewModel.loginEmailUser = it
                }
            )
            EditTextTopLabel(
                modifier = Modifier.padding(top = 30.dp).fillMaxWidth(),
                placeHolderText = "Ingrese contraseña",
                topLabelText = "Contraseña",
                isPassword = true,
                isError = loginViewModel.loginTokenState == StateApi.Error,
                value = loginViewModel.loginTokenUser,
                errorMessage = when (loginViewModel.loginTokenState) {
                    is StateApi.Success, StateApi.Loading, StateApi.None -> {
                        ""
                    }

                    is StateApi.Error -> {
                        (loginViewModel.loginTokenState as StateApi.Error).message.orEmpty()
                    }
                },
                onValueChange = {
                    loginViewModel.resetLoginError()
                    loginViewModel.loginTokenUser = it
                }
            )

            BlueButton(
                modifier = Modifier.padding(top = 25.dp),
                text = "Entrar"
            ) {
                loginViewModel.login {
                    navigator.navigate(HomeClientScreen.HomeDefaultClientScreen.route)
                }
            }

            SeparatorHorizontal(
                modifier = Modifier
                    .padding(top = 30.dp)
            )

            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
            ) {
                CornerImgButton(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(0.5f),
                    text = "Google",
                    imgRes = "ic_google_logo.xml"
                )
                CornerImgButton(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    text = "Facebook",
                    imgRes = "ic_facebook_logo.xml"
                )
            }

            SemiBoldText(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                fontSize = 15.sp,
                text = "Olvidé la contraseña", textAlign = TextAlign.Center
            )

            SeparatorHorizontal(
                modifier = Modifier
                    .padding(vertical = 22.dp)
            )

            CornerButton(text = "Quiero ser socio vendedor") {
                navigator.navigate(AuthScreen.RegisterScreen.route)
            }
        }
        it.calculateBottomPadding()
    }
}