package com.borealnetwork.allen.components.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.MediumText
import com.borealnetwork.allen.components.drawer.model.MenuItem
import com.borealnetwork.allen.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.GrayLetterDrawer
import com.borealnetwork.allen.theme.StarColor
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DrawerHeaderClient(closeClicked: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(GrayBackgroundMain)
    ) {
        Row(
            modifier = Modifier
                .background(White)
                .padding(top = 8.dp, start = 30.dp, end = 21.dp)
                .fillMaxWidth()
                .align(Alignment.End)
                .height(40.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Card(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                backgroundColor = GrayBackgroundDrawerDismiss,
                elevation = 0.dp,
                shape = CircleShape, onClick = { closeClicked?.invoke() }) {
                Image(
                    modifier = Modifier
                        .padding(
                            top = 12.dp, bottom = 15.dp,
                            start = 8.dp, end = 8.dp
                        ),
                    painter = painterResource(res = "ic_arrow_right.xml"),
                    contentDescription = ""
                )
            }
        }

        Row(
            modifier = Modifier
                .background(White)
                .height(110.dp)
                .padding(top = 13.dp, start = 30.dp)
        ) {
            Card(
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp),
                elevation = 0.dp,
                shape = CircleShape, onClick = { }) {
                Image(
                    modifier = Modifier.height(50.dp),
                    painter = painterResource(res = "person_test.png"),
                    contentDescription = ""
                )
            }
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(start = 15.dp)
            ) {
                BoldText(
                    text = "Hola, buen dia",
                    color = GrayLetterDrawer,
                    fontSize = 15.sp
                )
                BoldText(text = "Luna")
                StarStatus()
            }
        }
    }
}

@Composable
fun StarStatus(
    modifier: Modifier = Modifier,
    text: String = "(12 Compras)",
    stars: String = "4.6"
) {
    Row(
        modifier = modifier
            .padding(top = 4.dp)
            .fillMaxSize(), verticalAlignment = CenterVertically
    ) {
        Icon(
            painter = painterResource(res = "ic_star_icon.xml"),
            contentDescription = "star User",
            tint = StarColor
        )
        BoldText(modifier = Modifier.padding(start = 5.dp), fontSize = 15.sp, text = stars)
        BoldText(
            modifier = Modifier.padding(start = 10.dp),
            text = text,
            color = GrayLetterDrawer,
            fontSize = 15.sp
        )
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxSize()
            .background(GrayBackgroundMain)
    ) {
        itemsIndexed(items) { index, item ->
            Row(
                modifier = Modifier
                    .padding(
                        top = if (index == 0) 5.dp else {
                            when (item.close) {
                                0 -> {
                                    60.dp
                                }

                                else -> {
                                    2.dp
                                }
                            }
                        }
                    )
                    .background(White)
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    },
                verticalAlignment = CenterVertically
            ) {

                MediumText(
                    text = item.title,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, start = 12.dp)
                        .weight(1f)
                )
            }
        }
    }

}