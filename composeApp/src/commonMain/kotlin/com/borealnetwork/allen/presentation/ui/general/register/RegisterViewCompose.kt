package com.borealnetwork.allen.presentation.ui.general.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.components.BlueButton
import com.borealnetwork.allen.components.EditTextTopLabel
import com.borealnetwork.allen.components.LogoBlue
import com.borealnetwork.allen.components.TopTitle


@Composable
fun RegisterViewCompose() {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopTitle(titleText = "Nuevo socio") {
//            navController.navigateUp()
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxSize()
                .verticalScroll(scrollState),

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
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )

            LogoBlue(
                modifier = Modifier
                    .padding(top = 35.dp, bottom = 50.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }

}