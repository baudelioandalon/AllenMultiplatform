package com.borealnetwork.allen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.extensions.DottedShape
import com.borealnetwork.allen.components.extensions.drawColoredShadow
import com.borealnetwork.allen.components.extensions.mirror
import com.borealnetwork.allen.domain.model.ItemCartModel
import com.borealnetwork.allen.domain.model.ItemShoppingModel
import com.borealnetwork.allen.domain.model.ProductShoppingCart
import com.borealnetwork.allen.theme.BlueStatusLineColor
import com.borealnetwork.allen.theme.BlueTransparent
import com.borealnetwork.allen.theme.CategoryBackgroundSelectorOne
import com.borealnetwork.allen.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allen.theme.GrayBorderLight
import com.borealnetwork.allen.theme.GrayBrandingBackground
import com.borealnetwork.allen.theme.GrayCategoryBackground
import com.borealnetwork.allen.theme.GrayLetterCategoryProduct
import com.borealnetwork.allen.theme.GrayLetterHint
import com.borealnetwork.allen.theme.GrayLetterSeeAll
import com.borealnetwork.allen.theme.GrayLetterShipping
import com.borealnetwork.allen.theme.GrayMedium
import com.borealnetwork.allen.theme.GraySinceTo
import com.borealnetwork.allen.theme.GreenStrong
import com.borealnetwork.allen.theme.OrangeStrong
import com.borealnetwork.allen.theme.OrangeTransparent
import com.borealnetwork.allen.theme.RedEndColor
import com.borealnetwork.allen.theme.RedStartColor
import com.borealnetwork.allen.theme.StarColor
import org.jetbrains.compose.resources.painterResource

//@Composable
//fun TestItems() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(White)
//    ) {
//        CategorySeller()
//        SellerItemsItem()
//        SellerItem()
//        CategoryItem()
//        CategorySelectorItem()
//        BrandingItem()
////        QuestionItem()
//        ProductResultItem()
//        BrandingHorizontal()
//        AnswerItem()
//        ShoppingCategoryHistoryItem()
//    }
//}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryItem() {
    Column(
        modifier = Modifier
            .padding(start = 30.dp, end = 4.dp, bottom = 35.dp)
            .wrapContentSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(top = 23.dp, bottom = 9.dp)
                .size(74.dp), onClick = {},
            elevation = 0.dp,
            shape = CircleShape,
            backgroundColor = GrayCategoryBackground
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.width(32.dp),
                    painter = painterResource(res = "tools_icon.png"),
                    contentDescription = "item"
                )
            }
        }

        SemiBoldText(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Ferreteria",
            fontSize = 13.sp,
            letterSpacing = 0.sp,
            color = Black
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BrandingItem(itemSize: Dp = 60.dp) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 30.dp, end = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .size(itemSize), onClick = {},
            elevation = 0.dp,
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            backgroundColor = GrayBrandingBackground
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxSize(),
                    painter = painterResource(res = "tools_icon.png"),
                    contentDescription = "item"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategorySelectorItem(
    maxBackground: Boolean = false,
    color: Color = CategoryBackgroundSelectorOne
) {
    Box(
        modifier = Modifier
            .padding(start = 30.dp, end = 4.dp)
            .height(144.dp)
            .width(134.dp).graphicsLayer {
                shape = RoundedCornerShape(corner = CornerSize(15.dp))
            }
    ) {

        Column {
            AnimatedVisibility(!maxBackground) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(if (maxBackground) 1F else 0.5F),
                    elevation = 0.dp,
                    backgroundColor = Transparent
                ) {

                }
            }
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                elevation = 0.dp,
                backgroundColor = color
            ) {

            }
        }

        Card(
            modifier = Modifier, onClick = {},
            elevation = 0.dp,
            backgroundColor = Transparent
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(80.dp),
                    painter = painterResource(res = "laptop_test.png"),
                    contentDescription = "item"
                )
                BoldText(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Laptops", textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    color = Black
                )
            }

        }

    }

}

