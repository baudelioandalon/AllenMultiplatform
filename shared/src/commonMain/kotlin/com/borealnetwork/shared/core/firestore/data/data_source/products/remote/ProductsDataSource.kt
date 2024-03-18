package com.borealnetwork.shared.core.firestore.data.data_source.products.remote

import com.borealnetwork.shared.core.auth.domain.base.FirestoreRepository
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import com.borealnetwork.shared.domain.models.StateApi
import com.borealnetwork.shared.domain.models.product.ProductCompleteModel

class ProductsDataSource {
    companion object : FirestoreRepository() {
        suspend fun getProducts(
            collectionPath: String = "products",
        ): ApiResponse<List<ProductCompleteModel>> = try {
            val userResponse = firebaseFirestore.collection(collectionPath).get()

            ApiResponse(
                response = userResponse.documents.map {
                    it.data()
                },
                status = StateApi.Success
            )


        } catch (exception: Exception) {
            ApiResponse(
                failure = errorResponse(exception),
                status = StateApi.Error
            )
        }

    }


}