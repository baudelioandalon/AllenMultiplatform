package com.borealnetwork.allensharedui.theme

import kotlin.random.Random

fun getGradient() = listOf(
    startColors[Random.nextInt(startColors.lastIndex)],
    endColors[Random.nextInt(endColors.lastIndex)],
)