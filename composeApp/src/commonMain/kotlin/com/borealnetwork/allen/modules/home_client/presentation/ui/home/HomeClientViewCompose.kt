package com.borealnetwork.allen.modules.home_client.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.BrandingHorizontal
import com.borealnetwork.allen.components.CategoryItem
import com.borealnetwork.allen.components.CategorySelectorItem
import com.borealnetwork.allen.components.HorizontalContainerListItem
import com.borealnetwork.allen.components.ProductItem
import com.borealnetwork.allen.components.ToolbarSearchHome
import com.borealnetwork.allen.components.drawer.DrawerBodyClient
import com.borealnetwork.allen.components.drawer.DrawerHeaderClient
import com.borealnetwork.allen.components.drawer.model.DrawerOptions
import com.borealnetwork.allen.components.drawer.model.MenuItem
import com.borealnetwork.allen.domain.model.MinimalProductModel
import com.borealnetwork.allen.domain.model.PromotionItem
import com.borealnetwork.allen.domain.screen.NOTIFICATION_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.ORDERS_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.PRODUCT_DETAIL_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.SEARCH_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.SHOPPING_CART_CLIENT_GRAPH
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.categorySelectorColors
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeClientViewCompose(navigator: Navigator) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val lastProductsList = listOf(
        MinimalProductModel(
            skuProduct = "dd323234",
            nameProduct = "Sensor Dummy",
            imgProduct = "imagen",
            categoryItem = "Electronica",
            price = 34.0,
            discountPercentage = 0.0
        ),
        MinimalProductModel(
            skuProduct = "dd323234",
            nameProduct = "Sensor Dummy",
            imgProduct = "imagen",
            categoryItem = "Electronica",
            price = 34.0,
            discountPercentage = 0.0
        )
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Scaffold(modifier = Modifier
            .fillMaxWidth(), drawerShape = RectangleShape, topBar = {
            ToolbarSearchHome(startClicked = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }

            }, cartClicked = {
                navigator.navigate(
                    route = SHOPPING_CART_CLIENT_GRAPH
                )
//                            navController?.navigate(SHOPPING_CART_GRAPH)
            }, searchClicked = {
                navigator.navigate(SEARCH_CLIENT_GRAPH)
            })

        },
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            scaffoldState = scaffoldState,
            drawerContent = {
                DrawerHeaderClient {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
                DrawerBodyClient(
                    items = listOf(
                        MenuItem(
                            "Compras",
                            icon = "ic_cart_icon.xml",
                            contentDescription = "Cart",
                            option = DrawerOptions.Buys
                        ),
                        MenuItem(
                            "Favoritos",
                            icon = "ic_heart_icon.xml",
                            contentDescription = "Favorites",
                            option = DrawerOptions.Favorites
                        ),
                        MenuItem(
                            "Tiendas",
                            icon = "ic_stores_icon.xml",
                            contentDescription = "Stores",
                            option = DrawerOptions.Stores
                        ),
                        MenuItem(
                            "Notificaciónes",
                            icon = "ic_bell_icon.xml",
                            contentDescription = "Notifications",
                            option = DrawerOptions.Notifications
                        ),
                        MenuItem(
                            "Salir",
                            icon = "ic_arrow_right.xml",
                            contentDescription = "Exit",
                            option = DrawerOptions.Exit,
                            close = 0
                        ),
                        MenuItem(
                            "Cerrar sesión",
                            icon = "ic_close_session_icon.xml",
                            contentDescription = "Close session",
                            option = DrawerOptions.CloseSession
                        )
                    ),
                ) {
                    println("Clicked on ${it.option.name}")
                    when (it.option) {
                        DrawerOptions.Exit -> {

                        }

                        DrawerOptions.Buys -> {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                            navigator.navigate(route = ORDERS_CLIENT_GRAPH)
                        }

                        DrawerOptions.Favorites -> {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }

                        DrawerOptions.Stores -> {
//                            navController?.navigate(STORES_MAPS_GENERAL_GRAPH)
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }

                        DrawerOptions.Notifications -> {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                            navigator.navigate(route = NOTIFICATION_CLIENT_GRAPH)
                        }

                        else -> {

                        }
                    }
                }
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize().align(Alignment.TopCenter)
                        .background(White)
                ) {

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(GrayBackgroundMain)
                    ) {
                        item {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RectangleShape,
                                elevation = 5.dp
                            ) {
                                TopContainer()
                            }
                        }
                        item {
                            Card(
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .fillMaxWidth(),
                                shape = RectangleShape,
                                elevation = 5.dp
                            ) {
                                BrandingContainer()
                            }
                        }
                        item {
                            Card(
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .fillMaxWidth(),
                                shape = RectangleShape,
                                elevation = 5.dp
                            ) {
                                HorizontalContainerListItem(
                                    startText = "Ultimos articulos",
                                    endText = "Ver todos",
                                    listItem = lastProductsList
                                ) { minimalProductModel, index ->
                                    ProductItem(minimalProductModel) {
                                        navigator.navigate(PRODUCT_DETAIL_CLIENT_GRAPH)
                                    }
                                }
                            }
                        }
                        item {
                            Card(
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .fillMaxWidth(),
                                shape = RectangleShape,
                                elevation = 5.dp
                            ) {
                                CategoryListContainer()
                            }
                        }
                        item {
                            Card(
                                modifier = Modifier
                                    .padding(top = 30.dp, bottom = 50.dp)
                                    .fillMaxWidth(),
                                shape = RectangleShape,
                                elevation = 5.dp
                            ) {
                                HorizontalContainerListItem(
                                    startText = "Ofertas",
                                    endText = "Ver todos",
                                    listItem = lastProductsList
                                ) { minimalProductModel, index ->
                                    ProductItem(minimalProductModel) {
                                        navigator.navigate(PRODUCT_DETAIL_CLIENT_GRAPH)
                                    }
                                }
                            }
                        }
                    }
                }

                it.calculateBottomPadding()
            })

    }
}

