package com.borealnetwork.allen.modules.product.presentation.ui.detail_product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.BrandingItem
import com.borealnetwork.allen.components.Discount
import com.borealnetwork.allen.components.FavoriteButton
import com.borealnetwork.allen.components.FreeShipping
import com.borealnetwork.allen.components.HorizontalContainerListItem
import com.borealnetwork.allen.components.MediumText
import com.borealnetwork.allen.components.ProductItem
import com.borealnetwork.allen.components.RightRoundedButton
import com.borealnetwork.allen.components.SelectorCounter
import com.borealnetwork.allen.components.SelectorDetail
import com.borealnetwork.allen.components.SellerItem
import com.borealnetwork.allen.components.SemiBoldText
import com.borealnetwork.allen.components.SeparatorGray
import com.borealnetwork.allen.components.ShadowButton
import com.borealnetwork.allen.components.ShareButton
import com.borealnetwork.allen.components.SmallText
import com.borealnetwork.allen.components.StartIcon
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.components.drawer.StarStatus
import com.borealnetwork.allen.components.extensions.drawColoredShadow
import com.borealnetwork.allen.domain.model.MinimalProductModel
import com.borealnetwork.allen.domain.screen.PRODUCT_DETAIL_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.QUESTION_PRODUCT_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.RATING_PRODUCT_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.SHOPPING_CART_CLIENT_GRAPH
import com.borealnetwork.allen.theme.BlueTransparent
import com.borealnetwork.allen.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.GrayLetterShipping
import com.borealnetwork.allen.theme.Purple700
import com.borealnetwork.allen.theme.StarColor
import moe.tlaster.precompose.navigation.Navigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailProductViewCompose(navigator: Navigator) {

    val lastProductsList = listOf(
        MinimalProductModel(
            skuProduct = "dd323234",
            nameProduct = "Sensor Dummy",
            imgProduct = "imagen",
            categoryItem = "Electronica",
            price = 34.0,
            discountPercentage = 0.0
        ),
        MinimalProductModel(
            skuProduct = "dd323234",
            nameProduct = "Sensor Dummy",
            imgProduct = "imagen",
            categoryItem = "Electronica",
            price = 34.0,
            discountPercentage = 0.0
        )
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ToolbarTitle(
                titleText = "Articulo", startClicked = {
                    navigator.goBack()
                }, endClicked = {
                    navigator.navigate(SHOPPING_CART_CLIENT_GRAPH)
                }
            )
        },
        bottomBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth().padding(bottom = 40.dp),
                shape = RectangleShape,
                elevation = 9.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .background(White),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(
                            start = 30.dp,
                            bottom = 18.dp
                        ),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Discount()
                        Row(verticalAlignment = Alignment.Bottom) {
                            BoldText(
                                text = "$435.00",
                                color = Black
                            )
                            SmallText(
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                ), text = "$490.00"
                            )
                        }
                    }

                    ShadowButton(
                        modifier = Modifier
                            .padding(bottom = 18.dp, end = 30.dp)
                            .width(117.dp)
                            .height(52.dp)
                            .drawColoredShadow(
                                color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                                offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
                            ),
                        text = "Agregar al carrito",
                        size = 15.sp
                    )

                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .wrapContentWidth()
                .background(GrayBackgroundMain)
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RectangleShape,
                    elevation = 5.dp
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .background(White)
                                .padding(end = 30.dp, start = 30.dp)
                                .fillMaxSize()
                        ) {
                            Card(
                                modifier = Modifier
                                    .padding(
                                        top = 49.dp,
                                        bottom = 32.dp
                                    )
                                    .fillMaxWidth(0.75f)
                                    .height(240.dp),
                                backgroundColor = GrayBackgroundDrawerDismiss,
                                elevation = 0.dp,
                                shape = RoundedCornerShape(20.dp)
                            ) {

                            }
                            LazyColumn(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(289.dp)
                            ) {
                                items(5) {
                                    Card(
                                        modifier = Modifier
                                            .padding(start = 30.dp, top = 20.dp)
                                            .size(53.dp),
                                        backgroundColor = GrayBackgroundDrawerDismiss,
                                        elevation = 0.dp,
                                        shape = RoundedCornerShape(10.dp)
                                    ) {

                                    }
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(White)
                                .padding(end = 30.dp, start = 30.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            FreeShipping(modifier = Modifier.padding())
                            MediumText(
                                text = "Comprando 4 articulos",
                                fontSize = 10.sp,
                                color = GrayLetterShipping
                            )
                            FavoriteButton(
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            ShareButton()
                        }
                        Row(
                            modifier = Modifier
                                .background(White)
                                .padding(top = 21.dp, end = 30.dp, start = 30.dp)
                                .fillMaxWidth()
                        ) {
                            BoldText(text = "Miniesmeriladora Angular", color = Black)
                        }
                        StarStatus(
                            modifier = Modifier
                                .background(White)
                                .fillMaxWidth()
                                .padding(end = 30.dp, start = 30.dp)
                        )
                        SemiBoldText(
                            modifier = Modifier
                                .background(White)
                                .fillMaxWidth()
                                .padding(end = 30.dp, top = 38.dp, start = 30.dp),
                            text = "Información del articulo",
                            fontSize = 13.sp
                        )
                        SemiBoldText(
                            modifier = Modifier
                                .background(White)
                                .fillMaxWidth()
                                .padding(end = 30.dp, start = 30.dp),
                            color = GrayLetterShipping,
                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                                    "Integer tempus consectetur augue, ac pretium ipsum faucibus sit amet.",
                            fontSize = 13.sp,
                            textAlign = TextAlign.Justify
                        )
                        SemiBoldText(
                            modifier = Modifier
                                .background(White)
                                .fillMaxWidth()
                                .padding(
                                    end = 30.dp, start = 30.dp, top = 23.dp
                                ), text = "Seleccione version"
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(White)
                                .padding(end = 30.dp, bottom = 45.dp),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            LazyRow(
                                modifier = Modifier
                                    .padding(
                                        end = 30.dp,
                                        start = 30.dp,
                                        top = 23.dp
                                    ),
                            ) {
                                itemsIndexed(listOf("", "")) { index, item ->
                                    Column(
                                        modifier = Modifier
                                            .padding(end = 30.dp)
                                            .width(43.dp)
                                            .wrapContentHeight()
                                    ) {
                                        Surface(
                                            modifier = Modifier
                                                .size(43.dp),
                                            color = if (index % 2 != 0) {
                                                Purple700
                                            } else White,
                                            border = if (index % 2 == 0) {
                                                BorderStroke(
                                                    width = 1.dp,
                                                    color = StarColor
                                                )
                                            } else null,
                                            shape = RoundedCornerShape(10.dp),
                                            onClick = {}
                                        ) {
                                        }
                                        BoldText(
                                            modifier = Modifier.padding(top = 5.dp),
                                            fontSize = 10.sp,
                                            text = "115v Amarillo",
                                            color = Black
                                        )
                                    }
                                }
                            }
                            SelectorCounter()
                        }
                        SelectorDetail(
                            text = "Detalles del producto",
                            iconRes = "ic_detail_icon.xml"
                        ) {

                        }
                        SeparatorGray(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(White)
                                .padding(start = 30.dp, end = 30.dp)
                        )
                        SelectorDetail(
                            text = "Calificaciones",
                            iconRes = "ic_rating_icon.xml"
                        ) {
                            navigator.navigate(RATING_PRODUCT_CLIENT_GRAPH)
                        }
                        SeparatorGray(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(White)
                                .padding(start = 30.dp, end = 30.dp)
                        )
                        SelectorDetail(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(White)
                                .padding(bottom = 17.dp),
                            text = "Preguntas",
                            iconRes = "ic_questions_icon.xml"
                        ) {
                            navigator.navigate(QUESTION_PRODUCT_CLIENT_GRAPH)
                        }
                    }
                }

            }
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 45.dp),
                    shape = RectangleShape,
                    elevation = 5.dp
                ) {
                    HorizontalContainerListItem<Unit>(
                        startText = "Vendedor",
                        bottomCompose = {
                            SellerItem(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(start = 30.dp, bottom = 35.dp, top = 22.dp),
                                topText = "Ferreteria La Hormiga",
                                bottomText = "Para Casa y Hogar"
                            ) {

                            }
                        }
                    )
                }
            }
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 45.dp),
                    shape = RectangleShape,
                    elevation = 5.dp
                ) {

                    HorizontalContainerListItem(
                        startText = "Más productos del\nvendedor",
                        endIcon = {
                            RightRoundedButton(
                                modifier = Modifier.padding(top = 20.dp, end = 30.dp),
                                clicked = {

                                }
                            )
                        }, listItem = lastProductsList
                    ) { minimalProductModel, index ->
                        ProductItem(model = minimalProductModel) {
                            navigator.navigate(PRODUCT_DETAIL_CLIENT_GRAPH)
                        }
                    }
                }
            }
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 45.dp),
                    shape = RectangleShape,
                    elevation = 5.dp
                ) {
                    HorizontalContainerListItem(
                        startIcon = {
                            StartIcon(
                                modifier = Modifier.fillMaxWidth(0.7f).padding(
                                    top = 20.dp, start = 30.dp
                                ),
                                topText = "Para",
                                bottomText = "Casa y Hogar"
                            )
                        },
                        endIcon = {
                            RightRoundedButton(
                                modifier = Modifier.padding(top = 20.dp, end = 30.dp),
                                clicked = {

                                }
                            )
                        }, listItem = lastProductsList
                    ) { minimalProductModel, index ->
                        ProductItem(model = minimalProductModel) {
                            navigator.navigate(PRODUCT_DETAIL_CLIENT_GRAPH)
                        }
                    }
                }

            }
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 100.dp),
                    shape = RectangleShape,
                    elevation = 5.dp
                ) {
                    HorizontalContainerListItem(
                        startText = "Más vendedores",
                        endIcon = {
                            RightRoundedButton(
                                modifier = Modifier.padding(top = 20.dp, end = 30.dp),
                                clicked = {

                                }
                            )
                        },
                        listItem = listOf(
                            "tools_icon.png",
                            "tools_icon.png",
                            "tools_icon.png",
                            "tools_icon.png",
                            "tools_icon.png",
                            "tools_icon.png"
                        )
                    ) { model, index ->
                        BrandingItem(image = model) {
//                            navigator.navigate(PRODUCT_DETAIL_CLIENT_GRAPH)
                        }
                    }
                }
            }
        }
        it.calculateBottomPadding()
    }


}