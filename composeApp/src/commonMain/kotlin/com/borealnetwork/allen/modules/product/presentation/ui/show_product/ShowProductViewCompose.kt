package com.borealnetwork.allen.modules.product.presentation.ui.show_product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.BrandingItem
import com.borealnetwork.allen.components.FavoriteButton
import com.borealnetwork.allen.components.FreeShipping
import com.borealnetwork.allen.components.HorizontalContainerListItem
import com.borealnetwork.allen.components.HorizontalImageViewer
import com.borealnetwork.allen.components.MediumText
import com.borealnetwork.allen.components.ProductItem
import com.borealnetwork.allen.components.RegularText
import com.borealnetwork.allen.components.RightRoundedButton
import com.borealnetwork.allen.components.SelectorDetail
import com.borealnetwork.allen.components.SellerItem
import com.borealnetwork.allen.components.SeparatorGray
import com.borealnetwork.allen.components.ShareButton
import com.borealnetwork.allen.components.StartIcon
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.components.bottom_actions.BottomPriceItem
import com.borealnetwork.allen.components.drawer.StarStatus
import com.borealnetwork.allen.domain.model.MinimalProductModel
import com.borealnetwork.allen.modules.cart.domain.navigation.CartClientScreen
import com.borealnetwork.allen.modules.product.domain.navigation.ProductClientScreen
import com.borealnetwork.allen.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.GrayLetterShipping
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ShowProductViewCompose(navigator: Navigator) {

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
                    navigator.navigate(CartClientScreen.ShoppingCartClientScreen.route)
                }
            )
        },
        bottomBar = {
            BottomPriceItem(
                priceProduct = 490.0,
                discount = 15
            ) {

            }
        }
    ) {
        val imageList = listOf("", "", "", "", "", "", "")
        val firstVariantList = listOf("110V", "220V", "110V - 220V", "12V", "24V", "48V")
        val secondVariantList =
            listOf("Amarillo", "Verde", "Azul", "Morado", "Rojo", "Rosa", "Cafe")
        var firstItemSelected by rememberSaveable { mutableStateOf(firstVariantList.first()) }
        var secondItemSelected by rememberSaveable { mutableStateOf(secondVariantList.first()) }
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
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            backgroundColor = GrayBackgroundDrawerDismiss,
                            elevation = 0.dp,
                            shape = RectangleShape
                        ) {

                        }
                        HorizontalImageViewer(
                            modifier = Modifier.padding(vertical = 15.dp),
                            colorSelected = MaterialTheme.colors.primary,
                            itemList = imageList,
                            zoomWhenSelected = true,
                            itemClicked = { index, item ->

                            }
                        )



                        Row(
                            modifier = Modifier
                                .background(White)
                                .padding(end = 30.dp, start = 30.dp)
                                .fillMaxWidth().wrapContentHeight(unbounded = true)
                        ) {
                            BoldText(
                                modifier = Modifier.weight(1f),
                                text = "Miniesmeriladora Angular",
                                color = Black,
                                lineHeight = 22.sp
                            )
                            StarStatus(
                                modifier = Modifier
                                    .background(White)
                                    .fillMaxWidth(0.2f)
                            )
                        }


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(White)
                                .padding(top = 10.dp, end = 30.dp, start = 30.dp, bottom = 15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            FreeShipping(modifier = Modifier.padding(), unbounded = true)
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
                                .fillMaxWidth()
                                .background(White)
                                .padding(start = 30.dp, bottom = 15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            RegularText(
                                modifier = Modifier.padding(end = 5.dp).wrapContentHeight(),
                                text = "Modelo:",
                                fontSize = 14.sp
                            )
                            BoldText(
                                text = firstItemSelected,
                                fontSize = 14.sp,
                                color = Black
                            )
                        }

                        HorizontalImageViewer(
                            modifier = Modifier.padding(bottom = 15.dp),
                            bottomText = true,
                            itemClicked = { index, item ->
                                firstItemSelected = item
                            }
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(White)
                                .padding(start = 30.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            RegularText(
                                modifier = Modifier.padding(end = 5.dp).wrapContentHeight(),
                                text = "Color:",
                                fontSize = 14.sp
                            )
                            BoldText(
                                text = secondItemSelected,
                                fontSize = 14.sp,
                                color = Black
                            )
                        }

                        HorizontalImageViewer(
                            modifier = Modifier.padding(top = 15.dp, bottom = 20.dp),
                            sizeItem = 43.dp,
                            itemList = secondVariantList,
                            bottomText = true,
                            itemClicked = { index, item ->
                                secondItemSelected = item
                            }
                        )


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
                            navigator.navigate(ProductClientScreen.RatingProductClient.route)
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
                            navigator.navigate(ProductClientScreen.QuestionProductClient.route)
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
                            navigator.navigate(ProductClientScreen.ShowProductClient.route)
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
                            navigator.navigate(ProductClientScreen.ShowProductClient.route)
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