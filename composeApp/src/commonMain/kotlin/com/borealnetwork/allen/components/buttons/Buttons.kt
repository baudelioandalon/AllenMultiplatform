package com.borealnetwork.allen.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.theme.FavoriteSelectedColor
import com.borealnetwork.allen.theme.FavoriteUnselectedColor
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteButton(modifier: Modifier = Modifier, clicked: (() -> Unit)? = null) {
    Card(modifier = modifier.layoutId("favorite_selector").size(35.dp),
        elevation = 0.dp,
        shape = CircleShape,
        onClick = { clicked?.invoke() }) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(res = "ic_favorite_unselected.xml"),
            contentDescription = ""
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteCounterButton(
    modifier: Modifier = Modifier,
    amount: Int = 0, clicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .layoutId("favorite_selector")
            .height(35.dp)
            .wrapContentWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = FavoriteUnselectedColor,
        onClick = { clicked?.invoke() }) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.size(35.dp),
                painter = painterResource(res = "ic_favorite_unselected.xml"),
                contentDescription = ""
            )
            BoldText(
                modifier = Modifier
                    .padding(end = 13.dp)
                    .wrapContentWidth(),
                text = "$amount",
                color = FavoriteSelectedColor,
                size = 12.sp,
                align = TextAlign.Start
            )
        }

    }
}