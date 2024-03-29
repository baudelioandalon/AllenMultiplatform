package com.borealnetwork.shared.domain.models.cart

import com.borealnetwork.shared.tools.discount
import com.borealnetwork.shared.tools.round
import com.borealnetwork.shared.tools.rounded

data class ItemCartModel(
    val nameStore: String,
    val idStore: String,
    val imgStore: String,
    val listItems: List<ProductShoppingCart>
)

data class ProductShoppingCart(
    val skuProduct: String,
    val nameProduct: String,
    val imgProduct: String,
    val categoryItem: String,
    val quantity: Int,
    val discountPercentage: Int,
    val fastOrder: Boolean,
    val description: String = "",
    val minimalFastOrder: Int,
    val price: Double
) {
    fun finalPriceInString() = price.discount(discountPercentage).round().rounded()
}

data class MinimalProductModel(
    val skuProduct: String,
    val nameProduct: String,
    val imgProduct: String,
    val categoryItem: String,
    val price: Double,
    val discountPercentage: Double
)