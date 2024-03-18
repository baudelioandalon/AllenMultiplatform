package com.borealnetwork.allensharedui.components.drawer.model

data class MenuItem(
    val title: String,
    val icon: String,
    val contentDescription: String,
    val option: DrawerOptions,
    val close: Int = -1
)

sealed class DrawerOptions(val name: String) {
    //Client
    object Buys : DrawerOptions("BUYS")
    object Favorites : DrawerOptions("FAVORITES")
    object Stores : DrawerOptions("STORES")

    //Seller
    object MyProducts : DrawerOptions("MY_PRODUCTS")
    object Sales : DrawerOptions("SALES")
    object MyStores : DrawerOptions("MY_STORES")

    //General
    object Notifications : DrawerOptions("NOTIFICATIONS")
    object Exit : DrawerOptions("EXIT")
    object CloseSession : DrawerOptions("CLOSE_SESSION")

    //BussinessInformation
    object Main : DrawerOptions("MAIN")
    object Contact : DrawerOptions("CONTACT")
    object ShippingAndPayments : DrawerOptions("SHIPPING_AND_PAYMENTS")
    object Promotion : DrawerOptions("PROMOTION")
    object Save : DrawerOptions("Save")

    //Add product
    object Category : DrawerOptions("CATEGORY")
    object Details : DrawerOptions("DETAILS")
    object Price : DrawerOptions("PRICE")
    object Tags : DrawerOptions("TAGS")
}