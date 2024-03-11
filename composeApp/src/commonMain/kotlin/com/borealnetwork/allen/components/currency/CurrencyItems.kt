package com.borealnetwork.allen.components.currency

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.platform
import com.borealnetwork.allen.theme.GreenStrong
import com.borealnetwork.allen.theme.OrangeTransparent


@Composable
fun CurrencyInDiscountItem(
    modifier: Modifier = Modifier,
    composable: @Composable RowScope.() -> Unit
){
    Row(
        modifier = modifier.wrapContentWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        BoldText(
            modifier = Modifier.wrapContentWidth().padding(end = 5.dp),
            text = platform().currency,
            color = OrangeTransparent,
            fontSize = 12.sp
        )
        composable(this)
    }
}
@Composable
fun CurrencyInBottomItem(
    modifier: Modifier = Modifier,
    composable: @Composable RowScope.() -> Unit
){
    Row(
        modifier = modifier.wrapContentWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        BoldText(
            modifier = Modifier.wrapContentWidth().padding(end = 5.dp),
            text = platform().currency,
            color = GreenStrong,
            fontSize = 20.sp,
            textAlign = TextAlign.End
        )
        composable(this)
    }
}

@Composable
fun CurrencyInShoppingItem(
    modifier: Modifier = Modifier,
    composable: @Composable RowScope.() -> Unit
){
    Row(
        modifier = modifier.wrapContentWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        BoldText(
            modifier = Modifier.wrapContentWidth().padding(end = 5.dp),
            text = platform().currency,
            color = GreenStrong,
            fontSize = 12.sp,
            textAlign = TextAlign.End
        )
        composable(this)
    }
}