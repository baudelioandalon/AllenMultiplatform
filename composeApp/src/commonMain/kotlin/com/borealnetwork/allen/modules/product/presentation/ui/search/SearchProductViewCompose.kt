package com.borealnetwork.allen.modules.product.presentation.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.RegularText
import com.borealnetwork.allen.components.ToolbarSearch
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.GrayLetterHint
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchProductViewCompose(
    closeApp: () -> Unit = {}
) {

    Scaffold(topBar = {
        ToolbarSearch(backClicked = {
//            navController?.navigateUp()
        }, endClicked = {

        }, searchClicked = {

        }, settingsClicked = {

        })
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayBackgroundMain)
        ) {

            item {
                Card(
                    elevation = 10.dp,
                    shape = RectangleShape
                ) {
                    FlowRow(modifier = Modifier.padding(top = 10.dp)) {
                        listOf("Ropa de mujer", "Ropa de bebé", "Ropa de niño").forEach {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = rememberRipple(
                                            bounded = true,
                                            color = GrayLetterHint.copy(alpha = 0.1f)
                                        )
                                    ) {
//                                        navController?.navigate(
//                                            route = RESULT_CLIENT_GRAPH,
//                                            navOptions = NavOptions
//                                                .Builder()
//                                                .setPopUpTo(
//                                                    route = ClientScreen.HomeClientScreen.route,
//                                                    inclusive = false
//                                                )
//                                                .build()
//                                        )
                                    }
                                    .padding(
                                        start = 30.dp,
                                        end = 30.dp
                                    ),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(res = "ic_clock_gray.xml"),
                                    contentDescription = ""
                                )
                                RegularText(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(
                                            top = 10.dp,
                                            bottom = 10.dp
                                        )
                                        .padding(start = 10.dp),
                                    text = it,
                                    textAlign = TextAlign.Start,
                                    fontSize = 15.sp
                                )
                                Icon(
                                    painter = painterResource(res = "ic_search_icon.xml"),
                                    contentDescription = "",
                                    tint = GrayLetterHint
                                )
                            }

                        }
                    }
                }
            }
        }
        it.calculateBottomPadding()
    }


}