package com.borealnetwork.shared.core.firestore.di


import com.borealnetwork.shared.core.firestore.data.data_source.products.GetProductsDataSource
import com.borealnetwork.shared.core.firestore.data.data_source.products.remote.RemoteProductsDataSource
import com.borealnetwork.shared.core.firestore.data.repository.products.DefaultProductsRepository
import com.borealnetwork.shared.core.firestore.domain.interfaces.ProductsRepository
import com.borealnetwork.shared.core.firestore.domain.use_cases.ProductsUseCase
import com.borealnetwork.shared.domain.models.UseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val productsModule = module {
    single<GetProductsDataSource>(named("RemoteProductsDataSource")) { RemoteProductsDataSource() }

    single<ProductsRepository>(named("DefaultProductsRepository")) {
        DefaultProductsRepository(
            get(named("RemoteProductsDataSource"))
        )
    }

    single<UseCase<ProductsUseCase.Input, ProductsUseCase.Output>>(named("ProductsUseCase")) {
        ProductsUseCase(get(named("DefaultProductsRepository")))
    }

}