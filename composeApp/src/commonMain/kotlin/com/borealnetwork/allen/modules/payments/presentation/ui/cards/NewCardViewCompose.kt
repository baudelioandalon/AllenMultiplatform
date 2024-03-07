package com.borealnetwork.allen.modules.payments.presentation.ui.cards

import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.components.BottomContinueItem
import com.borealnetwork.allen.components.CardNoFilled
import com.borealnetwork.allen.components.EditTextTopLabel
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.tools.getGradient
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun NewCardViewCompose(navigator: Navigator) {

    var holderName by rememberSaveable {
        mutableStateOf(
            ""
        )
    }
    var numberCard by rememberSaveable {
        mutableStateOf(
            "1234567891012345"
        )
    }
    var aliasCard by rememberSaveable {
        mutableStateOf(
            ""
        )
    }
    var monthCard by rememberSaveable {
        mutableStateOf(
            ""
        )
    }
    var cvvCard by rememberSaveable {
        mutableStateOf(
            ""
        )
    }
    var yearCard by rememberSaveable {
        mutableStateOf(
            ""
        )
    }

    val colors = getGradient()
    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Nueva tarjeta",
            startClicked = {
                navigator.goBack()
            }, showEndImage = false
        )
    },
        bottomBar = {
            BottomContinueItem()
        }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {
            item {

                Column(modifier = Modifier.fillMaxWidth()) {
                    CardNoFilled(
                        modifier = Modifier.padding(
                            start = 30.dp, end = 30.dp, top = 30.dp
                        ),
                        holderName = holderName,
                        number = numberCard,
                        aliasCard = aliasCard,
                        month = monthCard,
                        year = yearCard,
                        list = colors
                    )

                    EditTextTopLabel(
                        modifier = Modifier.padding(top = 15.dp, start = 30.dp, end = 30.dp),
                        topLabelText = "Nombre del titular",
                        value = holderName,
                        onValueChange = {
                            holderName = it
                        },
                        placeHolderText = "Nombre completo",
                    )
                    EditTextTopLabel(
                        modifier = Modifier.padding(top = 15.dp, start = 30.dp, end = 30.dp),
                        topLabelText = "Numero de la tarjeta",
                        value = numberCard,
                        onValueChange = {
                            numberCard = it
                        },
                        placeHolderText = "16 o 17 digitos",
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 15.dp, start = 30.dp, end = 30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        EditTextTopLabel(
                            modifier = Modifier.weight(1f).padding(end = 19.dp),
                            topLabelText = "Fecha de expiración",
                            value = "$monthCard/$yearCard",
                            onValueChange = {
                                monthCard = it
                            },
                            placeHolderText = "MM/AA",
                        )
                        EditTextTopLabel(
                            modifier = Modifier.weight(1f).padding(start = 19.dp),
                            topLabelText = "CVV",
                            value = cvvCard,
                            onValueChange = {
                                cvvCard = it
                            },
                            placeHolderText = "#123",
                        )
                    }
                    EditTextTopLabel(
                        modifier = Modifier.padding(top = 15.dp, start = 30.dp, end = 30.dp),
                        topLabelText = "Alias de la tarjeta",
                        value = aliasCard,
                        onValueChange = {
                            aliasCard = it
                        },
                        placeHolderText = "Opcional",
                    )
                }

            }
            item {
                Spacer(modifier = Modifier.height(150.dp))
            }
        }

        it.calculateBottomPadding()
    }

}