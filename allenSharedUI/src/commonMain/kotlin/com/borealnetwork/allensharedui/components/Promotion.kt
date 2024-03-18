package com.borealnetwork.allensharedui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allensharedui.components.currency.CurrencyInDiscountItem
import com.borealnetwork.allensharedui.theme.GreenStrong
import com.borealnetwork.allensharedui.theme.GreenTransparent
import com.borealnetwork.allensharedui.theme.OrangeMedium
import com.borealnetwork.allensharedui.theme.OrangeTransparent
import com.borealnetwork.allensharedui.theme.StarColor
import com.borealnetwork.shared.tools.discount
import com.borealnetwork.shared.tools.round
import com.borealnetwork.shared.tools.rounded
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun FreeShipping(modifier: Modifier = Modifier, unbounded: Boolean = false) {
    Row(
        modifier = modifier
            .background(
                color = GreenStrong,
                shape = RoundedCornerShape(5.dp)
            )
            .wrapContentSize(unbounded = unbounded),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoldText(
            modifier = Modifier
                .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
                .fillMaxWidth(0.7f),
            text = "Envio gratis",
            fontSize = 10.sp,
            color = White
        )
        Icon(
            modifier = Modifier.requiredSize(20.dp).padding(start = 4.dp, end = 10.dp),
            painter = painterResource(resource = DrawableResource("ic_thunder_icon.xml")),
            contentDescription = "free shipping",
            tint = StarColor
        )
    }
}

@Composable
fun StatusStore(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(
                color = GreenStrong,
                shape = RoundedCornerShape(20.dp)
            )
            .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoldText(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .wrapContentSize(),
            text = "Abierto",
            fontSize = 10.sp,
            color = White
        )
    }
}

@Composable
fun Discount(modifier: Modifier = Modifier, discount: Int = 15) {
    BoldText(
        modifier = modifier
            .padding(top = 5.dp, bottom = 5.dp)
            .wrapContentSize()
            .background(
                color = GreenStrong,
                shape = RoundedCornerShape(corner = CornerSize(15.dp))
            ),
        text = "   $discount%   ",
        fontSize = 12.sp,
        color = White
    )
}


@Composable
fun PriceBeforeDiscount(
    modifier: Modifier = Modifier,
    currency: String,
    price: Double = 50.0
) {

    Box(modifier = modifier) {
        CurrencyInDiscountItem(
            modifier = Modifier.align(Alignment.CenterStart),
            currency = currency
        ) {
            BoldText(
                text = "$${price.round().rounded()}",
                color = OrangeTransparent,
                fontSize = 12.sp,
                maxLines = 1,
                textOverflow = TextOverflow.Ellipsis
            )
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
        ) {
            var yCord = 0f
            drawLine(
                OrangeMedium,
                Offset(0f, yCord),
                Offset(size.width, yCord),
                strokeWidth = 3f
            )
            yCord += 1.8f * 15.toDp().toPx()
        }

    }
}

@Composable
fun PriceWithDiscount(
    modifier: Modifier = Modifier,
    price: Double = 504.32786,
    discount: Int = 16,
    currency: String
) {
    Box(
        modifier = modifier.wrapContentSize().fillMaxWidth()
    ) {
        PriceBeforeDiscount(
            modifier = Modifier.wrapContentWidth().align(alignment = Alignment.CenterStart),
            currency,
            price = price
        )
        Row(
            modifier = Modifier.wrapContentSize()
                .align(alignment = Alignment.CenterEnd),
            verticalAlignment = Alignment.Bottom
        ) {
            LightText(
                modifier = Modifier.wrapContentWidth().padding(end = 2.dp),
                text = currency, fontSize = 10.sp,
                color = Color.Black
            )
            BoldText(
                modifier = Modifier.wrapContentWidth(),
                text = "$${price.discount(discount).round()}",
                fontSize = 16.sp,
                color = Color.Black,
                textOverflow = TextOverflow.Visible
            )
        }
    }
}

@Composable
fun Selector(
    modifier: Modifier = Modifier,
    text: String = "",
    backgroundColor: Color = GreenTransparent,
    textColor: Color = GreenStrong,
    roundDp: Dp = 10.dp,
    onClicked: (() -> Unit)? = {}
) {
    Row(
        modifier = if (onClicked != null) {
            modifier
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(roundDp)
                )
                .wrapContentSize()
                .clickable { onClicked() }
        } else {
            modifier
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(roundDp)
                )
                .wrapContentSize()
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        SemiBoldText(
            modifier = Modifier
                .padding(start = 17.dp, end = 17.dp, top = 5.dp, bottom = 5.dp)
                .wrapContentSize(),
            text = text,
            fontSize = 13.sp,
            color = textColor
        )
    }
}

