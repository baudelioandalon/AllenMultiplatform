package com.borealnetwork.allen.modules.stores.domain.navigation

import com.borealnetwork.allen.modules.stores.presentation.ui.stores.StoresInMapViewCompose
import com.borealnetwork.allensharedui.theme.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.storesInMapNavigationGraph(navigator: Navigator) {
    scene(
        route = StoresScreen.StoresInMapScreen.route,
        navTransition = defaultTransition()
    ) {
        StoresInMapViewCompose(navigator)
    }
}