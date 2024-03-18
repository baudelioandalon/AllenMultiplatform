package com.borealnetwork.allen.modules.auth.presentation.ui.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allensharedui.components.BlueButton
import com.borealnetwork.allensharedui.components.EditTextTopLabel
import com.borealnetwork.allensharedui.components.LogoBlue
import com.borealnetwork.allensharedui.components.ToolbarTitle
import moe.tlaster.precompose.navigation.Navigator


@Composable
fun RegisterViewCompose(navigator: Navigator) {

    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Nuevo socio",
            startClicked = {
                navigator.goBack()
            },
            showEndImage = false,
        )
    }) {
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {

            EditTextTopLabel(
                modifier = Modifier.padding(top = 31.dp),
                topLabelText = "Nombre",
                value = "",
                onValueChange = {},
                placeHolderText = "Nombre completo",
            )

            EditTextTopLabel(
                modifier = Modifier.padding(top = 26.dp),
                topLabelText = "Correo",
                value = "",
                onValueChange = {},
                placeHolderText = "nombre@dominio.com",
            )
            EditTextTopLabel(
                modifier = Modifier.padding(top = 26.dp),
                topLabelText = "Contraseña",
                value = "",
                onValueChange = {},
                placeHolderText = "Ingrese contraseña",
            )
            EditTextTopLabel(
                modifier = Modifier.padding(top = 26.dp),
                topLabelText = "Confirmar contraseña",
                value = "",
                onValueChange = {},
                placeHolderText = "Ingrese contraseña",
            )

            BlueButton(
                modifier = Modifier.padding(top = 35.dp),
                text = "Registrarme",
                enabled = false
            ){
                //IR a vista VENDEDOR
//                navigator.navigate(HomeClientScreen.HomeDefaultClientScreen.route)
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )

            LogoBlue(
                modifier = Modifier
                    .padding(top = 35.dp, bottom = 50.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
        it.calculateBottomPadding()
    }

}