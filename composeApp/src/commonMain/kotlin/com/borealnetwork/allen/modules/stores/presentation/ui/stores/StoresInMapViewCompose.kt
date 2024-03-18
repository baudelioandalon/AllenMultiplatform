package com.borealnetwork.allen.modules.stores.presentation.ui.stores

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun StoresInMapViewCompose(navigator: Navigator) {

    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Tiendas",
            startClicked = {
                navigator.goBack()
            },
            showEndImage = false
        )
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {

            item {

            }
        }
        it.calculateBottomPadding()
    }

}
