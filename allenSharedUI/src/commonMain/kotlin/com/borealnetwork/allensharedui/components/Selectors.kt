package com.borealnetwork.allensharedui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allensharedui.theme.GrayBackgroundSearch
import com.borealnetwork.allensharedui.theme.GrayBackgroundSelector
import com.borealnetwork.allensharedui.theme.GrayBorder
import com.borealnetwork.allensharedui.theme.GrayBorderLight
import com.borealnetwork.allensharedui.theme.GrayBorderThin
import com.borealnetwork.allensharedui.theme.GrayHomeSellerLetter
import com.borealnetwork.allensharedui.theme.GrayLetterArrow
import com.borealnetwork.allensharedui.theme.GrayLetterHint
import com.borealnetwork.allensharedui.theme.GrayMedium
import com.borealnetwork.allensharedui.theme.GraySelector
import com.borealnetwork.allensharedui.theme.GraySinceTo
import com.borealnetwork.allensharedui.theme.GreenStrong
import com.borealnetwork.allensharedui.theme.robotoMediumTypo
import com.borealnetwork.shared.domain.models.product.AttributeProductModel
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

//@Preview(showBackground = true)
@Composable
fun TestSelectors() {
    Column(modifier = Modifier.fillMaxSize()) {
        SelectorCounter()
        SelectorDetail(
            text = "Detalles del producto",
            iconRes = "ic_detail_icon.xml"
        )
        ShippingSelector()
        AddressSelector()
        ResumeSelector()
        SelectorSpinner()
        SelectorStoreSpinner()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectorCounter(
    quantity: Int = 1,
    lessClicked: (() -> Unit)? = null,
    moreClicked: (() -> Unit)? = null
) {
    Row(modifier = Modifier.wrapContentSize()) {
        Surface(
            modifier = Modifier
                .size(35.dp),
            color = White,
            border = BorderStroke(
                width = 1.dp,
                color = GreenStrong
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = { lessClicked?.invoke() }
        ) {
            Icon(
                modifier = Modifier.padding(13.dp),
                painter = painterResource(resource = DrawableResource("ic_less_icon.xml")),
                contentDescription = "less_icon",
                tint = GreenStrong
            )
        }
        SemiBoldText(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = "$quantity", fontSize = 25.sp
        )
        Surface(
            modifier = Modifier
                .size(35.dp),
            color = GreenStrong,
            shape = RoundedCornerShape(5.dp),
            onClick = { moreClicked?.invoke() }
        ) {
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
fun ShippingSelector(
    modifier: Modifier = Modifier, shipping: Boolean = false,
    onClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        border = if (shipping) BorderStroke(1.dp, MaterialTheme.colors.primary) else null,
        backgroundColor = if (shipping) White else GraySelector,
        onClick = {
            onClicked?.invoke()
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(end = 13.dp),
                painter = painterResource(resource = DrawableResource(if (shipping) "ic_house.xml" else "ic_walking.xml")),
                contentDescription = "hide shipping options",
                tint = if (shipping) MaterialTheme.colors.primary else GrayMedium
            )
            MediumText(
                text = if (shipping) "Enviar a \ndomicilio" else "Recolectar",
                textAlign = TextAlign.Center,
                color = if (shipping) MaterialTheme.colors.primary else GrayMedium,
                fontSize = 15.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddressSelector(
    modifier: Modifier = Modifier,
    textTop: String = "Recibe",
    textBottom: String = "Calle #22, Colonia Test, Ciudad, Estado 000ddd00",
    iconRes: String = "ic_location.xml",
    selected: Boolean = false,
    onClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, if (selected) MaterialTheme.colors.primary else GrayBorderThin),
        backgroundColor = White,
        onClick = {
            onClicked?.invoke()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(end = 13.dp, start = 16.dp),
                painter = painterResource(resource = DrawableResource(iconRes)),
                contentDescription = "hide shipping options",
                tint = if (selected) MaterialTheme.colors.primary else GraySinceTo
            )
            Column {
                MediumText(
                    text = textTop,
                    color = GraySinceTo,
                    fontSize = 15.sp
                )
                MediumText(
                    modifier = Modifier
                        .width(180.dp)
                        .wrapContentHeight(),
                    text = textBottom,
                    textAlign = TextAlign.Center,
                    color = GrayMedium,
                    fontSize = 15.sp,
                    textOverflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(end = 15.dp),
                painter = painterResource(resource = DrawableResource("ic_selector_right.xml")),
                contentDescription = "right selector"
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PaymentMethodSelector(
    modifier: Modifier = Modifier,
    text: String = "Contra entrega\nen efectivo",
    iconRes: String = "cash_symbol.xml",
    selected: Boolean = false,
    onClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, if (selected) MaterialTheme.colors.primary else GrayBorderThin),
        backgroundColor = White,
        onClick = {
            onClicked?.invoke()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 13.dp, start = 16.dp)
                    .size(20.dp),
                painter = painterResource(resource = DrawableResource(iconRes)),
                contentDescription = "hide shipping options",
                tint = if (selected) MaterialTheme.colors.primary else GraySinceTo
            )
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MediumText(
                    text = text,
                    color = GraySinceTo,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
            }
            Image(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(end = 15.dp),
                painter = painterResource(resource = DrawableResource("ic_check.xml")),
                contentDescription = "right selector"
            )
        }
    }
}

@Composable
fun ResumeSelector(
    modifier: Modifier = Modifier,
    textTop: String = "Recibe",
    textBottom: String = "Calle #22, Colonia Test, Ciudad, Estado 000ddd00",
    lineBottom: Boolean = true,
    onClicked: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(White)
            .clickable { onClicked?.invoke() },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                MediumText(
                    modifier = Modifier.padding(top = 5.dp),
                    text = textTop,
                    color = GraySinceTo,
                    fontSize = 15.sp
                )
                BoldText(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(),
                    text = textBottom,
                    textAlign = TextAlign.Center,
                    color = GrayMedium,
                    fontSize = 18.sp,
                    textOverflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.weight(1f))

        }
        if (lineBottom) {
            Divider(
                color = GrayBorderLight,
                thickness = 1.dp
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewAddressSelector(
    modifier: Modifier = Modifier,
    onClicked: (() -> Unit)? = null
) {

    val stroke = Stroke(
        width = 10f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(35f, 35f), 0f)
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp), contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRoundRect(
                color = GrayBorderThin, style = stroke,
                cornerRadius = CornerRadius(10.dp.toPx())
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp),
            backgroundColor = White,
            onClick = {
                onClicked?.invoke()
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(end = 13.dp, start = 16.dp),
                    painter = painterResource(resource = DrawableResource("ic_more_icon.xml")),
                    contentDescription = "hide shipping options",
                    tint = GraySinceTo
                )
                MediumText(
                    text = "Nueva dirección",
                    color = GraySinceTo,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(end = 15.dp),
                    painter = painterResource(resource = DrawableResource("ic_selector_right.xml")),
                    contentDescription = "right selector"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewCouponSelector(
    modifier: Modifier = Modifier,
    onClicked: (() -> Unit)? = null
) {

    val stroke = Stroke(
        width = 10f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(35f, 35f), 0f)
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp), contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRoundRect(
                color = GrayBorderThin, style = stroke,
                cornerRadius = CornerRadius(10.dp.toPx())
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp),
            backgroundColor = White,
            onClick = {
                onClicked?.invoke()
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.padding(end = 13.dp, start = 16.dp),
                    painter = painterResource(resource = DrawableResource("ic_coupon.xml")),
                    contentDescription = "coupon",
                )
                MediumText(
                    text = "Nuevo cupón",
                    color = GraySinceTo,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.weight(1f))
                MinimumAddButton(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(end = 15.dp),
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BussinessImageSelector(
    modifier: Modifier = Modifier,
    onClicked: (() -> Unit)? = null
) {

    val stroke = Stroke(
        width = 5f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(25f, 25f), 0f)
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(240.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRoundRect(
                color = GrayHomeSellerLetter, style = stroke,
                cornerRadius = CornerRadius(20.dp.toPx())
            )
        }
        Card(
            modifier = Modifier
                .fillMaxSize(),
            elevation = 0.dp,
            shape = RoundedCornerShape(20.dp),
            backgroundColor = White,
            onClick = {
                onClicked?.invoke()
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(resource = DrawableResource("ic_more_icon.xml")),
                    contentDescription = "hide shipping options",
                    tint = GraySinceTo
                )
                BoldText(
                    modifier = Modifier.padding(top = 10.dp),
                    text = "Logotipo",
                    color = GrayBorder,
                    fontSize = 25.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColorSelector(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClicked: (() -> Unit)? = null
) {

    Column(
        modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 30.dp)
            .wrapContentWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val stroke = Stroke(
            width = 10f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 15f), 0f)
        )

        Box(
            modifier = modifier
                .size(35.dp), contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRoundRect(
                    color = GrayHomeSellerLetter, style = stroke,
                    cornerRadius = CornerRadius(10.dp.toPx())
                )
            }
            Card(
                modifier = Modifier
                    .size(35.dp),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                backgroundColor = White,
                onClick = {
                    onClicked?.invoke()
                }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(resource = DrawableResource("ic_more_icon.xml")),
                        contentDescription = "hide shipping options",
                        tint = GraySinceTo
                    )

                }
            }
        }
        BoldText(
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 10.sp,
            text = text ?: "Cambiar"
        )
    }


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserSelector(
    modifier: Modifier = Modifier,
    text: String = "Yo",
    onClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, GrayBorderThin),
        backgroundColor = White,
        onClick = {
            onClicked?.invoke()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(end = 13.dp, start = 16.dp),
                painter = painterResource(resource = DrawableResource("ic_user.xml")),
                contentDescription = "hide shipping options",
                tint = GraySinceTo
            )
            Column {
                MediumText(
                    text = "Quien recibe",
                    color = GraySinceTo,
                    fontSize = 15.sp
                )
                MediumText(
                    text = text,
                    textAlign = TextAlign.Center,
                    color = GrayMedium,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(end = 15.dp),
                painter = painterResource(resource = DrawableResource("ic_selector_right.xml")),
                contentDescription = "right selector"
            )
        }
    }
}

@Composable
fun <T> Spinner(
    modifier: Modifier = Modifier,
    dropDownModifier: Modifier = Modifier,
    items: List<T>,
    selectedItem: T,
    onItemSelected: (T) -> Unit,
    selectedItemFactory: @Composable (Modifier, T) -> Unit,
    dropdownItemFactory: @Composable (T, Int) -> Unit,
) {
    val expanded = remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxWidth()) {
        selectedItemFactory(
            Modifier
                .clickable { expanded.value = true },
            selectedItem
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = dropDownModifier.fillMaxWidth()
        ) {
            items.forEachIndexed { index, element ->
                DropdownMenuItem(onClick = {
                    onItemSelected(items[index])
                    expanded.value = false
                }) {
                    dropdownItemFactory(element, index)
                }
            }
        }
    }
}

@Composable
fun SelectorSpinner(
    modifier: Modifier = Modifier,
    topLabelText: String = "",
    spinnerText: String = "Seleccione una opcion",
    list: List<String> = listOf("Seleccione una opcion", "Data 1", "Data 2")
) {

    Column(modifier = modifier) {

        if (topLabelText.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(bottom = 9.dp),
                text = topLabelText,
                color = Black,
                fontSize = 15.sp,
                fontFamily = robotoMediumTypo()
            )
        }

        Spinner(
            modifier = Modifier.wrapContentSize(),
            dropDownModifier = Modifier.wrapContentSize(),
            items = list,
            selectedItem = spinnerText,
            onItemSelected = {},
            selectedItemFactory = { modifierContainer, item ->
                Card(
                    modifier = modifierContainer
                        .fillMaxWidth()
                        .height(60.dp),
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = GraySelector
                ) {
                    Row(
                        modifier = modifierContainer
                            .padding(start = 16.dp, end = 20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MediumText(
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
    }

}

@Composable
fun SelectorStoreSpinner(
    modifier: Modifier = Modifier,
    list: List<String> = listOf("Fluvial Vallarta", "Data 1", "Data 2")
) {
    Spinner(
        modifier = modifier.wrapContentSize(),
        dropDownModifier = Modifier.wrapContentSize(),
        items = list,
        selectedItem = list.first(),
        onItemSelected = {},
        selectedItemFactory = { modifierContainer, item ->
            Card(
                modifier = modifierContainer
                    .fillMaxWidth()
                    .height(60.dp),
                elevation = 0.dp,
                shape = RoundedCornerShape(30.dp),
                backgroundColor = GrayBackgroundSearch
            ) {
                Row(
                    modifier = modifierContainer
                        .padding(start = 16.dp, end = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(resource = DrawableResource("ic_dot")),
                        contentDescription = "status store",
                        tint = GreenStrong
                    )
                    MediumText(
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
}

@Composable
fun SelectorDetail(
    modifier: Modifier = Modifier, text: String = "",
    iconRes: String,
    onClicked: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(White)
            .padding(horizontal = 30.dp)
            .clickable { onClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(resource = DrawableResource(iconRes)),
            contentDescription = "comment icon"
        )
        BoldText(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = text, fontSize = 13.sp,
            color = Black
        )
        Icon(
            modifier = Modifier
                .rotate(180f)
                .width(21.dp)
                .height(12.dp),
            tint = GrayLetterArrow,
            painter = painterResource(resource = DrawableResource("ic_right_arrow_simbol.xml")),
            contentDescription = "comment icon"
        )
    }
}

@Composable
fun SelectorWithRadioButton(
    modifier: Modifier = Modifier,
    iconRes: String = "",
    text: String,
    iconDescription: String? = null,
    selected: Boolean,
    onClicked: ((String) -> Unit)? = null
) {
    Box(
        modifier = modifier.background(
            color = GrayBackgroundSelector,
            shape = RoundedCornerShape(5.dp)
        ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().requiredHeight(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.padding(horizontal = 20.dp),
                painter = painterResource(resource = DrawableResource(iconRes)),
                contentDescription = iconDescription
            )
            SemiBoldText(
                modifier = Modifier.weight(1f),
                text = text,
                fontSize = 15.sp,
                textAlign = TextAlign.Justify
            )
            RadioButton(
                modifier = Modifier.padding(start = 15.dp),
                selected = selected,
                onClick = {
                    onClicked?.invoke(iconDescription.orEmpty())
                },
                colors = RadioButtonDefaults.colors(
                    unselectedColor = GrayLetterHint,
                    selectedColor = MaterialTheme.colors.primary
                )
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VariantsViewerSelector(
    modifier: Modifier = Modifier,
    list: List<AttributeProductModel>,
    actualPosition: Int,
    variantSelected: (String) -> Unit
) {
    val itemResult by rememberSaveable{ mutableStateOf(list.map { it.options[actualPosition] }.toMutableList()) }
    FlowColumn(modifier = modifier) {
        list.forEachIndexed { index, item ->
            VariantSelectorItem(
                attributeProductModel = item,
            ) { child ->
                itemResult[index] = child
                variantSelected(itemResult.joinToString(separator = "-"))
            }
        }
    }
}

@Composable
fun VariantSelectorItem(
    attributeProductModel: AttributeProductModel,
    variantSelected: (String) -> Unit
) {
    var itemSelected by rememberSaveable { mutableStateOf(attributeProductModel.options.first()) }
    Row(
        modifier = Modifier
            .fillMaxWidth().wrapContentHeight()
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        RegularText(
            modifier = Modifier.padding(start = 30.dp, end = 5.dp).wrapContentHeight(),
            text = "${attributeProductModel.name}:",
            fontSize = 14.sp
        )
        BoldText(
            text = itemSelected,
            fontSize = 14.sp,
            color = Black
        )
    }

    HorizontalImageViewer(
        modifier = Modifier.padding(bottom = 15.dp),
        bottomText = true,
        showIcon = true,
        itemList = attributeProductModel.options,
        itemClicked = { index, item ->
            itemSelected = item
            variantSelected.invoke(item)
        }
    )

}