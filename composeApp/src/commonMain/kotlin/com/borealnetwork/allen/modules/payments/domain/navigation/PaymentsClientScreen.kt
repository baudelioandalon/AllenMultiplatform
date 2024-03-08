package com.borealnetwork.allen.modules.payments.domain.navigation

sealed class ProfileScreen(val route: String) {
    data object NewCardClientScreen : ProfileScreen("new_card_client_screen")
    data object PaymentsMethodClientScreen : ProfileScreen("payments_method_client_screen")
}