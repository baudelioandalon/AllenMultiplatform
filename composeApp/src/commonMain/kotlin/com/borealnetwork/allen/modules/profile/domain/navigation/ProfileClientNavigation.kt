package com.borealnetwork.allen.modules.profile.domain.navigation

import com.borealnetwork.allen.domain.screen.ADDRESS_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.NEW_ADDRESS_CLIENT_GRAPH
import com.borealnetwork.allen.modules.profile.presentation.ui.address.AddressClientViewCompose
import com.borealnetwork.allen.modules.profile.presentation.ui.new_address.NewAddressClientViewCompose
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder
import moe.tlaster.precompose.navigation.transition.NavTransition

fun RouteBuilder.addressClientNavigationGraph(navigator: Navigator) {
    scene(
        route = ADDRESS_CLIENT_GRAPH,
        navTransition = null,
    ) {
        AddressClientViewCompose(navigator)
    }
}

fun RouteBuilder.newAddressClientNavigationGraph(navigator: Navigator) {
    scene(
        route = NEW_ADDRESS_CLIENT_GRAPH,
        navTransition = NavTransition(),
    ) {
        NewAddressClientViewCompose(navigator)
    }
}