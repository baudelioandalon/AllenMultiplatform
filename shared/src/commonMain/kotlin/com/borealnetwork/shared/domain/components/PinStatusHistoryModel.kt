package com.borealnetwork.shared.domain.components

import androidx.compose.runtime.Composable

data class PinStatusHistoryModel(
    val origin: String,
    val destiny: String,
    val icon: @Composable () -> Unit
)