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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.CircularIcon
import com.borealnetwork.allen.components.LogoBlue
import com.borealnetwork.allen.components.MediumText
import com.borealnetwork.allen.components.drawer.model.MenuItem
import com.borealnetwork.allen.platform
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.GrayBorder
import com.borealnetwork.allen.theme.StarColor
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DrawerHeaderClient(closeClicked: (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .wrapContentHeight(unbounded = true)
            .fillMaxWidth()
            .padding(top = 60.dp, start = 30.dp, end = 15.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier
                .size(68.dp),
            elevation = 0.dp,
            shape = CircleShape, onClick = { }) {
            Image(
                modifier = Modifier.height(50.dp),
                painter = painterResource(resource = DrawableResource(  "person_test.png")),
                contentDescription = ""
            )
        }
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(0.7f)
                .padding(start = 15.dp)
        ) {
            BoldText(
                text = "Hola, buen dia",
                color = White,
                fontSize = 15.sp,
            )
            BoldText(text = "Luna", color = White)
            StarStatus()

        }

        CircularIcon(
            modifier = Modifier
                .size(40.dp),
            icon = "ic_arrow_right.xml",
            onClick = closeClicked
        )

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
            painter = painterResource(resource = DrawableResource(  "ic_star_icon.xml")),
            contentDescription = "star User",
            tint = StarColor
        )
        BoldText(
            modifier = Modifier.padding(start = 5.dp),
            fontSize = 15.sp,
            text = stars,
            color = White
        )
        BoldText(
            modifier = Modifier.padding(start = 10.dp),
            text = text,
            color = White,
            fontSize = 15.sp
        )
    }
}

@Composable
fun DrawerBodyClient(
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
                    .fillMaxWidth().wrapContentHeight().clickable {
                        onItemClick(item)
                    }
                    .padding(start = 14.dp, end = 12.dp),
                verticalAlignment = CenterVertically
            ) {


                Icon(
                    modifier = Modifier.size(22.dp),
                    painter = painterResource(resource = DrawableResource(  item.icon)),
                    contentDescription = item.contentDescription,
                    tint = GrayBorder
                )
                MediumText(
                    text = item.title,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, start = 12.dp)
                        .weight(1f)
                )
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(resource = DrawableResource( "ic_rounded_arrow_right.xml")),
                    contentDescription = ""
                )
            }

        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                LogoBlue(
                    modifier = Modifier
                        .width(55.dp)
                )
                MediumText(
                    modifier = Modifier.padding(start = 13.dp),
                    text = platform().versionName,
                    fontSize = 13.sp
                )
            }
        }
    }

}