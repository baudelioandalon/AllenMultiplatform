package com.borealnetwork.allen.modules.profile.domain.navigation

import com.borealnetwork.allen.modules.profile.presentation.ui.address.AddressClientViewCompose
import com.borealnetwork.allen.modules.profile.presentation.ui.new_address.NewAddressClientViewCompose
import com.borealnetwork.allensharedui.theme.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.addressClientNavigationGraph(navigator: Navigator) {
    scene(
        route = ProfileScreen.AddressClientScreen.route,
        navTransition = defaultTransition(),
    ) {
        AddressClientViewCompose(navigator)
    }
}

fun RouteBuilder.newAddressClientNavigationGraph(navigator: Navigator) {
    scene(
        route = ProfileScreen.NewAddressClientScreen.route,
        navTransition = defaultTransition(),
    ) {
        NewAddressClientViewCompose(navigator)
    }
}