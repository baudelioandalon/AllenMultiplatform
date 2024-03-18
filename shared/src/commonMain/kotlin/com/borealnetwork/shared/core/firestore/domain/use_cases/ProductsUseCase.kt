package com.borealnetwork.shared.core.firestore.domain.use_cases

import com.borealnetwork.shared.core.firestore.domain.interfaces.ProductsRepository
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import com.borealnetwork.shared.domain.models.In
import com.borealnetwork.shared.domain.models.Out
import com.borealnetwork.shared.domain.models.UseCase
import com.borealnetwork.shared.domain.models.product.ProductCompleteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class ProductsUseCase(private val productsRepository: ProductsRepository) :
    UseCase<ProductsUseCase.Input, ProductsUseCase.Output> {

    class Input(val request: String) : In()
    inner class Output(val result: ApiResponse<List<ProductCompleteModel>>) :
        Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return productsRepository.executeProducts(input.request).flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }

}