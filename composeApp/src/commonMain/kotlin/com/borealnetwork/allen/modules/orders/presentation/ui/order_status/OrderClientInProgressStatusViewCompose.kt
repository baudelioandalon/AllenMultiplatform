package com.borealnetwork.allen.modules.orders.presentation.ui.order_status

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.components.ResumeSelector
import com.borealnetwork.allen.components.ShoppingCartStoreItem
import com.borealnetwork.allen.components.StatusPackageItem
import com.borealnetwork.allen.components.StatusPreviouPackageItem
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.components.bottom_actions.BottomBuyCartItem
import com.borealnetwork.allen.domain.model.ItemCartModel
import com.borealnetwork.allen.domain.model.ProductShoppingCart
import com.borealnetwork.allen.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allen.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OrderClientInProgressStatusViewCompose(navigator: Navigator) {

    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Estado del pedido",
            startClicked = {
                navigator.goBack()
            },
            showEndImage = false,
            endIcon = "ic_coupon.xml",
        )
    },
        bottomBar = {
            BottomBuyCartItem(payed = true)
        }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(200.dp),
                    shape = RectangleShape,
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp
                ) {

                }
            }
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(bottom = 30.dp),
                    shape = RectangleShape,
                    elevation = 5.dp
                ) {

                    Card(
                        modifier = Modifier
                            .padding(bottom = 30.dp, start = 30.dp, end = 30.dp)
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        backgroundColor = Transparent,
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column {
                            StatusPackageItem(
                                default = false
                            )
                            FlowRow(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                val list = listOf(false, false, false, false, false, true)
                                list.forEach {
                                    StatusPreviouPackageItem(lastItem = it)
                                }
                            }
                        }
                    }

                }
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RectangleShape,
                    elevation = 10.dp
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentWidth(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start
                    ) {
                        ResumeSelector(
                            modifier = Modifier.padding(horizontal = 30.dp),
                            textTop = "Forma de pago",
                            textBottom = "Contra entrega en efectivo"
                        )
                        ResumeSelector(
                            modifier = Modifier.padding(horizontal = 30.dp),
                            textTop = "Recibe",
                            textBottom = "Luna Lovegood"
                        )
                        ResumeSelector(
                            modifier = Modifier.padding(horizontal = 30.dp),
                            textTop = "Telefono de contacto",
                            textBottom = "332 846 1020"
                        )
                        ResumeSelector(
                            modifier = Modifier.padding(horizontal = 30.dp),
                            textTop = "Articulos",
                            textBottom = "3 articulos", lineBottom = false
                        )

                        FlowRow {
                            val list = listOf(
                                ItemCartModel(
                                    nameStore = "Ferreteria La Hormiga",
                                    idStore = "idmidjikjdokjdo",
                                    imgStore = "didimd",
                                    listItems = listOf(
                                        ProductShoppingCart(
                                            skuProduct = "d2d232",
                                            nameProduct = "1KG Clavo 1/2 pulgada",
                                            imgProduct = "ccdcdomd",
                                            categoryItem = "Ropa",
                                            quantity = 1,
                                            discountPercentage = 0.0,
                                            fastOrder = true,
                                            minimalFastOrder = 2,
                                            price = 46.0
                                        ),
                                        ProductShoppingCart(
                                            skuProduct = "d2d232",
                                            nameProduct = "Martillo",
                                            imgProduct = "ccdcdomd",
                                            categoryItem = "Ropa",
                                            quantity = 1,
                                            discountPercentage = 15.0,
                                            fastOrder = true,
                                            minimalFastOrder = 2,
                                            price = 46.0
                                        )
                                    )
                                ),
                                ItemCartModel(
                                    nameStore = "Nike Store",
                                    idStore = "idmidjikjdokjdo",
                                    imgStore = "didimd",
                                    listItems = listOf(
                                        ProductShoppingCart(
                                            skuProduct = "d2d232",
                                            nameProduct = "Balon Basketball num 6edcwedwedwedcedwcef",
                                            imgProduct = "ccdcdomd",
                                            categoryItem = "Deportes",
                                            quantity = 2,
                                            discountPercentage = 10.0,
                                            fastOrder = true,
                                            minimalFastOrder = 2,
                                            price = 50.0
                                        )
                                    )
                                )
                            )

                            list.forEachIndexed { index, item ->
                                ShoppingCartStoreItem(
                                    modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                                    item = item,
                                    counter = false,
                                    deleteOptions = false,
                                    selector = false
                                )
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
