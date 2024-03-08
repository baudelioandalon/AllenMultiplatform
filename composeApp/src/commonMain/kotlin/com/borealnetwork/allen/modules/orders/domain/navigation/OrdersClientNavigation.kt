package com.borealnetwork.allen.modules.orders.domain.navigation

import com.borealnetwork.allen.domain.screen.ORDERS_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.ORDER_CLIENT_FINISH_DETAIL_GRAPH
import com.borealnetwork.allen.domain.screen.ORDER_CLIENT_IN_PROGRESS_STATUS_GRAPH
import com.borealnetwork.allen.modules.orders.presentation.ui.order_detail.OrderClientFinishDetailViewCompose
import com.borealnetwork.allen.modules.orders.presentation.ui.order_status.OrderClientInProgressStatusViewCompose
import com.borealnetwork.allen.modules.orders.presentation.ui.orders.OrdersListViewCompose
import com.borealnetwork.allen.tools.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

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

fun RouteBuilder.orderClientFinishDetailNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ORDER_CLIENT_FINISH_DETAIL_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        OrderClientFinishDetailViewCompose(navigator)
    }
}

fun RouteBuilder.orderClientStatusNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ORDER_CLIENT_IN_PROGRESS_STATUS_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        OrderClientInProgressStatusViewCompose(navigator)
    }
}