@Composable
fun SellerItem(
    onClicked: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 30.dp, end = 30.dp)
        ) {
            BoldText(text = "Vendedor", fontSize = 18.sp, color = Black)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp, top = 22.dp)
                    .wrapContentHeight()
                    .clickable { onClicked?.invoke() },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    modifier = Modifier
                        .size(53.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
                Column(
                    modifier = Modifier
                        .padding(start = 19.dp)
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    BoldText(text = "Ferreteria La Hormiga", fontSize = 15.sp)
                    MediumText(
                        text = "Para Casa y Hogar",
                        color = GrayLetterSeeAll,
                        fontSize = 15.sp
                    )
                }
                RightRoundedButton()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductItem(productClicked: (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .padding(start = 30.dp, end = 4.dp)
            .height(240.dp)
            .width(178.dp), onClick = { productClicked?.invoke() },
        elevation = 6.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        backgroundColor = White
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box {
                FavoriteButton()
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(130.dp),
                    painter = painterResource("tools_icon.png"),
                    contentDescription = "item"
                )
            }

            NameProductText(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .fillMaxWidth(), text = "Sensor Hc-sr04", textAlign = TextAlign.Start
            )
            CategoryProductText(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .fillMaxWidth(),
                text = "Electronica",
                color = GrayLetterCategoryProduct,
                textAlign = TextAlign.Start
            )

            Row(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                BoldText(
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .wrapContentSize(),
                    text = "$54"
                )
                LittleAddButton()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductResultItem(
    modifier: Modifier = Modifier,
    productClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        onClick = { productClicked?.invoke() },
        elevation = 0.dp,
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        backgroundColor = White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = GrayBackgroundDrawerDismiss,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .height(200.dp)
            ) {
                FavoriteButton(modifier = Modifier.padding(start = 7.dp, top = 7.dp))
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource("tools_icon.png"),
                    contentDescription = "item"
                )
            }

            Row {
                SemiBoldText(
                    modifier = Modifier
                        .weight(1f),
                    text = "Sensor Hc-sr04", textAlign = TextAlign.Start,
                    fontSize = 13.sp
                )
                BoldText(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = "$54",
                    fontSize = 14.sp
                )
            }

            CategoryProductText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Electronica",
                color = GrayLetterCategoryProduct,
                textAlign = TextAlign.Start
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(20.dp),
                    painter = painterResource("ic_thunder_icon.xml"),
                    contentDescription = "free shipping",
                    tint = StarColor
                )
                MinimumAddButton(modifier = Modifier.padding(bottom = 10.dp))
            }
        }
    }
}

@Composable
fun BrandingHorizontal(
    modifier: Modifier = Modifier,
    itemSize: Dp = 60.dp
) {
    LazyRow(
        modifier = modifier
    ) {
        items(10) {
            BrandingItem(itemSize)
        }
    }
}

@Composable
fun SellerItemsItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .clickable { },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BoldText(
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Start, text = "Más productos del\nvendedor",
                color = Black
            )
            RightRoundedButton()
        }
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 35.dp
                )
        ) {
            items(10) {
                ProductItem()
            }
        }
    }

}

@Composable
fun ShowSellerItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier
                .size(53.dp),
            backgroundColor = GrayBackgroundDrawerDismiss,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {

        }
        Column(
            modifier = Modifier
                .padding(start = 19.dp)
                .fillMaxWidth()
        ) {
            MediumText(
                text = "Para",
                color = GrayLetterSeeAll,
                fontSize = 15.sp
            )
            BoldText(text = "Casa y Hogar", fontSize = 15.sp, color = Black)
        }
    }
}

@Composable
fun CategorySeller(
    modifier: Modifier = Modifier,
    innerModifier: Modifier = Modifier,
    onClicked: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(White)
            .clickable {
                onClicked?.invoke()
            },
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = innerModifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 30.dp
                    )
                    .wrapContentHeight()
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    modifier = Modifier
                        .size(53.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
                Column(
                    modifier = Modifier
                        .padding(start = 19.dp)
                        .weight(1f)
                ) {
                    MediumText(
                        text = "Para",
                        color = GrayLetterSeeAll,
                        fontSize = 15.sp
                    )
                    BoldText(text = "Casa y Hogar", fontSize = 15.sp, color = Black)
                }
                RightRoundedButton()
            }
            LazyRow(
                modifier = Modifier
                    .background(White)
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            ) {
                items(10) {
                    ProductItem()
                }
            }
        }
    }

}

