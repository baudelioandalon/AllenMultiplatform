package com.borealnetwork.allen.modules.payments.domain.navigation

import com.borealnetwork.allen.modules.payments.presentation.ui.new_card.NewCardViewCompose
import com.borealnetwork.allen.modules.payments.presentation.ui.payments_methods.PaymentMethodsViewCompose
import com.borealnetwork.allensharedui.theme.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.newCardClientNavigationGraph(navigator: Navigator) {
    scene(
        route = ProfileScreen.NewCardClientScreen.route,//TODO FALTA AGREGARLO A LA NAVEGACIÓN
        navTransition = defaultTransition(),
    ) {
        NewCardViewCompose(navigator)
    }
}

fun RouteBuilder.paymentsMethodClientNavigationGraph(navigator: Navigator) {
    scene(
        route = ProfileScreen.PaymentsMethodClientScreen.route,
        navTransition = defaultTransition(),
    ) {
        PaymentMethodsViewCompose(navigator)
    }
}