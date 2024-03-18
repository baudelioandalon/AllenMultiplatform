package com.borealnetwork.allen.modules.product.domain.navigation

import com.borealnetwork.allen.modules.product.presentation.ui.favorites.FavoritesClientViewCompose
import com.borealnetwork.allen.modules.product.presentation.ui.question.QuestionViewCompose
import com.borealnetwork.allen.modules.product.presentation.ui.rating.RatingProductViewCompose
import com.borealnetwork.allen.modules.product.presentation.ui.result_client.ResultProductsViewCompose
import com.borealnetwork.allen.modules.product.presentation.ui.search.SearchProductViewCompose
import com.borealnetwork.allen.modules.product.presentation.ui.show_product.ShowProductViewCompose
import com.borealnetwork.allensharedui.theme.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.searchClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ProductClientScreen.SearchClientScreen.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition()
    ) {
        SearchProductViewCompose(navigator)
    }
}

fun RouteBuilder.resultProductsClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ProductClientScreen.ResultProductsClient.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        ResultProductsViewCompose(navigator)
    }
}

fun RouteBuilder.showProductClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ProductClientScreen.ShowProductClient.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        ShowProductViewCompose(navigator)
    }
}

fun RouteBuilder.ratingProductClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ProductClientScreen.RatingProductClient.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        RatingProductViewCompose(navigator)
    }
}

fun RouteBuilder.questionsProductClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ProductClientScreen.QuestionProductClient.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        QuestionViewCompose(navigator)
    }
}

fun RouteBuilder.favoritesClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = ProductClientScreen.FavoritesProductsClient.route,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        FavoritesClientViewCompose(navigator)
    }

}