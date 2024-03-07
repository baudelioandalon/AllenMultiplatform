package com.borealnetwork.allen.modules.product.domain.navigation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.ui.unit.IntOffset
import com.borealnetwork.allen.domain.screen.PRODUCT_DETAIL_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.QUESTION_PRODUCT_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.RATING_PRODUCT_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.RESULT_PRODUCTS_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.SEARCH_CLIENT_GRAPH
import com.borealnetwork.allen.modules.product.presentation.ui.detail_product.DetailProductViewCompose
import com.borealnetwork.allen.modules.product.presentation.ui.question.QuestionViewCompose
import com.borealnetwork.allen.modules.product.presentation.ui.rating.RatingProductViewCompose
import com.borealnetwork.allen.modules.product.presentation.ui.result_client.ResultProductsViewCompose
import com.borealnetwork.allen.modules.product.presentation.ui.search.SearchProductViewCompose
import com.borealnetwork.allen.tools.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder
import moe.tlaster.precompose.navigation.transition.NavTransition

fun RouteBuilder.searchClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = SEARCH_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition()
    ) {
        SearchProductViewCompose(navigator)
    }
}

fun RouteBuilder.resultProductsClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = RESULT_PRODUCTS_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        ResultProductsViewCompose(navigator)
    }
}

fun RouteBuilder.detailProductClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = PRODUCT_DETAIL_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        DetailProductViewCompose(navigator)
    }
}

fun RouteBuilder.ratingProductClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = RATING_PRODUCT_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        RatingProductViewCompose(navigator)
    }
}

fun RouteBuilder.questionsProductClientNavigationGraph(navigator: Navigator) {
    scene(
        // Scene's route path
        route = QUESTION_PRODUCT_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        QuestionViewCompose(navigator)
    }
}