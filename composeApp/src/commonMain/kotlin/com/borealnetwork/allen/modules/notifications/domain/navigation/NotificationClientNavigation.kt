package com.borealnetwork.allen.modules.notifications.domain.navigation

import com.borealnetwork.allen.domain.screen.NOTIFICATION_CLIENT_GRAPH
import com.borealnetwork.allen.modules.notifications.presentation.ui.client.NotificationClientViewCompose
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder
import moe.tlaster.precompose.navigation.transition.NavTransition

fun RouteBuilder.notificationClientNavigationGraph(navigator: Navigator) {
    scene(
        route = NOTIFICATION_CLIENT_GRAPH,
        navTransition = NavTransition(),
    ) {
        NotificationClientViewCompose(navigator)
    }
}