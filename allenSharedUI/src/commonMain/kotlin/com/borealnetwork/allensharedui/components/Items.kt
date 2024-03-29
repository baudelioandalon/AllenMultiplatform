package com.borealnetwork.allensharedui.components

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
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.borealnetwork.allensharedui.components.currency.CurrencyInShoppingItem
import com.borealnetwork.allensharedui.theme.BlueStatusLineColor
import com.borealnetwork.allensharedui.theme.CategoryBackgroundSelectorOne
import com.borealnetwork.allensharedui.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allensharedui.theme.GrayBorderLight
import com.borealnetwork.allensharedui.theme.GrayBrandingBackground
import com.borealnetwork.allensharedui.theme.GrayCategoryBackground
import com.borealnetwork.allensharedui.theme.GrayLetterCategoryProduct
import com.borealnetwork.allensharedui.theme.GrayLetterHint
import com.borealnetwork.allensharedui.theme.GrayLetterSeeAll
import com.borealnetwork.allensharedui.theme.GrayMedium
import com.borealnetwork.allensharedui.theme.GraySelector
import com.borealnetwork.allensharedui.theme.GraySinceTo
import com.borealnetwork.allensharedui.theme.GrayStrong
import com.borealnetwork.allensharedui.theme.GreenStrong
import com.borealnetwork.allensharedui.theme.OrangeMedium
import com.borealnetwork.allensharedui.theme.OrangeStrong
import com.borealnetwork.allensharedui.theme.RedEndColor
import com.borealnetwork.allensharedui.theme.RedStartColor
import com.borealnetwork.shared.domain.components.PinStatusHistoryModel
import com.borealnetwork.shared.domain.models.cart.ItemCartModel
import com.borealnetwork.shared.domain.models.cart.ItemShoppingModel
import com.borealnetwork.shared.domain.models.cart.MinimalProductModel
import com.borealnetwork.shared.domain.models.cart.ProductShoppingCart
import com.borealnetwork.shared.domain.models.payments.CardModel
import com.borealnetwork.shared.domain.models.payments.TypeCard
import com.borealnetwork.shared.tools.DottedShape
import com.borealnetwork.shared.tools.limit
import com.borealnetwork.shared.tools.mirror
import com.borealnetwork.shared.tools.round
import com.borealnetwork.shared.tools.rounded
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.DrawableResource
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
        modifier = Modifier.padding(start = 30.dp, end = 4.dp, bottom = 35.dp).wrapContentSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.padding(top = 23.dp, bottom = 9.dp).size(74.dp),
            onClick = {},
            elevation = 0.dp,
            shape = CircleShape,
            backgroundColor = GrayCategoryBackground
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.width(32.dp),
                    painter = painterResource(resource = DrawableResource("tools_icon.png")),
                    contentDescription = "item"
                )
            }
        }

        SemiBoldText(
            modifier = Modifier.fillMaxWidth(),
            text = "Ferreteria",
            fontSize = 13.sp,
            letterSpacing = 0.sp,
            color = Black
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BrandingItem(
    image: String,
    itemSize: Dp = 60.dp,
    onClicked: (() -> Unit)?
) {
    Column(
        modifier = Modifier.wrapContentSize().padding(start = 30.dp, end = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.size(itemSize),
            onClick = { onClicked?.invoke() },
            elevation = 0.dp,
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            backgroundColor = GrayBrandingBackground
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.padding(horizontal = 10.dp).fillMaxSize(),
                    painter = painterResource(resource = DrawableResource(image)),
                    contentDescription = "item"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategorySelectorItem(
    maxBackground: Boolean = false, color: Color = CategoryBackgroundSelectorOne
) {
    Box(modifier = Modifier.padding(start = 30.dp, end = 4.dp).height(144.dp).width(134.dp)
        .graphicsLayer {
            shape = RoundedCornerShape(corner = CornerSize(15.dp))
        }) {

        Column {
            AnimatedVisibility(!maxBackground) {
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight(if (maxBackground) 1F else 0.5F),
                    elevation = 0.dp,
                    backgroundColor = Transparent
                ) {

                }
            }
            Card(
                modifier = Modifier.fillMaxSize(), elevation = 0.dp, backgroundColor = color
            ) {

            }
        }

        Card(
            modifier = Modifier, onClick = {}, elevation = 0.dp, backgroundColor = Transparent
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 10.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.padding(top = 10.dp).fillMaxWidth().height(80.dp),
                    painter = painterResource(resource = DrawableResource("laptop_test.png")),
                    contentDescription = "item"
                )
                BoldText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Laptops",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    color = Black
                )
            }

        }

    }

}

