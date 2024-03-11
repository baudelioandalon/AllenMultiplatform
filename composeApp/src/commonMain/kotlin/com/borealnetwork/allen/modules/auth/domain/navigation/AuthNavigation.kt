package com.borealnetwork.allen.modules.auth.domain.navigation

import com.borealnetwork.allen.modules.auth.domain.view_models.LoginViewModel
import com.borealnetwork.allen.modules.auth.presentation.ui.login.LoginViewCompose
import com.borealnetwork.allen.modules.auth.presentation.ui.register.RegisterViewCompose
import com.borealnetwork.allen.modules.auth.presentation.ui.welcome.WelcomeViewCompose
import com.borealnetwork.allen.modules.home_client.presentation.ui.home.HomeClientViewCompose
import com.borealnetwork.allen.tools.defaultTransition
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

fun RouteBuilder.loginNavigationGraph(
    navigator: Navigator,
    loginViewModel: LoginViewModel
) {
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
        if (Firebase.auth.currentUser != null) {
            HomeClientViewCompose(navigator)
        } else {
            WelcomeViewCompose(navigator)
        }
    }
}