package com.borealnetwork.allen.tools

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import com.borealnetwork.allen.theme.endColors
import com.borealnetwork.allen.theme.startColors
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import moe.tlaster.precompose.navigation.transition.NavTransition
import kotlin.math.round
import kotlin.random.Random


fun String.isEmailValid() = if (trim { it <= ' ' }.isEmpty()) {
    false
} else {
    val emailAddressRegex = Regex(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    matches(emailAddressRegex)
}

fun <E> List<E>.limit() = size - 1


fun getGradient() = listOf(
    startColors[Random.nextInt(startColors.lastIndex)],
    endColors[Random.nextInt(endColors.lastIndex)],
)

fun todaysDate(): String {
    fun LocalDateTime.format() = toString().substringBefore('T')

    val now = Clock.System.now()
    val zone = TimeZone.currentSystemDefault()
    return now.toLocalDateTime(zone).format()
}

fun Double.round(decimals: Int = 2): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}

fun Double.rounded(): String {
    return if (rem(1.0).toString().substringAfter('.').length == 1) {
        "${this}0"
    } else {
        toString()
    }
}

fun Double.discount(porcentage: Int): Double {
    return if (porcentage != 0) this - (this * (porcentage / 100.0)) else this
}

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