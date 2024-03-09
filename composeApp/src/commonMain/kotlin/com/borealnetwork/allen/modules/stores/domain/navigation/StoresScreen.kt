package com.borealnetwork.allen.modules.stores.domain.navigation

sealed class StoresScreen(val route : String){

    data object StoresInMapScreen: StoresScreen("stores_in_map_screen")
}