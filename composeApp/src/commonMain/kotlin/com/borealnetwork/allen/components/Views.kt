package com.borealnetwork.allen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.theme.GrayBorderLight


@Composable
fun SeparatorHorizontal(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().background(Color.White)
    ) {
        Divider(
            modifier = Modifier.layoutId("dividerLeft"), color = GrayBorderLight, thickness = 1.dp
        )
        Text(
            modifier = Modifier.layoutId("text"),
            text = "ó",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.W500
        )
        Divider(
            modifier = Modifier.layoutId("dividerRight"), color = GrayBorderLight, thickness = 1.dp
        )
    }
}

@Composable
fun SeparatorGray(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier, color = GrayBorderLight, thickness = 1.dp
    )
}
