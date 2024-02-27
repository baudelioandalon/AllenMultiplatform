package com.borealnetwork.allen.tools

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.borealnetwork.allen.theme.endColors
import com.borealnetwork.allen.theme.startColors
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


fun getGradient() =listOf(
    startColors[Random.nextInt(startColors.lastIndex)],
    endColors[Random.nextInt(endColors.lastIndex)],
    )