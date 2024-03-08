package com.borealnetwork.allen.domain.screen

const val HOME_CLIENT_GRAPH = "HOME_CLIENT_GRAPH"
const val NOTIFICATION_CLIENT_GRAPH = "NOTIFICATION_CLIENT_GRAPH"

//Orders
const val ORDERS_CLIENT_GRAPH = "ORDERS_CLIENT_GRAPH"
const val ORDER_CLIENT_FINISH_DETAIL_GRAPH = "ORDER_CLIENT_FINISH_DETAIL_GRAPH"
const val ORDER_CLIENT_IN_PROGRESS_STATUS_GRAPH = "ORDER_CLIENT_IN_PROGRESS_STATUS_GRAPH"

//Product
const val SEARCH_CLIENT_GRAPH = "SEARCH_CLIENT_GRAPH"
const val RESULT_PRODUCTS_CLIENT_GRAPH = "RESULT_PRODUCTS_CLIENT_GRAPH"
const val PRODUCT_DETAIL_CLIENT_GRAPH = "PRODUCT_DETAIL_CLIENT_GRAPH"
const val RATING_PRODUCT_CLIENT_GRAPH = "RATING_PRODUCT_CLIENT_GRAPH"
const val QUESTION_PRODUCT_CLIENT_GRAPH = "QUESTION_PRODUCT_CLIENT_GRAPH"


const val RESULT_BY_SELLER_CLIENT_GRAPH = "RESULT_BY_SELLER_CLIENT_GRAPH"
const val ADDRESS_CLIENT_GRAPH = "ADDRESS_CLIENT_GRAPH"
const val NEW_ADDRESS_CLIENT_GRAPH = "NEW_ADDRESS_CLIENT_GRAPH"
const val SHOPPING_CART_CLIENT_GRAPH = "SHOPPING_CART_CLIENT_GRAPH"
const val RESUME_BUY_CART_CLIENT_GRAPH = "RESUME_BUY_CART_CLIENT_GRAPH"
const val DETAIL_BUY_CART_CLIENT_GRAPH = "DETAIL_BUY_CART_CLIENT_GRAPH"

const val NEW_CARD_CLIENT_GRAPH = "NEW_CARD_CLIENT_GRAPH"
const val PAYMENTS_METHOD_CLIENT_GRAPH = "PAYMENTS_METHOD_CLIENT_GRAPH"
const val FAVORITES_GRAPH = "FAVORITES_GRAPH"
const val STORES_MAPS_GENERAL_GRAPH = "STORES_MAPS_GENERAL_GRAPH"
const val STATUS_GRAPH = "STATUS_GRAPH"

sealed class ClientScreen(val route: String) {
    data object HomeClientScreen : ClientScreen("home_client_screen")
    data object SearchClientScreen : ClientScreen("search_client_screen")
    data object ResultClientScreen : ClientScreen("result_client_screen")
    data object ResultBySellerClientScreen : ClientScreen("result_by_seller_client_screen")
    data object AddressClientScreen : ClientScreen("address_client_screen")
    data object ShoppingClientScreen : ClientScreen("shopping_client_screen")
    data object FavoritesClientScreen : ClientScreen("favorites_client_screen")
    data object NotificationClientScreen : ClientScreen("notification_client_screen")
    data object StoresMapGeneralScreen : ClientScreen("stores_maps_general_screen")
    data object ShoppingDetailClientScreen : ClientScreen("shopping_detail_client_screen")
    data object StatusClientScreen : ClientScreen("status_screen")
}