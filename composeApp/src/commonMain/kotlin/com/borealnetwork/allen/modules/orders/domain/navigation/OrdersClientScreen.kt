package com.borealnetwork.allen.modules.orders.domain.navigation


sealed class OrdersClientScreen(val route: String) {
    data object OrdersListClientScreen : OrdersClientScreen("orders_list_client_screen")
    data object OrderFinishDetailClientScreen :
        OrdersClientScreen("order_finish_detail_client_screen")

    data object OrderInProgressStatusClientScreen :
        OrdersClientScreen("order_in_progress_status_client_screen")
}