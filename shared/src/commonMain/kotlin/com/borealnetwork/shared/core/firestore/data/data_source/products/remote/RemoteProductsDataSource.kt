package com.borealnetwork.shared.core.firestore.data.data_source.products.remote

import com.borealnetwork.shared.core.firestore.data.data_source.products.GetProductsDataSource

class RemoteProductsDataSource : GetProductsDataSource {

    override suspend fun executeGetProducts(collectionPath: String) =
        ProductsDataSource.getProducts(collectionPath)

}
