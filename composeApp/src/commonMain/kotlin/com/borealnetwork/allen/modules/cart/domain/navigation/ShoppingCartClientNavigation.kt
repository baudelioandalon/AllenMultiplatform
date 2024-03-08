package com.borealnetwork.allen.modules.cart.domain.navigation

import com.borealnetwork.allen.modules.cart.presentation.ui.detail_buy_cart.DetailBuyCartStepOneViewCompose
import com.borealnetwork.allen.modules.cart.presentation.ui.resume_cart.ResumeCartStepTwoViewCompose
import com.borealnetwork.allen.modules.cart.presentation.ui.shopping_cart.ShoppingCartViewCompose
import com.borealnetwork.allen.tools.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.shoppingCartClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = CartClientScreen.ShoppingCartClientScreen.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        ShoppingCartViewCompose(navigator)
    }
}

fun RouteBuilder.resumeBuyCartClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = CartClientScreen.ResumeBuyCartClientScreen.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        ResumeCartStepTwoViewCompose(navigator)
    }
}

fun RouteBuilder.detailBuyCartClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = CartClientScreen.DetailBuyCartClientScreen.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        DetailBuyCartStepOneViewCompose(navigator)
    }
}