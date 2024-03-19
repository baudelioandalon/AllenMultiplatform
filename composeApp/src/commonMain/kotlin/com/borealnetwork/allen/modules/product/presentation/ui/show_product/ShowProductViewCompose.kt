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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.modules.cart.domain.navigation.CartClientScreen
import com.borealnetwork.allen.modules.product.domain.navigation.ProductClientScreen
import com.borealnetwork.allen.modules.product.domain.view_models.ShowProductViewModel
import com.borealnetwork.allensharedui.components.BoldText
import com.borealnetwork.allensharedui.components.BrandingItem
import com.borealnetwork.allensharedui.components.FavoriteButton
import com.borealnetwork.allensharedui.components.FreeShipping
import com.borealnetwork.allensharedui.components.HorizontalContainerListItem
import com.borealnetwork.allensharedui.components.HorizontalImageViewer
import com.borealnetwork.allensharedui.components.MediumText
import com.borealnetwork.allensharedui.components.ProductItem
import com.borealnetwork.allensharedui.components.RightRoundedButton
import com.borealnetwork.allensharedui.components.SelectorDetail
import com.borealnetwork.allensharedui.components.SellerItem
import com.borealnetwork.allensharedui.components.SeparatorGray
import com.borealnetwork.allensharedui.components.ShareButton
import com.borealnetwork.allensharedui.components.StartIcon
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allensharedui.components.VariantsViewerSelector
import com.borealnetwork.allensharedui.components.bottom_actions.BottomPriceItem
import com.borealnetwork.allensharedui.components.drawer.StarStatus
import com.borealnetwork.allensharedui.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import com.borealnetwork.allensharedui.theme.GrayLetterShipping
import com.borealnetwork.shared.domain.models.cart.MinimalProductModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ShowProductViewCompose(
    navigator: Navigator,
    showProductViewModel: ShowProductViewModel
) {
    val getLastProduct = showProductViewModel.getTopProductModel()

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
        val indexToShow by rememberSaveable {
            mutableStateOf(getLastProduct?.variants?.indexOfFirst { it.images.isNotEmpty() } ?: 0)
        }
        var imageList by rememberSaveable {
            mutableStateOf(
                getLastProduct?.variants?.get(indexToShow)?.images ?: emptyList()
            )
        }
        var itemSelected by rememberSaveable { mutableStateOf(imageList[indexToShow]) }

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
                            KamelImage(
                                modifier = Modifier.fillMaxSize(),
                                resource = asyncPainterResource(itemSelected),
                                contentScale = ContentScale.Crop,
                                contentDescription = "imageExample"
                            )
                        }
                        HorizontalImageViewer(
                            modifier = Modifier.padding(vertical = 15.dp),
                            colorSelected = MaterialTheme.colors.primary,
                            itemList = imageList,
                            zoomWhenSelected = true,
                            itemClicked = { index, item ->
                                itemSelected = item
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
                                text = getLastProduct?.nameProduct.orEmpty(),
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
                                text = "Comprando ${getLastProduct?.minimalFreeShipping?.toInt()} articulos",
                                fontSize = 10.sp,
                                color = GrayLetterShipping
                            )
                            FavoriteButton(
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            ShareButton()
                        }

                        VariantsViewerSelector(
                            modifier = Modifier.padding( bottom = 15.dp),
                            actualPosition = indexToShow,
                            list = getLastProduct?.attributes ?: emptyList()
                        ) { variantSelected ->
                            getLastProduct?.variants?.find { it.skuProduct == variantSelected }?.images?.let {newImages ->
                                itemSelected = newImages[0]
                                imageList = newImages
                            }
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
                                topText = getLastProduct?.nameProduct.orEmpty(),
                                bottomText = "Para ${getLastProduct?.categoryItem}"
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
                                bottomText = getLastProduct?.categoryItem.orEmpty()
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