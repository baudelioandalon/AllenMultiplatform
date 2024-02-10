package com.borealnetwork.allen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.theme.GrayBorderLight


@Composable
fun SeparatorHorizontal(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Divider(
            modifier = Modifier.weight(1f),
            color = GrayBorderLight,
            thickness = 2.dp
        )
        MediumText(
            modifier = Modifier.wrapContentSize().padding(horizontal = 10.dp),
            text = "ó",
            fontSize = 20.sp,
            color = Color.Black
        )
        Divider(
            modifier = Modifier.weight(1f),
            color = GrayBorderLight,
            thickness = 2.dp
        )
    }
}

@Composable
fun SeparatorGray(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier, color = GrayBorderLight, thickness = 1.dp
    )
}
