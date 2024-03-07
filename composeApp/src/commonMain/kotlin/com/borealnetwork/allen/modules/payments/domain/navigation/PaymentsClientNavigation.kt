package com.borealnetwork.allen.modules.payments.domain.navigation

import com.borealnetwork.allen.domain.screen.NEW_CARD_CLIENT_GRAPH
import com.borealnetwork.allen.domain.screen.PAYMENTS_METHOD_CLIENT_GRAPH
import com.borealnetwork.allen.modules.payments.presentation.ui.cards.NewCardViewCompose
import com.borealnetwork.allen.modules.payments.presentation.ui.selector.PaymentMethodsViewCompose
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder
import moe.tlaster.precompose.navigation.transition.NavTransition

fun RouteBuilder.newCardClientNavigationGraph(navigator: Navigator) {
    scene(
        route = NEW_CARD_CLIENT_GRAPH,
        navTransition = NavTransition(),
    ) {
        NewCardViewCompose(navigator)
    }
}

fun RouteBuilder.paymentsMethodClientNavigationGraph(navigator: Navigator) {
    scene(
        route = PAYMENTS_METHOD_CLIENT_GRAPH,
        navTransition = NavTransition(),
    ) {
        PaymentMethodsViewCompose(navigator)
    }
}