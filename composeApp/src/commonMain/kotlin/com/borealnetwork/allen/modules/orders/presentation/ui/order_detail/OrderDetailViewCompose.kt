package com.borealnetwork.allen.modules.orders.presentation.ui.order_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.platform
import com.borealnetwork.allensharedui.components.GoalIcon
import com.borealnetwork.allensharedui.components.LocationIcon
import com.borealnetwork.allensharedui.components.ResumeSelector
import com.borealnetwork.allensharedui.components.ResumeStatusTravelItem
import com.borealnetwork.allensharedui.components.ShoppingCartStoreItem
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allensharedui.components.bottom_actions.BottomBuyCartItem
import com.borealnetwork.shared.domain.models.cart.ItemCartModel
import com.borealnetwork.shared.domain.models.cart.ProductShoppingCart
import com.borealnetwork.shared.domain.components.PinStatusHistoryModel
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderClientFinishDetailViewCompose(navigator: Navigator) {

    val listItems = listOf(
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
                    discountPercentage = 0,
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
                    discountPercentage = 15,
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
                    discountPercentage = 10,
                    fastOrder = true,
                    minimalFastOrder = 2,
                    price = 50.0
                )
            )
        )
    )

    Scaffold(
        topBar = {
            ToolbarTitle(
                titleText = "Detalles del pedido",
                startClicked = {
                    navigator.goBack()
                },
                showEndImage = false,
                endIcon = "ic_coupon.xml",
            )
        },
        bottomBar = {
            BottomBuyCartItem(
                payed = true,
                price = 100.0,
                discount = 8,
                currency = platform().currency
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        ) {

            item {
                ResumeStatusTravelItem(
                    modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 30.dp),
                    pinStatusList = listOf(
                        PinStatusHistoryModel(
                            origin = "Desde",
                            destiny = "Ferreteria La hormiga",
                            icon = { LocationIcon() }
                        ),
                        PinStatusHistoryModel(
                            origin = "Para",
                            destiny = "Calle Miramar #1195, San esteban, Puerto Vallarta, Jalisco",
                            icon = { GoalIcon() }
                        ),
                        PinStatusHistoryModel(
                            origin = "Recibido por",
                            destiny = "Luna Lovegood",
                            icon = { GoalIcon() }
                        )

                    )
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
                        .height(220.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = 0.dp,
                    backgroundColor = GrayBackgroundMain,
                    onClick = {}
                ) {

                }
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
                    textBottom = "${listItems.sumOf { it.listItems.size }} articulos",
                    lineBottom = false
                )
            }
            itemsIndexed(
                listItems
            ) { index, item ->
                ShoppingCartStoreItem(
                    modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                    item = item,
                    counter = false,
                    currency = platform().currency,
                    deleteOptions = false,
                    selector = false
                )
            }
            item {
                Spacer(modifier = Modifier.height(150.dp))
            }
        }
        it.calculateBottomPadding()
    }


}