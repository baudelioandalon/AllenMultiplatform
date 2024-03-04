package com.borealnetwork.allen.tools

import com.borealnetwork.allen.theme.endColors
import com.borealnetwork.allen.theme.startColors
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
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

fun Double.discount(porcentage: Int): Double {
    return this - (this * (porcentage/100.0))
}