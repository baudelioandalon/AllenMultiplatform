package com.borealnetwork.allen.modules.cart.domain.navigation

import com.borealnetwork.allen.domain.screen.DETAIL_BUY_CART_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.RESUME_BUY_CART_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.SHOPPING_CART_CLIENT_GRAPH
import com.borealnetwork.allen.modules.cart.presentation.ui.detail_buy_cart.DetailBuyCartStepOneViewCompose
import com.borealnetwork.allen.modules.cart.presentation.ui.resume_cart.ResumeCartStepTwoViewCompose
import com.borealnetwork.allen.modules.cart.presentation.ui.shopping_cart.ShoppingCartViewCompose
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder
import moe.tlaster.precompose.navigation.transition.NavTransition

fun RouteBuilder.shoppingCartClientNavigationGraph(navigator: Navigator){
    scene(
        // Scene's route path
        route = SHOPPING_CART_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = NavTransition(),
    ) {
        ShoppingCartViewCompose(navigator)
    }
}

fun RouteBuilder.resumeBuyCartClientNavigationGraph(navigator: Navigator){
    scene(
        // Scene's route path
        route = RESUME_BUY_CART_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = NavTransition(),
    ) {
        ResumeCartStepTwoViewCompose(navigator)
    }
}

fun RouteBuilder.detailBuyCartClientNavigationGraph(navigator: Navigator){
    scene(
        // Scene's route path
        route = DETAIL_BUY_CART_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = NavTransition(),
    ) {
        DetailBuyCartStepOneViewCompose(navigator)
    }
}