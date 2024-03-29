package com.borealnetwork.allen.modules.auth.presentation.ui.welcome

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
import com.borealnetwork.allensharedui.components.BlueButton
import com.borealnetwork.allensharedui.components.BoldText
import com.borealnetwork.allensharedui.components.CornerButton
import com.borealnetwork.allensharedui.components.LogoBlue
import com.borealnetwork.allen.modules.auth.domain.navigation.AuthScreen
import com.borealnetwork.allensharedui.theme.mediumTypo
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun WelcomeViewCompose(navigator: Navigator) {

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
            painter = painterResource(resource = DrawableResource("login_shopping.png")),
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
                    resource = DrawableResource("allen_blue_logo.xml")
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
                navigator.navigate(AuthScreen.LoginScreen.route)
            }
            CornerButton(
                text = "Quiero ser socio vendedor", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp)
            ) {
                navigator.navigate(AuthScreen.RegisterScreen.route)
            }

            LogoBlue(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 50.dp)
                    .width(75.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}