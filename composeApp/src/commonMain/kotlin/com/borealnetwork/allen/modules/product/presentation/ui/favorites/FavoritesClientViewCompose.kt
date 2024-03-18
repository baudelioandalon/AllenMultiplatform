package com.borealnetwork.allen.modules.product.presentation.ui.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.platform
import com.borealnetwork.allensharedui.components.ShoppingCartItem
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.shared.domain.models.cart.ProductShoppingCart
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import com.borealnetwork.shared.tools.firstItem
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun FavoritesClientViewCompose(navigator: Navigator) {

    val list = listOf(
        ProductShoppingCart(
            skuProduct = "d2d232",
            nameProduct = "1KG Clavo 1/2 pulgada Mas descripcion para dos lineas",
            imgProduct = "ccdcdomd",
            categoryItem = "Ropa",
            quantity = 1,
            discountPercentage = 5,
            fastOrder = true,
            minimalFastOrder = 2,
            price = 46.0
        ), ProductShoppingCart(
            skuProduct = "d2d232",
            nameProduct = "1KG Clavo 1/2 pulgada Mas descripcion para dos lineas",
            imgProduct = "ccdcdomd",
            categoryItem = "Ropa",
            quantity = 1,
            discountPercentage = 5,
            fastOrder = true,
            minimalFastOrder = 2,
            price = 46.0
        ), ProductShoppingCart(
            skuProduct = "d2d232",
            nameProduct = "1KG Clavo 1/2 pulgada Mas descripcion para dos lineas",
            imgProduct = "ccdcdomd",
            categoryItem = "Ropa",
            quantity = 1,
            discountPercentage = 5,
            fastOrder = true,
            minimalFastOrder = 2,
            price = 46.0
        ), ProductShoppingCart(
            skuProduct = "d2d232",
            nameProduct = "Martillo Mas descripcion para dos lineas Mas descripcion para dos lineas",
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
            }, endIcon = "ic_white_heart.xml"
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
                    showChecked = false,
                    currency = platform().currency,
                    topPadding = if (index == list.firstItem()) 20.dp else 0.dp,
                    imgClicked = {item ->

                    },
                    startClicked = { item ->

                    }, endClicked = { item ->

                    })
            }
        }
        it.calculateBottomPadding()
    }
}
