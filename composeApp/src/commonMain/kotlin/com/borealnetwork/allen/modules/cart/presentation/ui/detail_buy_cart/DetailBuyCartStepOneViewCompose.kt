package com.borealnetwork.allen.modules.cart.presentation.ui.detail_buy_cart

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allensharedui.components.AddressSelector
import com.borealnetwork.allensharedui.components.ResumeItem
import com.borealnetwork.allensharedui.components.SelectorSpinner
import com.borealnetwork.allensharedui.components.ShippingSelector
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allensharedui.components.UserSelector
import com.borealnetwork.allensharedui.components.bottom_actions.BottomBuyCartItem
import com.borealnetwork.allen.modules.profile.domain.navigation.ProfileScreen
import com.borealnetwork.allen.platform
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun DetailBuyCartStepOneViewCompose(navigator: Navigator) {

    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Detalles de compra",
            startClicked = {
                navigator.goBack()
            }, showEndImage = false
        )
    },
        bottomBar = {
            BottomBuyCartItem(
                price = 100.0,
                discount = 8,
                currency = platform().currency
            )
        }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {
            item {
                ResumeItem(
                    title = "Opciones de envio"
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        ShippingSelector(
                            modifier = Modifier
                                .padding(end = 25.dp)
                                .weight(1f), shipping = true
                        )
                        ShippingSelector(
                            modifier = Modifier
                                .padding(start = 25.dp)
                                .weight(1f)
                        )
                    }
                }

                ResumeItem(
                    title = "Dirección"
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                    ) {
                        AddressSelector(
                            textTop = "Desde",
                            iconRes = "ic_location.xml"
                        )
                        AddressSelector(
                            modifier = Modifier.padding(top = 20.dp),
                            textTop = "Para",
                            iconRes = "ic_goal.xml"
                        ) {
                            navigator.navigate(ProfileScreen.AddressClientScreen.route)
                        }
                        UserSelector(
                            modifier = Modifier.padding(top = 20.dp)
                        )
                    }
                }

                ResumeItem(title = "Forma de pago") {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                    ) {

                        SelectorSpinner()

                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(250.dp))
            }
        }
        it.calculateBottomPadding()
    }

}