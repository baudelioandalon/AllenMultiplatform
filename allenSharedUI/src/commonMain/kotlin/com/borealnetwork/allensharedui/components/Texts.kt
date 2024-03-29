package com.borealnetwork.allensharedui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.borealnetwork.allensharedui.theme.GrayLetterSeeAll
import com.borealnetwork.allensharedui.theme.boldTypo
import com.borealnetwork.allensharedui.theme.lightTypo
import com.borealnetwork.allensharedui.theme.mediumTypo
import com.borealnetwork.allensharedui.theme.regularTypo
import com.borealnetwork.allensharedui.theme.semiBoldTypo


@Composable
fun SemiBoldText(
    modifier: Modifier = Modifier,
    text: String,
    letterSpacing: TextUnit = 0.sp,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    fontSize: TextUnit = 18.sp,
    lineHeight: TextUnit = 14.sp,
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1
) {

    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        letterSpacing = letterSpacing,
        color = color,
        fontWeight = SemiBold,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = textOverflow,
        maxLines = maxLines,
        minLines = minLines,
        fontFamily = semiBoldTypo()
    )
}

@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    text: String,
    letterSpacing: TextUnit = 0.sp,
    fontSize: TextUnit = 25.sp,
    color: Color = Color.White,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = 14.sp,
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    softWrap: Boolean = true,
    onClicked: (() -> Unit)? = null
) {
    Text(
        modifier = if (onClicked != null) modifier.clickable { onClicked.invoke() } else modifier,
        text = text,
        fontSize = fontSize,
        color = color,
        letterSpacing = letterSpacing,
        textAlign = textAlign,
        lineHeight = lineHeight,
        minLines = minLines,
        overflow = textOverflow,
        softWrap = softWrap,
        maxLines = maxLines,
        fontFamily = boldTypo()
    )
}

@Composable
fun MediumText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    letterSpacing: TextUnit = 0.sp,
    fontSize: TextUnit = 20.sp,
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        letterSpacing = letterSpacing,
        color = color,
        fontWeight = Medium,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        fontFamily = mediumTypo()
    )
}


@Composable
fun MediumTextBold(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 20.sp,
    color: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = color,
        letterSpacing = 0.sp,
        fontWeight = Bold,
        textAlign = textAlign,
        fontFamily = mediumTypo()
    )
}


@Composable
fun RegularText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 15.sp,
    color: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = fontSize,
        color = color,
        fontWeight = Normal,
        textAlign = textAlign,
        fontFamily = regularTypo()
    )
}

@Composable
fun LightText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 15.sp,
    color: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = fontSize,
        color = color,
        fontWeight = Normal,
        textAlign = textAlign,
        fontFamily = lightTypo()
    )
}

@Composable
fun SmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = GrayLetterSeeAll,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = 12.sp,
        color = color,
        letterSpacing = 0.sp,
        fontWeight = Bold,
        textAlign = textAlign,
        fontFamily = regularTypo()
    )
}