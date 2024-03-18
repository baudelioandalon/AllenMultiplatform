package com.borealnetwork.allen.modules.notifications.domain.navigation

import com.borealnetwork.allen.modules.notifications.presentation.ui.client.NotificationClientViewCompose
import com.borealnetwork.allensharedui.theme.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.notificationClientNavigationGraph(navigator: Navigator) {
    scene(
        route = NotificationsClientScreen.NotificationsDefaultClientScreen.route,
        navTransition = defaultTransition(),
    ) {
        NotificationClientViewCompose(navigator)
    }
}