package com.borealnetwork.allen.modules.product.presentation.ui.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.borealnetwork.allen.components.ShoppingCartItem
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.domain.model.ProductShoppingCart
import com.borealnetwork.allen.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun FavoritesClientViewCompose(navigator: Navigator) {

    val list = listOf(
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
        ), ProductShoppingCart(
            skuProduct = "d2d232",
            nameProduct = "Martillo",
            imgProduct = "ccdcdomd",
            categoryItem = "Ropa",
            quantity = 1,
            discountPercentage = 15,
            fastOrder = true,
            minimalFastOrder = 2,
            price = 46.0
        ), ProductShoppingCart(
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
    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Favoritos", startClicked = {
                navigator.goBack()
            }, endIcon = "ic_favorite_unselected.xml"
        )
    }) {

        LazyColumn(
            modifier = Modifier.wrapContentHeight().background(GrayBackgroundMain)
        ) {

            itemsIndexed(
                list
            ) { index, item ->
                ShoppingCartItem(productShoppingCart = item,
                    endTextButton = "Mover al carrito",
                    counter = false,
                    showBottomDivider = true,
                    startClicked = { item ->

                    }, endClicked = { item ->

                    })
            }
        }
        it.calculateBottomPadding()
    }
}
