package com.borealnetwork.allen.modules.product.domain.view_models

import com.borealnetwork.shared.domain.models.product.ProductCompleteModel
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class ShowProductViewModel : ViewModel() {

    private var productModelList = MutableStateFlow<ProductCompleteModel?>(null)
    fun setTopProductModel(productModelOnTop: ProductCompleteModel) {
        productModelList.update {
            productModelOnTop
        }
    }

    fun getTopProductModel(): ProductCompleteModel? {
        val data = productModelList.value
        return data
    }

}