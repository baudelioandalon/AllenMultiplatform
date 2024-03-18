package com.borealnetwork.allensharedui.components.drawer

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allensharedui.components.BoldText
import com.borealnetwork.allensharedui.components.MediumText
import com.borealnetwork.allensharedui.components.Selector
import com.borealnetwork.allensharedui.components.SemiBoldText
import com.borealnetwork.allensharedui.components.drawer.model.DrawerOptions
import com.borealnetwork.allensharedui.components.drawer.model.MenuItem
import com.borealnetwork.allensharedui.theme.GrayBackgroundDrawerDismiss
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import com.borealnetwork.allensharedui.theme.GrayLetterDrawer
import com.borealnetwork.allensharedui.theme.OrangeBackground
import com.borealnetwork.allensharedui.theme.OrangeStrong
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun BussinessInformationDrawer(onItemClicked: (MenuItem) -> Unit = {}) {
    Column(modifier = Modifier.fillMaxWidth()) {
        BusinessInformationDrawerBody(
            items = listOf(
                MenuItem(
                    "Principal",
                    icon = "ic_menu_icon.xml",
                    contentDescription = "main",
                    option = DrawerOptions.Main
                ),
                MenuItem(
                    "Contacto",
                    icon = "ic_user.xml",
                    contentDescription = "Contact",
                    option = DrawerOptions.Contact
                ),
                MenuItem(
                    "Envíos \n Y Pagos",
                    icon = "ic_bell_icon.xml",
                    contentDescription = "envios y pagos",
                    option = DrawerOptions.ShippingAndPayments
                ),
                MenuItem(
                    "Promo\nción",
                    icon = "ic_arrow_right.xml",
                    contentDescription = "promoción",
                    option = DrawerOptions.Promotion,
                    close = 0
                ),
                MenuItem(
                    "Guardar",
                    icon = "ic_check_mark.xml",
                    contentDescription = "guardar",
                    option = DrawerOptions.CloseSession
                ),
                MenuItem(
                    "Salir",
                    icon = "ic_arrow_right.xml",
                    contentDescription = "salir",
                    option = DrawerOptions.Exit
                )
            )
        ) {
            onItemClicked.invoke(it)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DrawerHeaderSeller(closeClicked: (() -> Unit)? = null) {
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
                    painter = painterResource(resource = DrawableResource("ic_arrow_right.xml")),
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
                    painter = painterResource(resource = DrawableResource("person_test.png")),
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
fun DrawerBodySeller(
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BusinessInformationDrawerBody(
    items: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxSize()
            .background(GrayBackgroundMain)
    ) {
        item {
            SemiBoldText(
                modifier = Modifier.padding(start = 30.dp, top = 28.dp, bottom = 30.dp),
                text = "Menu"
            )
        }
        itemsIndexed(items) { index, item ->
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .height(56.dp),
                    backgroundColor = GrayBackgroundMain,
                    elevation = 0.dp,
                    onClick = {
                        onItemClick.invoke(item)
                    }
                ) {
                    Selector(
                        roundDp = 15.dp,
                        backgroundColor = OrangeBackground,
                        text = item.title,
                        textColor = OrangeStrong,
                        onClicked = null
                    )
                }
            }
        }
    }

}