@Composable
fun SellerItem(
    modifier: Modifier,
    topText: String,
    bottomText: String,
    onClicked: (() -> Unit)? = null
) {
    Row(
        modifier = modifier.wrapContentHeight().clickable {
            onClicked?.invoke()
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier.size(53.dp),
            backgroundColor = GrayBackgroundDrawerDismiss,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {

        }
        Column(
            modifier = Modifier.padding(start = 19.dp).weight(1f).fillMaxHeight()
        ) {
            BoldText(
                text = topText, color = Black,
                fontSize = 15.sp
            )
            MediumText(
                text = bottomText, color = GrayLetterSeeAll, fontSize = 15.sp
            )
        }
        RightRoundedButton(
            modifier = Modifier.padding(end = 30.dp),
        ) {

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductItem(
    model: MinimalProductModel, onClicked: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier.padding(start = 30.dp, end = 4.dp).height(240.dp).width(178.dp),
        onClick = { onClicked?.invoke() },
        elevation = 6.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        backgroundColor = White
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box {
                KamelImage(
                    modifier = Modifier.padding(top = 10.dp).fillMaxWidth().height(130.dp),
                    resource = asyncPainterResource(
                        model.imgProduct,
                    ),
                    contentDescription = "imageExample"
                )
                FavoriteButton()
            }

            SemiBoldText(
                modifier = Modifier.padding(start = 14.dp).fillMaxWidth(),
                text = model.nameProduct,
                fontSize = 17.sp,
                textAlign = TextAlign.Start
            )
            SemiBoldText(
                modifier = Modifier.padding(start = 14.dp).fillMaxWidth(),
                text = model.categoryItem,
                color = GrayLetterCategoryProduct,
                fontSize = 10.sp,
                textAlign = TextAlign.Start
            )

            Row(
                modifier = Modifier.padding(start = 14.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                BoldText(
                    modifier = Modifier.padding(bottom = 5.dp).wrapContentSize(),
                    text = "$${model.price.round(2).rounded()}",
                    color = Black
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
    currency: String,
    productClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier.wrapContentHeight().fillMaxWidth(),
        onClick = { productClicked?.invoke() },
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = White,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier.background(
                    color = GrayBackgroundDrawerDismiss, shape = RoundedCornerShape(10.dp)
                ).requiredHeight(200.dp)
            ) {
                FavoriteButton(modifier = Modifier.padding(start = 7.dp, top = 7.dp))
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(resource = DrawableResource("tools_icon.png")),
                    contentDescription = "item"
                )
            }

            SemiBoldText(
                text = "Sensor Hc-sr04 Tipo C entrada De nombre inconmensurable",
                textAlign = TextAlign.Start,
                textOverflow = TextOverflow.Ellipsis,
                fontSize = 13.sp,
                maxLines = 2
            )

            PriceWithDiscount(
                currency = currency
            )
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                FreeShipping(
                    modifier = Modifier.padding(top = 10.dp).fillMaxWidth(0.5f)
                        .align(Alignment.CenterStart)
                )
                BoldText(
                    modifier = Modifier.align(alignment = Alignment.BottomEnd),
                    text = "15% OFF",
                    color = OrangeMedium,
                    fontSize = 12.sp
                )
            }

        }
    }
}

@Composable
fun BrandingHorizontal(
    modifier: Modifier = Modifier, itemSize: Dp = 60.dp
) {//TODO CAMBIAR POR HorizontalContainerListItem
    LazyRow(
        modifier = modifier
    ) {
        items(10) {
            BrandingItem("tools_icon.png", itemSize) {

            }
        }
    }
}

@Composable
fun ShowSellerItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().wrapContentHeight().clickable { },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier.size(53.dp),
            backgroundColor = GrayBackgroundDrawerDismiss,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {

        }
        Column(
            modifier = Modifier.padding(start = 19.dp).fillMaxWidth()
        ) {
            MediumText(
                text = "Para", color = GrayLetterSeeAll, fontSize = 15.sp
            )
            BoldText(text = "Casa y Hogar", fontSize = 15.sp, color = Black)
        }
    }
}


