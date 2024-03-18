package com.borealnetwork.shared.core.firestore.data.data_source.products

import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import com.borealnetwork.shared.domain.models.product.ProductCompleteModel


interface GetProductsDataSource {

    suspend fun executeGetProducts(
        collectionPath: String
    ): ApiResponse<List<ProductCompleteModel>>

}