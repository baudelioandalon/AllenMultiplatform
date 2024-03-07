package com.borealnetwork.allen.modules.cart.presentation.ui.shopping_cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.components.BottomBuyCartItem
import com.borealnetwork.allen.components.ShoppingCartStoreItem
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.domain.model.ItemCartModel
import com.borealnetwork.allen.domain.model.ProductShoppingCart
import com.borealnetwork.allen.domain.screen.RESUME_BUY_CART_CLIENT_GRAPH
import com.borealnetwork.allen.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ShoppingCartViewCompose(navigator: Navigator) {

    Scaffold(topBar = {

        ToolbarTitle(
            titleText = "Mi carrito",
            startClicked = {
                navigator.goBack()
            },
            endIcon = "ic_coupon.xml"
        )
    },
        bottomBar = {
            BottomBuyCartItem{
                navigator.navigate(RESUME_BUY_CART_CLIENT_GRAPH)
            }
        }) {
        val sellersList = listOf(
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {

            itemsIndexed(
                sellersList
            ) { index, item ->
                ShoppingCartStoreItem(
                    modifier = Modifier.padding(bottom = 30.dp),
                    item = item,
                    elevation = 5.dp
                )
            }

            item {
                Spacer(modifier = Modifier.height(300.dp))
            }
        }
        it.calculateBottomPadding()
    }

}