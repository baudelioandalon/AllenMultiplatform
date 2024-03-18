package com.borealnetwork.allen.modules.product.domain.navigation


sealed class ProductClientScreen(val route: String) {
    data object SearchClientScreen : ProductClientScreen("search_client_screen")
    data object ResultProductsClient : ProductClientScreen("result_products_client_screen")
    data object ShowProductClient : ProductClientScreen("show_product_client_screen")
    data object ProductDetailClient : ProductClientScreen("product_detail_client_screen")
    data object RatingProductClient : ProductClientScreen("rating_product_client_screen")
    data object QuestionProductClient : ProductClientScreen("question_product_client_screen")
    data object FavoritesProductsClient : ProductClientScreen("favorites_products_client_screen")
}