@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun QuestionItem(
    text: String = "", answerList: List<String> = emptyList(), likesList: List<String> = emptyList()
) {
    Card(
        elevation = 5.dp, shape = RectangleShape
    ) {
        Row(
            modifier = Modifier.background(White).padding(start = 30.dp, top = 25.dp, end = 30.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = Modifier.padding(bottom = 9.dp).size(41.dp),
                onClick = {},
                elevation = 0.dp,
                shape = CircleShape,
                backgroundColor = GrayCategoryBackground
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(resource = DrawableResource("tools_icon.png")),
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
    text: String = "", likesList: List<String> = emptyList()
) {
    Card(
        shape = RectangleShape, elevation = 5.dp
    ) {
        Row(
            modifier = Modifier.background(White)
                .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 25.dp).fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Card(
                modifier = Modifier.padding(bottom = 9.dp).size(41.dp),
                onClick = {},
                elevation = 0.dp,
                shape = CircleShape,
                backgroundColor = GrayCategoryBackground
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(resource = DrawableResource("tools_icon.png")),
                        contentDescription = "item"
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
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
        modifier = modifier.padding(start = 30.dp, end = 4.dp).sizeIn(maxWidth = 200.dp)
            .background(White),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Card(
            modifier = Modifier.padding(bottom = 9.dp).size(30.dp),
            onClick = {},
            elevation = 0.dp,
            shape = CircleShape,
            backgroundColor = GrayCategoryBackground
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(resource = DrawableResource("tools_icon.png")),
                    contentDescription = "item"
                )
            }
        }

        SemiBoldText(
            modifier = Modifier.padding(start = 28.dp),
            text = text,
            textAlign = TextAlign.Justify,
            fontSize = 17.sp,
            color = MaterialTheme.colors.primary
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ShoppingCartStoreItem(
    modifier: Modifier = Modifier,
    topModifier: Modifier = Modifier,
    item: ItemCartModel = ItemCartModel(
        "Test", "3e23dc2", "dd", listOf()
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true,
    selector: Boolean = true,
    elevation: Dp = 0.dp,
    hideTopLine: Boolean = false,
    check: Boolean = false,
    currency: String,
    startTextButton: String = "",
    endTextButton: String = ""
) {

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RectangleShape,
        elevation = elevation
    ) {

        val showItems = rememberSaveable { mutableStateOf(true) }
        Column(
            modifier = Modifier.fillMaxWidth().background(White)
        ) {
            if (!hideTopLine) {
                Divider(
                    thickness = 1.5.dp, color = GrayBorderLight
                )
            }
            //TopStoreInformation
            StoreInformationItem(
                modifier = topModifier,
                deleteOptions = deleteOptions,
                selector = selector,
                itemNotPayed = item,
                hideArrow = true,
                showItems = showItems
            )
            AnimatedVisibility(visible = showItems.value) {
                Divider(
                    thickness = 1.5.dp, color = GrayBorderLight
                )
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    //Items
                    item.listItems.forEachIndexed { index, model ->
                        ShoppingCartItem(productShoppingCart = model,
                            counter = counter,
                            deleteOptions = deleteOptions,
                            check = check,
                            startText = startTextButton,
                            endTextButton = endTextButton,
                            currency = currency,
                            showBottomDivider = index != item.listItems.limit(),
                            startClicked = { item ->

                            },
                            endClicked = { item ->

                            })
                    }
                }
            }
        }
    }
}

@Composable
fun StoreInformationItem(
    modifier: Modifier = Modifier,
    deleteOptions: Boolean,
    selector: Boolean,
    hideArrow: Boolean = true,
    itemNotPayed: ItemCartModel? = null,
    itemPayed: ItemShoppingModel? = null,
    showItems: MutableState<Boolean>,
) {
    Row(
        modifier = modifier.fillMaxWidth()
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
                    unselectedColor = GrayLetterHint, selectedColor = MaterialTheme.colors.primary
                )
            )
        }

        Card(
            modifier = Modifier.size(30.dp),
            backgroundColor = GrayBackgroundDrawerDismiss,
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp)
        ) {

        }
        BoldText(
            modifier = Modifier.weight(0.5f).padding(start = 6.dp, end = 10.dp),
            text = itemNotPayed?.nameStore ?: itemPayed?.nameStore.orEmpty(),
            fontSize = 15.sp,
            textOverflow = TextOverflow.Ellipsis,
            maxLines = 2,
            color = Black
        )
        SemiBoldText(
            modifier = Modifier.padding(end = 23.dp), text = "${
                itemNotPayed?.listItems?.size ?: itemPayed?.numberProducts
            } articulo${
                if ((itemNotPayed?.listItems?.size ?: itemPayed?.numberProducts ?: 0) > 1) {
                    "s"
                } else {
                    ""
                }
            }", color = GrayMedium, fontSize = 13.sp
        )
        if (hideArrow) {
            CircularIcon(modifier = Modifier.size(35.dp).wrapContentSize()
                .rotate(if (showItems.value) 0f else 180f),
                icon = "ic_arrow_down.xml",
                contentDescription = "arrow",
                onClick = {
                    showItems.value = (!showItems.value)
                })
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShoppingCartItem(
    productShoppingCart: ProductShoppingCart = ProductShoppingCart(
        skuProduct = "d2d232",
        nameProduct = "Balon Basketball num 6edcwedwedwedcedwcef",
        imgProduct = "ccdcdomd",
        categoryItem = "Deportes",
        quantity = 2,
        discountPercentage = 10,
        fastOrder = true,
        minimalFastOrder = 2,
        price = 588880.0
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true,
    check: Boolean = true,
    showChecked: Boolean = true,
    currency: String,
    startText: String = "Remover",
    endTextButton: String = "Guardar para después",
    showBottomDivider: Boolean = false,
    topPadding: Dp = 0.dp,
    imgClicked: ((ProductShoppingCart) -> Unit)? = null,
    startClicked: ((ProductShoppingCart) -> Unit)? = null,
    endClicked: ((ProductShoppingCart) -> Unit)? = null
) {
    Column(
        modifier = if (deleteOptions) Modifier.fillMaxWidth().background(White)
            .padding(bottom = 20.dp, top = topPadding)
        else Modifier.fillMaxWidth().background(White).padding(top = 14.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            //ImageProduct
            Box(
                modifier = Modifier.wrapContentWidth()
            ) {
                Card(
                    modifier = Modifier.size(91.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp),
                    onClick = {
                        imgClicked?.invoke(productShoppingCart)
                    }
                ) {

                }
                if (showChecked) {
                    Image(
                        modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                        painter = painterResource(resource = DrawableResource(if (check) "ic_checked.xml" else "ic_check.xml")),
                        contentDescription = "check"
                    )
                }


            }
            //NameProduct, Category, PriceBeforeDiscount
            Column(
                modifier = Modifier.height(90.dp).padding(start = 15.dp).weight(0.3f),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                SemiBoldText(
                    text = productShoppingCart.nameProduct,
                    fontSize = 13.sp,
                    maxLines = 2,
                    textOverflow = TextOverflow.Ellipsis
                )
                SemiBoldText(
                    modifier = Modifier.wrapContentHeight().padding(bottom = 5.dp),
                    text = productShoppingCart.categoryItem,
                    color = GrayLetterCategoryProduct,
                    maxLines = 1,
                    textOverflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp
                )

                if (productShoppingCart.discountPercentage > 0) {
                    PriceBeforeDiscount(
                        modifier = Modifier.weight(0.3f).padding(end = 20.dp),
                        price = productShoppingCart.price,
                        currency = currency
                    )
                }

            }
            //Discount, FreeShipping
            Column(
                modifier = Modifier.height(81.dp).weight(0.3f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
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
                }
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, top = 17.dp)
        ) {
            Spinner(
                modifier = Modifier.width(91.dp),
                dropDownModifier = Modifier.wrapContentSize(),
                items = listOf("Talla M", "Talla S"),
                selectedItem = "Talla M",
                onItemSelected = {},
                selectedItemFactory = { modifierContainer, item ->
                    Card(
                        modifier = modifierContainer
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = GraySelector
                    ) {
                        Row(
                            modifier = modifierContainer.fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SemiBoldText(
                                modifier = Modifier.padding(end = 8.dp),
                                text = item,
                                fontSize = 15.sp
                            )
                            Icon(
                                painter = painterResource(resource = DrawableResource("ic_arrow_down.xml")),
                                contentDescription = "drop down arrow"
                            )
                        }
                    }

                },
                dropdownItemFactory = { item, _ ->
                    Text(text = item)
                }
            )
            CurrencyInShoppingItem(
                modifier = Modifier.padding(start = 25.dp),
                currency = currency
            ) {
                BoldText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "$3242.45",
                    fontSize = 18.sp,
                    color = GreenStrong,
                    textAlign = TextAlign.Start,
                    textOverflow = TextOverflow.Clip
                )
            }

        }
        if (deleteOptions) {
            Row(modifier = Modifier.padding(start = 20.dp, top = 12.dp)) {
                BoldText(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 5.dp,
                        top = 10.dp
                    ),
                    text = startText, fontSize = 12.sp, color = OrangeStrong
                ) {
                    startClicked?.invoke(productShoppingCart)
                }
                BoldText(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 5.dp,
                        top = 10.dp
                    ),
                    text = endTextButton,
                    fontSize = 12.sp,
                    color = OrangeStrong
                ) {
                    endClicked?.invoke(productShoppingCart)
                }
            }
        }
        if (showBottomDivider) {
            Divider(
                modifier = Modifier.padding(top = 10.dp),
                thickness = 1.5.dp, color = GrayBorderLight
            )
        }
    }
}

