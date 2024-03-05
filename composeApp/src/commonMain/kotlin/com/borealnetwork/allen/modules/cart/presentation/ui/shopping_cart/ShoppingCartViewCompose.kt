package com.borealnetwork.allen.modules.cart.presentation.ui.shopping_cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.BottomBuyCartItem
import com.borealnetwork.allen.components.MediumText
import com.borealnetwork.allen.components.SemiBoldText
import com.borealnetwork.allen.components.ShadowButton
import com.borealnetwork.allen.components.ShoppingCartStoreItem
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.components.extensions.DottedShape
import com.borealnetwork.allen.components.extensions.drawColoredShadow
import com.borealnetwork.allen.domain.model.ItemCartModel
import com.borealnetwork.allen.domain.model.ProductShoppingCart
import com.borealnetwork.allen.theme.BlueTransparent
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.GrayLetterSeeAll
import com.borealnetwork.allen.theme.GrayLetterShipping
import com.borealnetwork.allen.theme.GreenStrong
import com.borealnetwork.allen.theme.OrangeTransparent

@Composable
fun ShoppingCartViewCompose() {

    Scaffold(topBar = {

        ToolbarTitle(
            titleText = "Mi carrito", startClicked = {
//                navController?.navigateUp()
            },
            endIcon = "ic_coupon.xml"
        )
    },
        bottomBar = {
            BottomBuyCartItem()
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