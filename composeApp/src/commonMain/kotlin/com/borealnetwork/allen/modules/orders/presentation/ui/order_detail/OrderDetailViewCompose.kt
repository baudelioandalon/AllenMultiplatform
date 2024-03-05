package com.borealnetwork.allen.modules.orders.presentation.ui.order_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.MediumText
import com.borealnetwork.allen.components.PriceBeforeDiscount
import com.borealnetwork.allen.components.RegularText
import com.borealnetwork.allen.components.ResumeSelector
import com.borealnetwork.allen.components.SemiBoldText
import com.borealnetwork.allen.components.ShoppingCartStoreItem
import com.borealnetwork.allen.components.StatusPackageItem
import com.borealnetwork.allen.components.StatusPreviouPackageItem
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.components.extensions.DottedShape
import com.borealnetwork.allen.domain.model.ItemCartModel
import com.borealnetwork.allen.domain.model.ProductShoppingCart
import com.borealnetwork.allen.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.GrayLetterSeeAll
import com.borealnetwork.allen.theme.GrayLetterShipping
import com.borealnetwork.allen.theme.GreenStrong

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OrderDetailViewCompose() {

    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Detalles del pedido",
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
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(200.dp),
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
                        Column(
                            modifier = Modifier
                                .background(White)
                                .padding(
                                    start = 30.dp, end = 30.dp
                                ),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 15.dp, bottom = 15.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                MediumText(
                                    text = "Descuento de tienda",
                                    color = GrayLetterSeeAll,
                                    fontSize = 13.sp
                                )
                                SemiBoldText(
                                    text = "8%",
                                    color = GrayLetterShipping,
                                    fontSize = 15.sp
                                )
                            }

                            Box(
                                Modifier
                                    .height(1.dp)
                                    .fillMaxWidth()
                                    .background(Color.Gray, shape = DottedShape(step = 20.dp))
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 20.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                RegularText(
                                    modifier = Modifier.weight(1f),
                                    text = "No pagado",
                                    color = GrayLetterShipping,
                                    fontSize = 18.sp
                                )
                                PriceBeforeDiscount(
                                    modifier = Modifier.width(50.dp),
                                    firstModifier = Modifier.weight(0.5f),
                                    price = 100.0
                                )
                                BoldText(
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .padding(start = 21.dp),
                                    text = "$92",
                                    color = GreenStrong,
                                    fontSize = 30.sp,
                                    textAlign = TextAlign.End
                                )
                            }

                        }
                    }
                }
            }

        }

        it.calculateBottomPadding()
    }
}
