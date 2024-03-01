package com.borealnetwork.allen.domain.payments

import androidx.compose.ui.graphics.Color
import com.borealnetwork.allen.tools.getGradient

data class CardModel(
    val aliasCard: String,
    val holderName: String,
    val lastFourNumber: Int,
    val month: String,
    val year: String,
    val type: TypeCard,
    val listColor: List<Color> = getGradient()
)
