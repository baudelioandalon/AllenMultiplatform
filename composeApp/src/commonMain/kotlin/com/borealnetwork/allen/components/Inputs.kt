package com.borealnetwork.allen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EditText(
    modifier: Modifier = Modifier,
    placeHolderText: String? = null,
    topLabelText: String? = null,
    onValueChange: (String) -> Unit,
    value: String
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        placeholder = { SemiBoldText(text = placeHolderText.orEmpty()) },
        label = { SemiBoldText(text = topLabelText.orEmpty()) }
    )
}