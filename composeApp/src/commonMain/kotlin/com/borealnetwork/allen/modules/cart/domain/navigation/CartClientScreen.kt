package com.borealnetwork.allen.modules.cart.domain.navigation


sealed class CartClientScreen(val route: String) {
    data object DetailBuyCartClientScreen : CartClientScreen("detail_buy_cart_client_screen")
    data object ResumeBuyCartClientScreen : CartClientScreen("resume_buy_cart_client_screen")
    data object ShoppingCartClientScreen : CartClientScreen("shopping_cart_client_screen")
}