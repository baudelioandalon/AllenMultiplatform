package com.borealnetwork.allen.domain.payments

data class CardModel(
    val aliasCard: String,
    val holderName: String,
    val lastFourNumber: Int,
    val month: String,
    val year: String,
    val type: TypeCard
)
