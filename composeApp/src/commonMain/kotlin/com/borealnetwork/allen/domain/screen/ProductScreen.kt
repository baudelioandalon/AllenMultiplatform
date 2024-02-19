package com.borealnetwork.allen.domain.screen

const val PRODUCT_GRAPH = "PRODUCT_GRAPH"

sealed class ProductScreen(val route: String) {
    data object ViewProductScreen : ProductScreen("view_product_screen")
    data object ViewRatingScreen : ProductScreen("view_rating_screen")
    data object ViewQuestionScreen : ProductScreen("view_question_screen")
}