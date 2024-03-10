package com.borealnetwork.allen.modules.auth.domain.navigation

sealed class AuthScreen(val route: String){

    data object WelcomeScreen: AuthScreen("welcome_screen")
    data object RegisterScreen: AuthScreen("registere_screen")
    data object LoginScreen: AuthScreen("login_screen")
}