@Composable
fun TopContainer() {
    Column {
        AutoSliding()
        CategoryHorizontalContainer()
    }
}

@Composable
fun CategoryHorizontalContainer() {
    LazyRow(
        modifier = Modifier
            .background(White)
    ) {
        items(4) {
            CategoryItem()
        }
    }
}

@Composable
fun BrandingContainer(
    modifier: Modifier = Modifier,
    hideTitle: Boolean = false
) {
    Column(
        modifier = modifier
            .background(White)
    ) {
        if (!hideTitle) {
            BoldText(
                modifier = Modifier.padding(start = 30.dp, top = 20.dp),
                text = "Marcas",
                color = Black,
                fontSize = 20.sp
            )
        }
        BrandingHorizontal(
            modifier = Modifier.padding(
                top = 30.dp,
                bottom = 35.dp
            )
        )
    }
}

@Composable
fun CategoryListContainer() {
    Column(
        modifier = Modifier
            .background(White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BoldText(
                modifier = Modifier.padding(start = 30.dp, top = 20.dp),
                text = "Tecnologia", color = Black,
                fontSize = 20.sp
            )
        }
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 35.dp
                )
        ) {
            items(10) { index ->
                CategorySelectorItem(
                    index % 2 != 0,
                    categorySelectorColors[index % categorySelectorColors.size]
                )
            }
        }
    }
}

@Composable
fun AutoSliding() {
    val promotion = listOf(
        PromotionItem("Title one", "pager_one.png"),
        PromotionItem("Title two", "pager_two.png")
    )
    val page = rememberSaveable {
        mutableStateOf(0)
    }
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(3000)
            if (page.value == 0) {
                page.value += 1
            } else {
                page.value = 0
            }
        }
    }
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(res = promotion[0].imgUrl),
            contentDescription = promotion[page.value].title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()

        )
    }
}