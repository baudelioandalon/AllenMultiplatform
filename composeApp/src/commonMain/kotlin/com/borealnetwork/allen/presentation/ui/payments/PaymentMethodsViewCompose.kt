package com.borealnetwork.allen.presentation.ui.payments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.components.AddButton
import com.borealnetwork.allen.components.BottomContinueItem
import com.borealnetwork.allen.components.CardFilled
import com.borealnetwork.allen.components.ResumeItem
import com.borealnetwork.allen.components.SelectorWithRadioButton
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.domain.payments.CardModel
import com.borealnetwork.allen.domain.payments.TypeCard
import com.borealnetwork.allen.domain.payments.paymentList
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.tools.limit

@Composable
fun PaymentMethodsViewCompose() {
    var selectedOption by rememberSaveable { mutableStateOf(paymentList[0].iconDescription) }

    val cardList = listOf(
        CardModel(
            aliasCard = "TDD BBVA",
            holderName = "Stan Lee",
            lastFourNumber = 1234,
            month = "12",
            year = "30",
            type = TypeCard.VISA
        ),
        CardModel(
            aliasCard = "TDD BANORTE",
            holderName = "Stan Lee",
            lastFourNumber = 4312,
            month = "06",
            year = "29",
            type = TypeCard.MASTERCARD
        ),
        CardModel(
            aliasCard = "TDD BANORTE",
            holderName = "Stan Lee",
            lastFourNumber = 4312,
            month = "06",
            year = "29",
            type = TypeCard.MASTERCARD
        )
    )
    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Metodos de pago", startClicked = {
//                navController?.navigateUp()
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
                AnimatedVisibility(
                    visible = selectedOption == paymentList.first().iconDescription,
                ) {
                    ResumeItem(
                        title = "Tarjetas guardadas",
                        topContent = {
                            AddButton(text = "Agregar")
                        },
                        middleItem = true,
                        endPadding = 0.dp,
                        startPadding = 0.dp,
                        innerStartPadding = 30.dp,
                        innerEndPadding = 20.dp,
                        innerTopPadding = 0.dp,
                        innerBottomPadding = 0.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 30.dp),
                        ) {
                            LazyRow {
                                itemsIndexed(items = cardList) { index, card ->
                                    CardFilled(
                                        modifier = Modifier.padding(
                                            start = 30.dp,
                                            end = if (index == cardList.limit()) 30.dp else 0.dp
                                        ),
                                        model = card
                                    )
                                }
                            }
                        }

                    }
                }

                ResumeItem(
                    title = "Tipos de pago"
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                    ) {
                        paymentList.forEachIndexed { index, paymentMethod ->
                            SelectorWithRadioButton(
                                modifier = Modifier.padding(bottom = if (index != paymentList.limit()) 30.dp else 0.dp),
                                text = paymentMethod.text,
                                iconRes = paymentMethod.iconRes,
                                iconDescription = paymentMethod.iconDescription,
                                selected = paymentMethod.iconDescription == selectedOption
                            ) { paymentClicked ->
                                selectedOption = paymentClicked
                            }
                        }

                    }
                }

            }
            item {
                Spacer(modifier = Modifier.height(150.dp))
            }
        }


        it.calculateBottomPadding()
    }

}