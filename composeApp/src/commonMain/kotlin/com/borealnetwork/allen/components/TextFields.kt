package com.borealnetwork.allen.components

import androidx.compose.runtime.Composable

//@Composable
//fun TestPreviewTextField() {
//    Column(
//        Modifier
//            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
//            .fillMaxSize()
//            .background(Color.White)
//    ) {
//        SearchOutlinedTextField(
//            value = "",
//            placeHolder = "Buscar"
//        )
//        OutlinedTextField(
//            helperText = "Correo",
//            value = "edew",
//            onValueChange = {},
//            placeHolder = "nombre@dominio.com",
//            errorMessage = "Error",
//            enabledCounter = true,
//            isError = true
//        )
//        OutlinedTextField(value = "holl", onValueChange = {})
//        TextField(value = "holl", onValueChange = {})
//    }
//}
//
//@Composable
//fun OutlinedTextField(
//    modifier: Modifier = Modifier,
//    placeHolder: String = "",
//    value: String,
//    onValueChange: (String) -> Unit,
//    isError: Boolean = false,
//    errorMessage: String = "",
//    keyboardOptions: KeyboardOptions = KeyboardOptions(
//        capitalization = KeyboardCapitalization.Words,
//        keyboardType = KeyboardType.Text
//    ),
//    keyboardActions: KeyboardActions = KeyboardActions { },
//    trailingIcon: @Composable (() -> Unit)? = null,
//    enabled: Boolean = true,
//    helperText: String = "",
//    enabledHelper: Boolean = false,
//    enabledCounter: Boolean = false,
//    maxLength: Int = 0,
//    singleLine: Boolean = false,
//    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(unfocusedLabelColor = GrayLetterHint),
//    visualTransformation: VisualTransformation = VisualTransformation.None
//) {
//    val interactionSource = remember { MutableInteractionSource() }
//    Column(modifier = modifier) {
//
//        Text(
//            modifier = Modifier.padding(bottom = 9.dp),
//            text = helperText,
//            color = Black,
//            fontWeight = SemiBold,
////            fontFamily = RobotoTypo.caption.fontFamily,
//            fontFamily = MaterialTheme.typography.caption.fontFamily,
//            fontSize = 15.sp
//        )
//
//        OutlinedTextField(
//            modifier = Modifier
//                .fillMaxWidth(),
//            textStyle = TextStyle(
//                color = Black,
//                fontWeight = SemiBold,
//                fontSize = 15.sp
//            ),
//            interactionSource = interactionSource,
//            value = value,
//            onValueChange = {
//                if (enabledCounter) {
//                    if (it.length <= maxLength) {
//                        onValueChange(it)
//                    }
//                } else
//                    onValueChange(it)
//            }, placeholder = {
//                Text(
//                    text = placeHolder,
//                    color = GrayLetterHint,
//                    fontWeight = SemiBold,
//                    fontSize = 15.sp
//                )
//            },
//            colors = colors,
//            isError = isError,
//            keyboardOptions = keyboardOptions,
//            keyboardActions = keyboardActions,
//            trailingIcon = trailingIcon,
//            enabled = enabled,
//            singleLine = singleLine,
//            visualTransformation = visualTransformation
//        )
//
//        ConstraintLayout(
//            modifier = Modifier.fillMaxWidth(),
//            constraintSet = buildHelperCounterConstraints()
//        ) {
//            Box(
//                modifier = Modifier
//                    .layoutId("helperText")
//            ) {
//                if (isError) {
//                    Text(
//                        text = errorMessage,
//                        color = MaterialTheme.colors.error,
//                        style = MaterialTheme.typography.caption
//                    )
//                } else if (enabledHelper && helperText.isNotEmpty()) {
//                    Text(
//                        text = helperText,
//                        color = GrayBorderLight,
//                        style = MaterialTheme.typography.caption
//                    )
//                }
//            }
//            Box(
//                modifier = Modifier
//                    .layoutId("counter")
//            ) {
//                if (enabledCounter) {
//                    Text(
//                        text = "${value.length}/${maxLength}",
//                        color = GrayLetterHint,
//                        fontWeight = SemiBold,
//                        fontSize = 15.sp
//                    )
//                }
//            }
//        }
//
//    }
//}
//
//@Composable
//fun TextField(
//    modifier: Modifier = Modifier,
//    placeHolder: String = "",
//    value: String,
//    onValueChange: (String) -> Unit,
//    isError: Boolean = false,
//    errorMessage: String = "",
//    keyboardOptions: KeyboardOptions = KeyboardOptions(
//        capitalization = KeyboardCapitalization.Words,
//        keyboardType = KeyboardType.Text
//    ),
//    keyboardActions: KeyboardActions = KeyboardActions { },
//    trailingIcon: @Composable (() -> Unit)? = null,
//    enabled: Boolean = true,
//    helperText: String = "",
//    enabledHelper: Boolean = false,
//    enabledCounter: Boolean = false,
//    maxLength: Int = 0,
//    singleLine: Boolean = false,
//    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
//        focusedBorderColor = MaterialTheme.colors.primary.copy(
//            alpha = 0f
//        ),
//        unfocusedBorderColor = MaterialTheme.colors.onSurface.copy(
//            alpha = 0f
//        ),
//        disabledBorderColor = MaterialTheme.colors.onSurface.copy(
//            alpha = 0f
//        ),
//        errorBorderColor = MaterialTheme.colors.error
//    ),
//    visualTransformation: VisualTransformation = VisualTransformation.None,
//    hideText: Boolean = true
//) {
//    val interactionSource = remember { MutableInteractionSource() }
//    Column(modifier = modifier, verticalArrangement = Arrangement.Top) {
//        if (!hideText) {
//            Text(
//                modifier = Modifier.padding(bottom = 9.dp),
//                text = helperText,
//                color = Black,
//                fontWeight = SemiBold,
//                fontFamily = MaterialTheme.typography.caption.fontFamily,
//                fontSize = 15.sp
//            )
//        }
//
//        OutlinedTextField(
//            modifier = Modifier
//                .fillMaxWidth(),
//            textStyle = TextStyle(
//                color = GrayBorder,
//                fontWeight = Bold,
//                fontSize = 25.sp
//            ),
//            interactionSource = interactionSource,
//            value = value,
//            onValueChange = {
//                if (enabledCounter) {
//                    if (it.length <= maxLength) {
//                        onValueChange(it)
//                    }
//                } else
//                    onValueChange(it)
//            }, placeholder = {
//                Text(
//                    text = placeHolder,
//                    color = GrayLetterHint,
//                    fontWeight = SemiBold,
//                    fontSize = 15.sp
//                )
//            },
//            colors = colors,
//            isError = isError,
//            keyboardOptions = keyboardOptions,
//            keyboardActions = keyboardActions,
//            trailingIcon = trailingIcon,
//            enabled = enabled,
//            singleLine = singleLine,
//            visualTransformation = visualTransformation
//        )
//
//        ConstraintLayout(
//            modifier = Modifier.fillMaxWidth(),
//            constraintSet = buildHelperCounterConstraints()
//        ) {
//            Box(
//                modifier = Modifier
//                    .layoutId("helperText")
//            ) {
//                if (isError) {
//                    Text(
//                        text = errorMessage,
//                        color = MaterialTheme.colors.error,
//                        style = MaterialTheme.typography.caption
//                    )
//                } else if (enabledHelper && helperText.isNotEmpty()) {
//                    Text(
//                        text = helperText,
//                        color = GrayBorderLight,
//                        style = MaterialTheme.typography.caption
//                    )
//                }
//            }
//            Box(
//                modifier = Modifier
//                    .layoutId("counter")
//            ) {
//                if (enabledCounter) {
//                    Text(
//                        text = "${value.length}/${maxLength}",
//                        color = GrayLetterHint,
//                        fontWeight = SemiBold,
//                        fontSize = 15.sp
//                    )
//                }
//            }
//        }
//
//    }
//}
//
//fun buildHelperCounterConstraints(): ConstraintSet {
//    return ConstraintSet {
//        val helperText = createRefFor("helperText")
//        val counter = createRefFor("counter")
//
//        constrain(helperText) {
//            top.linkTo(parent.top)
//            start.linkTo(parent.start)
//            end.linkTo(counter.start)
//            width = Dimension.fillToConstraints
//        }
//        constrain(counter) {
//            top.linkTo(parent.top)
//            end.linkTo(parent.end)
//        }
//    }
//}