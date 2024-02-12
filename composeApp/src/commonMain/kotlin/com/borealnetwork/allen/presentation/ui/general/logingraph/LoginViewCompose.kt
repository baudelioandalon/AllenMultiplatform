package com.borealnetwork.allen.presentation.ui.general.logingraph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BlueButton
import com.borealnetwork.allen.components.CornerButton
import com.borealnetwork.allen.components.CornerImgButton
import com.borealnetwork.allen.components.EditText
import com.borealnetwork.allen.components.EditTextTopLabel
import com.borealnetwork.allen.components.LogoBlue
import com.borealnetwork.allen.components.SemiBoldText
import com.borealnetwork.allen.components.SeparatorHorizontal
import com.borealnetwork.allen.components.TopTitle

@Composable
fun LoginViewCompose() {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopTitle(titleText = "Este es el titulo") {
//            navController.navigateUp()
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .verticalScroll(scrollState)
        ) {

            SemiBoldText(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 45.dp),
                text = "Soy cliente / Quiero ser cliente",
                fontSize = 20.sp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .padding(top = 34.dp)
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

            SeparatorHorizontal(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 39.dp)
            )

            SemiBoldText(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                fontSize = 20.sp,
                text = "Soy socio vendedor"
            )



            EditTextTopLabel(
                modifier = Modifier.padding(top = 31.dp).fillMaxWidth(),
                placeHolderText = "correo@dominio.com",
                topLabelText = "Correo",
                enabledHelper = true,
                onValueChange = {
                }
            )
            EditTextTopLabel(
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                placeHolderText = "Ingrese contraseña",
                topLabelText = "Contraseña",
                onValueChange = {

                }
            )


            BlueButton(
                modifier = Modifier.padding(top = 25.dp),
                text = "Entrar"
            ) {
//                navController.navigate(HOME_CLIENT_GRAPH)
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
//                navController.navigate(LoginScreen.RegisterLoginScreen.route)
            }
            LogoBlue(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 50.dp)
                    .width(35.dp)
                    .height(11.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }

}