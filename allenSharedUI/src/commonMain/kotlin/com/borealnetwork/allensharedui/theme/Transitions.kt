package com.borealnetwork.allensharedui.theme

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import moe.tlaster.precompose.navigation.transition.NavTransition

fun defaultTransition(duration: Int = 150) = NavTransition(
    createTransition = slideInHorizontally(
        initialOffsetX = { -300 }, // small slide 300px
        animationSpec = tween(
            durationMillis = duration,
            easing = LinearEasing // interpolator
        )
    ),
    destroyTransition = slideOutHorizontally(
        targetOffsetX = { -300 },
        animationSpec = tween(
            durationMillis = duration,
            easing = LinearEasing
        )
    ),
    pauseTransition = slideOutHorizontally(
        targetOffsetX = { -300 },
        animationSpec = tween(
            durationMillis = duration,
            easing = LinearEasing
        )
    ),
    resumeTransition = slideInHorizontally(
        initialOffsetX = { -300 }, // small slide 300px
        animationSpec = tween(
            durationMillis = duration,
            easing = LinearEasing // interpolator
        )
    )
)