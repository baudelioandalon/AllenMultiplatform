package com.borealnetwork.allen.modules.auth.domain.navigation

import com.borealnetwork.allen.modules.auth.presentation.ui.login.LoginViewCompose
import com.borealnetwork.allen.modules.auth.presentation.ui.register.RegisterViewCompose
import com.borealnetwork.allen.modules.auth.presentation.ui.welcome.WelcomeViewCompose
import com.borealnetwork.allen.tools.defaultTransition
import com.borealnetwork.allen.viewmodel.LoginViewModel
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.loginNavigationGraph(navigator: Navigator, loginViewModel: LoginViewModel) {
    scene(
        route = AuthScreen.LoginScreen.route,
        navTransition = defaultTransition()
    ) {
        LoginViewCompose(navigator, loginViewModel)
    }
}

fun RouteBuilder.registerNavigationGraph(navigator: Navigator) {
    scene(
        route = AuthScreen.RegisterScreen.route,
        navTransition = defaultTransition()
    ) {
        RegisterViewCompose(navigator)
    }
}

fun RouteBuilder.welcomeNavigationGraph(navigator: Navigator) {
    scene(
        route = AuthScreen.WelcomeScreen.route,
        navTransition = defaultTransition()
    ) {
        WelcomeViewCompose(navigator)
    }
}