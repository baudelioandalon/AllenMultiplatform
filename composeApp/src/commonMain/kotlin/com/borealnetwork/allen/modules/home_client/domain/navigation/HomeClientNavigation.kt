package com.borealnetwork.allen.modules.home_client.domain.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.ui.unit.IntOffset
import com.borealnetwork.allen.domain.screen.HOME_CLIENT_GRAPH
import com.borealnetwork.allen.modules.home_client.presentation.ui.home.HomeClientViewCompose
import com.borealnetwork.allen.tools.defaultTransition
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder
import moe.tlaster.precompose.navigation.transition.NavTransition

fun RouteBuilder.homeClientNavigationGraph(navigator: Navigator){
    scene(
        // Scene's route path
        route = HOME_CLIENT_GRAPH,
        // Navigation transition for this scene, this is optional
        navTransition = defaultTransition(),
    ) {
        HomeClientViewCompose(navigator)
    }
}