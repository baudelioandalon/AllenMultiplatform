package com.borealnetwork.allen.modules.home_client.domain.view_model

import com.borealnetwork.shared.core.firestore.domain.use_cases.ProductsUseCase
import com.borealnetwork.shared.core.network.domain.models.ApiResponse
import com.borealnetwork.shared.core.network.domain.models.error
import com.borealnetwork.shared.core.network.domain.models.success
import com.borealnetwork.shared.domain.models.UseCase
import com.borealnetwork.shared.domain.models.product.ProductCompleteModel
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeClientViewModel(
    private val productsUseCase: UseCase<ProductsUseCase.Input, ProductsUseCase.Output>
) : ViewModel() {

    private var getProductExecute = false

    private val _productsResult = MutableStateFlow<ApiResponse<List<ProductCompleteModel>>?>(null)
    val productsResult = _productsResult.asStateFlow()

    fun getProducts() {
        if (getProductExecute) return
        getProductExecute = true
        viewModelScope.launch {
            productsUseCase.execute(
                ProductsUseCase.Input(
                    "products"
                )
            ).catch { cause ->
                cause
            }.collect {
                it
                it.result.success { response ->
                    _productsResult.update {
                        response
                    }
                }
                it.result.error { error ->
                    _productsResult.update {
                        error
                    }
                }
            }
        }
    }

}