package com.borealnetwork.allen.modules.payments.presentation.ui.payments_methods

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
import com.borealnetwork.allensharedui.components.AddButton
import com.borealnetwork.allensharedui.components.CardFilled
import com.borealnetwork.allensharedui.components.ResumeItem
import com.borealnetwork.allensharedui.components.SelectorWithRadioButton
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allensharedui.components.bottom_actions.BottomContinueItem
import com.borealnetwork.shared.domain.models.payments.CardModel
import com.borealnetwork.shared.domain.models.payments.TypeCard
import com.borealnetwork.shared.domain.models.payments.paymentList
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import com.borealnetwork.allensharedui.theme.getGradient
import com.borealnetwork.shared.tools.limit
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun PaymentMethodsViewCompose(navigator: Navigator) {
    var selectedOption by rememberSaveable { mutableStateOf(paymentList[0].iconDescription) }

    val cardList = listOf(
        CardModel(
            aliasCard = "TDD BBVA",
            holderName = "Stan Lee",
            lastFourNumber = 1234,
            month = "12",
            year = "30",
            type = TypeCard.VISA,
            listColor  = getGradient()
        ),
        CardModel(
            aliasCard = "TDD BANORTE",
            holderName = "Stan Lee",
            lastFourNumber = 4312,
            month = "06",
            year = "29",
            type = TypeCard.MASTERCARD,
            listColor  = getGradient()
        ),
        CardModel(
            aliasCard = "TDD BANORTE",
            holderName = "Stan Lee",
            lastFourNumber = 4312,
            month = "06",
            year = "29",
            type = TypeCard.MASTERCARD,
            listColor  = getGradient()
        )
    )
    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Metodos de pago",
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
                                        model = card,
                                        listColor = card.listColor
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