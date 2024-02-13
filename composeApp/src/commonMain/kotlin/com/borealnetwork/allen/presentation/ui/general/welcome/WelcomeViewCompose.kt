package com.borealnetwork.allen.presentation.ui.general.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BlueButton
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.CornerButton
import com.borealnetwork.allen.components.LogoBlue
import com.borealnetwork.allen.theme.mediumTypo
import org.jetbrains.compose.resources.painterResource

@Composable
fun WelcomeViewCompose() {

    val scrollRemember = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollRemember)
            .background(White)
    ) {
        Image(
            modifier = Modifier
                .padding(top = 100.dp, bottom = 49.dp)
                .width(300.dp)
                .height(200.dp),
            painter = painterResource(res = "login_shopping.png"),
            contentDescription = "shoppingImage"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            BoldText(
                text = "Bienvenido a tu Tienda local",
                color = Black,
                fontSize = 30.sp
            )
            Image(
                modifier = Modifier.padding(top = 7.dp),
                painter = painterResource(
                    res = "allen_blue_logo.xml"
                ), contentDescription = "allenIcon"
            )
            BoldText(
                modifier = Modifier.padding(top = 16.dp),
                text = "En linea",
                color = Black,
                fontSize = 30.sp
            )
            val annotatedText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Black,
                        fontSize = 14.sp,
                        fontWeight = Medium,
                        fontFamily = mediumTypo()
                    )
                ) {
                    append("Puedes comenzar a hacer compras o publicar tus productos, incluso ")
                }
                // We attach this *termsClick* annotation to the following content
                // until `pop()` is called
                pushStringAnnotation(
                    tag = "termsClick",
                    annotation = "termsClick"
                )
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 14.sp,
                        fontFamily = mediumTypo()
                    )
                ) {
                    append("sin ubicación fija y sin local.")
                }
                pop()
            }
            ClickableText(
                text = annotatedText,
                modifier = Modifier.padding(top = 27.dp),
                onClick = { offset ->

                }
            )

            BlueButton(
                modifier = Modifier.padding(top = 40.dp),
                text = "Entrar"
            ) {
//                navController.navigate(LoginScreen.LoginLoginScreen.route)
            }
            CornerButton(
                text = "Quiero ser socio vendedor", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp)
            ) {
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