package com.borealnetwork.allen.modules.orders.domain.navigation

import com.borealnetwork.allen.domain.screen.ORDERS_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.ORDER_CLIENT_DETAIL_GRAPH
import com.borealnetwork.allen.modules.orders.presentation.ui.order_detail.OrderDetailViewCompose
import com.borealnetwork.allen.modules.orders.presentation.ui.orders.OrdersListViewCompose
import com.borealnetwork.allen.tools.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder
import moe.tlaster.precompose.navigation.transition.NavTransition

fun RouteBuilder.ordersClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ORDERS_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        OrdersListViewCompose(navigator)
    }
}

fun RouteBuilder.orderClientDetailNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ORDER_CLIENT_DETAIL_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        OrderDetailViewCompose(navigator)
    }
}