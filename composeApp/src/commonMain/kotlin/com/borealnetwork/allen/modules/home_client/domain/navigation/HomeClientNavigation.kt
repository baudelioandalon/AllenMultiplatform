package com.borealnetwork.allen.modules.home_client.domain.navigation

import com.borealnetwork.allen.modules.home_client.domain.view_model.HomeClientViewModel
import com.borealnetwork.allen.modules.home_client.presentation.ui.home.HomeClientViewCompose
import com.borealnetwork.allen.modules.product.domain.view_models.ShowProductViewModel
import com.borealnetwork.allensharedui.theme.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.homeClientNavigationGraph(
    navigator: Navigator,
    homeClientViewModel: HomeClientViewModel,
    showProductViewModel: ShowProductViewModel
) {
    scene(
        // Scene's route path
        route = HomeClientScreen.HomeDefaultClientScreen.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        HomeClientViewCompose(navigator, homeClientViewModel, showProductViewModel)
    }
}