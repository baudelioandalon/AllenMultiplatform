package com.borealnetwork.allen.modules.notifications.domain.navigation

import com.borealnetwork.allen.domain.screen.NOTIFICATION_CLIENT_GRAPH
import com.borealnetwork.allen.modules.notifications.presentation.ui.client.NotificationClientViewCompose
import com.borealnetwork.allen.tools.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.notificationClientNavigationGraph(navigator: Navigator) {
    scene(
        route = NOTIFICATION_CLIENT_GRAPH,
        navTransition = defaultTransition(),
    ) {
        NotificationClientViewCompose(navigator)
    }
}