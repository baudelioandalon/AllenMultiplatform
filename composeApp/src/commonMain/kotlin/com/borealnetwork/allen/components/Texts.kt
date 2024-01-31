package com.borealnetwork.allen.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    text: String,
    size: TextUnit = 25.sp,
    color: Color = Color.Black,
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
        fontWeight = Bold,
        textAlign = align,
        overflow = textOverflow,
        maxLines = maxLines,
        fontFamily = val fontFamilyExtraBold: FontFamily = fontFamilyResource(SharedRes.fonts.PlayfairDisplay.extraBold)
    )
}