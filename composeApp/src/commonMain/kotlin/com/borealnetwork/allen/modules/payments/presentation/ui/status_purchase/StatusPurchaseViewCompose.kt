package com.borealnetwork.allen.modules.payments.presentation.ui.status_purchase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.SemiBoldText
import com.borealnetwork.allen.domain.enum.StatusEnum
import com.borealnetwork.allen.theme.ErrorColor
import com.borealnetwork.allen.theme.SuccessColor
import com.borealnetwork.allen.theme.WarningColor
import org.jetbrains.compose.resources.painterResource

@Composable
fun StatusPurchaseViewCompose(
    titleText: String = "titleText",
    type: StatusEnum = StatusEnum.SUCCESS,
    subtitleText: String = "subtitleText",
    bottomText: String = "bottomText"
) {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(
                when (type) {
                    StatusEnum.SUCCESS -> SuccessColor
                    StatusEnum.WARNING -> WarningColor
                    else -> ErrorColor
                }
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SemiBoldText(
            text = titleText,
            textAlign = TextAlign.Center,
            color = White,
            fontSize = 30.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 150.dp),
            painter = painterResource(
                res = when (type) {
                    StatusEnum.SUCCESS -> "ic_success_status.xml"
                    StatusEnum.WARNING -> "ic_warning_status.xml"
                    else -> "ic_error_status.xml"
                }
            ),
            contentDescription = "imgType"
        )
        SemiBoldText(
            text = subtitleText,
            textAlign = TextAlign.Center,
            color = White,
            fontSize = 25.sp
        )
        SemiBoldText(
            text = bottomText,
            textAlign = TextAlign.Center,
            color = White,
            fontSize = 14.sp
        )
    }

}