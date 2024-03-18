package com.borealnetwork.shared.core.firestore.domain.interfaces

import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import com.borealnetwork.shared.domain.models.product.ProductCompleteModel
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun executeProducts(collectionPath: String):
            Flow<ApiResponse<List<ProductCompleteModel>>>
}