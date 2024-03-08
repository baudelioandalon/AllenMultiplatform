package com.borealnetwork.allen.modules.home_client.domain.navigation


sealed class HomeClientScreen(val route: String) {
    data object HomeDefaultClientScreen : HomeClientScreen("home_client_screen")
}