@Composable
fun SellersItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
    ) {
        Row(
            modifier = Modifier
                .padding(end = 30.dp, start = 30.dp, top = 20.dp)
                .fillMaxWidth()
                .clickable { },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MediumTextBold(
                text = "Más vendedores"
            )
            RightRoundedButton()
        }
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 35.dp
                )
        ) {
            items(10) {
                BrandingItem()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun QuestionItem(
    text: String = "", answerList: List<String> = emptyList(),
    likesList: List<String> = emptyList()
) {
    Card(
        elevation = 5.dp,
        shape = RectangleShape
    ) {
        Row(
            modifier = Modifier
                .background(White)
                .padding(start = 30.dp, top = 25.dp, end = 30.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = Modifier
                    .padding(bottom = 9.dp)
                    .size(41.dp), onClick = {},
                elevation = 0.dp,
                shape = CircleShape,
                backgroundColor = GrayCategoryBackground
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource("tools_icon.png"),
                        contentDescription = "item"
                    )
                }
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SemiBoldText(
                        modifier = Modifier.padding(start = 28.dp, bottom = 30.dp),
                        text = text,
                        fontSize = 17.sp
                    )
                    FavoriteCounterButton(amount = likesList.size)
                }
                FlowColumn {
                    answerList.forEachIndexed { index, item ->
                        AnswerItem(
                            modifier = if (index == answerList.size - 1) Modifier.padding(bottom = 15.dp) else Modifier,
                            text = item
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RatingByUserItem(
    text: String = "",
    likesList: List<String> = emptyList()
) {
    Card(
        shape = RectangleShape,
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .background(White)
                .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 25.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = Modifier
                    .padding(bottom = 9.dp)
                    .size(41.dp), onClick = {},
                elevation = 0.dp,
                shape = CircleShape,
                backgroundColor = GrayCategoryBackground
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource("tools_icon.png"),
                        contentDescription = "item"
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    SemiBoldText(
                        modifier = Modifier.padding(start = 28.dp, bottom = 20.dp),
                        text = text,
                        fontSize = 17.sp
                    )
                    StarRatingSelector(
                        modifier = Modifier.padding(start = 28.dp)
                    )
                }
                FavoriteCounterButton(amount = likesList.size)
            }
        }
    }

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnswerItem(modifier: Modifier = Modifier, text: String = "") {
    Row(
        modifier = modifier
            .padding(start = 30.dp, end = 4.dp)
            .sizeIn(maxWidth = 200.dp)
            .background(White),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 9.dp)
                .size(30.dp), onClick = {},
            elevation = 0.dp,
            shape = CircleShape,
            backgroundColor = GrayCategoryBackground
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(res = "tools_icon.png"),
                    contentDescription = "item"
                )
            }
        }

        SemiBoldText(
            modifier = Modifier
                .padding(start = 28.dp),
            text = text,
            textAlign = TextAlign.Justify,
            fontSize = 17.sp, color = MaterialTheme.colors.primary
        )
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun ShoppingCartStoreItem(
    modifier: Modifier = Modifier,
    item: ItemCartModel = ItemCartModel(
        "Test",
        "3e23dc2",
        "dd", listOf()
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true,
    selector: Boolean = true,
    elevation: Dp = 0.dp,
    hideTopLine: Boolean = false,
    check: Boolean = false
) {

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        elevation = elevation
    ) {

        val showItems = rememberSaveable { mutableStateOf(true) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
        ) {
            if (!hideTopLine) {
                Divider(
                    thickness = 1.5.dp,
                    color = GrayBorderLight
                )
            }
            //TopStoreInformation
            StoreInformationItem(
                deleteOptions, selector, item, showItems
            )
            AnimatedVisibility(visible = showItems.value) {
                Divider(
                    thickness = 1.5.dp,
                    color = GrayBorderLight
                )
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    //Items
                    item.listItems.forEach {
                        ShoppingCartItem(
                            productShoppingCart = it,
                            counter = counter,
                            deleteOptions = deleteOptions,
                            check = check,
                            removeClicked = { item ->

                            },
                            saveAfterClicked = { item ->

                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StoreInformationItem(
    deleteOptions: Boolean,
    selector: Boolean, item: ItemCartModel,
    showItems: MutableState<Boolean>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 14.dp, end = if (deleteOptions) 20.dp else 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        if (selector) {
            RadioButton(
                modifier = Modifier.padding(start = 15.dp),
                selected = false,
                onClick = { },
                colors = RadioButtonDefaults.colors(
                    unselectedColor = GrayLetterHint,
                    selectedColor = MaterialTheme.colors.primary
                )
            )
        }

        Card(
            modifier = Modifier
                .size(30.dp),
            backgroundColor = GrayBackgroundDrawerDismiss,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {

        }
        BoldText(
            modifier = Modifier
                .weight(0.5f)
                .padding(start = 6.dp, end = 10.dp),
            text = item.nameStore,
            fontSize = 15.sp,
            textOverflow = TextOverflow.Ellipsis,
            maxLines = 2,
            color = Black
        )
        SemiBoldText(
            modifier = Modifier.padding(end = 23.dp),
            text = "${item.listItems.size} articulos",
            color = GrayMedium,
            fontSize = 13.sp
        )
        CircularIcon(
            modifier = Modifier
                .size(35.dp).wrapContentSize()
                .rotate(if (showItems.value) 0f else 180f), icon = "ic_arrow_down.xml",
            contentDescription = "arrow", onClick = {
                showItems.value = (!showItems.value)
            })
    }
}

@Composable
fun ShoppingCartItem(
    productShoppingCart: ProductShoppingCart = ProductShoppingCart(
        skuProduct = "d2d232",
        nameProduct = "Balon Basketball num 6edcwedwedwedcedwcef",
        imgProduct = "ccdcdomd",
        categoryItem = "Deportes",
        quantity = 2,
        discountPercentage = 10.0,
        fastOrder = true,
        minimalFastOrder = 2,
        price = 588880.0
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true,
    check: Boolean = false,
    removeClicked: ((ProductShoppingCart) -> Unit)? = null,
    saveAfterClicked: ((ProductShoppingCart) -> Unit)? = null,
) {
    Column(
        modifier = if (deleteOptions)
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 20.dp)
        else Modifier
            .fillMaxWidth()
            .padding(top = 14.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Card(
                    modifier = Modifier
                        .size(81.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }
            Column(
                modifier = Modifier
                    .height(81.dp)
                    .padding(start = 27.dp)
                    .weight(0.3f),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                SemiBoldText(
                    text = productShoppingCart.nameProduct,
                    fontSize = 13.sp,
                    maxLines = 3,
                    textOverflow = TextOverflow.Ellipsis
                )
                SemiBoldText(
                    modifier = Modifier.wrapContentHeight(),
                    text = productShoppingCart.categoryItem,
                    color = GrayLetterCategoryProduct,
                    fontSize = 10.sp
                )
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.End
                ) {
                    if (productShoppingCart.discountPercentage > 0) {
                        PriceBeforeDiscount(
                            modifier = Modifier.weight(0.3f),
                            price = productShoppingCart.price
                        )
                    }
                    BoldText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        text = "$${productShoppingCart.getProductWithDiscount().toInt()}",
                        fontSize = 15.sp, textAlign = TextAlign.End
                    )
                }
            }
            Column(
                modifier = Modifier
                    .height(81.dp)
                    .weight(0.3f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (productShoppingCart.discountPercentage > 0) {
                        Discount(
                            modifier = Modifier.padding(start = 10.dp),
                            discount = productShoppingCart.discountPercentage.toInt()
                        )
                    } else {
                        Spacer(modifier = Modifier.padding(start = 10.dp))
                    }
                    if (productShoppingCart.fastOrder) {
                        FreeShipping(
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }
                if (counter) {
                    SelectorCounter(
                        quantity = productShoppingCart.quantity
                    )
                } else {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        SemiBoldText(
                            modifier = Modifier.padding(
                                end = 14.dp,
                                bottom = 5.dp,
                                start = 10.dp
                            ),
                            text = "Cantidad", fontSize = 15.sp
                        )
                        SemiBoldText(
                            text = "${productShoppingCart.quantity}",
                            fontSize = 25.sp
                        )
                    }
                }
            }
            if (check) {
                Image(
                    modifier = Modifier.padding(start = 30.dp),
                    painter = painterResource(res = "ic_checked.xml"),
                    contentDescription = "check"
                )
            }
        }
        if (deleteOptions) {
            Row(modifier = Modifier.padding(top = 12.dp)) {
                BoldText(
                    text = "Remover",
                    fontSize = 12.sp,
                    color = OrangeStrong
                ) {
                    removeClicked?.invoke(productShoppingCart)
                }
                BoldText(
                    modifier = Modifier.padding(start = 38.dp),
                    text = "Guardar para después",
                    fontSize = 12.sp,
                    color = OrangeStrong
                ) {
                    saveAfterClicked?.invoke(productShoppingCart)
                }
            }
        }
    }
}

@Composable
fun FavoriteItem(
    productShoppingCart: ProductShoppingCart = ProductShoppingCart(
        skuProduct = "d2d232",
        nameProduct = "Balon Basketball num 6edcwedwedwedcedwcef",
        imgProduct = "ccdcdomd",
        categoryItem = "Deportes",
        quantity = 1,
        discountPercentage = 10.0,
        fastOrder = true,
        minimalFastOrder = 2,
        price = 588880.0
    )
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .background(White)
                .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    modifier = Modifier.wrapContentWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .size(81.dp),
                        backgroundColor = GrayBackgroundDrawerDismiss,
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {

                    }

                }
                Column(
                    modifier = Modifier
                        .height(81.dp)
                        .padding(start = 27.dp)
                        .weight(0.3f),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    SemiBoldText(
                        text = productShoppingCart.nameProduct,
                        fontSize = 13.sp,
                        maxLines = 3,
                        textOverflow = TextOverflow.Ellipsis
                    )
                    SemiBoldText(
                        modifier = Modifier.wrapContentHeight(),
                        text = productShoppingCart.categoryItem,
                        color = GrayLetterCategoryProduct,
                        fontSize = 10.sp
                    )
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (productShoppingCart.discountPercentage > 0) {
                            PriceBeforeDiscount(
                                modifier = Modifier.weight(0.3f),
                                price = productShoppingCart.price
                            )
                        }
                        BoldText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            text = "$${productShoppingCart.getProductWithDiscount().toInt()}",
                            fontSize = 15.sp, textAlign = TextAlign.End
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .height(81.dp)
                        .weight(0.3f),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (productShoppingCart.discountPercentage > 0) {
                            Discount(
                                modifier = Modifier.padding(start = 10.dp),
                                discount = productShoppingCart.discountPercentage.toInt()
                            )
                        } else {
                            Spacer(modifier = Modifier.padding(start = 10.dp))
                        }
                        if (productShoppingCart.fastOrder) {
                            Icon(
                                painter = painterResource(res = "ic_thunder_icon.xml"),
                                contentDescription = "free shipping",
                                tint = StarColor
                            )
                        }
                    }
                }
            }
            Row(modifier = Modifier.padding(top = 12.dp)) {
                BoldText(
                    text = "Remover",
                    fontSize = 12.sp,
                    color = OrangeStrong
                ) {

                }
                BoldText(
                    modifier = Modifier.padding(start = 38.dp),
                    text = "Guardar para después",
                    fontSize = 12.sp,
                    color = OrangeStrong
                )
            }
        }
    }
}

@Composable
fun NotificationItem(
    step: Int = 0,
    default: Boolean = true,
    shippingType: String = "SHIPPING",
    shippingStatus: String = "OK"
) {
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .background(White)
            .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Card(
                    modifier = Modifier
                        .size(81.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }
            if (default) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = 22.dp)
                        .fillMaxWidth()
                        .background(White),
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SemiBoldText(
                            text = "Recibido el 1 de septiembre",
                            fontSize = 15.sp,
                            maxLines = 3,
                            textOverflow = TextOverflow.Ellipsis
                        )
                        Image(
                            modifier = Modifier.mirror(),
                            painter = painterResource(res = "ic_on_way_traffic_circle.xml"),
                            contentDescription = "on way"
                        )
                    }
                    SemiBoldText(
                        modifier = Modifier.wrapContentHeight(),
                        text = "Camiseta",
                        color = GrayLetterCategoryProduct,
                        fontSize = 10.sp
                    )

                    StepIndicatorNotification(
                        modifier = Modifier.padding(top = 20.dp),
                        step = step
                    )
                    BoldText(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Calificar",
                        fontSize = 12.sp,
                        color = OrangeStrong
                    ) {

                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = 22.dp)
                        .fillMaxWidth()
                        .background(White),
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SemiBoldText(
                            text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (
                                shippingType == "PICKUP" && shippingStatus == "OK"
                            ) "Pedido listo" else if (shippingStatus == "CANCELLED_BY_SELLER") "Cancelado por el vendedor" else "Cancelado por el cliente",
                            fontSize = 15.sp,
                            maxLines = 3,
                            textOverflow = TextOverflow.Ellipsis
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 7.dp)
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = if (shippingStatus == "OK") listOf(
                                        MaterialTheme.colors.primary,
                                        MaterialTheme.colors.onPrimary
                                    ) else listOf(
                                        RedStartColor,
                                        RedEndColor
                                    )
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 9.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .padding(horizontal = 16.dp),
                                painter = painterResource(res = if (shippingType == "PICKUP") "ic_on_way_walking.xml" else "ic_on_way_traffic.xml"),
                                contentDescription = "on way",
                                tint = White
                            )
                            Column(modifier = Modifier.wrapContentWidth()) {
                                MediumText(
                                    text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (
                                        shippingType == "PICKUP" && shippingStatus == "OK"
                                    ) "Pedido listo" else "Pedido cancelado",
                                    color = White,
                                    fontSize = 15.sp
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    MediumText(
                                        text = if (shippingType == "SHIPPING") "Enviar" else "Recolectar",
                                        color = White,
                                        fontSize = 12.sp
                                    )
                                    MediumText(
                                        modifier = Modifier.padding(end = 20.dp),
                                        text = "Ene 8, 9:30 am",
                                        color = White,
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    }
                    BoldText(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Contactar",
                        fontSize = 12.sp,
                        color = OrangeStrong
                    ) {

                    }
                }
            }
        }
    }
}

