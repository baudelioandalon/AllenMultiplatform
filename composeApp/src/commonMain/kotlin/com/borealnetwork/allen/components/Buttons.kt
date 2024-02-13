package com.borealnetwork.allen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.extensions.drawColoredShadow
import com.borealnetwork.allen.theme.BlueTransparent
import com.borealnetwork.allen.theme.FavoriteSelectedColor
import com.borealnetwork.allen.theme.FavoriteUnselectedColor
import com.borealnetwork.allen.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allen.theme.GrayBorder
import com.borealnetwork.allen.theme.GreenStrong
import com.borealnetwork.allen.theme.GreenTransparent
import com.borealnetwork.allen.theme.StarColor
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteButton(modifier: Modifier = Modifier, clicked: (() -> Unit)? = null) {
    Card(modifier = modifier.layoutId("favorite_selector").size(35.dp),
        elevation = 0.dp,
        shape = CircleShape,
        onClick = { clicked?.invoke() }) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(res = "ic_favorite_unselected.xml"),
            contentDescription = ""
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteCounterButton(
    modifier: Modifier = Modifier,
    amount: Int = 0, clicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .layoutId("favorite_selector")
            .height(35.dp)
            .wrapContentWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = FavoriteUnselectedColor,
        onClick = { clicked?.invoke() }) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.size(35.dp),
                painter = painterResource(res = "ic_favorite_unselected.xml"),
                contentDescription = ""
            )
            BoldText(
                modifier = Modifier
                    .padding(end = 13.dp)
                    .wrapContentWidth(),
                text = "$amount",
                color = FavoriteSelectedColor,
                fontSize = 12.sp,
                textAlign = TextAlign.Start
            )
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShareButton(modifier: Modifier = Modifier, clicked: (() -> Unit)? = null) {
    Card(
        modifier = modifier
            .layoutId("share_selector")
            .size(35.dp),
        elevation = 0.dp,
        shape = CircleShape, onClick = { clicked?.invoke() }) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource("ic_share_icon.xml"),
            contentDescription = ""
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RightRoundedButton(modifier: Modifier = Modifier, clicked: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .size(52.dp)
            .padding(bottom = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = modifier
                .layoutId("rounded_selector")
                .size(40.dp),
            elevation = 0.dp,
            shape = CircleShape, onClick = { clicked?.invoke() }) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource("ic_rounded_arrow_right.xml"),
                contentDescription = ""
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GrayButton(
    modifier: Modifier = Modifier,
    text: String = "Calificar",
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .wrapContentWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = GrayBackgroundDrawerDismiss,
        onClick = { onClick?.invoke() }
    ) {
        Row(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)) {
            SemiBoldText(
                modifier = Modifier.fillMaxWidth(),
                text = text,
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MinimumAddButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .drawColoredShadow(
                color = GreenTransparent, alpha = 1f, borderRadius = 10.dp,
                offsetY = 3.dp, offsetX = 3.dp, blurRadius = 10.dp
            )
            .size(30.dp),
        backgroundColor = GreenStrong,
        shape = RoundedCornerShape(3.dp),
        onClick = {
            onClick?.invoke()
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(13.dp),
                painter = painterResource(res = "ic_more_icon.xml"),
                contentDescription = "moreIcon",
                tint = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LittleAddButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .drawColoredShadow(
                color = GreenTransparent, alpha = 1f, borderRadius = 10.dp,
                offsetY = 3.dp, offsetX = 3.dp, blurRadius = 10.dp
            )
            .size(40.dp),
        backgroundColor = GreenStrong,
        shape = RoundedCornerShape(3.dp),
        onClick = {
            onClick?.invoke()
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(res = "ic_more_icon.xml"),
                contentDescription = "moreIcon",
                tint = Color.White
            )
        }
    }
}

@Composable
fun ShadowButton(
    modifier: Modifier = Modifier,
    text: String = "Agregar al carrito",
//    @StringRes labelId: Int? = null,
    size: TextUnit = 20.sp,
    onClick: (() -> Unit)? = null
) {
    BlueButton(
        modifier = modifier
            .drawColoredShadow(
                color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
            ),
        fontSize = size,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        borderRadius = 10.dp
    ) {
        onClick?.invoke()
    }
}

@Composable
fun StarRatingSelector(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .clickable { }
                .size(30.dp),
            painter = painterResource("ic_star_icon.xml"),
            contentDescription = "star one",
            tint = StarColor
        )
        Icon(
            modifier = Modifier
                .padding(horizontal = 2.dp)
                .clickable { }
                .size(30.dp),
            painter = painterResource("ic_star_icon.xml"),
            contentDescription = "star two",
            tint = StarColor
        )
        Icon(
            modifier = Modifier
                .padding(horizontal = 2.dp)
                .clickable { }
                .size(30.dp),
            painter = painterResource("ic_star_icon.xml"),
            contentDescription = "star three",
            tint = StarColor
        )
        Icon(
            modifier = Modifier
                .padding(horizontal = 2.dp)
                .clickable { }
                .size(30.dp),
            painter = painterResource("ic_star_icon.xml"),
            contentDescription = "star four",
            tint = StarColor
        )
        Icon(
            modifier = Modifier
                .padding(start = 2.dp)
                .clickable { }
                .size(30.dp),
            painter = painterResource("ic_star_icon.xml"),
            contentDescription = "star five",
            tint = StarColor
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .width(35.dp)
            .height(35.dp),
        elevation = 0.dp,
        shape = CircleShape, onClick = { onClick?.invoke() }) {
        Image(
            modifier = Modifier.wrapContentSize(),
            painter = painterResource("ic_back_arrow.xml"),
            contentDescription = ""
        )
    }
}

@Composable
fun BlueButton(
    modifier: Modifier = Modifier,
    text: String,
    borderRadius: Dp = 5.dp,
    fontSize: TextUnit = 15.sp,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        enabled = enabled,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 5.dp,
            disabledElevation = 0.dp
        ),
        shape = RoundedCornerShape(corner = CornerSize(borderRadius)),
        onClick = { onClick?.invoke() },
    ) {
        SemiBoldText(
            text = text,
            fontSize = fontSize,
            color = Color.White,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CornerButton(
    modifier: Modifier = Modifier,
    text: String,//? = null,
//    @StringRes labelId: Int? = null,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth(), elevation = 0.dp,
        border = BorderStroke(1.dp, GrayBorder)
    ) {
        Button(
            modifier = Modifier
                .background(color = Color.White)
                .height(54.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 5.dp,
                disabledElevation = 0.dp
            ),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            onClick = { onClick?.invoke() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            SemiBoldText(
                text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
                fontSize = 15.sp,
                color = Color.Black,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CornerImgButton(
    modifier: Modifier = Modifier,
    text: String,
    imgRes: String = "ic_google_logo.xml",
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth(), elevation = 0.dp,
        border = BorderStroke(1.dp, GrayBorder)
    ) {
        Button(
            modifier = Modifier
                .background(color = Color.White)
                .height(54.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 5.dp,
                disabledElevation = 0.dp
            ),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            onClick = { onClick?.invoke() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(res = imgRes),
                    contentDescription = "Login"
                )
                SemiBoldText(
                    text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
                    fontSize = 15.sp,
                    color = Color.Black,
                    letterSpacing = 0.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun ScannerButton(
    modifier: Modifier = Modifier,
    text: String,//? = null,
//    @StringRes labelId: Int? = null,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth(), elevation = 0.dp,
        border = BorderStroke(1.dp, MaterialTheme.colors.primary)
    ) {
        Button(
            modifier = Modifier
                .background(color = Color.White)
                .height(54.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 5.dp,
                disabledElevation = 0.dp
            ),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            onClick = { onClick?.invoke() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.padding(end = 10.dp),
                    painter = painterResource("bar_code.xml"),
                    contentDescription = "bar code"
                )
                Text(
                    text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
                    fontSize = 15.sp,
                    color = MaterialTheme.colors.primary,
                    fontWeight = SemiBold,
                    letterSpacing = 0.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = MaterialTheme.typography.caption.fontFamily
                )
                Icon(
                    modifier = Modifier.padding(start = 10.dp),
                    painter = painterResource("qr_code.xml"),
                    contentDescription = "qr code"
                )
            }
        }
    }
}