package com.borealnetwork.allen.modules.auth.domain.navigation

import com.borealnetwork.allen.modules.auth.domain.view_model.LoginViewModel
import com.borealnetwork.allen.modules.auth.presentation.ui.login.LoginViewCompose
import com.borealnetwork.allen.modules.auth.presentation.ui.register.RegisterViewCompose
import com.borealnetwork.allen.modules.auth.presentation.ui.welcome.WelcomeViewCompose
import com.borealnetwork.allen.modules.home_client.domain.view_model.HomeClientViewModel
import com.borealnetwork.allen.modules.home_client.presentation.ui.home.HomeClientViewCompose
import com.borealnetwork.allen.modules.product.domain.view_models.ShowProductViewModel
import com.borealnetwork.allensharedui.theme.defaultTransition
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

fun RouteBuilder.welcomeNavigationGraph(
    navigator: Navigator,
    homeClientViewModel: HomeClientViewModel,
    showProductViewModel: ShowProductViewModel
) {
    scene(
        route = AuthScreen.WelcomeScreen.route,
        navTransition = defaultTransition()
    ) {
        if (Firebase.auth.currentUser != null) {
            HomeClientViewCompose(navigator, homeClientViewModel, showProductViewModel)
        } else {
            WelcomeViewCompose(navigator)
        }
    }
}