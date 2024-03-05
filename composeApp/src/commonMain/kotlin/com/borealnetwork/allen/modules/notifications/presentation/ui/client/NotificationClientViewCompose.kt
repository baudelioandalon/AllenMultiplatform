package com.borealnetwork.allen.modules.notifications.presentation.ui.client

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.borealnetwork.allen.components.NotificationItem
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.theme.GrayBackgroundMain

@Composable
fun NotificationClientViewCompose() {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            ToolbarTitle(
                titleText = "Notificaciones", startClicked = {
//                navController?.navigateUp()
                },
                endIcon = "ic_bell_icon.xml"
            )
        }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {

            itemsIndexed(
                listOf(
                    Pair("PICKUP", "OK"),
                    Pair("SHIPPING", "OK"),
                    Pair("PICKUP", "CANCELLED_BY_CLIENT"),
                    Pair("SHIPPING", "CANCELLED_BY_SELLER"),
                    Pair("SHIPPING", "OK"),
                    Pair("PICKUP", "CANCELLED_BY_CLIENT"),
                    Pair("SHIPPING", "CANCELLED_BY_SELLER")
                )
            ) { index, item ->

                NotificationItem(
                    step = index,
                    default = index % 2 == 0,
                    shippingType = item.first,
                    shippingStatus = item.second
                )
            }


        }
        it.calculateBottomPadding()
    }
}