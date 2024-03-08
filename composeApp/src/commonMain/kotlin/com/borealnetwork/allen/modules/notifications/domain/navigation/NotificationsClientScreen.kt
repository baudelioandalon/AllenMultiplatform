package com.borealnetwork.allen.modules.notifications.domain.navigation


sealed class NotificationsClientScreen(val route: String) {
    data object NotificationsDefaultClientScreen : NotificationsClientScreen("notifications_client_screen")
}