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
import com.borealnetwork.allensharedui.components.ShoppingCartStoreItem
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allensharedui.components.bottom_actions.BottomBuyCartItem
import com.borealnetwork.shared.domain.models.cart.ItemCartModel
import com.borealnetwork.shared.domain.models.cart.ProductShoppingCart
import com.borealnetwork.allen.modules.cart.domain.navigation.CartClientScreen
import com.borealnetwork.allen.platform
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ShoppingCartViewCompose(navigator: Navigator) {

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

    Scaffold(topBar = {

        ToolbarTitle(
            titleText = "Mi carrito",
            startClicked = {
                navigator.goBack()
            },
            endIcon = "ic_coupon.xml",
            endIconTint = null
        )
    },
        bottomBar = {
            BottomBuyCartItem(
                price = 100.0,
                discount = 8,
                currency = platform().currency
            ) {
                navigator.navigate(CartClientScreen.ResumeBuyCartClientScreen.route)
            }
        }) {

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
                    elevation = 5.dp,
                    check = true,
                    currency = platform().currency,
                    startTextButton = "Remover",
                    endTextButton = "Guardar para despues"
                )
            }

            item {
                Spacer(modifier = Modifier.height(300.dp))
            }
        }
        it.calculateBottomPadding()
    }

}