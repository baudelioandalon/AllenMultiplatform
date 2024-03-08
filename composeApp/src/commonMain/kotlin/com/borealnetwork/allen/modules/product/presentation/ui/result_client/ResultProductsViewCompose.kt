package com.borealnetwork.allen.modules.product.presentation.ui.result_client

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.BrandingHorizontal
import com.borealnetwork.allen.components.ProductResultItem
import com.borealnetwork.allen.components.SemiBoldText
import com.borealnetwork.allen.components.ToolbarSearchHome
import com.borealnetwork.allen.domain.screen.PRODUCT_DETAIL_CLIENT_GRAPH
import com.borealnetwork.allen.theme.GrayBorder
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun ResultProductsViewCompose(
    navigator: Navigator,
) {

    Scaffold(topBar = {
        ToolbarSearchHome(
            startIcon = "ic_back_arrow.xml",
            textPlaceHolder = "Ropa",
            startClicked = {
                navigator.goBack()
            }, cartClicked = {
            }, searchClicked = {
            })
    }) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(White),
            columns = GridCells.Fixed(2)
        ) {

            item(span = { GridItemSpan(2) }) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 30.dp,
                            top = 20.dp,
                            bottom = 25.dp
                        )
                ) {
                    Column(
                        modifier = Modifier.wrapContentWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        SemiBoldText(
                            text = "Todos",
                            fontSize = 25.sp
                        )
                        BoldText(
                            text = "14 articulos",
                            fontSize = 12.sp,
                            color = GrayBorder
                        )
                    }
                    BrandingHorizontal(itemSize = 50.dp)
                }

            }
            itemsIndexed(
                items = listOf(
                    "", "", "", "",
                    "", "", "", "", ""
                )
            ) { index, item ->
                ProductResultItem(
                    modifier = Modifier.padding(
                        start = if (index % 2 == 0) 30.dp else 10.dp,
                        end = if (index % 2 == 0) 10.dp else 30.dp,
                        top = if (index % 2 != 0) 20.dp else 0.dp
                    ),
                    productClicked = {
                        navigator.navigate(PRODUCT_DETAIL_CLIENT_GRAPH)
                    }
                )
            }
        }
        it.calculateBottomPadding()
    }

}