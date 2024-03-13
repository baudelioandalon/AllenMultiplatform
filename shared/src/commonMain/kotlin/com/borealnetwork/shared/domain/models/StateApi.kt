package com.borealnetwork.shared.domain.models

sealed class StateApi {
    data object Loading : StateApi()
    data class Success<T>(val data: T) : StateApi()
    data object Error : StateApi() {
        var message: String? = null
        fun error(message: String): Error {
            Error.message = message
            return this
        }
    }

    data object None : StateApi()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data: $data]"
            is Loading -> "Loading[]"
            is None -> ""
            is Error -> message.orEmpty()
        }
    }
}