package com.borealnetwork.shared.domain.models.payments

import androidx.compose.ui.graphics.Color

data class CardModel(
    val aliasCard: String,
    val holderName: String,
    val lastFourNumber: Int,
    val month: String,
    val year: String,
    val type: TypeCard,
    val listColor: List<Color>
)
