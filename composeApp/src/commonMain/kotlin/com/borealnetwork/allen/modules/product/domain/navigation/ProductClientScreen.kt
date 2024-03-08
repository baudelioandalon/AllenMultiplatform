package com.borealnetwork.allen.modules.product.domain.navigation

//HomeClient
const val HOME_CLIENT_GRAPH = "HOME_CLIENT_GRAPH"

//Notifications
const val NOTIFICATION_CLIENT_GRAPH = "NOTIFICATION_CLIENT_GRAPH"

//Orders
const val ORDERS_CLIENT_GRAPH = "ORDERS_CLIENT_GRAPH"
const val ORDER_CLIENT_FINISH_DETAIL_GRAPH = "ORDER_CLIENT_FINISH_DETAIL_GRAPH"
const val ORDER_CLIENT_IN_PROGRESS_STATUS_GRAPH = "ORDER_CLIENT_IN_PROGRESS_STATUS_GRAPH"



const val RESULT_BY_SELLER_CLIENT_GRAPH = "RESULT_BY_SELLER_CLIENT_GRAPH"



//Cart
const val DETAIL_BUY_CART_CLIENT_GRAPH = "DETAIL_BUY_CART_CLIENT_GRAPH"
const val RESUME_BUY_CART_CLIENT_GRAPH = "RESUME_BUY_CART_CLIENT_GRAPH"
const val SHOPPING_CART_CLIENT_GRAPH = "SHOPPING_CART_CLIENT_GRAPH"

//Payments
const val NEW_CARD_CLIENT_GRAPH = "NEW_CARD_CLIENT_GRAPH"
const val PAYMENTS_METHOD_CLIENT_GRAPH = "PAYMENTS_METHOD_CLIENT_GRAPH"

const val FAVORITES_GRAPH = "FAVORITES_GRAPH"
const val STORES_MAPS_GENERAL_GRAPH = "STORES_MAPS_GENERAL_GRAPH"
const val STATUS_GRAPH = "STATUS_GRAPH"


sealed class ProductClientScreen(val route: String) {
    data object SearchClientScreen : ProductClientScreen("search_client_screen")
    data object ResultProductsClient : ProductClientScreen("result_products_client_screen")
    data object ProductDetailClient : ProductClientScreen("product_detail_client_screen")
    data object RatingProductClient : ProductClientScreen("rating_product_client_screen")
    data object QuestionProductClient : ProductClientScreen("question_product_client_screen")
}