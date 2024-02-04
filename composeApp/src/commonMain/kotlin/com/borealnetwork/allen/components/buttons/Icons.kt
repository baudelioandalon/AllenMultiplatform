package com.borealnetwork.allen.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allen.theme.GrayBorderSearch
import com.borealnetwork.allen.theme.GrayStrong
import com.borealnetwork.allen.theme.OrangeStrong
import com.borealnetwork.allen.theme.OrangeTransparentLow
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LocationIcon(onClick: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .size(52.dp)
            .background(
                alpha = 0.5f,
                brush = Brush.radialGradient(
                    colors = listOf(
                        OrangeStrong,
                        OrangeTransparentLow
                    )
                ), shape = RoundedCornerShape(30.dp)
            )
            .padding(bottom = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .size(40.dp)
                .background(Color.Transparent),
            backgroundColor = OrangeStrong, elevation = 0.dp,
            onClick = { onClick?.invoke() }
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource("ic_location.xml"),
                    contentDescription = "moreIcon",
                    tint = White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoalIcon(onClick: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .size(52.dp)
            .padding(bottom = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.padding(start = 5.dp)
                .size(40.dp)
                .background(Color.Transparent),
            backgroundColor = GrayBackgroundDrawerDismiss, elevation = 0.dp,
            onClick = { onClick?.invoke() }
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource("ic_goal.xml"),
                    contentDescription = "moreIcon",
                    tint = GrayStrong
                )
            }
        }
    }
}