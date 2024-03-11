package com.borealnetwork.allen.components.bottom_actions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BlueButton
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.Discount
import com.borealnetwork.allen.components.EditText
import com.borealnetwork.allen.components.MediumText
import com.borealnetwork.allen.components.SemiBoldText
import com.borealnetwork.allen.components.ShadowButton
import com.borealnetwork.allen.components.SmallText
import com.borealnetwork.allen.components.currency.CurrencyInBottomItem
import com.borealnetwork.allen.components.currency.CurrencyInDiscountItem
import com.borealnetwork.allen.components.extensions.DottedShape
import com.borealnetwork.allen.components.extensions.drawColoredShadow
import com.borealnetwork.allen.theme.BlueTransparent
import com.borealnetwork.allen.theme.GrayLetterSeeAll
import com.borealnetwork.allen.theme.GrayLetterShipping
import com.borealnetwork.allen.theme.GraySubtitleBottom
import com.borealnetwork.allen.theme.GreenStrong
import com.borealnetwork.allen.theme.OrangeTransparent
import com.borealnetwork.allen.tools.discount
import com.borealnetwork.allen.tools.round
import com.borealnetwork.allen.tools.rounded

@Composable
fun BottomBuyCartItem(
    modifier: Modifier = Modifier,
    payed: Boolean = false,
    discount: Int,
    price: Double,
    nextClicked: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RectangleShape, elevation = 15.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp).background(Color.White),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 30.dp, end = 30.dp, bottom = 18.dp
                    ),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(top = 15.dp, bottom = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        MediumText(
                            text = "Descuento de tienda", color = GrayLetterSeeAll, fontSize = 13.sp
                        )
                        SemiBoldText(
                            text = "8%", color = GrayLetterShipping, fontSize = 15.sp
                        )
                    }

                    Box(
                        Modifier.height(1.dp).fillMaxWidth()
                            .background(Color.Gray, shape = DottedShape(step = 20.dp))
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        SemiBoldText(
                            modifier = Modifier.weight(1f),
                            text = if (payed) "Pagado" else "Pagar",
                            color = GrayLetterShipping,
                            fontSize = 18.sp
                        )
                        CurrencyInDiscountItem {
                            BoldText(
                                text = "$${price.discount(discount).round().rounded()}",
                                color = OrangeTransparent,
                                fontSize = 12.sp
                            )
                        }
                        CurrencyInBottomItem(modifier = Modifier.padding(start = 21.dp)) {
                            BoldText(
                                text = "$${price.round().rounded()}",
                                color = GreenStrong,
                                fontSize = 30.sp,
                                textAlign = TextAlign.End
                            )

                        }

                    }
                    if (!payed) {
                        BlueButton(
                            modifier = Modifier.padding(bottom = 18.dp, top = 24.dp).fillMaxWidth()
                                .drawColoredShadow(
                                    color = BlueTransparent,
                                    alpha = 1f,
                                    borderRadius = 10.dp,
                                    offsetY = 6.dp,
                                    offsetX = 5.dp,
                                    blurRadius = 10.dp
                                ), text = "Continuar"
                        ) {
                            nextClicked?.invoke()
                        }
                    }

                }
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().height(30.dp)
                .background(Color.White)
        )

    }

}

@Composable
fun BottomContinueItem(
    modifier: Modifier = Modifier,
    textButton: String = "Continuar",
    onClicked: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RectangleShape,
            elevation = 15.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().background(Color.White).padding(
                    top = 10.dp, start = 30.dp, end = 30.dp, bottom = 18.dp
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                BlueButton(
                    modifier = Modifier.padding(bottom = 18.dp, top = 24.dp).fillMaxWidth(),
                    text = textButton
                ) {
                    onClicked?.invoke()
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().height(30.dp)
                .background(Color.White)
        )
    }
}

@Composable
fun BottomEditTextItem(
    modifier: Modifier = Modifier,
    topText: String,
    placeHolderText: String,
    buttonText: String,
    onClicked: ((String) -> Unit)? = null
) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
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
                    .background(Color.White),
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
                    SemiBoldText(
                        text = topText,
                        color = GraySubtitleBottom,
                        fontSize = 18.sp
                    )
                    EditText(
                        modifier = Modifier.padding(bottom = 30.dp, top = 18.dp),
                        placeHolderText = placeHolderText,
                        value = text,
                        onValueChange = { text = it }
                    )
                    ShadowButton(
                        modifier = Modifier
                            .padding(bottom = 18.dp)
                            .fillMaxWidth()
                            .drawColoredShadow(
                                color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                                offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
                            ),
                        text = buttonText,
                        onClick = {
                            onClicked?.invoke(text)
                        }
                    )
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().height(30.dp)
                .background(Color.White)
        )
    }
}


@Composable
fun BottomPriceItem(
    modifier: Modifier = Modifier,
    priceProduct: Double,
    discount: Int = 0,
    textButton: String = "Agregar al carrito",
    onClicked: (() -> Unit)? = null
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
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
                    .background(Color.White),
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
                    Discount(discount = discount)
                    Row(verticalAlignment = Alignment.Bottom) {
                        BoldText(
                            text = "$${priceProduct.discount(discount).round().rounded()}",
                            color = Color.Black
                        )
                        SmallText(
                            modifier = Modifier.padding(
                                start = 10.dp,
                            ), text = "$${priceProduct.round().rounded()}"
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
                    text = textButton,
                    size = 15.sp,
                    onClick = onClicked
                )

            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().height(30.dp)
                .background(Color.White)
        )
    }
}