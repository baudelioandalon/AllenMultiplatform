package com.borealnetwork.allen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource


@Composable
fun TopTitle(
    titleText: String,
    backClicked: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 5.dp,
        shape = RectangleShape
    ) {
        Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularIcon(
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .width(35.dp)
                        .height(35.dp),
                    icon = "ic_back_arrow.xml"
                ) {
                    backClicked?.invoke()
                }

            }
            SemiBoldText(
                modifier = Modifier.wrapContentWidth().align(Alignment.Center),
                text = titleText,
                textAlign = TextAlign.Center
            )
        }

    }

}


@Composable
fun TopTitleImg(
    backClicked: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 5.dp,
        shape = RectangleShape
    ) {
        Box {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularIcon(
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .width(35.dp)
                        .height(35.dp),
                    icon = "ic_back_arrow.xml"
                ) {
                    backClicked?.invoke()
                }

            }
            Image(
                modifier = Modifier.width(53.dp)
                    .height(23.dp).align(Alignment.Center),
                painter = painterResource(res = "allen_blue_logo.xml"),
                contentDescription = "logo"
            )
        }
    }

}

//@Composable
//fun TestToolbars() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    ) {
//        ToolbarSearchHome()
//        ToolbarSearch()
//        TopTitle(titleText = "Socio vendedor") {
//
//        }
//        ToolbarTitle(titleText = "Articulo")
//        ToolbarSellerStore()
//    }
//}
//
//@OptIn(ExperimentalMaterialApi::class)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToolbarSearchHome(
    modifier: Modifier = Modifier,
    textPlaceHolder: String = "Buscar",
    menuClicked: (() -> Unit)? = null,
    searchClicked: (() -> Unit)? = null,
    cartClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RectangleShape,
        elevation = 5.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CircularIcon(
                modifier = Modifier.weight(1f),
                onClick = menuClicked,
                icon = "ic_menu_icon.xml"
            )
            SearchOutlinedTextField(
                value = "",
                placeHolder = textPlaceHolder,
                itemClicked = { searchClicked?.invoke() },
                onValueChange = {}
            )
            CircularIcon(
                modifier = Modifier.weight(1f),
                onClick = cartClicked,
                icon = "ic_cart_icon.xml"
            )
        }
    }

}

//
//@Composable
//fun ToolbarSearch(
//    modifier: Modifier = Modifier,
//    backClicked: (() -> Unit)? = null,
//    configClicked: (() -> Unit)? = null,
//    searchClicked: (() -> Unit)? = null
//) {
//    Row(modifier = modifier) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(80.dp)
//                .layoutId("imageMenu"),
//            elevation = 5.dp
//        ) {
//            ConstraintLayout(
//                modifier = Modifier
//                    .fillMaxSize(),
//                constraintSet = ConstraintSet {
//                    val backButton = createRefFor("backButton")
//                    constrain(backButton) {
//                        start.linkTo(parent.start, margin = 10.dp)
//                        top.linkTo(parent.top)
//                        bottom.linkTo(parent.bottom)
//                    }
//                    constrain(createRefFor("search")) {
//                        start.linkTo(backButton.end, margin = 10.dp)
//                        top.linkTo(parent.top)
//                        end.linkTo(parent.end, margin = 10.dp)
//                        bottom.linkTo(parent.bottom)
//                        width = Dimension.fillToConstraints
//                        height = Dimension.wrapContent
//                    }
//                }) {
//                BackButton(
//                    Modifier
//                        .layoutId("backButton")
//                        .width(35.dp)
//                        .height(35.dp)
//                ) {
//                    backClicked?.invoke()
//                }
//                SearcherWithSettings(
//                    modifier = Modifier.layoutId("search"),
//                    value = "",
//                    placeHolder = "Escribe el producto o marca...",
//                    itemClicked = { searchClicked?.invoke() },
//                    settingsClicked = {
//                        configClicked?.invoke()
//                    }
//                )
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun ToolbarTitle(
//    modifier: Modifier = Modifier,
//    titleText: String? = null,
//    @IdRes labelId: Int? = null,
//    backClicked: (() -> Unit)? = null,
//    cartClicked: (() -> Unit)? = null,
//    showEndImage: Boolean = true,
//    firstIcon: Int = R.drawable.ic_back_arrow,
//    endIcon: Int = R.drawable.ic_cart_icon
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(80.dp)
//            .layoutId("imageMenu"),
//        elevation = 5.dp
//    ) {
//        Row(modifier = modifier) {
//            ConstraintLayout(
//                modifier = Modifier
//                    .fillMaxSize(),
//                constraintSet = ConstraintSet {
//                    val imageBack = createRefFor("imageBack")
//                    val title = createRefFor("title")
//                    val imageCart = createRefFor("imageCart")
//                    constrain(imageBack) {
//                        start.linkTo(parent.start, margin = 28.dp)
//                        top.linkTo(parent.top)
//                        bottom.linkTo(parent.bottom)
//                    }
//                    constrain(title) {
//                        start.linkTo(imageBack.end)
//                        top.linkTo(parent.top)
//                        end.linkTo(imageCart.start)
//                        bottom.linkTo(parent.bottom)
//                        width = Dimension.fillToConstraints
//                        height = Dimension.wrapContent
//                    }
//                    constrain(imageCart) {
//                        end.linkTo(parent.end, margin = 28.dp)
//                        top.linkTo(parent.top)
//                        bottom.linkTo(parent.bottom)
//                    }
//                }) {
//                Card(
//                    modifier = Modifier
//                        .width(35.dp)
//                        .height(35.dp)
//                        .layoutId("imageBack"),
//                    elevation = 0.dp,
//                    shape = CircleShape, onClick = { backClicked?.invoke() }) {
//                    Image(
//                        modifier = Modifier.wrapContentSize(),
//                        painter = painterResource(id = firstIcon),
//                        contentDescription = ""
//                    )
//                }
//                SemiBoldText(
//                    modifier = Modifier
//                        .layoutId("title"),
//                    text = titleText ?: stringResource(id = labelId ?: R.string.empty_string),
//                    align = TextAlign.Center
//                )
//                if (showEndImage) {
//                    Card(
//                        modifier = Modifier
//                            .width(35.dp)
//                            .height(35.dp)
//                            .layoutId("imageCart"),
//                        elevation = 0.dp,
//                        shape = CircleShape, onClick = { cartClicked?.invoke() }) {
//                        Image(
//                            modifier = Modifier.wrapContentSize(),
//                            painter = painterResource(id = endIcon),
//                            contentDescription = ""
//                        )
//                    }
//                }
//            }
//
//        }
//    }
//}
//


@Composable
fun ToolbarTitle(
    modifier: Modifier = Modifier,
    titleText: String,
    showStartImage: Boolean = true,
    startClicked: (() -> Unit)? = null,
    endClicked: (() -> Unit)? = null,
    showEndImage: Boolean = true,
    firstIcon: String = "ic_back_arrow.xml",
    endIcon: String = "ic_cart_icon.xml"
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RectangleShape,
        elevation = 5.dp
    ) {
        Box {
            if (showStartImage) {
                CircularIcon(
                    modifier = Modifier.padding(start = 20.dp).align(Alignment.CenterStart),
                    icon = firstIcon
                ) {
                    startClicked?.invoke()
                }
            }
            CircularIcon(
                modifier = Modifier.padding(start = 20.dp).align(Alignment.CenterStart),
                icon = firstIcon
            ) {
                startClicked?.invoke()
            }
            SemiBoldText(
                modifier = Modifier.align(Alignment.Center),
                fontSize = 20.sp,
                text = titleText,
                textAlign = TextAlign.Center
            )
            if (showEndImage) {
                CircularImage(
                    modifier = Modifier.align(Alignment.CenterEnd).padding(end = 20.dp),
                    onClick = endClicked,
                    icon = endIcon
                )
            }
        }
    }
}

