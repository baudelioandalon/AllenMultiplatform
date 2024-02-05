package com.borealnetwork.allen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
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
import com.borealnetwork.allen.theme.GrayLetterSeeAll
import com.borealnetwork.allen.theme.boldTypo
import com.borealnetwork.allen.theme.regularTypo


@Composable
fun SemiBoldText(
    modifier: Modifier = Modifier,
    text: String,
    letterSpacing: TextUnit = 0.sp,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    fontSize: TextUnit = 18.sp,
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE
) {

    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        letterSpacing = letterSpacing,
        color = color,
        fontWeight = SemiBold,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        fontFamily = regularTypo()
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
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    onClicked: (() -> Unit)? = null
) {
    Text(
        modifier = if (onClicked != null) modifier.clickable { onClicked.invoke() } else modifier,
        text = text,
        fontSize = fontSize,
        color = color,
        letterSpacing = letterSpacing,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        fontFamily = boldTypo()
    )
}


@Composable
fun LargeText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = text,
        fontSize = 30.sp,
        color = color,
        fontWeight = Bold,
        textAlign = textAlign
    )
}

@Composable
fun MediumText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    fontSize: TextUnit = 20.sp,
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        letterSpacing = 0.sp,
        color = color,
        fontWeight = Medium,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        fontFamily = regularTypo()
    )
}


@Composable
fun MediumTextBold(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = 20.sp,
        color = color,
        letterSpacing = 0.sp,
        fontWeight = Bold,
        textAlign = textAlign,
        fontFamily = regularTypo()
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
fun SmallText(
    modifier: Modifier = Modifier,
    text: String,//? = null,
//    labelId: Int? = null,
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

@Composable
fun SeeAll(
    modifier: Modifier = Modifier,
    text: String,//? = null,
//    labelId: Int? = null,
    color: Color = GrayLetterSeeAll,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = 18.sp,
        color = color,
        letterSpacing = 0.sp,
        fontWeight = Bold,
        textAlign = textAlign,
        fontFamily = regularTypo()
    )
}

@Composable
fun NameProductText(
    text: String,//? = null,
//    labelId: Int? = null,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = 17.sp,
        color = color,
        letterSpacing = 0.sp,
        fontWeight = SemiBold,
        textAlign = textAlign,
        fontFamily = regularTypo()
    )
}

@Composable
fun CategoryProductText(
    text: String,//? = null,
//    labelId: Int? = null,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = 10.sp,
        color = color,
        letterSpacing = 0.sp,
        fontWeight = SemiBold,
        textAlign = textAlign,
        fontFamily = regularTypo()
    )
}