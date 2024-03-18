package com.borealnetwork.shared.tools

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.math.round


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

fun <E> List<E>.firstItem() = 0


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
    val remResultAfter = rem(1.0).toString().substringAfter('.')
    val remSize = remResultAfter.length
    return if (remSize == 1) {
        "${this}0"
    } else if (remSize > 2) {
        "${this.toString().substringBefore('.')}.${remResultAfter.substring(0, 2)}"
    } else {
        toString()
    }
}

fun Double.discount(porcentage: Int): Double {
    return if (porcentage != 0) this - (this * (porcentage / 100.0)) else this
}

