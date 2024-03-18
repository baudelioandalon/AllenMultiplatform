package com.borealnetwork.allen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allen.tools.cut
import com.borealnetwork.allen.tools.firstItem
import com.borealnetwork.allen.tools.limit

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HorizontalImageViewer(
    modifier: Modifier = Modifier,
    sizeItem: Dp = 53.dp,
    colorSelected: Color = MaterialTheme.colors.primary,
    zoomWhenSelected: Boolean = false,
    itemList: List<String> = listOf("110V", "220V", "110V - 220V", "12V", "24V", "48"),
    itemClicked: ((Int, String) -> Unit)? = null,
    bottomText: Boolean = false
) {
    var selected by rememberSaveable { mutableStateOf(0) }
    LazyRow(
        modifier = modifier.fillMaxWidth()
    ) {
        itemsIndexed(itemList) { index, item ->
            val defaultSize =
                if (selected == index && zoomWhenSelected) sizeItem.plus(8.dp) else sizeItem
            Column(
                modifier = Modifier.width(IntrinsicSize.Max),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val startPadding = if (itemList.firstItem() == index) 30.dp else 0.dp
                val endPadding = if (itemList.limit() == index) 30.dp else 15.dp
                Card(
                    modifier = Modifier.padding(
                        start = startPadding,
                        end = endPadding
                    ).defaultMinSize(defaultSize, defaultSize),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    border = if (index == selected && !zoomWhenSelected) BorderStroke(
                        width = 1.dp,
                        color = colorSelected
                    ) else null,
                    shape = RoundedCornerShape(10.dp),
                    onClick = {
                        selected = index
                        itemClicked?.invoke(index, item)
                    }
                ) {

                }
                if (bottomText) {
                    BoldText(
                        modifier = Modifier.padding(
                            start = startPadding,
                            end = endPadding
                        ).fillMaxWidth(),
                        fontSize = 10.sp,
                        text = item.cut(10),
                        color = Black,
                        textAlign = TextAlign.Center
                    )
                }


            }


        }
    }
}