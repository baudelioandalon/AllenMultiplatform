package com.borealnetwork.allen.modules.orders.domain.navigation

import com.borealnetwork.allen.modules.orders.presentation.ui.order_detail.OrderClientFinishDetailViewCompose
import com.borealnetwork.allen.modules.orders.presentation.ui.order_status.OrderClientInProgressStatusViewCompose
import com.borealnetwork.allen.modules.orders.presentation.ui.orders.OrdersListViewCompose
import com.borealnetwork.allensharedui.theme.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.ordersClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = OrdersClientScreen.OrdersListClientScreen.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        OrdersListViewCompose(navigator)
    }
}

fun RouteBuilder.orderClientFinishDetailNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = OrdersClientScreen.OrderFinishDetailClientScreen.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        OrderClientFinishDetailViewCompose(navigator)
    }
}

fun RouteBuilder.orderClientStatusNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = OrdersClientScreen.OrderInProgressStatusClientScreen.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        OrderClientInProgressStatusViewCompose(navigator)
    }
}