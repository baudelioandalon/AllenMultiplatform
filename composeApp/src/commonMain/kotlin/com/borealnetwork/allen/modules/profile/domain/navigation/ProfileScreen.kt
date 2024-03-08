package com.borealnetwork.allen.modules.profile.domain.navigation


const val RESULT_BY_SELLER_CLIENT_GRAPH = "RESULT_BY_SELLER_CLIENT_GRAPH"


const val FAVORITES_GRAPH = "FAVORITES_GRAPH"
const val STORES_MAPS_GENERAL_GRAPH = "STORES_MAPS_GENERAL_GRAPH"
const val STATUS_GRAPH = "STATUS_GRAPH"

//Profile

sealed class ProfileScreen(val route: String) {
    data object AddressClientScreen : ProfileScreen("address_client_screen")
    data object NewAddressClientScreen : ProfileScreen("new_address_client_screen")
}