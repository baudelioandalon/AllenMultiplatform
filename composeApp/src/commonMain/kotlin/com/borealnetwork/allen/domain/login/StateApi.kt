package com.borealnetwork.allen.domain.login

sealed class StateApi {
    data object Loading : StateApi()
    data class Success(val data: String) : StateApi()
    data object Error : StateApi() {
        var message: String? = null
        fun error(message: String): Error {
            this.message = message
            return this
        }
    }

    data object None : StateApi()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data: $data]"
            is Loading -> "Loading[]"
            is None -> ""
            is Error -> message.orEmpty()
        }
    }
}