package com.borealnetwork.shared.domain.models.product

import kotlinx.serialization.Serializable

@Serializable
data class ProductCompleteModel(
    val attributes: List<AttributeProductModel>,
    val categoryItem: String,
    val comments: List<CommentProductModel>,
    val description: String,
    val discount: Double,
    val idSeller: String,
    val minimalFreeShipping: Double,
    val nameProduct: String,
    val price: Double,
    val quantity: Double,
    val rating: List<RatingProductModel>,
    val skuProduct: String,
    val variants: List<VariantProductModel>
)

@Serializable
data class AttributeProductModel(
    val name: String,
    val options: List<String>
)


@Serializable
data class CommentProductModel(
    val answer: String,
    val idClient: String,
    val idSeller: String,
    val likes: List<String>,
    val question: String
)

@Serializable
data class RatingProductModel(
    val description: String,
    val idClient: String,
    val imgClient: String,
    val imgs: List<String>,
    val likes: List<String>,
    val stars: Double
)

@Serializable
data class VariantProductModel(
    val attributes: List<UniqueAttributeProductModel>,
    val images: List<String>,
    val price: Double,
    val skuProduct: String
)

@Serializable
data class UniqueAttributeProductModel(
    val name: String,
    val value: String
)