@Composable
fun NotificationNewSaleItem(
    shippingType: String = "SHIPPING",
    shippingStatus: String = "OK",
    onClicked: (() -> Unit)? = null
) {
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .background(White)
            .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Card(
                    modifier = Modifier
                        .size(81.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(start = 22.dp)
                    .fillMaxWidth()
                    .background(White),
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SemiBoldText(
                        text = if (shippingType == "SHIPPING" && shippingStatus == "WAITING") "Preparar pedido" else if (
                            shippingType == "PICKUP" && shippingStatus == "WAITING"
                        ) "Preparar pedido" else "Cancelado por el cliente",
                        fontSize = 15.sp,
                        maxLines = 3,
                        textOverflow = TextOverflow.Ellipsis
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 7.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = if (shippingStatus == "WAITING") listOf(
                                    MaterialTheme.colors.primary,
                                    MaterialTheme.colors.onPrimary
                                ) else listOf(
                                    RedStartColor,
                                    RedEndColor
                                )
                            ),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {
                            onClicked?.invoke()
                        }
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 9.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            modifier = Modifier
                                .wrapContentHeight()
                                .padding(horizontal = 16.dp),
                            painter = painterResource(res = if (shippingType == "PICKUP") "ic_on_way_walking.xml" else "ic_on_way_traffic.xml"),
                            contentDescription = "on way",
                            tint = White
                        )
                        Column(modifier = Modifier.wrapContentWidth()) {
                            MediumText(
                                text = if (shippingType == "SHIPPING" && shippingStatus == "WAITING") "Preparar pedido" else if (
                                    shippingType == "PICKUP" && shippingStatus == "WAITING"
                                ) "4 Articulos" else "No recolectar",
                                color = White,
                                fontSize = 15.sp
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                MediumText(
                                    text = if (shippingType == "SHIPPING" || shippingStatus == "PICKUP") "Recolectar" else "Cancelado",
                                    color = White,
                                    fontSize = 12.sp
                                )
                                MediumText(
                                    modifier = Modifier.padding(end = 20.dp),
                                    text = "Ene 8, 9:30 am",
                                    color = White,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
                BoldText(
                    modifier = Modifier.padding(top = 10.dp),
                    text = "Contactar",
                    fontSize = 12.sp,
                    color = OrangeStrong
                ) {

                }
            }
        }
    }
}

@Composable
fun StatusPackageItem(
    step: Int = 0,
    default: Boolean = true,
    shippingType: String = "SHIPPING",
    shippingStatus: String = "OK"
) {
    if (default) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(start = 22.dp)
                .fillMaxWidth()
                .background(White),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SemiBoldText(
                    text = "Recibido el 1 de septiembre",
                    fontSize = 15.sp,
                    maxLines = 3,
                    textOverflow = TextOverflow.Ellipsis
                )
                Image(
                    modifier = Modifier.mirror(),
                    painter = painterResource(res = "ic_on_way_traffic_circle.xml"),
                    contentDescription = "on way"
                )
            }
            SemiBoldText(
                modifier = Modifier.wrapContentHeight(),
                text = "Camiseta",
                color = GrayLetterCategoryProduct,
                fontSize = 10.sp
            )

            StepIndicatorNotification(
                modifier = Modifier.padding(top = 20.dp),
                step = step
            )
            BoldText(
                modifier = Modifier.padding(top = 10.dp),
                text = "Calificar",
                fontSize = 12.sp,
                color = OrangeStrong
            ) {

            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = if (shippingStatus == "OK") listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.onPrimary
                        ) else listOf(
                            RedStartColor,
                            RedEndColor
                        )
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Row(
                modifier = Modifier.padding(vertical = 9.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(horizontal = 16.dp),
                    painter = painterResource(res = if (shippingType == "PICKUP") "ic_on_way_walking.xml" else "ic_on_way_traffic.xml"),
                    contentDescription = "on way",
                    tint = White
                )
                Column(modifier = Modifier.wrapContentWidth()) {
                    MediumText(
                        text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (
                            shippingType == "PICKUP" && shippingStatus == "OK"
                        ) "Pedido listo" else "Pedido cancelado",
                        color = White,
                        fontSize = 15.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        MediumText(
                            text = if (shippingType == "SHIPPING") "Enviar" else "Recolectar",
                            color = White,
                            fontSize = 12.sp
                        )
                        MediumText(
                            modifier = Modifier.padding(end = 20.dp),
                            text = "Ene 8, 9:30 am",
                            color = White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StatusPreviouPackageItem(
    step: Int = 0,
    shippingType: String = "SHIPPING",
    shippingStatus: String = "OK",
    lastItem: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = White,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider(
                    modifier = Modifier
                        .height(20.dp)
                        .width(2.dp),
                    color = BlueStatusLineColor,
                    thickness = 1.dp
                )
                Icon(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(horizontal = 16.dp, vertical = 5.dp),
                    painter = painterResource(res = "ic_dot.xml"),
                    contentDescription = "on way",
                    tint = MaterialTheme.colors.primary
                )
                if (!lastItem) {
                    Divider(
                        modifier = Modifier
                            .height(20.dp)
                            .width(2.dp),
                        color = BlueStatusLineColor,
                        thickness = 1.dp
                    )
                }
            }
            Column(modifier = Modifier.wrapContentWidth()) {
                MediumText(
                    text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (
                        shippingType == "PICKUP" && shippingStatus == "OK"
                    ) "Pedido listo" else "Pedido cancelado",
                    color = Black,
                    fontSize = 15.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    MediumText(
                        text = if (shippingType == "SHIPPING") "Enviar" else "Recolectar",
                        color = GraySinceTo,
                        fontSize = 12.sp
                    )
                    MediumText(
                        modifier = Modifier.padding(end = 20.dp),
                        text = "Ene 8, 9:30 am",
                        color = GraySinceTo,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }

}

@Composable
fun StepIndicatorNotification(
    modifier: Modifier = Modifier,
    step: Int = 0,
    messageOne: String = "19/11/23",
    messageTwo: String = "20/11/23",
    messageThree: String = "21/11/23"
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BoldText(
                text = messageOne,
                fontSize = 12.sp
            )
            BoldText(
                text = messageTwo,
                fontSize = 12.sp
            )
            BoldText(
                text = messageThree,
                fontSize = 12.sp
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Divider(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .weight(0.5f),
                    color = if (step > 0) MaterialTheme.colors.primary else GrayBackgroundDrawerDismiss,
                    thickness = 7.dp
                )
                Divider(
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .weight(0.5f),
                    color = if (step > 3) MaterialTheme.colors.primary else GrayBackgroundDrawerDismiss,
                    thickness = 7.dp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(res = "ic_circle.xml"),
                    contentDescription = "on way",
                    tint = if (step >= 0) MaterialTheme.colors.primary else GrayBackgroundDrawerDismiss
                )
                Icon(
                    painter = painterResource(res = "ic_circle.xml"),
                    contentDescription = "on way",
                    tint = if (step > 2) MaterialTheme.colors.primary else GrayBackgroundDrawerDismiss
                )
                Icon(
                    painter = painterResource(res = "ic_circle.xml"),
                    contentDescription = "on way",
                    tint = if (step > 4) MaterialTheme.colors.primary else GrayBackgroundDrawerDismiss
                )
            }
        }
    }

}

@Composable
fun ShoppingCategoryHistoryItem(
    modifier: Modifier = Modifier,
    item: ItemShoppingModel = ItemShoppingModel(
        nameStore = "Ferreteria La hormiga",
        idStore = "d2d232",
        imgStore = "dddd",
        idSale = "dwed342",
        price = 46.0,
        status = "RECEIVED",
        giftStatus = "AVAILABLE",
        apologyStatus = "NONE",
        canceledBy = "NONE",
        numberProducts = 1
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true,
    selector: Boolean = true,
    elevation: Dp = 0.dp,
    hideTopLine: Boolean = false,
    onClicked: (() -> Unit)? = null
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = elevation
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(White)
        ) {
            if (!hideTopLine) {
                Divider(
                    thickness = 1.5.dp,
                    color = GrayBorderLight
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 14.dp, end = if (deleteOptions) 30.dp else 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                if (selector) {
                    RadioButton(
                        selected = false,
                        onClick = { },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = GrayLetterHint,
                            selectedColor = MaterialTheme.colors.primary
                        )
                    )
                }

                Card(
                    modifier = Modifier
                        .size(30.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
                BoldText(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = 6.dp, end = 10.dp),
                    text = item.nameStore,
                    fontSize = 15.sp,
                    textOverflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                SemiBoldText(
                    modifier = Modifier.padding(end = 23.dp),
                    text = "${item.numberProducts} articulos",
                    color = GrayMedium,
                    fontSize = 13.sp
                )

            }
            Divider(
                thickness = 1.5.dp,
                color = GrayBorderLight
            )
            ShoppingHistoryItem(
                counter = counter,
                deleteOptions = deleteOptions,
                historyModel = item
            ) {
                onClicked?.invoke()
            }
        }
    }
}

@Composable
fun ShoppingHistoryItem(
    historyModel: ItemShoppingModel = ItemShoppingModel(
        nameStore = "Ferreteria La hormiga",
        idStore = "d2d232",
        imgStore = "dddd",
        idSale = "dwed342",
        price = 46.0,
        status = "RECEIVED",
        giftStatus = "AVAILABLE",
        apologyStatus = "NONE",
        canceledBy = "NONE",
        numberProducts = 1
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true,
    onClicked: (() -> Unit)? = null
) {
    Column(
        modifier = if (deleteOptions)
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 20.dp)
        else Modifier
            .fillMaxWidth()
            .padding(top = 14.dp, bottom = 20.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClicked?.invoke() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Card(
                    modifier = Modifier
                        .size(81.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .padding(start = 27.dp)
                    .weight(0.3f),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                SemiBoldText(
                    text = if (historyModel.status == "WAITING_CLIENT") "Esperando" else "Orden",
                    fontSize = 15.sp,
                    maxLines = 2,
                    textOverflow = TextOverflow.Ellipsis
                )
                SemiBoldText(
                    text = when (historyModel.status) {
                        "CANCELED" -> {
                            "cancelada"
                        }

                        "RUNNING" -> {
                            "en camino"
                        }

                        "WAITING_CLIENT" -> {
                            "al cliente"
                        }

                        "WAITING_SELLER" -> {
                            "en proceso"
                        }

                        else -> {
                            "confirmada"
                        }
                    },
                    fontSize = 15.sp,
                    maxLines = 2,
                    color = when (historyModel.status) {
                        "CANCELED" -> {
                            Red
                        }

                        else -> {
                            Black
                        }
                    },
                    textOverflow = TextOverflow.Ellipsis
                )
                SemiBoldText(
                    modifier = Modifier.wrapContentHeight(),
                    text = "$${historyModel.price}",
                    color = Black,
                    fontSize = 15.sp
                )

                SemiBoldText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "12/08/2023 a las 09:41 am",
                    color = GrayLetterCategoryProduct,
                    fontSize = 12.sp,
                    maxLines = 2,
                    textOverflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )

            }
            Column(
                modifier = Modifier
                    .height(81.dp)
                    .weight(0.3f),
                verticalArrangement = if (historyModel.giftStatus != "NONE") Arrangement.Center else Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                if (historyModel.status == "RUNNING" || historyModel.status == "WAITING_SELLER" ||
                    historyModel.status == "WAITING_CLIENT"
                ) {
                    Card(
                        modifier = Modifier
                            .size(81.dp),
                        backgroundColor = GrayBackgroundDrawerDismiss,
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {

                    }
                } else {
                    if (historyModel.canceledBy != "NONE") {
                        GrayButton(
                            text = when (historyModel.canceledBy) {
                                "CLIENT" -> {
                                    "Disculpas"
                                }

                                else -> {
                                    "Calificar"
                                }
                            }
                        )
                    }

                    when (historyModel.giftStatus) {
                        "NONE" -> {

                        }

                        "TAKEN" -> {
                            Row(
                                modifier = Modifier.wrapContentWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                SemiBoldText(
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .alpha(0.39f),
                                    text = "Recolectado",
                                    color = GrayMedium,
                                    fontSize = 12.sp
                                )
                                Image(
                                    modifier = Modifier
                                        .size(25.dp)
                                        .alpha(0.39f),
                                    painter = painterResource(res = "ic_gift.png"),
                                    contentDescription = "gift"
                                )
                            }
                        }

                        else -> {
                            Row(
                                modifier = Modifier.wrapContentWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                SemiBoldText(
                                    modifier = Modifier.padding(end = 10.dp),
                                    text = "Recolectar regalo",
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 12.sp
                                )
                                Image(
                                    modifier = Modifier.size(25.dp),
                                    painter = painterResource(res = "ic_gift.png"),
                                    contentDescription = "gift"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

//Seller
@Composable
fun ItemSold() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(3f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            SemiBoldText(
                text = "Feb 21, 2022",
                fontSize = 15.sp
            )
            SemiBoldText(
                text = "14:02",
                fontSize = 12.sp,
                color = GraySinceTo
            )
        }
        Column(
            modifier = Modifier.weight(2f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            SemiBoldText(
                text = "$21.72",
                fontSize = 15.sp
            )
            SemiBoldText(
                text = "3 articulos",
                fontSize = 12.sp,
                color = GraySinceTo
            )
        }
    }
}


//Items de Compra
@Composable
fun BottomBuyCartItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        elevation = 15.dp
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
                    start = 30.dp, end = 30.dp,
                    bottom = 18.dp
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
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {
                    SemiBoldText(
                        modifier = Modifier.weight(1f),
                        text = "Pagar",
                        color = GrayLetterShipping,
                        fontSize = 18.sp
                    )
                    BoldText(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(bottom = 5.dp),
                        text = "$100",
                        color = OrangeTransparent,
                        fontSize = 12.sp
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
                ShadowButton(
                    modifier = Modifier
                        .padding(bottom = 18.dp, top = 24.dp)
                        .fillMaxWidth()
                        .drawColoredShadow(
                            color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                            offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
                        ),
                    text = "Continuar"
                ) {
//                            navController?.navigate(SHOPPING_DETAIL_GRAPH)
                }
            }
        }
    }
}

@Composable
fun ResumeItem(
    modifier: Modifier = Modifier,
    title: String,
    hideIcon: Boolean = true,
    content: @Composable () -> Unit
) {

    val showItems = rememberSaveable { mutableStateOf(true) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp),
        shape = RectangleShape,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .background(White)
                .padding(horizontal = 30.dp)
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SemiBoldText(
                    text = title,
                    fontSize = 15.sp
                )
                if (hideIcon) {
                    CircularIcon(
                        modifier = Modifier
                            .size(35.dp).wrapContentSize()
                            .rotate(if (showItems.value) 0f else 180f), icon = "ic_arrow_down.xml",
                        contentDescription = "arrow", onClick = {
                            showItems.value = (!showItems.value)
                        })

                }

            }
            AnimatedVisibility(visible = showItems.value) {
                content()
            }

        }
    }
}