package com.borealnetwork.shared.core.firestore.data.repository.products

import com.borealnetwork.shared.core.firestore.data.data_source.products.GetProductsDataSource
import com.borealnetwork.shared.core.firestore.domain.interfaces.ProductsRepository
import kotlinx.coroutines.flow.flow

class DefaultProductsRepository(
    private val getProductsDataSource: GetProductsDataSource
) : ProductsRepository {

    override suspend fun executeProducts(collectionPath: String) =
        flow {
            emit(getProductsDataSource.executeGetProducts(collectionPath))
        }

}