package com.borealnetwork.allen.modules.orders.presentation.ui.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.components.ResumeItem
import com.borealnetwork.allen.components.ShoppingCategoryHistoryItem
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.domain.model.ItemShoppingModel
import com.borealnetwork.allen.theme.GrayBackgroundMain

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OrdersListViewCompose() {

    val listInProgress = listOf(
        ItemShoppingModel(
            nameStore = "Ferreteria La hormiga",
            idStore = "d2d232",
            imgStore = "dddd",
            idSale = "dwed342",
            price = 46.0,
            status = "RUNNING",
            giftStatus = "TAKEN",
            apologyStatus = "NONE",
            canceledBy = "NONE",
            numberProducts = 1
        ), ItemShoppingModel(
            nameStore = "Ferreteria La hormiga",
            idStore = "d2d232",
            imgStore = "dddd",
            idSale = "dwed342",
            price = 46.0,
            status = "WAITING_CLIENT",
            giftStatus = "TAKEN",
            apologyStatus = "NONE",
            canceledBy = "NONE",
            numberProducts = 1
        ), ItemShoppingModel(
            nameStore = "Ferreteria La hormiga",
            idStore = "d2d232",
            imgStore = "dddd",
            idSale = "dwed342",
            price = 46.0,
            status = "WAITING_SELLER",
            giftStatus = "TAKEN",
            apologyStatus = "NONE",
            canceledBy = "NONE",
            numberProducts = 1
        )
    )
    val listDone = listOf(
        ItemShoppingModel(
            nameStore = "Ferreteria La hormiga",
            idStore = "d2d232",
            imgStore = "dddd",
            idSale = "dwed342",
            price = 46.0,
            status = "RECEIVED",
            giftStatus = "TAKEN",
            apologyStatus = "NONE",
            canceledBy = "NONE",
            numberProducts = 1
        ),
        ItemShoppingModel(
            nameStore = "Ferreteria La hormiga",
            idStore = "d2d232",
            imgStore = "dddd",
            idSale = "dwed342",
            price = 1000.0,
            status = "CANCELED",
            giftStatus = "AVAILABLE",
            apologyStatus = "NONE",
            canceledBy = "SELLER",
            numberProducts = 1
        ),
        ItemShoppingModel(
            nameStore = "Ferreteria La hormiga",
            idStore = "d2d232",
            imgStore = "dddd",
            idSale = "dwed342",
            price = 56.0,
            status = "CANCELED",
            giftStatus = "NONE",
            apologyStatus = "NONE",
            canceledBy = "CLIENT",
            numberProducts = 1
        )
    )
    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Mis compras",
            startClicked = {
            },
            showEndImage = false,
            endIcon = "ic_coupon.xml",
        )
    }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {

            item {
                ResumeItem(
                    title = "En curso",
                    topCounter = true,
                    numberCounter = listInProgress.size,
                    innerBottomPadding = 5.dp
                ) {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        listInProgress.forEachIndexed { index, item ->
                            ShoppingCategoryHistoryItem(
                                itemPayed = item,
                                counter = false,
                                deleteOptions = false,
                                selector = false,
                                hideArrow = false,
                                hideTopLine = index != listInProgress.lastIndex
                            ) {
//                                    navController?.navigate(SHOPPING_DETAIL_CLIENT_GRAPH)
                            }
                        }
                    }
                }
            }
            item {
                ResumeItem(
                    title = "Anteriores",
                    topCounter = true,
                    numberCounter = listDone.size,
                    innerBottomPadding = 5.dp
                ) {

                    FlowRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        listDone.forEachIndexed { index, item ->
                            ShoppingCategoryHistoryItem(
                                itemPayed = item,
                                counter = false,
                                deleteOptions = false,
                                selector = false,
                                hideArrow = false,
                                hideTopLine = index != listDone.lastIndex
                            ) {
//                                    navController?.navigate(SHOPPING_DETAIL_CLIENT_GRAPH)
                            }
                        }

                    }

                }
            }
        }
        it.calculateBottomPadding()
    }
}