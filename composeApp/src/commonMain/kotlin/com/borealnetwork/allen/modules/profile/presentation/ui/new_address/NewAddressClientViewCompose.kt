package com.borealnetwork.allen.modules.profile.presentation.ui.new_address

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.components.BottomContinueItem
import com.borealnetwork.allen.components.EditTextTopLabel
import com.borealnetwork.allen.components.ResumeItem
import com.borealnetwork.allen.components.SelectorSpinner
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun NewAddressClientViewCompose(navigator: Navigator) {
    Scaffold(
        topBar = {
            ToolbarTitle(
                titleText = "Nueva Direccion",
                startClicked = {
                    navigator.goBack()
                }, showEndImage = false
            )
        },
        bottomBar = {
            BottomContinueItem()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {
            item {
                ResumeItem(title = "Ciudad") {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        EditTextTopLabel(
                            topLabelText = "Calle",
                            value = "",
                            onValueChange = {},
                            placeHolderText = "Calle Allen",
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 26.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            EditTextTopLabel(
                                modifier = Modifier.weight(1f).padding(end = 19.dp),
                                topLabelText = "Numero Exterior",
                                value = "",
                                onValueChange = {},
                                placeHolderText = "#123",
                            )
                            EditTextTopLabel(
                                modifier = Modifier.weight(1f).padding(start = 19.dp),
                                topLabelText = "Numero Interior",
                                value = "",
                                onValueChange = {},
                                placeHolderText = "#123",
                            )
                        }

                        EditTextTopLabel(
                            topLabelText = "Ciudad",
                            value = "",
                            onValueChange = {},
                            placeHolderText = "Ciudad de la ubicación",
                        )
                    }
                }
                ResumeItem(title = "Codigo postal") {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        EditTextTopLabel(
                            topLabelText = "Codigo postal",
                            value = "",
                            onValueChange = {},
                            placeHolderText = "5 digitos",
                        )

                        SelectorSpinner(
                            modifier = Modifier.padding(vertical = 26.dp),
                            topLabelText = "Colonia",
                            spinnerText = "Seleccione una colonia"
                        )

                        SelectorSpinner(
                            modifier = Modifier.padding(bottom = 26.dp),
                            topLabelText = "Estado",
                            spinnerText = "Seleccione un estado"
                        )

                        EditTextTopLabel(
                            topLabelText = "Alias",
                            value = "",
                            onValueChange = {},
                            placeHolderText = "Casa de verano",
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(200.dp))
            }
        }
        it.calculateBottomPadding()
    }

}