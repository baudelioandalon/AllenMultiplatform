package com.borealnetwork.allen.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.theme.GrayLetterHint
import com.borealnetwork.allen.theme.robotoMediumTypo
import com.borealnetwork.allen.theme.semiBoldTypo

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

@Composable
fun EditTextTopLabel(
    modifier: Modifier = Modifier,
    placeHolderText: String = "",
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Words,
        keyboardType = KeyboardType.Text
    ),
    keyboardActions: KeyboardActions = KeyboardActions { },
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    topLabelText: String = "",
    enabledHelper: Boolean = false,
    enabledCounter: Boolean = false,
    maxLength: Int = 0,
    singleLine: Boolean = false,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(unfocusedLabelColor = GrayLetterHint),
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    var text by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    Column(modifier = modifier) {

        Text(
            modifier = Modifier.padding(bottom = 9.dp),
            text = topLabelText,
            color = Color.Black,
            fontSize = 15.sp,
            fontFamily = robotoMediumTypo()
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(
                fontFamily = semiBoldTypo(),
                color = Color.Black,
                fontWeight = SemiBold,
                fontSize = 15.sp
            ),
            interactionSource = interactionSource,
            value = text,
            onValueChange = {
                text = it
                if (enabledCounter) {
                    if (it.length <= maxLength) {
                        onValueChange(it)
                    }
                } else {
                    onValueChange(it)
                }
            }, placeholder = {
                SemiBoldText(
                    text = placeHolderText,
                    color = GrayLetterHint,
                    fontSize = 15.sp
                )
            },
            colors = colors,
            isError = isError,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            trailingIcon = trailingIcon,
            enabled = enabled,
            singleLine = singleLine,
            visualTransformation = visualTransformation
        )
    }
}