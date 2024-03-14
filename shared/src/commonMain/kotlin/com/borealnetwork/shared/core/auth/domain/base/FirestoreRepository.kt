package com.borealnetwork.shared.core.auth.domain.base

import com.borealnetwork.shared.core.network.domain.models.error_handler.FirestoreErrorEnum
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuthException
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.FirebaseFirestoreException
import dev.gitlive.firebase.firestore.FirestoreExceptionCode
import dev.gitlive.firebase.firestore.code
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

abstract class FirestoreRepository {

    protected val coroutineScope: CoroutineScope = MainScope()
    protected val firebaseAuth = Firebase.auth

    companion object {
        fun errorResponse(causeThrowable: Exception) =
            when (causeThrowable) {
                is FirebaseFirestoreException -> {
                    findFirestoreException(exception = causeThrowable)
                }

                is FirebaseAuthException -> {
                    findAuthenticationException(exception = causeThrowable)
                }

                else -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }
            }


        private fun findFirestoreException(exception: FirebaseFirestoreException): String {
            return when (exception.code) {
                FirestoreExceptionCode.UNAVAILABLE -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.INVALID_ARGUMENT -> {
                    FirestoreErrorEnum.ERROR_INVALID_PATH.messageError
                }

                FirestoreExceptionCode.ABORTED -> {
                    FirestoreErrorEnum.ERROR_PAYMENT_PAYED.messageError
                }

                FirestoreExceptionCode.ALREADY_EXISTS -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.CANCELLED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.DATA_LOSS -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.DEADLINE_EXCEEDED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.FAILED_PRECONDITION -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.INTERNAL -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.NOT_FOUND -> {
                    FirestoreErrorEnum.ERROR_NOT_FOUND.messageError
                }

                FirestoreExceptionCode.OK -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.OUT_OF_RANGE -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.PERMISSION_DENIED -> {
                    FirestoreErrorEnum.ERROR_PERMISSION_DENIED.messageError
                }

                FirestoreExceptionCode.RESOURCE_EXHAUSTED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.UNAUTHENTICATED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.UNIMPLEMENTED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                FirestoreExceptionCode.UNKNOWN -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE.messageError
                }

                else -> {
                    exception.message.orEmpty()
                }
            }
        }

        private fun findAuthenticationException(exception: FirebaseAuthException): String {
            return when (exception.message.orEmpty()) {
                FirestoreErrorEnum.ERROR_INVALID_PASSWORD.defaultError -> {
                    FirestoreErrorEnum.ERROR_INVALID_PASSWORD.messageError
                }

                FirestoreErrorEnum.ERROR_USER_NOT_FOUND.defaultError -> {
                    FirestoreErrorEnum.ERROR_USER_NOT_FOUND.messageError
                }

                FirestoreErrorEnum.ERROR_NOT_VERIFIED_EMAIL.defaultError -> {
                    FirestoreErrorEnum.ERROR_NOT_VERIFIED_EMAIL.messageError
                }

                FirestoreErrorEnum.ERROR_USER_NOT_LOGGED_IN.defaultError -> {
                    FirestoreErrorEnum.ERROR_USER_NOT_LOGGED_IN.messageError
                }

                else -> {
                    exception.message.orEmpty()
                }
            }
        }

    }


}