package com.borealnetwork.allen.modules.home_client.domain.navigation

import com.borealnetwork.allen.modules.home_client.presentation.ui.home.HomeClientViewCompose
import com.borealnetwork.allen.tools.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.homeClientNavigationGraph(navigator: Navigator){
    scene(
        // Scene's route path
        route = HomeClientScreen.HomeDefaultClientScreen.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        HomeClientViewCompose(navigator)
    }
}