package com.borealnetwork.allen.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.theme.boldTypo

@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    text: String,
    size: TextUnit = 25.sp,
    color: Color = Color.White,
    align: TextAlign? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    onClicked: (() -> Unit)? = null
) {
    Text(
        modifier = if (onClicked != null) modifier.clickable { onClicked.invoke() } else modifier,
        text = text,
        fontSize = size,
        color = color,
        letterSpacing = 0.sp,
        textAlign = align,
        overflow = textOverflow,
        maxLines = maxLines,
        fontFamily = boldTypo()
    )
}