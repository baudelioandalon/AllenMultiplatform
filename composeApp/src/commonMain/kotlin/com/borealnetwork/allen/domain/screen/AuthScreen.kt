package com.borealnetwork.allen.domain.screen

const val ROOT_GRAPH = "ROOT_GRAPH"
const val ROOT_SELLER_GRAPH = "ROOT_SELLER_GRAPH"
const val LOGIN_GRAPH = "LOGIN_GRAPH"

sealed class AuthScreen(val route: String) {
    data object WelcomeLoginScreen : AuthScreen("welcome_screen")
    data object LoginLoginScreen : AuthScreen("login_screen")
    data object RegisterLoginScreen : AuthScreen("register_screen")
}