//
//@OptIn(ExperimentalMaterialApi::class)
//@Preview
//@Composable
//fun ToolbarSellerStore(
//    modifier: Modifier = Modifier,
//    backClicked: (() -> Unit)? = null,
//    optionClicked: (() -> Unit)? = null,
//    firstIcon: Int = R.drawable.ic_back_arrow,
//    endIcon: Int = R.drawable.ic_dots_options
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(80.dp)
//            .layoutId("imageMenu"),
//        elevation = 5.dp
//    ) {
//        Row(modifier = modifier) {
//            ConstraintLayout(
//                modifier = Modifier
//                    .fillMaxSize(),
//                constraintSet = ConstraintSet {
//                    val imageBack = createRefFor("imageBack")
//                    val selector = createRefFor("selector")
//                    val imageCart = createRefFor("imageCart")
//                    constrain(imageBack) {
//                        start.linkTo(parent.start, margin = 28.dp)
//                        top.linkTo(parent.top)
//                        bottom.linkTo(parent.bottom)
//                    }
//                    constrain(selector) {
//                        start.linkTo(imageBack.end, 55.dp)
//                        top.linkTo(parent.top)
//                        end.linkTo(imageCart.start, 35.dp)
//                        bottom.linkTo(parent.bottom)
//                        width = Dimension.fillToConstraints
//                        height = Dimension.value(46.dp)
//                    }
//                    constrain(imageCart) {
//                        end.linkTo(parent.end, margin = 28.dp)
//                        top.linkTo(parent.top)
//                        bottom.linkTo(parent.bottom)
//                    }
//                }) {
//                Card(
//                    modifier = Modifier
//                        .width(35.dp)
//                        .height(35.dp)
//                        .layoutId("imageBack"),
//                    elevation = 0.dp,
//                    shape = CircleShape, onClick = { backClicked?.invoke() }) {
//                    Image(
//                        modifier = Modifier.wrapContentSize(),
//                        painter = painterResource(id = firstIcon),
//                        contentDescription = ""
//                    )
//                }
//                SelectorStoreSpinner(
//                    modifier = Modifier
//                        .size(35.dp)
//                        .layoutId("selector")
//                )
//                Card(
//                    modifier = Modifier
//                        .width(35.dp)
//                        .height(35.dp)
//                        .layoutId("imageCart"),
//                    elevation = 0.dp,
//                    shape = CircleShape, onClick = { optionClicked?.invoke() }) {
//                    Image(
//                        modifier = Modifier.wrapContentSize(),
//                        painter = painterResource(id = endIcon),
//                        contentDescription = ""
//                    )
//                }
//            }
//
//        }
//    }
//}
