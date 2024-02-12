package com.borealnetwork.allen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import com.borealnetwork.allen.theme.GrayLetterHint

@Composable
fun EditText(
    modifier: Modifier = Modifier,
    placeHolderText: String? = null,
    topLabelText: String? = null,
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var focused by remember { mutableStateOf(false) }
    OutlinedTextField(modifier = modifier.fillMaxWidth().onFocusChanged {
        focused = it.isFocused
    },
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        placeholder = { SemiBoldText(text = placeHolderText.orEmpty(), color = GrayLetterHint) },
        label = {
            if (focused || !focused && text.isNotEmpty()) RegularText(text = topLabelText.orEmpty()) else SemiBoldText(
                text = topLabelText.orEmpty(),
                color = GrayLetterHint
            )
        })
}