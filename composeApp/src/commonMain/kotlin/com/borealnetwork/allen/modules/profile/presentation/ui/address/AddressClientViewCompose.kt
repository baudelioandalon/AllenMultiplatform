package com.borealnetwork.allen.modules.profile.presentation.ui.address

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.borealnetwork.allensharedui.components.AddressSelector
import com.borealnetwork.allensharedui.components.NewAddressSelector
import com.borealnetwork.allensharedui.components.ResumeItem
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allensharedui.components.bottom_actions.BottomContinueItem
import com.borealnetwork.allen.modules.profile.domain.navigation.ProfileScreen
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun AddressClientViewCompose(navigator: Navigator) {
    Scaffold(
        topBar = {
            ToolbarTitle(
                titleText = "Mis direcciónes",
                startClicked = {
                    navigator.goBack()
                }, showEndImage = false
            )
        },
        bottomBar = {
            BottomContinueItem {
                navigator.goBack()
            }
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
                        ) {
                            navigator.navigate(ProfileScreen.NewAddressClientScreen.route)
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(200.dp))
            }
        }
        it.calculateBottomPadding()
    }

}