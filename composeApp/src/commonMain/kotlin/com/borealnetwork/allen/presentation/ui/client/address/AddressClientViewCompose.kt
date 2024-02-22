package com.borealnetwork.allen.presentation.ui.client.address

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.components.AddressSelector
import com.borealnetwork.allen.components.BottomContinueItem
import com.borealnetwork.allen.components.NewAddressSelector
import com.borealnetwork.allen.components.ResumeItem
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.theme.GrayBackgroundMain

@Composable
fun AddressClientViewCompose() {
    Scaffold(
        topBar = {
            ToolbarTitle(
                titleText = "Mis direcciónes", startClicked = {
//                    navController?.navigateUp()
                }, showEndImage = false
            )
        },
        bottomBar = {
            BottomContinueItem()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {
            item {
                ResumeItem(title = "Dirección") {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                    ) {
                        AddressSelector(
                            textTop = "Casa",
                            iconRes = "ic_house.xml",
                            selected = true
                        )
                        AddressSelector(
                            modifier = Modifier.padding(top = 20.dp),
                            textTop = "Trabajo",
                            iconRes = "ic_briefcase.xml"
                        )
                        NewAddressSelector(
                            modifier = Modifier.padding(top = 20.dp)
                        )
                    }
                }
            }
        }
        it.calculateBottomPadding()
    }

}