package com.borealnetwork.allensharedui.components.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.borealnetwork.allensharedui.theme.loadingString
import io.github.alexzhirkevich.compottie.LottieAnimation
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.LottieConstants
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition

@Composable
fun Loading(
    showOrHide: Boolean,
    modifier: Modifier = Modifier,
    onDismissDialog: (() -> Unit )? = null
) {
    if (showOrHide) {
        Dialog(
            onDismissRequest = {
                onDismissDialog?.invoke()
            },
            properties = DialogProperties(
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false
            )
        ) {
            Surface(
                modifier = modifier.fillMaxSize(),
                color = Color.Transparent
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    val composition by rememberLottieComposition(
                        LottieCompositionSpec.JsonString(
                            loadingString
                        )
                    )

                    val progress = animateLottieCompositionAsState(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LottieAnimation(
                            modifier = Modifier.fillMaxSize(),
                            composition = composition,
                            progress = { progress.value },
                        )
                    }
                }
            }
        }

    }
}