package com.borealnetwork.allen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun LogoBlue(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.width(75.dp).fillMaxWidth(),
        painter = painterResource(resource = DrawableResource(  "allen_blue_logo.xml")), contentDescription = "allenIcon"
    )
}