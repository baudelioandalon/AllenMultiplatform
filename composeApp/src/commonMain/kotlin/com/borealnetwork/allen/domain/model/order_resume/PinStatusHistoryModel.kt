package com.borealnetwork.allen.domain.model.order_resume

import androidx.compose.runtime.Composable

data class PinStatusHistoryModel(
    val origin: String,
    val destiny: String,
    val icon: @Composable () -> Unit
)