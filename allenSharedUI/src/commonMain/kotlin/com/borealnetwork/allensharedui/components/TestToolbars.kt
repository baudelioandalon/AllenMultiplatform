package com.borealnetwork.allensharedui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun ToolbarImg(
    startIcon: String = "ic_back_arrow.xml",
    startClicked: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth().height(110.dp),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.primary,
        shape = RectangleShape
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(30.dp)
                    .background(MaterialTheme.colors.primary)
            )
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularIcon(
                    modifier = Modifier.padding(start = 10.dp)
                        .align(Alignment.CenterStart),
                    icon = startIcon
                ) {
                    startClicked?.invoke()
                }
                Icon(
                    modifier = Modifier.width(53.dp)
                        .height(23.dp).align(Alignment.Center),
                    painter = painterResource(resource = DrawableResource("allen_blue_logo.xml")),
                    contentDescription = "logo",
                    tint = White
                )
            }
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
    startIconTint: Color = White,
    startIcon: String = "ic_menu_icon.xml",
    startClicked: (() -> Unit)? = null,
    searchClicked: (() -> Unit)? = null,
    cartClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RectangleShape,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(30.dp)
                    .background(MaterialTheme.colors.primary)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                CircularIcon(
                    modifier = Modifier.weight(1f),
                    onClick = startClicked,
                    icon = startIcon,
                    iconTint = startIconTint
                )
                SearchOutlinedTextField(
                    value = "",
                    placeHolder = textPlaceHolder,
                    itemClicked = { searchClicked?.invoke() },
                    onValueChange = {}
                )
                CircularIcon(
                    modifier = Modifier.weight(1f),
                    iconTint = White,
                    onClick = cartClicked,
                    icon = "ic_cart_icon.xml"
                )
            }
        }
    }

}

//
@Composable
fun ToolbarSearch(
    modifier: Modifier = Modifier,
    backClicked: (() -> Unit)? = null,
    endClicked: (() -> Unit)? = null,
    searchClicked: (() -> Unit)? = null,
    settingsClicked: (() -> Unit)? = null
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RectangleShape,
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(30.dp)
                    .background(MaterialTheme.colors.primary)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                CircularIcon(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(35.dp),
                    iconTint = White,
                    icon = "ic_back_arrow.xml"
                ) {
                    backClicked?.invoke()
                }
                SearcherWithSettings(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    value = "",
                    placeHolder = "Escribe el producto o marca...",
                    itemClicked = { searchClicked?.invoke() },
                    settingsClicked = {
                        settingsClicked?.invoke()
                    }
                )
            }


        }
    }
}
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
    startIcon: String = "ic_back_arrow.xml",
    endIconTint: Color? = White,
    endIcon: String = "ic_cart_icon.xml"
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RectangleShape,
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(30.dp)
                    .background(MaterialTheme.colors.primary)
            )
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                if (showStartImage) {
                    CircularIcon(
                        modifier = Modifier.padding(start = 10.dp)
                            .align(Alignment.CenterStart),
                        icon = startIcon
                    ) {
                        startClicked?.invoke()
                    }
                }
                SemiBoldText(
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 20.sp,
                    text = titleText,
                    color = White,
                    textAlign = TextAlign.Center
                )
                if (showEndImage) {
                    CircularImage(
                        modifier = Modifier.align(Alignment.CenterEnd).padding(end = 5.dp),
                        onClick = endClicked,
                        iconTint = if (endIconTint != null) ColorFilter.tint(color = endIconTint) else null,
                        icon = endIcon
                    )
                }
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
