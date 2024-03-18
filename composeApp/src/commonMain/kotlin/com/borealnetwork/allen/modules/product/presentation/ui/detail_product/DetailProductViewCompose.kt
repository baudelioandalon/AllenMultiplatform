package com.borealnetwork.allen.modules.product.presentation.ui.detail_product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allensharedui.components.SemiBoldText
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allen.modules.cart.domain.navigation.CartClientScreen
import com.borealnetwork.allensharedui.theme.GrayLetterShipping
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun DetailProductViewCompose(navigator: Navigator) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ToolbarTitle(
                titleText = "Detalle del producto", startClicked = {
                    navigator.goBack()
                }, endClicked = {
                    navigator.navigate(CartClientScreen.ShoppingCartClientScreen.route)
                }
            )
        }) {
        SemiBoldText(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(end = 30.dp, top = 38.dp, start = 30.dp),
            text = "Información del articulo",
            fontSize = 13.sp
        )
        SemiBoldText(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(end = 30.dp, start = 30.dp),
            color = GrayLetterShipping,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                    "Integer tempus consectetur augue, ac pretium ipsum faucibus sit amet.",
            fontSize = 13.sp,
            textAlign = TextAlign.Justify
        )
        it.calculateBottomPadding()
    }

}