@Composable
fun NotificationItem(
    modifier: Modifier = Modifier,
    step: Int = 0,
    default: Boolean = true,
    shippingType: String = "SHIPPING",
    shippingStatus: String = "OK",
    elevation: Dp = 5.dp,
) {
    Card(
        modifier = modifier.fillMaxWidth(), shape = RectangleShape, elevation = elevation
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().background(White)
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
                        modifier = Modifier.size(81.dp),
                        backgroundColor = GrayBackgroundDrawerDismiss,
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {

                    }

                }
                if (default) {
                    Column(
                        modifier = Modifier.wrapContentHeight().padding(start = 22.dp)
                            .fillMaxWidth().background(White), verticalArrangement = Arrangement.Top
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
                                painter = painterResource(resource = DrawableResource("ic_on_way_traffic_circle.xml")),
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
                            modifier = Modifier.padding(top = 20.dp), step = step
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
                        modifier = Modifier.wrapContentHeight().padding(start = 22.dp)
                            .fillMaxWidth().background(White), verticalArrangement = Arrangement.Top
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SemiBoldText(
                                text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (shippingType == "PICKUP" && shippingStatus == "OK") "Pedido listo" else if (shippingStatus == "CANCELLED_BY_SELLER") "Cancelado por el vendedor" else "Cancelado por el cliente",
                                fontSize = 15.sp,
                                maxLines = 3,
                                textOverflow = TextOverflow.Ellipsis
                            )
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth().padding(top = 7.dp).background(
                                brush = Brush.horizontalGradient(
                                    colors = if (shippingStatus == "OK") listOf(
                                        MaterialTheme.colors.primary, MaterialTheme.colors.onPrimary
                                    ) else listOf(
                                        RedStartColor, RedEndColor
                                    )
                                ), shape = RoundedCornerShape(10.dp)
                            )
                        ) {
                            Row(
                                modifier = Modifier.padding(vertical = 9.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Icon(
                                    modifier = Modifier.wrapContentHeight()
                                        .padding(horizontal = 16.dp),
                                    painter = painterResource(resource = DrawableResource(if (shippingType == "PICKUP") "ic_on_way_walking.xml" else "ic_on_way_traffic.xml")),
                                    contentDescription = "on way",
                                    tint = White
                                )
                                Column(modifier = Modifier.wrapContentWidth()) {
                                    MediumText(
                                        text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (shippingType == "PICKUP" && shippingStatus == "OK") "Pedido listo" else "Pedido cancelado",
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

}

@Composable
fun NotificationNewSaleItem(
    shippingType: String = "SHIPPING",
    shippingStatus: String = "OK",
    onClicked: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth().background(White)
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
                    modifier = Modifier.size(81.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }
            Column(
                modifier = Modifier.wrapContentHeight().padding(start = 22.dp).fillMaxWidth()
                    .background(White), verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SemiBoldText(
                        text = if (shippingType == "SHIPPING" && shippingStatus == "WAITING") "Preparar pedido" else if (shippingType == "PICKUP" && shippingStatus == "WAITING") "Preparar pedido" else "Cancelado por el cliente",
                        fontSize = 15.sp,
                        maxLines = 3,
                        textOverflow = TextOverflow.Ellipsis
                    )
                }
                Box(modifier = Modifier.fillMaxWidth().padding(top = 7.dp).background(
                    brush = Brush.horizontalGradient(
                        colors = if (shippingStatus == "WAITING") listOf(
                            MaterialTheme.colors.primary, MaterialTheme.colors.onPrimary
                        ) else listOf(
                            RedStartColor, RedEndColor
                        )
                    ), shape = RoundedCornerShape(10.dp)
                ).clickable {
                    onClicked?.invoke()
                }) {
                    Row(
                        modifier = Modifier.padding(vertical = 9.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            modifier = Modifier.wrapContentHeight().padding(horizontal = 16.dp),
                            painter = painterResource(resource = DrawableResource(if (shippingType == "PICKUP") "ic_on_way_walking.xml" else "ic_on_way_traffic.xml")),
                            contentDescription = "on way",
                            tint = White
                        )
                        Column(modifier = Modifier.wrapContentWidth()) {
                            MediumText(
                                text = if (shippingType == "SHIPPING" && shippingStatus == "WAITING") "Preparar pedido" else if (shippingType == "PICKUP" && shippingStatus == "WAITING") "4 Articulos" else "No recolectar",
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
            modifier = Modifier.wrapContentHeight().padding(start = 22.dp).fillMaxWidth()
                .background(White), verticalArrangement = Arrangement.Top
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
                    painter = painterResource(resource = DrawableResource("ic_on_way_traffic_circle.xml")),
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
                modifier = Modifier.padding(top = 20.dp), step = step
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
            modifier = Modifier.fillMaxWidth().padding(top = 7.dp).background(
                brush = Brush.horizontalGradient(
                    colors = if (shippingStatus == "OK") listOf(
                        MaterialTheme.colors.primary, MaterialTheme.colors.onPrimary
                    ) else listOf(
                        RedStartColor, RedEndColor
                    )
                ), shape = RoundedCornerShape(10.dp)
            )
        ) {
            Row(
                modifier = Modifier.padding(vertical = 9.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier.wrapContentHeight().padding(horizontal = 16.dp),
                    painter = painterResource(resource = DrawableResource(if (shippingType == "PICKUP") "ic_on_way_walking.xml" else "ic_on_way_traffic.xml")),
                    contentDescription = "on way",
                    tint = White
                )
                Column(modifier = Modifier.wrapContentWidth()) {
                    MediumText(
                        text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (shippingType == "PICKUP" && shippingStatus == "OK") "Pedido listo" else "Pedido cancelado",
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
        modifier = Modifier.fillMaxWidth().background(
            color = White, shape = RoundedCornerShape(10.dp)
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
                    modifier = Modifier.height(20.dp).width(2.dp),
                    color = BlueStatusLineColor,
                    thickness = 1.dp
                )
                Icon(
                    modifier = Modifier.wrapContentHeight()
                        .padding(horizontal = 16.dp, vertical = 5.dp),
                    painter = painterResource(resource = DrawableResource("ic_dot.xml")),
                    contentDescription = "on way",
                    tint = MaterialTheme.colors.primary
                )
                if (!lastItem) {
                    Divider(
                        modifier = Modifier.height(20.dp).width(2.dp),
                        color = BlueStatusLineColor,
                        thickness = 1.dp
                    )
                }
            }
            Column(modifier = Modifier.wrapContentWidth()) {
                MediumText(
                    text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (shippingType == "PICKUP" && shippingStatus == "OK") "Pedido listo" else "Pedido cancelado",
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
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BoldText(
                text = messageOne, fontSize = 12.sp
            )
            BoldText(
                text = messageTwo, fontSize = 12.sp
            )
            BoldText(
                text = messageThree, fontSize = 12.sp
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Divider(
                    modifier = Modifier.padding(start = 5.dp).weight(0.5f),
                    color = if (step > 0) MaterialTheme.colors.primary else GrayBackgroundDrawerDismiss,
                    thickness = 7.dp
                )
                Divider(
                    modifier = Modifier.padding(end = 5.dp).weight(0.5f),
                    color = if (step > 3) MaterialTheme.colors.primary else GrayBackgroundDrawerDismiss,
                    thickness = 7.dp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(resource = DrawableResource("ic_circle.xml")),
                    contentDescription = "on way",
                    tint = if (step >= 0) MaterialTheme.colors.primary else GrayBackgroundDrawerDismiss
                )
                Icon(
                    painter = painterResource(resource = DrawableResource("ic_circle.xml")),
                    contentDescription = "on way",
                    tint = if (step > 2) MaterialTheme.colors.primary else GrayBackgroundDrawerDismiss
                )
                Icon(
                    painter = painterResource(resource = DrawableResource("ic_circle.xml")),
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
    topModifier: Modifier = Modifier,
    itemPayed: ItemShoppingModel = ItemShoppingModel(
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
    deleteOptions: Boolean = true,
    selector: Boolean = true,
    elevation: Dp = 0.dp,
    hideArrow: Boolean = true,
    hideTopLine: Boolean = false,
    onClicked: (() -> Unit)? = null
) {

    Card(
        modifier = Modifier.fillMaxWidth(), shape = RectangleShape, elevation = elevation
    ) {
        val showItems = rememberSaveable { mutableStateOf(true) }
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            if (!hideTopLine) {
                Divider(
                    thickness = 1.5.dp, color = GrayBorderLight
                )
            }
            StoreInformationItem(
                modifier = topModifier,
                deleteOptions = deleteOptions,
                selector = selector,
                hideArrow = hideArrow,
                itemPayed = itemPayed,
                showItems = showItems
            )
            AnimatedVisibility(visible = showItems.value) {
                Divider(
                    thickness = 1.5.dp, color = GrayBorderLight
                )
                ShoppingHistoryItem(historyModel = itemPayed) {
                    onClicked?.invoke()
                }

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
    ), onClicked: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 14.dp, bottom = 20.dp, start = 30.dp, end = 30.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxSize().clickable { onClicked?.invoke() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Card(
                    modifier = Modifier.size(81.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }
            Column(
                modifier = Modifier.height(100.dp).padding(start = 27.dp).weight(0.3f),
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
                    }, fontSize = 15.sp, maxLines = 2, color = when (historyModel.status) {
                        "CANCELED" -> {
                            Red
                        }

                        else -> {
                            Black
                        }
                    }, textOverflow = TextOverflow.Ellipsis
                )
                SemiBoldText(
                    modifier = Modifier.wrapContentHeight(),
                    text = "$${historyModel.price}",
                    color = Black,
                    fontSize = 15.sp
                )

                SemiBoldText(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    text = "12/08/2023 a las 09:41 am",
                    color = GrayLetterCategoryProduct,
                    fontSize = 12.sp,
                    maxLines = 2,
                    textOverflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )

            }
            Column(
                modifier = Modifier.height(81.dp).weight(0.3f),
                verticalArrangement = if (historyModel.giftStatus != "NONE") Arrangement.Center else Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                if (historyModel.status == "RUNNING" || historyModel.status == "WAITING_SELLER" || historyModel.status == "WAITING_CLIENT") {
                    Card(
                        modifier = Modifier.size(81.dp),
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
                                    modifier = Modifier.padding(end = 10.dp).alpha(0.39f),
                                    text = "Recolectado",
                                    color = GrayMedium,
                                    fontSize = 12.sp
                                )
                                Image(
                                    modifier = Modifier.size(25.dp).alpha(0.39f),
                                    painter = painterResource(resource = DrawableResource("ic_gift.png")),
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
                                    painter = painterResource(resource = DrawableResource("ic_gift.png")),
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
            modifier = Modifier.weight(3f), verticalArrangement = Arrangement.SpaceBetween
        ) {
            SemiBoldText(
                text = "Feb 21, 2022", fontSize = 15.sp
            )
            SemiBoldText(
                text = "14:02", fontSize = 12.sp, color = GraySinceTo
            )
        }
        Column(
            modifier = Modifier.weight(2f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            SemiBoldText(
                text = "$21.72", fontSize = 15.sp
            )
            SemiBoldText(
                text = "3 articulos", fontSize = 12.sp, color = GraySinceTo
            )
        }
    }
}


@Composable
fun ResumeItem(
    modifier: Modifier = Modifier,
    title: String,
    topCounter: Boolean = false,
    numberCounter: Int = 0,
    hideIcon: Boolean = true,
    middleItem: Boolean = false,
    topContent: @Composable (() -> Unit?)? = null,
    endPadding: Dp = 20.dp,
    bottomPadding: Dp = 0.dp,
    startPadding: Dp = 30.dp,
    innerStartPadding: Dp = 0.dp,
    innerEndPadding: Dp = 0.dp,
    innerTopPadding: Dp = 10.dp,
    innerBottomPadding: Dp = 20.dp,
    content: @Composable () -> Unit
) {

    var showItems by rememberSaveable { mutableStateOf(true) }
    Card(
        modifier = modifier.fillMaxWidth().padding(bottom = 30.dp),
        shape = RectangleShape,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.background(White).padding(
                start = startPadding,
                bottom = bottomPadding,
                end = endPadding,
                top = innerTopPadding
            ).wrapContentHeight().fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(
                    bottom = innerBottomPadding
                ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    SemiBoldText(
                        modifier = Modifier.padding(
                            start = if (startPadding > 0.dp) 0.dp else innerStartPadding
                        ), text = title, fontSize = 15.sp
                    )
                    if (topCounter) {
                        Card(
                            modifier = Modifier.padding(start = 10.dp).size(25.dp),
                            shape = CircleShape,
                            backgroundColor = MaterialTheme.colors.primary
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                SemiBoldText(
                                    text = numberCounter.toString(), color = White
                                )
                            }
                        }
                    }
                }



                if (middleItem) {
                    topContent?.invoke()
                }
                if (hideIcon) {
                    CircularIcon(modifier = Modifier.padding(
                        end = if (endPadding > 0.dp) 0.dp else innerEndPadding
                    ).size(35.dp).wrapContentSize().rotate(if (showItems) 0f else 180f),
                        icon = "ic_arrow_down.xml",
                        contentDescription = "arrow",
                        onClick = {
                            showItems = (!showItems)
                        })

                }

            }
            AnimatedVisibility(visible = showItems) {
                content()
            }

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddButton(
    modifier: Modifier = Modifier, text: String, onClicked: (() -> Unit)? = null
) {
    Row(
        modifier = modifier.wrapContentSize(), verticalAlignment = Alignment.CenterVertically
    ) {
        MediumText(
            text = text, fontSize = 15.sp, color = GraySinceTo
        )
        Surface(modifier = Modifier.padding(start = 9.dp).size(35.dp),
            color = GreenStrong,
            shape = RoundedCornerShape(5.dp),
            onClick = { onClicked?.invoke() }) {
            Icon(
                modifier = Modifier.padding(12.dp),
                painter = painterResource(resource = DrawableResource("ic_more_icon.xml")),
                contentDescription = "more_icon",
                tint = White
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardFilled(
    modifier: Modifier = Modifier, model: CardModel, listColor: List<Color>
) {
    Card(modifier = modifier.width(300.dp).height(175.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        onClick = {

        }) {
        Box(
            Modifier.fillMaxSize().background(
                brush = Brush.horizontalGradient(
                    colors = listColor
                )
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(all = 15.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BoldText(
                        text = model.holderName, color = White, fontSize = 12.sp
                    )
                    Image(
                        painterResource(resource = DrawableResource(if (model.type == TypeCard.VISA) "ic_visa.xml" else if (model.type == TypeCard.MASTERCARD) "ic_mastercard.xml" else "ic_mastercard.xml")),
                        contentDescription = "type card"
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Image(
                        modifier = Modifier.padding(end = 10.dp),
                        painter = painterResource(resource = DrawableResource("ic_chip.xml")),
                        contentDescription = "chip"
                    )
                    Icon(
                        painter = painterResource(resource = DrawableResource("ic_cashless.xml")),
                        contentDescription = "cashless",
                        tint = White
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(3) {
                        SemiBoldText(
                            text = "****", fontSize = 30.sp, color = White
                        )
                    }

                    SemiBoldText(
                        text = model.lastFourNumber.toString(), fontSize = 30.sp, color = White
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SemiBoldText(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        text = "${model.month} / ${model.year}",
                        fontSize = 15.sp,
                        color = White
                    )
                    SemiBoldText(
                        text = model.aliasCard, fontSize = 13.sp, color = White
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardNoFilled(
    modifier: Modifier = Modifier,
    holderName: String,
    number: String,
    aliasCard: String,
    month: String,
    year: String,
    list: List<Color>
) {
    Card(modifier = modifier.fillMaxWidth().requiredHeight(200.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        onClick = {

        }) {
        Box(
            Modifier.fillMaxSize().background(
                brush = Brush.horizontalGradient(
                    colors = list
                )
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(all = 15.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BoldText(
                        text = holderName, color = White, fontSize = 12.sp
                    )
                    Image(
                        painterResource(
                            resource = DrawableResource(
                                if (number.startsWith("4") && number.length == 16) "ic_visa.xml" else if (number.startsWith(
                                        "5"
                                    ) && number.length == 16
                                ) "ic_mastercard.xml" else "ic_mastercard.xml"
                            )
                        ), contentDescription = "type card"
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Image(
                        modifier = Modifier.padding(end = 10.dp),
                        painter = painterResource(resource = DrawableResource("ic_chip.xml")),
                        contentDescription = "chip"
                    )
                    Icon(
                        painter = painterResource(resource = DrawableResource("ic_cashless.xml")),
                        contentDescription = "cashless",
                        tint = White
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SemiBoldText(
                        text = number.substring(0, 3), fontSize = 30.sp, color = White
                    )
                    SemiBoldText(
                        text = number.substring(4, 7), fontSize = 30.sp, color = White
                    )
                    SemiBoldText(
                        text = number.substring(8, 11), fontSize = 30.sp, color = White
                    )

                    SemiBoldText(
                        text = number.substring(12), fontSize = 30.sp, color = White
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SemiBoldText(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        text = "$month / $year",
                        fontSize = 15.sp,
                        color = White
                    )
                    SemiBoldText(
                        text = aliasCard, fontSize = 13.sp, color = White
                    )
                }
            }
        }
    }
}

@Composable
fun ResumeStatusTravelItem(
    modifier: Modifier = Modifier, pinStatusList: List<PinStatusHistoryModel>
) {
    Column(
        modifier = modifier.wrapContentWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        pinStatusList.forEachIndexed { index, item ->
            PinStatusLocationItem(
                topText = item.origin, bottomText = item.destiny
            ) {
                item.icon()
            }
            if (index < pinStatusList.limit()) {
                DottedVerticalLine()
            }
        }

    }
}


@Composable
fun <T> HorizontalContainerListItem(
    startText: String? = null,
    startIcon: @Composable (() -> Unit)? = null,
    endText: String? = null,
    endIcon: @Composable (() -> Unit)? = null,
    listItem: List<T> = emptyList(),
    bottomCompose: @Composable (() -> Unit)? = null,
    composeItem: @Composable ((T, Int) -> Unit)? = null
) {
    Column(
        modifier = Modifier.background(White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (startIcon != null) {
                startIcon()
            } else {
                BoldText(
                    modifier = Modifier.padding(start = 30.dp, top = 20.dp),
                    text = startText.orEmpty(),
                    color = Black,
                    fontSize = 20.sp
                )
            }
            if (endIcon != null) {
                endIcon()
            } else {
                BoldText(
                    modifier = Modifier.padding(top = 20.dp, end = 30.dp),
                    text = endText.orEmpty(),
                    fontSize = 18.sp,
                    color = GrayLetterSeeAll
                )
            }
        }
        if (listItem.isNotEmpty()) {
            LazyRow(
                modifier = Modifier.padding(
                    top = 30.dp, bottom = 35.dp
                )
            ) {
                itemsIndexed(items = listItem) { index, item ->
                    composeItem?.invoke(item, index)
                }
            }
        }
        bottomCompose?.invoke()
    }
}


@Composable
fun PinStatusLocationItem(
    topText: String, bottomText: String, icon: @Composable () -> Unit
) {
    Row(horizontalArrangement = Arrangement.Start) {
        icon()
        Column(modifier = Modifier.padding(start = 13.dp)) {
            MediumText(
                text = topText, color = GraySinceTo, fontSize = 15.sp
            )
            MediumText(
                modifier = Modifier.width(180.dp).wrapContentHeight(),
                text = bottomText,
                textAlign = TextAlign.Start,
                color = GrayMedium,
                fontSize = 15.sp,
                textOverflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}

@Composable
fun DottedVerticalLine() {
    Box(
        Modifier.padding(top = 20.dp).rotate(90f).width(50.dp).height(1.dp)
            .background(GrayStrong, shape = DottedShape(step = 10.dp))
    )
}