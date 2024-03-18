package com.borealnetwork.allen.modules.cart.presentation.ui.resume_cart

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allensharedui.components.GoalIcon
import com.borealnetwork.allensharedui.components.LocationIcon
import com.borealnetwork.allensharedui.components.MediumText
import com.borealnetwork.allensharedui.components.ResumeSelector
import com.borealnetwork.allensharedui.components.ShoppingCartStoreItem
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allensharedui.components.bottom_actions.BottomBuyCartItem
import com.borealnetwork.shared.tools.DottedShape
import com.borealnetwork.shared.domain.models.cart.ItemCartModel
import com.borealnetwork.shared.domain.models.cart.ProductShoppingCart
import com.borealnetwork.allen.modules.cart.domain.navigation.CartClientScreen
import com.borealnetwork.allen.platform
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import com.borealnetwork.allensharedui.theme.GrayBorderLight
import com.borealnetwork.allensharedui.theme.GrayMedium
import com.borealnetwork.allensharedui.theme.GraySinceTo
import com.borealnetwork.allensharedui.theme.GrayStrong
import moe.tlaster.precompose.navigation.Navigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ResumeCartStepTwoViewCompose(navigator: Navigator) {

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
                titleText = "Resumen de compra",
                startClicked = {
                    navigator.goBack()
                },
                showEndImage = false,
                endIcon = "ic_coupon.xml",
            )
        },
        bottomBar = {
            BottomBuyCartItem(
                price = 100.0,
                discount = 8,
                currency = platform().currency
            ) {
                navigator.navigate(CartClientScreen.DetailBuyCartClientScreen.route)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        ) {

            item {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(start = 30.dp, top = 20.dp, bottom = 30.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(horizontalArrangement = Arrangement.Start) {
                        LocationIcon()
                        Column(modifier = Modifier.padding(start = 13.dp)) {
                            MediumText(
                                text = "Desde",
                                color = GraySinceTo,
                                fontSize = 15.sp
                            )
                            MediumText(
                                modifier = Modifier
                                    .width(180.dp)
                                    .wrapContentHeight(),
                                text = "Ferreteria La hormiga",
                                textAlign = TextAlign.Start,
                                color = GrayMedium,
                                fontSize = 15.sp,
                                textOverflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    }
                    Box(
                        Modifier
                            .padding(top = 20.dp)
                            .rotate(90f)
                            .width(50.dp)
                            .height(1.dp)
                            .background(GrayStrong, shape = DottedShape(step = 10.dp))
                    )
                    Row(horizontalArrangement = Arrangement.Start) {
                        GoalIcon()
                        Column(modifier = Modifier.padding(start = 18.dp)) {
                            MediumText(
                                text = "Para",
                                color = GraySinceTo,
                                fontSize = 15.sp
                            )
                            MediumText(
                                modifier = Modifier
                                    .width(180.dp)
                                    .wrapContentHeight(),
                                text = "Calle Miramar #1195, San esteban, Puerto Vallarta, Jalisco",
                                textAlign = TextAlign.Start,
                                color = GrayMedium,
                                fontSize = 15.sp,
                                textOverflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    }
                }
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
                Divider(
                    color = GrayBorderLight,
                    thickness = 1.dp
                )
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
                    topModifier = Modifier.padding(horizontal = 20.dp),
                    item = item,
                    counter = false,
                    currency = platform().currency,
                    deleteOptions = false,
                    selector = false
                )
            }
            item {
                Spacer(modifier = Modifier.height(250.dp))
            }
        }
        it.calculateBottomPadding()
    }


}