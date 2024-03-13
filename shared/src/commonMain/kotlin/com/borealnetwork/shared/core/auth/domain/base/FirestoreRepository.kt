package com.borealnetwork.shared.core.auth.domain.base

import com.borealnetwork.shared.core.network.domain.models.error_handler.AuthenticationErrorEnum
import com.borealnetwork.shared.core.network.domain.models.error_handler.FirestoreErrorEnum
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuthInvalidCredentialsException
import dev.gitlive.firebase.auth.FirebaseAuthInvalidUserException
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.FirebaseFirestoreException
import dev.gitlive.firebase.firestore.FirestoreExceptionCode
import dev.gitlive.firebase.firestore.code
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

abstract class FirestoreRepository {

    protected val coroutineScope: CoroutineScope = MainScope()
    protected val firebaseAuth = Firebase.auth
    companion object {
        fun errorResponse(causeThrowable: Throwable) =
            if (causeThrowable is FirebaseFirestoreException) {
                errorResponse(exception = causeThrowable)
            } else {
                FirestoreErrorEnum.ERROR_UNAVAILABLE
            }


        fun errorResponse(exception: FirebaseFirestoreException): FirestoreErrorEnum {
            return when (exception.code) {
                FirestoreExceptionCode.UNAVAILABLE -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.INVALID_ARGUMENT -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.ABORTED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.ALREADY_EXISTS -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.CANCELLED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.DATA_LOSS -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.DEADLINE_EXCEEDED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.FAILED_PRECONDITION -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.INTERNAL -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.NOT_FOUND -> {
                    FirestoreErrorEnum.ERROR_NOT_FOUND
                }
                FirestoreExceptionCode.OK -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.OUT_OF_RANGE -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.PERMISSION_DENIED -> {
                    FirestoreErrorEnum.ERROR_PERMISSION_DENIED
                }
                FirestoreExceptionCode.RESOURCE_EXHAUSTED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.UNAUTHENTICATED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.UNIMPLEMENTED -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
                FirestoreExceptionCode.UNKNOWN -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }

                else -> {
                    FirestoreErrorEnum.ERROR_UNAVAILABLE
                }
            }
        }

        fun validationError(errorReceived: String): FirestoreErrorEnum {
            return when {
                errorReceived.contains(FirestoreErrorEnum.ERROR_INVALID_PATH.defaultError) -> {
                    FirestoreErrorEnum.ERROR_INVALID_PATH
                }
                errorReceived.contains(FirestoreErrorEnum.ERROR_INVALID_FIELD_PATH.defaultError) -> {
                    FirestoreErrorEnum.ERROR_INVALID_FIELD_PATH
                }
                errorReceived.contains(FirestoreErrorEnum.ERROR_NOT_FOUND.defaultError) -> {
                    FirestoreErrorEnum.ERROR_NOT_FOUND
                }
                errorReceived.contains(FirestoreErrorEnum.ERROR_DESERIALIZE_OBJECT.defaultError) -> {
                    FirestoreErrorEnum.ERROR_DESERIALIZE_OBJECT
                }
                else -> {
                    FirestoreErrorEnum.ERROR_DEFAULT
                }
            }
        }

        fun authenticationValidException(exception: Exception): AuthenticationErrorEnum {
            return when (exception) {
                is FirebaseAuthInvalidUserException -> {
                    AuthenticationErrorEnum.ERROR_USER_NOT_FOUND
                }
                is FirebaseAuthInvalidCredentialsException -> {
                    AuthenticationErrorEnum.ERROR_INVALID_PASSWORD
                }
                else -> {
                    AuthenticationErrorEnum.ERROR_DEFAULT
                }
            }
        }
    }


}